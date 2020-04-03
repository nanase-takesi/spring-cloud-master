package com.shengda.provider.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shengda.provider.mapper.UserMapper;
import com.shengda.provider.model.domain.User;
import com.shengda.provider.service.UserService;
import com.shengda.vo.UserVo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author takesi
 * @date 2020-03-27
 */
@Service
@AllArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final UserMapper userMapper;

    @Override
    public UserVo getByUsername(String username) {
        return userMapper.queryByUsername(username);
    }

    @Override
    public UserVo getByMobile(String mobile) {
        return userMapper.queryByMobile(mobile);
    }
}
