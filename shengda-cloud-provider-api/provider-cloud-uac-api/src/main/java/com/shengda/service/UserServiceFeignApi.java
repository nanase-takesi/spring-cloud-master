package com.shengda.service;

import com.shengda.base.wrapper.Wrapper;
import com.shengda.service.fallback.UserServiceFeignFallbackFactory;
import com.shengda.vo.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author takesi
 * @date 2020-03-27
 */
@FeignClient(name = "provider-cloud-uac", fallbackFactory = UserServiceFeignFallbackFactory.class, decode404 = true)
public interface UserServiceFeignApi {

    /**
     * 根据用户名查询用户实体
     *
     * @param username username
     * @return UserVo
     */
    @GetMapping(value = "/user/name/{username}")
    Wrapper<UserVo> getUserByUsername(@PathVariable String username);

    /**
     * 根据手机号查询用户实体
     *
     * @param mobile mobile
     * @return UserVo
     */
    @GetMapping(value = "/user/mobile/{mobile}")
    Wrapper<UserVo> getUserByUserMobile(@PathVariable String mobile);

}
