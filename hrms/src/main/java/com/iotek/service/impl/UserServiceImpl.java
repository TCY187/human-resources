package com.iotek.service.impl;

import com.iotek.dao.UserMapper;
import com.iotek.model.User;
import com.iotek.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by TCY on 2018/7/25.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    public User getUserByNameAndPass(User user) {
        return userMapper.getUserByNameAndPass(user);
    }

    public boolean saveUser(User user) {
        return userMapper.saveUser(user);
    }
}
