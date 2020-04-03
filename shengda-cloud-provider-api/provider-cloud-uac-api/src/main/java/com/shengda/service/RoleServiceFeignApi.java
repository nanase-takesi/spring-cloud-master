package com.shengda.service;

import com.shengda.base.wrapper.Wrapper;
import com.shengda.service.fallback.RoleServiceFeignFallbackFactory;
import com.shengda.vo.RoleVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author takesi
 * @date 2020-03-27
 */
@FeignClient(name = "provider-cloud-uac", fallbackFactory = RoleServiceFeignFallbackFactory.class, decode404 = true)
public interface RoleServiceFeignApi {

    /**
     * getByUserId
     *
     * @param userId userId
     * @return Wrapper
     */
    @GetMapping(value = "/role/byUserId/{userId}")
    Wrapper<List<RoleVo>> getByUserId(@PathVariable Long userId);

}
