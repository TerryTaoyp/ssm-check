package com.tao.eat.service.user;

import com.tao.eat.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Taoyongpan on 2017/5/25.
 */
public class UserTest extends BaseTest {
    @Autowired
    UserService userService;

    @Test
    public void testListUser(){
        System.out.println( userService.findAllUser()+"哈哈哈");

    }
}
