package com.pandawork.home.web.controller.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.home.common.entity.check.*;
import com.pandawork.home.common.entity.system.Department;
import com.pandawork.home.common.entity.system.Power;
import com.pandawork.home.common.entity.system.Role;
import com.pandawork.home.common.entity.user.User;
import com.pandawork.home.service.check.*;
import com.pandawork.home.service.system.DepartmentService;
import com.pandawork.home.service.system.PowerService;
import com.pandawork.home.service.system.RoleService;
import com.pandawork.home.service.user.UserService;
import com.pandawork.home.web.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Taoyongpan on 2017/9/10.
 */
@Controller
@RequestMapping("/check")
public class CheckController extends AbstractController {
    @Autowired
    WorkPlanService workPlanService;
    @Autowired
    WorkDetailService workDetailService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    RoleService roleService;
    @Autowired
    UserService userService;
    @Autowired
    PowerService powerService;
    @Autowired
    TestPlanService testPlanService;
    @Autowired
    SummaryService summaryService;
    @Autowired
    PerformanceService performanceService;

    /**
     * 获取月份的工作计划
     * @param model
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/month/list",method = RequestMethod.GET)
    public String monthList(Model model, HttpSession session)throws Exception{
        try {
            User user = userService.queryByUname((String) session.getAttribute("username"));
            Role role = roleService.queryById(user.getRid());
            Power power = powerService.queryById(role.getPid());
            if (power.getPower()<=1){
                List<TestPlan> testPlanList = testPlanService.listAll();
                model.addAttribute("testPlanList",testPlanList);
            }else if (power.getPower() == 5){
                List<TestPlan> testPlanList = testPlanService.queryByDid(user.getDid());
                model.addAttribute("testPlanList",testPlanList);
            }
            List<Department> departmentList =departmentService.listAll();
            List<Role> roleList = roleService.listAll();
            List<User> userList = userService.listAll();
            model.addAttribute("userList",userList);
            model.addAttribute("roleList",roleList);
            model.addAttribute("departmentList",departmentList);
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
        return "exam/month/exam-list";
    }

    /**
     * 跳转到月份 的详情页面
     * @param id
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/month/detail/{id}",method = RequestMethod.GET)
    public String monthDetail(@PathVariable("id") int id,Model model)throws Exception{
        WorkPlan workPlan = workPlanService.queryByTestId(id);
        List<WorkDetail> workDetailList = workDetailService.queryByWId(workPlan.getId());
        List<User> userList = userService.listAll();
        List<TestPlan> testPlanList = testPlanService.listAll();
        model.addAttribute("testPlanList",testPlanList);
        model.addAttribute("userList",userList);
        model.addAttribute("workPlan",workPlan);
        model.addAttribute("workDetailList",workDetailList);
        return "exam/month/exam-detail";
    }

    /**
     * 能力指标
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/year/ability",method = RequestMethod.GET)
    public String yearAbility()throws Exception{
        return "exam/year/evaluation-list";
    }

    /**
     * 综合绩效列表
     * @param session
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "year/performance",method = RequestMethod.GET)
    public String yearPerformance(HttpSession session,Model model)throws Exception{
        User user = userService.queryByUname((String) session.getAttribute("username"));
        Role role = roleService.queryById(user.getRid());
        Power power = powerService.queryById(role.getPid());
        if (power.getPower()<=1){
            List<Performance> performanceList = performanceService.listAll();
            model.addAttribute("performanceList",performanceList);
        }else if (power.getPower()==5){
            List<Performance> performanceList = performanceService.queryByDid(user.getDid());
            model.addAttribute("performanceList",performanceList);
        }
        List<Performance> performanceYear = performanceService.queryYearByUid(user.getId());
        List<WorkPlan> workPlanList = workPlanService.queryByUid(user.getId());
        model.addAttribute("performanceYear",performanceYear);
        model.addAttribute("workPlanList",workPlanList);
        return "exam/year/exam-list";
    }

    /**
     * 年度总结考核
     * @param model
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/year/summary",method = RequestMethod.GET)
    public String yearSummary(Model model,HttpSession session)throws Exception{
        User user = userService.queryByUname((String) session.getAttribute("username"));
        Role role = roleService.queryById(user.getRid());
        Power power = powerService.queryById(role.getPid());
        if (power.getPower()<=1){
            List<Summary> summaryList = summaryService.listAll();
            model.addAttribute("summaryList",summaryList);
        }else if (power.getPower() == 5){
            List<Summary> summaryList = summaryService.queryByDid(user.getDid());
            model.addAttribute("summaryList",summaryList);
        }
        List<Department> departmentList =departmentService.listAll();
        List<Role> roleList = roleService.listAll();
        model.addAttribute("roleList",roleList);
        model.addAttribute("departmentList",departmentList);
        model.addAttribute("user",user);
        return "exam/year/summary-list";
    }

    /**
     * 年度总结详情页面
     * @param id
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/year/summary/detail/{id}")
    public String summaryDetail(@PathVariable("id") int id,Model model)throws Exception{
        Summary summary = summaryService.queryById(id);
        model.addAttribute("summary",summary);
        return "exam/year/summary-detail";
    }
}
