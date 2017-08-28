package com.pandawork.home.service.user;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.entity.user.User;

import java.util.List;

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

    /**
     * 多条件查询
     * @param rid
     * @param dname
     * @param status
     * @param isDelete
     * @param isBeCheck
     * @param username
     * @param realName
     * @return
     * @throws SSException
     */
    public List<User> queryMore(int rid, String dname, int status, int isDelete, int isBeCheck,String username,String realName)throws SSException;

    /**
     * 计算用户总的条数
     * @return
     * @throws SSException
     */
    public int countAll()throws SSException;

    /**
     * 删除用户
     * @param user
     * @return
     * @throws SSException
     */
    public User delUser(User  user)throws SSException;

    /**
     * 审核用户
     * @param user
     * @return
     * @throws SSException
     */
    public User statusUser(User user)throws SSException;

    /**
     * 修改用户密码
     * @param user
     * @return
     * @throws SSException
     */
    public User updatePassword(User user)throws SSException;

    /**
     * 修改真实姓名
     * @param user
     * @return
     * @throws SSException
     */
    public User updateRealName(User user)throws SSException;
}
