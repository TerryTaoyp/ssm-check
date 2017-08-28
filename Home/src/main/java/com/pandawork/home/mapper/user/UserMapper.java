package com.pandawork.home.mapper.user;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.entity.user.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
    public List<User> queryMore(@Param("rid") int rid,@Param("dname") String dname,@Param("status") int status,@Param("isDelete") int isDelete,@Param("isDelete") int isBeCheck,@Param("username") String username,@Param("realName") String realName)throws SSException;

    /**
     * 计算用户条数
     * @return
     * @throws SSException
     */
    public int countAll()throws SSException;
    /**
     * 根据ID删除用户
     * @param user
     * @return
     * @throws SSException
     */
    public User delUser(@Param("user") User user)throws SSException;

    /**
     * 审核用户
     * @param user
     * @return
     * @throws SSException
     */
    public User statusUser(@Param("user") User user)throws SSException;

    /**
     * 修改用户密码
     * @param user
     * @return
     * @throws SSException
     */
    public User updatePassword(@Param("user") User user)throws SSException;

    /**
     * 修改真实姓名
     * @param user
     * @return
     * @throws SSException
     */
    public User updateRealName(@Param("user") User user)throws SSException;
}
