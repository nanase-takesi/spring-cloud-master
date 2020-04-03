package com.shengda.provider.controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.shengda.base.wrapper.WrapMapper;
import com.shengda.base.wrapper.Wrapper;
import com.shengda.core.support.BaseController;
import com.shengda.provider.service.UserService;
import com.shengda.vo.UserVo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author takesi
 * @date 2020-03-27
 */
@RestController
@AllArgsConstructor
@RequestMapping(value = "/user")
public class UserController extends BaseController {

    private final UserService userService;

    @GetMapping(value = "/info")
    public Wrapper getUserInfo() {
        Map<String, Object> result = Maps.newHashMap();
        result.put("name", "Super Admin");
        result.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        result.put("introduction", "I am a super administrator");
        result.put("roles", Lists.newArrayList("admin"));
        return WrapMapper.ok(result);
    }

    @GetMapping(value = "/name/{username}")
    public Wrapper<UserVo> getUserByUsername(@PathVariable String username) {
        return WrapMapper.ok(userService.getByUsername(username));
    }

    @GetMapping(value = "/mobile/{mobile}")
    public Wrapper<UserVo> getUserByMobile(@PathVariable String mobile) {
        return WrapMapper.ok(userService.getByMobile(mobile));
    }

}
