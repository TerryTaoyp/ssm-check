package com.pandawork.home.web.controller.user;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.util.Assert;
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
import javax.servlet.http.HttpSession;

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
    public String login(HttpServletRequest request, HttpServletResponse response, @RequestParam("username") String username, @RequestParam("password") String password, HttpSession session,Model model) throws SSException {
        User user = userService.queryByUname(username);
        if (!Assert.isNull(user)){
            if (user.getPassword().equals(password)){
                session.setAttribute("username",user.getUsername());
//            if (user.getStatus()==1&&user.getPassword().equals(password)){
//                user.getDid()
                return "index";
//            }else {
//                return "login";
//            }
//            if (user.getPassword().equals(password))
//            return "index";
            }else {
                model.addAttribute("error","用户名或密码错误");
                return "login";
            }
        }else {
            model.addAttribute("error","用户名或密码错误");
            return "login";
        }
    }

    /**
     * 跳转到 主页
     * @return
     */
    @RequestMapping(value = "/toindex",method = RequestMethod.GET)
    public String toIndex(){
        return "index";
    }
    /**
     * 跳转到注册页面
     * @return
     */
    @RequestMapping(value = "/toregister",method = RequestMethod.GET)
    public String toRegister(){
        return "register";
    }
    /**
     * 注册新用户
     * @return
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(@RequestParam("username") String username,@RequestParam("realName") String realName,@RequestParam("did") int did,@RequestParam("password") String password,Model model) throws SSException {
        if (userService.queryByUname(username)!=null){
            model.addAttribute("error","账户名已经存在！");
            return "register";
        }else {
            User user = new User();
            user.setUsername(username);
            user.setRealName(realName);
            user.setDid(did);
            user.setPassword(password);
            userService.addUser(user);
            return "login";
        }
    }

    /**
     * 跳转到更新页面
     * @return
     * @throws SSException
     */
    @RequestMapping(value = "/toupwd",method = RequestMethod.GET)
    public String toUpdatePassword(HttpSession session,Model model)throws SSException{
        User user = userService.queryByUname((String) session.getAttribute("username"));
        model.addAttribute("user",user);
        return "update-password";
    }

    /**
     * 更新密码
     * @return
     * @throws SSException
     */
    @RequestMapping(value = "/upwd",method = RequestMethod.POST)
    public String updatePassword(Model model,HttpSession session,@RequestParam("password") String password,@RequestParam("newPassword") String newPassword)throws SSException{
        User user = userService.queryByUname((String) session.getAttribute("username"));
        if (user.getPassword().equals(password)){
            user.setPassword(newPassword);
            userService.updatePassword(user);
            session.invalidate();
            return "login";
        }else {
            model.addAttribute("msg","原密码错误");
            return "update-password";
        }
    }

    /**
     * 注销登录
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpSession session)throws Exception{
        session.invalidate();
        return "login";
    }

}
