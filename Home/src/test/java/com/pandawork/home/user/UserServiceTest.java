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

    @Test
    public void addUserTest() throws Exception {
        User user = new User();
        user.setUsername("陶永攀1");
        user.setRealName("陶永攀");
        user.setPassword("tt123456");
        user.setStatus(1);
        userService.addUser(user);
    }
}
