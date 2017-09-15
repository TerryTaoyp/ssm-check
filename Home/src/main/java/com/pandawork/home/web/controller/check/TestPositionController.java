package com.pandawork.home.web.controller.check;

import com.pandawork.home.common.entity.check.AbilityPosition;
import com.pandawork.home.service.check.AbilityPositionService;
import com.pandawork.home.service.check.TestPositionService;
import com.pandawork.home.web.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/9/15.
 */
@Controller
@RequestMapping("/test/position")
public class TestPositionController extends AbstractController {
    @Autowired
    TestPositionService testPositionService;
    @Autowired
    AbilityPositionService abilityPositionService;


    /**
     * 根据考核计划ID列出此次考核的问题
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/list/{id}",method = RequestMethod.GET)
    public String queryByTestId(@PathVariable("id")int id, Model model)throws Exception{
        List<AbilityPosition> abilityPositionList = abilityPositionService.queryByTestId(id);

        model.addAttribute("abilityPositionList",abilityPositionList);
        return "evaluation/year/ability-detail";
    }
}
