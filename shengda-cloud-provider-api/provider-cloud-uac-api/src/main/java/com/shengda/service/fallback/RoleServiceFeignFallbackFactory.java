package com.shengda.service.fallback;

import com.shengda.base.wrapper.WrapMapper;
import com.shengda.base.wrapper.Wrapper;
import com.shengda.service.RoleServiceFeignApi;
import com.shengda.vo.RoleVo;
import feign.hystrix.FallbackFactory;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * @author takesi
 * @date 2020-03-27
 */
public class RoleServiceFeignFallbackFactory implements FallbackFactory<RoleServiceFeignApi> {

    @Override
    public RoleServiceFeignApi create(Throwable throwable) {
        return new RoleServiceFeignApi() {
            @Override
            public Wrapper<List<RoleVo>> getByUserId(Long userId) {
                return WrapMapper.wrap(HttpStatus.NOT_FOUND.value());
            }
        };
    }
}
