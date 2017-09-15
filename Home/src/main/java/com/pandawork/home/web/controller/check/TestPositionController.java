package com.pandawork.home.web.controller.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.dto.TestPositionDto;
import com.pandawork.home.common.entity.check.AbilityOption;
import com.pandawork.home.common.entity.check.AbilityPosition;
import com.pandawork.home.service.check.*;
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
    @Autowired
    AbilityOptionService abilityOptionService;
    @Autowired
    AbilityTargetService abilityTargetService;
    @Autowired
    AbilityTargetTypeService abilityTargetTypeService;
    /**
     * 根据考核计划ID列出此次考核的问题
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/list/{id}",method = RequestMethod.GET)
    public String queryByTestId(@PathVariable("id")int id, Model model)throws Exception{
        List<AbilityPosition> abilityPositionList = abilityPositionService.queryByTestId(id);
        List<TestPositionDto> testPositionList = testPositionService.queryDtoByTesId(id);
        List<AbilityOption> abilityOptionList = abilityOptionService.queryByTestId(id);
        model.addAttribute("testPositionList",testPositionList);
        model.addAttribute("abilityOptionList",abilityOptionList);
        model.addAttribute("abilityPositionList",abilityPositionList);
        model.addAttribute("id",id);
        return "evaluation/year/ability-detail";
    }

    /**
     * 新增此次考核计划的考核问题
     * @param id
     * @return
     * @throws SSException
     */
    @RequestMapping(value = "/add/{id}")
    public String addTestPosition(@PathVariable("id") int id)throws SSException{

        return "evaluation/year/ability-add";
    }
}
