package com.pandawork.home.mapper.user;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.entity.user.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Taoyongpan on 2017/8/12.
 */
public interface UserMapper {

    /**
     * 注册用户
     * @param user
     * @return
     */
    public void addUser(@Param("user") User user)throws SSException;

    /**
     * 根据真实姓名查找用户
     * @param realName
     * @return
     * @throws Exception
     */
    public User queryByRname(@Param("realName") String realName)throws SSException;

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     * @throws Exception
     */
    public User queryByUname(@Param("username") String username)throws SSException;

    /**
     * 根据用户名和密码查找用户
     * @param user
     * @return
     * @throws Exception
     */
    public User queryByUnameAndPword(@Param("user") User user)throws SSException;
}
