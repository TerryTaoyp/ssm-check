package com.pandawork.home.web.controller.user;

import com.pandawork.home.service.user.UserService;
import com.pandawork.home.web.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Taoyongpan on 2017/9/2.
 */
@Controller
@RequestMapping("")
public class LoginController extends AbstractController {

    @Autowired
    UserService userService;
    @RequestMapping(value = "",method = RequestMethod.GET)
    public String toLogin(HttpServletRequest req, Model model){
        return "login";
    }

}
