package com.pandawork.home.web.controller.user;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.entity.user.User;
import com.pandawork.home.service.user.UserService;
import com.pandawork.home.web.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Taoyongpan on 2017/9/2.
 */
@Controller
@RequestMapping("")
public class LoginController extends AbstractController {

    @Autowired
    UserService userService;

    /**
     * 跳到登录页面
     * @param req
     * @param model
     * @return
     */
    @RequestMapping(value = "/tologin")
    public String toLogin(HttpServletRequest req, Model model){
        return "login";
    }

    /**
     * 登录验证
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response, @RequestParam("username") String username, @RequestParam("password") String password) throws SSException {
        User user = userService.queryByUname(username);
        if (user!=null){
//            if (user.getStatus()==1&&user.getPassword().equals(password)){
//                user.getDid()
                return "index";
//            }else {
//                return "login";
//            }
//            if (user.getPassword().equals(password))
//            return "index";
        }else {
            return "login";
        }
    }

    /**
     * 跳转到注册页面
     * @return
     */
    @RequestMapping(value = "/toregister",method = RequestMethod.POST)
    public String toRegister(){
        return "register";
    }
    /**
     * 注册新用户
     * @return
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(){

        return "login";
    }

    /**
     * 更新密码
     * @return
     * @throws SSException
     */
    @RequestMapping(value = "/toupwd",method = RequestMethod.POST)
    public String toUpdatePassword()throws SSException{
        return "update-password";
    }

}
