package com.pandawork.home.user;

import com.pandawork.home.AbstractTestCase;
import com.pandawork.home.common.entity.user.User;
import com.pandawork.home.service.user.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Taoyongpan on 2017/4/20.
 */
public class UserServiceTest extends AbstractTestCase {
    @Autowired
    UserService userService;

    /**
     * 测试新增用户
     * @throws Exception
     */
    @Test
    public void addUserTest() throws Exception {
        User user = new User();
        user.setUsername("陶永攀11");
        user.setRealName("陶永攀1");
        user.setPassword("tt123456");
        user.setSex("男");
        user.setDid(1);
        user.setStatus(1);
        userService.addUser(user);
    }

    /**
     * 根据真实姓名查找用户
     * @throws Exception
     */
    @Test
    public void queryByRnameTest()throws Exception{
        System.out.println( userService.queryByRname("陶永攀1"));
    }

    /**
     * 根据用户名查找用户
     * @throws Exception
     */
    @Test
    public void queryByUnameTest()throws Exception{
        System.out.println(userService.queryByUname("陶永攀11"));
    }

    /**
     * 根据用户名和密码查找用户
     * @throws Exception
     */
    @Test
    public void  loginTest()throws Exception{
        User user = new User();
        user.setUsername("陶永攀11");
        user.setPassword("tt123456");
        System.out.println(userService.queryByUnameAndPword(user));
    }


}
