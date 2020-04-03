package com.shengda.provider.service;

import com.shengda.provider.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shengda.vo.UserVo;

/**
 * @author takesi
 * @date 2020-03-27
 */
public interface UserService extends IService<User> {

    /**
     * 根据username查询User
     *
     * @param username username
     * @return UserVo
     */
    UserVo getByUsername(String username);

    /**
     * 根据mobile查询User
     *
     * @param mobile mobile
     * @return UserVo
     */
    UserVo getByMobile(String mobile);
}
