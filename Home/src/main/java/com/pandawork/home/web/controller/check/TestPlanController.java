package com.pandawork.home.web.controller.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.home.common.entity.check.TestPlan;
import com.pandawork.home.common.entity.check.TestType;
import com.pandawork.home.common.entity.user.User;
import com.pandawork.home.service.check.TestPlanService;
import com.pandawork.home.service.check.TestTypeService;
import com.pandawork.home.service.check.WorkPlanService;
import com.pandawork.home.service.user.UserService;
import com.pandawork.home.web.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Taoyongpan on 2017/9/6.
 */
@Controller
@RequestMapping("/testplan")
public class TestPlanController extends AbstractController{
    @Autowired
    WorkPlanService workPlanService;
    @Autowired
    TestPlanService testPlanService;
    @Autowired
    TestTypeService testTypeService;
    @Autowired
    UserService userService;

    /**
     * 获取考核计划列表
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(Model model)throws Exception{
        try {
            List<TestPlan> testPlanList = testPlanService.listAll();
            List<TestType> testTypeList = testTypeService.listAll();
            model.addAttribute("testPlanList",testPlanList);
            model.addAttribute("testTypeList",testTypeList);
            return "evaluation/plan-management";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }

    }

    /**
     * 根据ID删除考核计划
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/del/{id}",method = RequestMethod.GET)
    public String del(@PathVariable("id") int id)throws Exception{
        try {
            TestPlan testPlan = testPlanService.queryTestPlan(id);
            if (testPlan.getIsAvailable()==1){
                testPlan.setIsAvailable(0);
            }else if (testPlan.getIsAvailable()==0){
                testPlan.setIsAvailable(1);
            }
            testPlanService.delTestPlan(testPlan);
            return "redirect:/testplan/list";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    /**
     * 跳转到新增页面
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/toadd",method = RequestMethod.GET)
    public String toAdd(Model model)throws Exception{
        try{
            List<TestType> testTypeList = testTypeService.listAll();
            model.addAttribute("testTypeList",testTypeList);
            return "evaluation/plan-management-add";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    /**
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(@RequestParam("testName") String testName, @RequestParam("testTypeId") int testTypeId, @RequestParam("startTime") String startTime, @RequestParam("finishTime") String finishTime, HttpSession session)throws Exception{
        try{
            User  user = userService.queryByUname((String) session.getAttribute("username"));

            TestPlan testPlan = new TestPlan();
            testPlan.setUid(user.getId());
            testPlan.setTestName(testName);
            testPlan.setTestTypeId(testTypeId);
            testPlan.setStartTime(startTime);
            testPlan.setFinishTime(finishTime);
            testPlan.setDid(user.getDid());
            testPlanService.addTestPlan(testPlan);
            return "redirect:/testplan/list";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    /**
     * 跳转到考核分配页面
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/toallot/{id}",method = RequestMethod.GET)
    public String toAllot(@PathVariable("id") int id,Model model)throws Exception{
        TestPlan testPlan = testPlanService.queryTestPlan(id);
        model.addAttribute("testPlan",testPlan);
        return "evaluation/allot-detail";
    }

    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public String toAllotDetail()throws Exception{
        return "evaluation/allot-detail";
    }
}
