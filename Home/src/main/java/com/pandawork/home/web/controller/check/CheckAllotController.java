package com.pandawork.home.web.controller.check;

import com.pandawork.home.service.user.UserService;
import com.pandawork.home.web.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Taoyongpan on 2017/9/6.
 */
@Controller
@RequestMapping("/check")
public class CheckAllotController extends AbstractController {

    @Autowired
    UserService userService;
}
