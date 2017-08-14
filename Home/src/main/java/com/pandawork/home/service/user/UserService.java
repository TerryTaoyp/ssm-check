package com.pandawork.home.service.user;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.entity.user.User;

/**
 * Created by Taoyongpan on 2017/8/12.
 */
public interface UserService {
    /**
     * 注册新用户
     * @param user
     * @return
     * @throws Exception
     */
    public void addUser(User user)throws SSException;

    /**
     * 根据真实姓名查找用户
     * @param realName
     * @return
     * @throws Exception
     */
    public User queryByRname(String realName)throws SSException;

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     * @throws Exception
     */
    public User queryByUname(String username)throws SSException;

    /**
     * 根据用户名和密码查找用户
     * @param user
     * @return
     * @throws Exception
     */
    public User queryByUnameAndPword(User user)throws SSException;
}
