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
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    AbilityPositionService abilityPositionService;
    @Autowired
    AbilityOptionService abilityOptionService;

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
            List<TestPlan> testPlanList = testPlanService.listAll();
            model.addAttribute("testPlanList",testPlanList);
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
            if (power.getPower()<=7){
                List<User> userList = userService.queryByIsDelete(1);
                model.addAttribute("userList",userList);
            }else if (power.getPower()==8 ||power.getPower()==9){
                List<User> userList = userService.queryByDidAndIsDelete(user.getDid(),1);
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
        model.addAttribute("id",id);
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
        List<TestPlan> testPlanList = testPlanService.queryByTypeId(3);
        model.addAttribute("testPlanList",testPlanList);
        List<TestType> testTypeList = testTypeService.listAll();
        model.addAttribute("testTypeList",testTypeList);
        return "exam/year/ability-list";
    }

    @RequestMapping(value = "/year/ability/user/{id}",method = RequestMethod.GET)
    public String user(@PathVariable("id") int id,HttpSession session,Model model)throws Exception{
        User user = userService.queryByUname((String) session.getAttribute("username"));
        Role role = roleService.queryById(user.getRid());
        Power power = powerService.queryById(role.getPid());
        List<JoinTest> joinTestList = joinTestService.queryByTid(id);
        List<Department> departmentList =departmentService.listAll();
        List<Role> roleList = roleService.listAll();
        if (power.getPower()<=7){
            List<User> userList = userService.queryByIsDelete(1);
            model.addAttribute("userList",userList);
        }else if (power.getPower()==8 ||power.getPower()==9){
            List<User> userList = userService.queryByDidAndIsDelete(user.getDid(),1);
            model.addAttribute("userList",userList);
        }
        TestPlan testPlan = testPlanService.queryTestPlan(id);
        model.addAttribute("testPlan",testPlan);
        model.addAttribute("power",power);
        model.addAttribute("joinTestList",joinTestList);
        model.addAttribute("roleList",roleList);
        model.addAttribute("departmentList",departmentList);
//        model.addAttribute("id",id);
        return "exam/year/ability-user";
    }

    /**
     * 进入能力指标考核
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/year/ability/detail/{id}&{uid}" ,method = RequestMethod.GET)
    public String yearAbility(@PathVariable("id") int tid,@PathVariable("uid") int uid,Model model)throws Exception{

        List<AbilityPosition> abilityPositionList = abilityPositionService.queryByTestId(tid);
        List<AbilityOption> abilityOptionList = abilityOptionService.queryByTestId(tid);
        TestPlan testPlan = testPlanService.queryTestPlan(tid);
        model.addAttribute("testPlan",testPlan);
        model.addAttribute("abilityPositionList",abilityPositionList);
        model.addAttribute("abilityOptionList",abilityOptionList);
        model.addAttribute("id",tid);//把考核计划的ID传到jsp页面
        return "exam/year/ability-detail";
    }
    /**
     * 综合绩效列表
     * @param session
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/year/performance/{id}&{uid}",method = RequestMethod.GET)
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
        return "exam/year/evaluation-detail";
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
        List<TestPlan> testPlanList = testPlanService.listAll();
        model.addAttribute("testPlanList",testPlanList);
        List<TestType> testTypeList = testTypeService.listAll();
        model.addAttribute("testTypeList",testTypeList);
        return "exam/year/evaluation-list";
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
            if (power.getPower()<=2){
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
        return "exam/year/evaluation-user";
    }

    /**
     * 月度打分
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/month/mark",method = RequestMethod.GET)
    public JSONObject marking(@RequestParam("id") int id, @RequestParam("completion") String completion, @RequestParam("testScore") double testScore,HttpSession session)throws Exception{
        WorkDetail workDetail = workDetailService.queryById(id);
        workDetail.setCompletion(completion);
        workDetail.setTestScore(testScore);
        workDetail.setIsJoin(1);
        workDetailService.marking(workDetail);
        WorkPlan workPlan = workPlanService.queryById(workDetail.getWid());
        TestPlan testPlan = testPlanService.queryTestPlan(workPlan.getTestId());
        if (testPlan.getTestTypeId()==1){
            double quarterScore = workPlan.getQueaterScore()+testScore*(workDetail.getWeight()/100);
            workPlan.setQueaterScore(quarterScore);
        }else if (testPlan.getTestTypeId()==2){
            double monthScore = workPlan.getMonthScore()+testScore*(workDetail.getWeight()/100);
            workPlan.setMonthScore(monthScore);
        }
        User user = (User) session.getAttribute("username");
        workPlan.setCheckId(user.getId());
        workPlanService.updateWorkPlan(workPlan);
        return sendJsonObject(1);
    }


}
