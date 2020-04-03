package com.shengda.provider.service.impl;

import com.shengda.base.wrapper.Wrapper;
import com.shengda.core.exception.MobileNotFountException;
import com.shengda.provider.model.domain.UacUserDetails;
import com.shengda.provider.service.IUserDetailService;
import com.shengda.service.RoleServiceFeignApi;
import com.shengda.service.UserServiceFeignApi;
import com.shengda.util.CachedBeanCopierUtils;
import com.shengda.vo.RoleVo;
import com.shengda.vo.UserVo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author takesi
 * @date 2020-03-27
 */
@Service
@AllArgsConstructor
public class UserDetailServiceImpl implements IUserDetailService {

    private final UserServiceFeignApi userServiceFeignApi;

    private final RoleServiceFeignApi roleServiceFeignApi;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Wrapper<UserVo> wrapper = userServiceFeignApi.getUserByUsername(username);

        if (wrapper.success()) {
            UserVo userVo = wrapper.getData();
            return this.buildUserDetails(userVo);
        }
        throw new UsernameNotFoundException("user is not fount by username!");
    }

    @Override
    public UserDetails loadUserByMobile(String mobile) {
        Wrapper<UserVo> wrapper = userServiceFeignApi.getUserByUserMobile(mobile);
        if (wrapper.success()) {
            UserVo userVo = wrapper.getData();
            return this.buildUserDetails(userVo);
        }
        throw new MobileNotFountException("user is not fount by mobile!");
    }

    private UserDetails buildUserDetails(UserVo userVo) {
        Wrapper<List<RoleVo>> roleWrapper = roleServiceFeignApi.getByUserId(userVo.getId());
        UacUserDetails uacUserDetails = new UacUserDetails();
        CachedBeanCopierUtils.copy(userVo, uacUserDetails);
        uacUserDetails.setEnabled(userVo.getEnabled());

        if (roleWrapper.success()) {
            List<RoleVo> roleVoList = roleWrapper.getData();
            uacUserDetails.setRoles(roleVoList);
        }
        return uacUserDetails;
    }

}
