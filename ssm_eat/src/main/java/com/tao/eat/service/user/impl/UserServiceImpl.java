package com.tao.eat.service.user.impl;


import com.tao.eat.entity.user.User;
import com.tao.eat.mapper.user.UserMapper;
import com.tao.eat.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/5/24.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> findAllUser() {
        List<User> findAllUser = userMapper.findAllUser();
        return findAllUser;
    }
}
