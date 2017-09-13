package com.pandawork.home.web.controller.query;

import com.pandawork.home.common.entity.check.*;
import com.pandawork.home.common.entity.system.Department;
import com.pandawork.home.common.entity.system.Role;
import com.pandawork.home.common.entity.user.User;
import com.pandawork.home.service.check.*;
import com.pandawork.home.service.system.DepartmentService;
import com.pandawork.home.service.system.RoleService;
import com.pandawork.home.service.user.UserService;
import com.pandawork.home.web.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Taoyongpan on 2017/9/10.
 */
@Controller
@RequestMapping("/query")
public class ResultController extends AbstractController {
    @Autowired
    WorkPlanService workPlanService;
    @Autowired
    WorkDetailService workDetailService;
    @Autowired
    UserService userService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    RoleService roleService;
    @Autowired
    PerformanceService performanceService;
    @Autowired
    AbilityResultService abilityResultService;
    @Autowired
    TestPlanService testPlanService;
    @Autowired
    JoinTestService joinTestService;
    /**
     * 报表展示页面
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/result",method = RequestMethod.GET)
    public String queryResult(Model model, HttpSession session)throws Exception{

        List<User> userList = userService.queryByIsDelete(1);
        List<Department> departmentList = departmentService.listAll();
        List<Role> roleList = roleService.listAll();
        List<Performance> performanceList = performanceService.listAll();
        List<AbilityResult> abilityResultList = abilityResultService.listAll();
        List<TestPlan> testPlanList = testPlanService.listAll();
        List<WorkPlan> workPlanList = workPlanService.listAll();
        List<JoinTest> joinTestList = joinTestService.listAll();
        model.addAttribute("joinTestList",joinTestList);
        model.addAttribute("workPlanList",workPlanList);
        model.addAttribute("userList",userList);
        model.addAttribute("departmentList",departmentList);
        model.addAttribute("roleList",roleList);
        model.addAttribute("performanceList",performanceList);
        model.addAttribute("abilityResultList",abilityResultList);
        model.addAttribute("testPlanList",testPlanList);
        return "performance/result";
    }

    /**
     * 月工作计划展示
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/month/plan",method = RequestMethod.GET)
    public String monthList()throws Exception{
        return "performance/month/plan";
    }

    /**
     * 副总经理结果查询
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/year/vice",method = RequestMethod.GET)
    public String yearVice()throws Exception{
        return "performance/year/vice-president";
    }

    /**
     * 综合绩效考评结果报表
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/year/synthetical",method = RequestMethod.GET)
    public String yearSynthetical()throws Exception{
        return "performance/year/synthetical";
    }

    /**
     * 能力指标考评结果报表
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/year/ability",method = RequestMethod.GET)
    public String yearAbility()throws Exception{
        return "performance/year/ability";
    }
}
