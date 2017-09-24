package com.pandawork.home.web.controller.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.home.common.dto.AllotDto;
import com.pandawork.home.common.entity.check.*;
import com.pandawork.home.common.entity.system.Allot;
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
    @Autowired
    AbilityTestService abilityTestService;
    @Autowired
    AbilityAllotService abilityAllotService;

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
            if (power.getPower()<=2){
                List<User> userList = userService.queryByIsDelete(1);
                model.addAttribute("userList",userList);
            }else if (power.getPower()==9){
                List<AllotDto> userList = abilityAllotService.generalCheck(user.getDid());
                model.addAttribute("userList",userList);
            }else if (power.getPower()==8){
                List<AllotDto> userList = abilityAllotService.deputyCheck(user.getDid());
                model.addAttribute("userList",userList);
            }else if (power.getPower()==7){
                List<AllotDto> userList = abilityAllotService.dManagerCheck(user.getDid());
                model.addAttribute("userList",userList);
            }else if (power.getPower()==6){
                List<Allot> allotList = allotService.queryByUid(user.getId());
                List<User> userList = null;
                for (Allot allot:allotList){
                    List<User> userList1 = userService.queryByDid(allot.getDid());
                    userList.addAll(userList1);
                }
                model.addAttribute("userList",userList);
            }else if (power.getPower()==5){
                List<AllotDto> userList = abilityAllotService.topManagerCheck();
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
    @RequestMapping(value = "/month/detail/{id}&{uid}",method = RequestMethod.GET)
    public String monthDetail(@PathVariable("id") int id,@PathVariable("uid") int uid,Model model,HttpSession session)throws Exception{
        User user = userService.queryByUname((String) session.getAttribute("username"));
        WorkPlan workPlan = workPlanService.queryByTestId(id);
        List<WorkDetail> workDetailList = workDetailService.queryByUidAndWid(uid,workPlan.getId());
        List<User> userList = userService.listAll();
//        AllotDto allotDto = allotService.queryByUid(uid);
        List<TestPlan> testPlanList = testPlanService.listAll();
        model.addAttribute("id",id);
        model.addAttribute("uid",uid);//用户ID
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

        AbilityTest abilityTest = abilityTestService.queryByTidAndUid(id,user.getId());
        model.addAttribute("abilityTest",abilityTest);
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
     * 能力指标打分
     * @return
     * @throws SSException
     */
    @RequestMapping(value = "/year/ability/check",method = RequestMethod.POST)
    public String abilityCheck(@RequestParam("score") Double score,@RequestParam("beCheckId") int beCheckId,HttpSession session,@RequestParam("testId") int testId,@RequestParam("year") int year) throws Exception {
        //考核者的信息
        User user1 = userService.queryByUname((String) session.getAttribute("username"));
        Role role1  = roleService.queryById(user1.getRid());
        Power power1 = powerService.queryById(role1.getPid());

        //被考核用户的信息
        User user2 = userService.queryById(beCheckId);
        Role role2 = roleService.queryById(user2.getRid());
        Power power2 = powerService.queryById(role2.getPid());

        AbilityTest abilityTest = new AbilityTest();
        abilityTest.setBeCheckId(beCheckId);
        abilityTest.getCheckId(user1.getId());
        abilityTest.setTestId(testId);
        //被考核用户为一般员工
        if (power2.getPower()==9){
            if (power1.getPower()==9){
                abilityTest.setScore(score*0.3);
                abilityTestService.addAbilityTest(abilityTest);
            }else if (power1.getPower()==8){
                abilityTest.setScore(score*0.5);
                abilityTestService.addAbilityTest(abilityTest);
            }else if (power1.getPower()==7){
                abilityTest.setScore(score*0.2);
                abilityTestService.addAbilityTest(abilityTest);
            }
        }
        //被考核用户为部门副经理
        else if (power2.getPower()==8){
            if (power1.getPower()==9){
                abilityTest.setScore(score*0.3);
                abilityTestService.addAbilityTest(abilityTest);
            }else if (power1.getPower()==7){
                abilityTest.setScore(score*0.5);
                abilityTestService.addAbilityTest(abilityTest);
            }else if (power1.getPower()==6){
                abilityTest.setScore(score*0.2);
                abilityTestService.addAbilityTest(abilityTest);
            }
        }
        //被考核用户身份为部门经理
        else if (power2.getPower()==7){
            if (power1.getPower()==8){
                abilityTest.setScore(score*0.3);
                abilityTestService.addAbilityTest(abilityTest);
            }else if (power1.getPower()==6){
                abilityTest.setScore(score*0.5);
                abilityTestService.addAbilityTest(abilityTest);
            }else if (power1.getPower()==5){
                abilityTest.setScore(score*0.2);
                abilityTestService.addAbilityTest(abilityTest);
            }
        }
        //被考核用户为公司副总经理
        else if (power2.getPower()==6){
            if (power1.getPower()==7){
                abilityTest.setScore(score*0.3);
                abilityTestService.addAbilityTest(abilityTest);
            }else if (power1.getPower()==5){
                abilityTest.setScore(score*0.5);
                abilityTestService.addAbilityTest(abilityTest);
            }else if (power1.getPower()==8){
                abilityTest.setScore(score*0.2);
                abilityTestService.addAbilityTest(abilityTest);
            }
        }
        double totalScore = 0;
        //查出所有本用户的被打分
        List<AbilityTest> abilityTestList = abilityTestService.queryByTestIdAndUid(testId,beCheckId);
        for (AbilityTest abilityTest1:abilityTestList){
            totalScore+=abilityTest1.getScore();
        }
        AbilityResult abilityResult = new AbilityResult();
        abilityResult.setBeCheckId(beCheckId);
        abilityResult.setCheckId(user1.getId());
        abilityResult.setTestId(testId);
        abilityResult.setFinishTime("");
        abilityResult.setTotalScore(totalScore);
        abilityResult.setYear(year);
        abilityResultService.addResult(abilityResult);

        return "exam/year/ability-user";
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
        double sumScore = 0;
        if (testPlan.getTestTypeId()==1){
            for (WorkPlan workPlan1 : workPlanList){
                sumScore+=workPlan1.getQueaterScore();
            }
            model.addAttribute("score",sumScore/workPlanList.size());
        }else if (testPlan.getTestTypeId()==2){
            for (WorkPlan workPlan1 : workPlanList){
                sumScore+=workPlan1.getMonthScore();
            }
            int size = workPlanList.size();
            model.addAttribute("score",sumScore/size);
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
//        WorkPlan workPlan = workPlanService.queryByTidAndUid(testPlan.getId(),uid);
        Summary summary = summaryService.queryByUidAndYear(uid,testPlan.getYear());
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
    public JSONObject marking(@RequestParam("id") int id,@RequestParam("uid") int uid,@RequestParam("completion") String completion, @RequestParam("testScore") double testScore,HttpSession session)throws Exception{
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
        //判断此次考核是否参加过
        List<WorkDetail> workDetails = workDetailService.queryByUidAndWid(uid,id);
        int sum = 0;
        for (WorkDetail workDetail1:workDetails){
            sum+=workDetail1.getIsJoin();
        }
        if (sum == workDetails.size()){
            JoinTest joinTest = joinTestService.queryByUidAndTid(uid,testPlan.getId());
            joinTest.setIsJoin(1);
            joinTestService.isJoin(joinTest);
        }
        User user = userService.queryByUname((String) session.getAttribute("username"));
        workPlan.setCheckId(user.getId());
        workPlanService.updateWorkPlan(workPlan);
        return sendJsonObject(1);
    }

    /**
     * 年度绩效打分
     * @param uid
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/year/mark",method = RequestMethod.GET)
    public JSONObject yearMarking(@RequestParam("beCheckId") int uid,@RequestParam("year") int year,@RequestParam("yearScore") Double yearScore,@RequestParam("suggestScore") Double suggestScore)throws Exception{
        if (Assert.isNull(uid)){
            return sendJsonObject(0);
        }
        Performance performance = performanceService.queryByUidAndYear(uid, year);
        performance.setYearScore(yearScore);
        performance.setSuggestScore(suggestScore);
        performanceService.updateYearScore(performance);
        return sendJsonObject(1);
    }

    /**
     * 个人总结打分
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/summary/mark",method = RequestMethod.GET)
    public JSONObject abilityMarking(@RequestParam("beCheckId") int uid,@RequestParam("year") int year,@RequestParam("summaryScore") Double summaryScore)throws Exception{

        Summary summary = summaryService.queryByUidAndYear(uid,year);
        summary.setSummaryScore(summaryScore);
        summary.setIsJoin(1);
        summaryService.updateScore(summary);
        Performance performance = performanceService.queryByUidAndYear(uid,year);
        performance.setSummaryScore(summaryScore);
        performanceService.updateSummaryScore(performance);
        return sendJsonObject(1);
    }
}
