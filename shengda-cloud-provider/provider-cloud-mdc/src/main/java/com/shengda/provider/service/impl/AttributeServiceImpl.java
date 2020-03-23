package com.shengda.provider.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shengda.provider.mapper.AttributeMapper;
import com.shengda.provider.model.domain.Attribute;
import com.shengda.provider.service.AttributeService;
import org.springframework.stereotype.Service;

/**
 * @author takesi
 * @date 2020-03-19
 */
@Service
public class AttributeServiceImpl extends ServiceImpl<AttributeMapper, Attribute> implements AttributeService {

}
