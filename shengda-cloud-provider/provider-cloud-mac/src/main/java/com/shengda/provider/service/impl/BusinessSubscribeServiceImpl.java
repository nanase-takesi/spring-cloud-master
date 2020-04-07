package com.shengda.provider.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shengda.provider.mapper.BusinessSubscribeMapper;
import com.shengda.provider.model.domain.BusinessSubscribe;
import com.shengda.provider.service.BusinessSubscribeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author takesi
 * @date 2019-12-26
 */
@Service
@AllArgsConstructor
public class BusinessSubscribeServiceImpl extends ServiceImpl<BusinessSubscribeMapper, BusinessSubscribe> implements BusinessSubscribeService {

    private final BusinessSubscribeMapper businessSubscribeMapper;

}
