package com.pandawork.home.service.user.impl;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.home.common.entity.user.User;
import com.pandawork.home.common.exception.ChException;
import com.pandawork.home.mapper.user.UserMapper;
import com.pandawork.home.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Taoyongpan on 2017/8/12.
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
//    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class,Exception.class, RuntimeException.class})
    public void addUser(User user) throws SSException {
        try{
//            if (Assert.isNull(userMapper.queryByUname(user.getUsername()))){
//                return;
//            }
            userMapper.addUser(user);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.UserExist);
        }
    }

    @Override
    public User queryByRname(String realName) throws SSException {
        return null;
    }

    @Override
    public User queryByUname(String username) throws SSException {
        return null;
    }

    @Override
    public User queryByUnameAndPword(User user) throws SSException {
        return null;
    }
}
