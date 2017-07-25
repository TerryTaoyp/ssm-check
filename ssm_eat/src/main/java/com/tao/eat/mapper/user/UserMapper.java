package com.tao.eat.mapper.user;

import com.tao.eat.entity.user.User;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/5/25.
 */
public interface UserMapper {
    public List<User> findAllUser();
}
