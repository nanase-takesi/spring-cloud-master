package com.shengda.provider.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shengda.provider.mapper.RoleMapper;
import com.shengda.provider.model.domain.Role;
import com.shengda.provider.service.RoleService;
import com.shengda.vo.RoleVo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author takesi
 * @date 2020-03-27
 */
@Service
@AllArgsConstructor
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    private final RoleMapper roleMapper;

    @Override
    public List<RoleVo> getByUserId(Long userId) {
        return roleMapper.queryByUserId(userId);
    }
}
