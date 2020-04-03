package com.shengda.service.fallback;

import com.shengda.base.wrapper.WrapMapper;
import com.shengda.base.wrapper.Wrapper;
import com.shengda.service.UserServiceFeignApi;
import com.shengda.vo.UserVo;
import feign.hystrix.FallbackFactory;
import org.springframework.http.HttpStatus;

/**
 * @author takesi
 * @date 2020-03-27
 */
public class UserServiceFeignFallbackFactory implements FallbackFactory<UserServiceFeignApi> {

    @Override
    public UserServiceFeignApi create(Throwable throwable) {
        return new UserServiceFeignApi() {
            @Override
            public Wrapper<UserVo> getUserByUsername(String username) {
                return WrapMapper.wrap(HttpStatus.NOT_FOUND.value());
            }

            @Override
            public Wrapper<UserVo> getUserByUserMobile(String mobile) {
                return WrapMapper.wrap(HttpStatus.NOT_FOUND.value());
            }
        };
    }
}
