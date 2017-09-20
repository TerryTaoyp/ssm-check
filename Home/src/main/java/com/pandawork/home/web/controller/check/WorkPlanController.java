package com.pandawork.home.web.controller.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.home.common.entity.check.*;
import com.pandawork.home.common.entity.system.Department;
import com.pandawork.home.common.entity.user.User;
import com.pandawork.home.service.check.*;
import com.pandawork.home.service.system.DepartmentService;
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
 * Created by Taoyongpan on 2017/9/6.
 */
@Controller
@RequestMapping("/workplan")
public class WorkPlanController extends AbstractController {
    @Autowired
    WorkPlanService workPlanService;
    @Autowired
    WorkDetailService workDetailService;
    @Autowired
    UserService userService;
    @Autowired
    TestPlanService testPlanService;
    @Autowired
    TestTypeService testTypeService;
    @Autowired
    JoinTestService joinTestService;
    @Autowired
    DepartmentService departmentService;

    /**
     * 获得月份的列表
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/month/list",method = RequestMethod.GET)
    public String monthList(HttpSession session, Model model)throws Exception{
        try{
            User user = userService.queryByUname((String) session.getAttribute("username"));

//            List<WorkPlan> workPlanList = workPlanService.queryByUid(user.getId());
            List<JoinTest> joinTestList = joinTestService.queryByUid(user.getId());
            List<TestPlan> testPlanList = testPlanService.listAll();
            List<TestType> testTypeList = testTypeService.listAll();
            model.addAttribute("joinTestList",joinTestList);
            model.addAttribute("testTypeList",testTypeList);
            model.addAttribute("testPlanList",testPlanList);
            return "evaluation/month/plan-list";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    /**
     * 跳转到更新页面
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/month/to/update",method = RequestMethod.GET)
    public JSONObject monthUpdate(@RequestParam("id") int id, Model model)throws Exception{
        WorkDetail workDetail = workDetailService.queryById(id);
        model.addAttribute("workDetail",workDetail);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("workDetail",workDetail);
        return sendJsonObject(jsonObject);
    }

    @ResponseBody
    @RequestMapping(value = "/month/update",method = RequestMethod.GET)
    public JSONObject update(@RequestParam("id") int wid, @RequestParam("startTime")String startTime,@RequestParam("startTime")String endTime,@RequestParam("weight")int weight,@RequestParam("planContent") String planContent,@RequestParam("excpetResult") String excpetResult,HttpSession session)throws Exception{
        User user = userService.queryByUname((String) session.getAttribute("username"));
        WorkDetail workDetail = new WorkDetail();
        workDetail.setUid(user.getId());
        workDetail.setWid(wid);
        workDetail.setWeight(weight);
        workDetail.setStartTime(startTime);
        workDetail.setEndTime(endTime);
        workDetail.setPlanContent(planContent);
        workDetail.setExpectResult(excpetResult);
        workDetailService.updateWorkDetail(workDetail);
        return sendJsonObject(1);
    }
    /**
     * 获得月季度工作计划的详情
     * @param model
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/month/detail/{id}",method = RequestMethod.GET)
    public String monthDetail(Model model,HttpSession session,@PathVariable("id") int id)throws Exception{
        try {
            User user = userService.queryByUname((String) session.getAttribute("username"));
            WorkPlan workPlan1 = workPlanService.queryByTestId(id);
            if (workPlan1==null){
                model.addAttribute("workDetailList",null);
                model.addAttribute("testPlan",null);
            }else {
                List<WorkDetail> workDetailList = workDetailService.queryByUidAndWid(user.getId(),workPlan1.getId());
                model.addAttribute("workDetailList",workDetailList);
                TestPlan testPlan = testPlanService.queryTestPlan(workPlan1.getTestId());
                model.addAttribute("testPlan",testPlan);
            }
            model.addAttribute("workPlan1",workPlan1);
            return "evaluation/month/plan-detail";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    /**
     * 跳转到新增页面
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/month/to/add/{id}",method = RequestMethod.GET)
    public String monthToAdd(@PathVariable("id") int id,Model model,HttpSession session)throws Exception{
        User user = userService.queryByUname((String) session.getAttribute("username"));
        WorkPlan workPlan = workPlanService.queryById(id);
        List<Department> departmentList = departmentService.listAll();
        TestPlan testPlan = testPlanService.queryTestPlan(workPlan.getTestId());
        model.addAttribute("workPlan",workPlan);
        model.addAttribute("departmentList",departmentList);
        model.addAttribute("testPlan",testPlan);
        return "evaluation/month/plan-add";
    }

    /**
     * 跳转到月添加工作计划的页面
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/month/add",method = RequestMethod.POST)
    public String monthAdd(@RequestParam("wid") int wid, @RequestParam("startTime")String startTime,@RequestParam("startTime")String endTime,@RequestParam("weight")int weight,@RequestParam("planContent") String planContent,@RequestParam("excpetResult") String excpetResult, HttpSession session)throws Exception{
        User user = userService.queryByUname((String) session.getAttribute("username"));
        WorkDetail workDetail = new WorkDetail();
        workDetail.setUid(user.getId());
        workDetail.setWid(wid);
        workDetail.setWeight(weight);
        workDetail.setStartTime(startTime);
        workDetail.setEndTime(endTime);
        workDetail.setPlanContent(planContent);
        workDetail.setExpectResult(excpetResult);
        workDetailService.addWorkDetail(workDetail);
        return "redirect:/workplan/month/detail/"+wid;
    }



}
