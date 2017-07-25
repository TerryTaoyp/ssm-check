package com.tao.eat.controller.user;


import com.tao.eat.entity.user.User;
import com.tao.eat.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Taoyongpan on 2017/5/24.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/findAllUser")
    public String findAllUser(HttpServletRequest request){
        List<User> listUser =  userService.findAllUser();
        request.setAttribute("listUser", listUser);
        return "01";
    }
}