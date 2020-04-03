package com.shengda.service;

import com.shengda.base.wrapper.Wrapper;
import com.shengda.service.fallback.BucketServiceFeignFallbackFactory;
import com.shengda.vo.BucketVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author takesi
 * @date 2020-03-27
 */
@FeignClient(name = "provider-cloud-uac", fallbackFactory = BucketServiceFeignFallbackFactory.class, decode404 = true)
public interface BucketServiceFeignApi {

    /**
     * 获取bucket
     *
     * @param id id
     * @return Wrapper<BucketVo>
     */
    @GetMapping(value = "/bucket/{id}/detail")
    Wrapper<BucketVo> getBucket(@PathVariable Long id);

}
