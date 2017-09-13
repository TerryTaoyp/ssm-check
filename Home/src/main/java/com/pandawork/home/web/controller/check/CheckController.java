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
    @Autowired
    TestTypeService testTypeService;
    @Autowired
    JoinTestService joinTestService;

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
            List<TestType> testTypeList = testTypeService.listAll();
            model.addAttribute("testTypeList",testTypeList);
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
        return "exam/month/exam-list";
    }

    /**
     * 跳转到某一次列表页
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/month/detail/list/{id}" ,method = RequestMethod.GET)
    public String detailList(@PathVariable("id") int id, HttpSession session, Model model)throws Exception{
        try {
            User user = userService.queryByUname((String) session.getAttribute("username"));
            Role role = roleService.queryById(user.getRid());
            Power power = powerService.queryById(role.getPid());
            List<JoinTest> joinTestList = joinTestService.queryByTid(id);
            List<Department> departmentList =departmentService.listAll();
            List<Role> roleList = roleService.listAll();
            if (power.getPower()<=1){
                List<User> userList = userService.listAll();
                model.addAttribute("userList",userList);
            }else if (power.getPower()==5){
                List<User> userList = userService.queryByDid(user.getDid());
                model.addAttribute("userList",userList);
            }
            TestPlan testPlan = testPlanService.queryTestPlan(id);
            model.addAttribute("testPlan",testPlan);
            model.addAttribute("power",power);
            model.addAttribute("joinTestList",joinTestList);
            model.addAttribute("roleList",roleList);
            model.addAttribute("departmentList",departmentList);
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
        return "exam/month/exam-detail-list";
    }
    /**
     * 跳转到月份的详情页面
     * @param id
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/month/detail/{id}",method = RequestMethod.GET)
    public String monthDetail(@PathVariable("id") int id,Model model,HttpSession session)throws Exception{
        User user = userService.queryByUname((String) session.getAttribute("username"));
        WorkPlan workPlan = workPlanService.queryByTestId(id);
        List<WorkDetail> workDetailList = workDetailService.queryByUidAndWid(user.getId(),workPlan.getId());
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
    @RequestMapping(value = "/year/ability/list",method = RequestMethod.GET)
    public String yearAbility(HttpSession session,Model model)throws Exception{
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
        List<TestType> testTypeList = testTypeService.listAll();
        model.addAttribute("testTypeList",testTypeList);
        return "exam/year/evaluation-list";
    }

    /**
     * 综合绩效列表
     * @param session
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "year/performance/{id}&{uid}",method = RequestMethod.GET)
    public String yearPerformance(@PathVariable("id") int id,@PathVariable("uid") int uid,HttpSession session,Model model)throws Exception{
        TestPlan testPlan = testPlanService.queryTestPlan(id);
        model.addAttribute("testPlan",testPlan);
        WorkPlan workPlan = workPlanService.queryByTestId(id);
        List<WorkPlan> workPlanList = workPlanService.queryByUidAndYear(uid,workPlan.getYear());
        Summary summary = summaryService.queryByUidAndYear(uid,workPlan.getYear());
        List<TestType> testTypeList = testTypeService.listAll();
        int sumScore = 0;
        if (testPlan.getTestTypeId()==1){
            for (WorkPlan workPlan1 : workPlanList){
                sumScore+=workPlan1.getQueaterScore();
            }
            model.addAttribute("score",sumScore/4);
        }else if (testPlan.getTestTypeId()==2){
            for (WorkPlan workPlan1 : workPlanList){
                sumScore+=workPlan1.getMonthScore();
            }
            model.addAttribute("score",sumScore/12);
        }
        model.addAttribute("testTypeList",testTypeList);
        model.addAttribute("summary",summary);
        model.addAttribute("workPlanList",workPlanList);
        model.addAttribute("id",id);
        model.addAttribute("uid",uid);
        return "exam/year/exam-list";
    }

    /**
     * 年度绩效考核
     * @param model
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/year/summary/list",method = RequestMethod.GET)
    public String yearSummary(Model model,HttpSession session)throws Exception{
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
        List<TestType> testTypeList = testTypeService.listAll();
        model.addAttribute("testTypeList",testTypeList);
        return "exam/year/summary-detail-list";
    }

    /**
     * 年度总结考核
     * @param model
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/year/summary/{id}&{uid}",method = RequestMethod.GET)
    public String yearSummary1(@PathVariable("id") int id,@PathVariable("uid") int uid,Model model,HttpSession session)throws Exception{
        User user = userService.queryByUname((String) session.getAttribute("username"));
        TestPlan testPlan = testPlanService.queryTestPlan(id);
        WorkPlan workPlan = workPlanService.queryByTestId(testPlan.getId());
        Summary summary = summaryService.queryByUidAndYear(uid,workPlan.getYear());
        model.addAttribute("summary",summary);
        model.addAttribute("id",id);
        model.addAttribute("uid",uid);
        return "exam/year/summary-detail";
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

    @RequestMapping(value = "/year/user/{id}",method = RequestMethod.GET)
    public String yearUser(HttpSession session,Model model,@PathVariable("id") int id)throws Exception{
        try {
            User user = userService.queryByUname((String) session.getAttribute("username"));
            Role role = roleService.queryById(user.getRid());
            Power power = powerService.queryById(role.getPid());
            List<JoinTest> joinTestList = joinTestService.queryByTid(id);
            List<Department> departmentList =departmentService.listAll();
            List<Role> roleList = roleService.listAll();
            if (power.getPower()<=1){
                List<User> userList = userService.listAll();
                model.addAttribute("userList",userList);
            }else if (power.getPower()==5){
                List<User> userList = userService.queryByDid(user.getDid());
                model.addAttribute("userList",userList);
            }
            TestPlan testPlan = testPlanService.queryTestPlan(id);
            model.addAttribute("testPlan",testPlan);
            model.addAttribute("power",power);
            model.addAttribute("joinTestList",joinTestList);
            model.addAttribute("roleList",roleList);
            model.addAttribute("departmentList",departmentList);
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
        return "exam/year/user-list";
    }
}
