package com.shengda.provider.service;

import com.shengda.provider.model.domain.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shengda.vo.RoleVo;

import java.util.List;

/**
 * @author takesi
 * @date 2020-03-27
 */
public interface RoleService extends IService<Role> {

    /**
     * getByUserId
     *
     * @param userId userId
     * @return List<RoleVo>
     */
    List<RoleVo> getByUserId(Long userId);

}
