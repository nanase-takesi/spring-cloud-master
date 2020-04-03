package com.shengda.provider.controller;

import com.shengda.base.wrapper.WrapMapper;
import com.shengda.base.wrapper.Wrapper;
import com.shengda.core.support.BaseController;
import com.shengda.provider.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author takesi
 * @date 2020-03-27
 */
@RestController
@AllArgsConstructor
@RequestMapping(value = "/role")
public class RoleController extends BaseController {

    private final RoleService roleService;

    @GetMapping(value = "/byUserId/{userId}")
    public Wrapper listRole(@PathVariable Long userId) {
        return WrapMapper.ok(roleService.getByUserId(userId));
    }

}
