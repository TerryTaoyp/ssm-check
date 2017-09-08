package com.pandawork.home.web.controller.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.home.common.entity.check.TestPlan;
import com.pandawork.home.common.entity.check.TestType;
import com.pandawork.home.common.entity.check.WorkDetail;
import com.pandawork.home.common.entity.check.WorkPlan;
import com.pandawork.home.common.entity.user.User;
import com.pandawork.home.service.check.TestPlanService;
import com.pandawork.home.service.check.TestTypeService;
import com.pandawork.home.service.check.WorkDetailService;
import com.pandawork.home.service.check.WorkPlanService;
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
            List<TestPlan> testPlanList = testPlanService.queryByUid(user.getId());
            List<TestType> testTypeList = testTypeService.listAll();
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
            WorkPlan workPlan = workPlanService.queryByTestId(id);
            List<WorkDetail> workDetailList = workDetailService.queryByWId(workPlan.getId());
            model.addAttribute("workPlan",workPlan);
            model.addAttribute("workDetailList",workDetailList);
            return "evaluation/month/plan-detail";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    /**
     * 跳转到月添加工作计划的页面
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/month/add",method = RequestMethod.GET)
    public String monthAdd()throws Exception{
        return "evaluation/month/plan-add";
    }
}
