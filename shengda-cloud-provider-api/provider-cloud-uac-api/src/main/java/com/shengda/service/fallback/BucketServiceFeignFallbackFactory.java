package com.shengda.service.fallback;

import com.shengda.base.wrapper.WrapMapper;
import com.shengda.service.BucketServiceFeignApi;
import feign.hystrix.FallbackFactory;
import org.springframework.http.HttpStatus;

/**
 * @author takesi
 * @date 2020-03-27
 */
public class BucketServiceFeignFallbackFactory implements FallbackFactory<BucketServiceFeignApi> {

    @Override
    public BucketServiceFeignApi create(Throwable throwable) {
        return id -> WrapMapper.wrap(HttpStatus.NOT_FOUND.value());
    }
}
