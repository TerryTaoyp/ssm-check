package com.pandawork.home.web.controller.check;

import com.pandawork.home.service.check.*;
import com.pandawork.home.web.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Taoyongpan on 2017/9/8.
 */
@Controller
@RequestMapping("/ability")
public class AbilityController extends AbstractController {
    @Autowired
    AbilityOptionService abilityOptionService;
    @Autowired
    AbilityPositionService abilityPositionService;
    @Autowired
    AbilityResultService abilityResultService;
    @Autowired
    AbilityTargetService abilityTargetService;
    @Autowired
    AbilityTargetTypeService abilityTargetTypeService;

    /**
     * 获取列表页面
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list()throws Exception{
        return "evaluation/year/ability-list";
    }
}
