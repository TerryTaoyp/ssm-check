package com.pandawork.home.web.controller.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.dto.TestPositionDto;
import com.pandawork.home.common.entity.check.AbilityOption;
import com.pandawork.home.common.entity.check.AbilityPosition;
import com.pandawork.home.common.entity.check.TestPlan;
import com.pandawork.home.service.check.*;
import com.pandawork.home.web.controller.AbstractController;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    TestPlanService testPlanService;
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
        TestPlan testPlan = testPlanService.queryTestPlan(id);
        model.addAttribute("testPlan",testPlan);
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
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject addTestPosition(@RequestParam("id") int id, @RequestParam("targetType") String targetType,
                                      @RequestParam("weight") int weight, @RequestParam("target") String target,
                                      @RequestParam("optionName1") int optionName1, @RequestParam("content1") String content1,
                                      @RequestParam("optionName2") int optionName2, @RequestParam("content2") String content2,
                                      @RequestParam("optionName3") int optionName3, @RequestParam("content3") String content3,
                                      @RequestParam("optionName4") int optionName4, @RequestParam("content4") String content4
                                      )throws SSException{
        AbilityPosition abilityPosition = new AbilityPosition();
        abilityPosition.setTargetId(target);
        abilityPosition.setTargetTypeId(targetType);
        abilityPosition.setWeight(weight);
        abilityPosition.setTestId(id);
        abilityPositionService.addPosition(abilityPosition);
//        AbilityPosition abilityPosition1 = abilityPositionService.queryByTestId(id);
        AbilityOption abilityOption1 = new AbilityOption();
        abilityOption1.setPositionId(abilityPosition.getId());
        abilityOption1.setTestId(id);
        abilityOption1.setOptionName(optionName1);
        abilityOption1.setOptionContent(content1);
        abilityOptionService.addOption(abilityOption1);
        AbilityOption abilityOption2= new AbilityOption();
        abilityOption1.setPositionId(abilityPosition.getId());
        abilityOption1.setTestId(id);
        abilityOption1.setOptionName(optionName2);
        abilityOption1.setOptionContent(content2);
        abilityOptionService.addOption(abilityOption2);
        AbilityOption abilityOption3 = new AbilityOption();
        abilityOption1.setPositionId(abilityPosition.getId());
        abilityOption1.setTestId(id);
        abilityOption1.setOptionName(optionName3);
        abilityOption1.setOptionContent(content3);
        abilityOptionService.addOption(abilityOption3);
        AbilityOption abilityOption4 = new AbilityOption();
        abilityOption1.setPositionId(abilityPosition.getId());
        abilityOption1.setTestId(id);
        abilityOption1.setOptionName(optionName4);
        abilityOption1.setOptionContent(content4);
        abilityOptionService.addOption(abilityOption4);
        return sendJsonObject(1);
    }

    /**
     * 编辑本体
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public JSONObject edit(@RequestParam("positionId") int pid, @RequestParam("targetType") String targetType,
                             @RequestParam("weight") int weight, @RequestParam("target") String target,
                             @RequestParam("optionName1") int optionName1, @RequestParam("content1") String content1,
                             @RequestParam("optionName2") int optionName2, @RequestParam("content2") String content2,
                             @RequestParam("optionName3") int optionName3, @RequestParam("content3") String content3,
                             @RequestParam("optionName4") int optionName4, @RequestParam("content4") String content4)throws Exception{
        AbilityPosition abilityPosition = abilityPositionService.queryById(pid);
        abilityPosition.setTargetId(target);
        abilityPosition.setTargetTypeId(targetType);
        abilityPosition.setWeight(weight);
        abilityPositionService.updatePosition(abilityPosition);
        AbilityOption abilityOption1 = abilityOptionService.queryByPidAndOption(pid,1);
        abilityOption1.setPositionId(abilityPosition.getId());
        abilityOption1.setOptionName(optionName1);
        abilityOption1.setOptionContent(content1);
        abilityOptionService.updateOption(abilityOption1);
        AbilityOption abilityOption2= abilityOptionService.queryByPidAndOption(pid,2);
        abilityOption1.setPositionId(abilityPosition.getId());
        abilityOption1.setOptionName(optionName2);
        abilityOption1.setOptionContent(content2);
        abilityOptionService.updateOption(abilityOption2);
        AbilityOption abilityOption3 = abilityOptionService.queryByPidAndOption(pid,3);
        abilityOption1.setPositionId(abilityPosition.getId());
        abilityOption1.setOptionName(optionName3);
        abilityOption1.setOptionContent(content3);
        abilityOptionService.updateOption(abilityOption3);
        AbilityOption abilityOption4 = abilityOptionService.queryByPidAndOption(pid,4);
        abilityOption1.setPositionId(abilityPosition.getId());
        abilityOption1.setOptionName(optionName4);
        abilityOption1.setOptionContent(content4);
        abilityOptionService.updateOption(abilityOption4);
        return sendJsonObject(1);
    }

    /**
     * 跳转到编辑本道题页面
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/to/edit",method = RequestMethod.GET)
    public JSONObject toEdit(@RequestParam("positionId") int pid)throws Exception{
        AbilityPosition abilityPosition = abilityPositionService.queryById(pid);
        TestPlan testPlan = testPlanService.queryTestPlan(abilityPosition.getTestId());
        AbilityOption abilityOption1 = abilityOptionService.queryByPidAndOption(pid,1);
        AbilityOption abilityOption2 = abilityOptionService.queryByPidAndOption(pid,2);
        AbilityOption abilityOption3 = abilityOptionService.queryByPidAndOption(pid,3);
        AbilityOption abilityOption4 = abilityOptionService.queryByPidAndOption(pid,4);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("testName",testPlan.getTestName());
        jsonObject.put("option1",abilityOption1);
        jsonObject.put("option2",abilityOption2);
        jsonObject.put("option3",abilityOption3);
        jsonObject.put("option4",abilityOption4);
        return sendJsonObject(jsonObject);
    }

    /**
     * 删除本道题
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/del",method = RequestMethod.GET)
    public JSONObject del(@RequestParam("positionId") int id)throws Exception{
//        abilityPositionService.delPosition();
        abilityPositionService.del(id);
        List<AbilityOption> abilityOptionList = abilityOptionService.queryByPositionId(id);
        for (AbilityOption option:abilityOptionList){
            abilityOptionService.delOption(option.getId());
        }
        return sendJsonObject(1);
    }
}
