package com.pandawork.home.web.controller.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.home.common.entity.check.Performance;
import com.pandawork.home.common.entity.check.WorkPlan;
import com.pandawork.home.common.entity.user.User;
import com.pandawork.home.service.check.PerformanceService;
import com.pandawork.home.service.check.WorkPlanService;
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
 * Created by Taoyongpan on 2017/9/8.
 */
@Controller
@RequestMapping("/performance")
public class PerformanceController extends AbstractController {
    @Autowired
    PerformanceService performanceService;
    @Autowired
    UserService userService;
    @Autowired
    WorkPlanService workPlanService;

    /**
     * 获取综合绩效列表页
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(Model model, HttpSession session)throws Exception{
        try{
            User user = userService.queryByUname((String) session.getAttribute("username"));
            List<Performance> performanceList = performanceService.queryByUid(user.getId());
            List<Performance> performanceYear = performanceService.queryYearByUid(user.getId());
            List<WorkPlan> workPlanList = workPlanService.queryByUid(user.getId());
            int size = performanceYear.size();
//            Performance performance =
            model.addAttribute("performanceList",performanceList);
            model.addAttribute("performanceYear",performanceYear);
            model.addAttribute("size",size);
            model.addAttribute("workPlanList",workPlanList);
            return "evaluation/year/synthetical-list";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

}
