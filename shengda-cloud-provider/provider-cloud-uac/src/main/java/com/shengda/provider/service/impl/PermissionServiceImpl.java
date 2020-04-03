package com.shengda.provider.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shengda.provider.mapper.PermissionMapper;
import com.shengda.provider.model.domain.Permission;
import com.shengda.provider.service.PermissionService;
import org.springframework.stereotype.Service;

/**
 * @author takesi
 * @date 2020-03-27
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

}
