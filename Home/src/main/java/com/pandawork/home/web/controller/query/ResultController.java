package com.pandawork.home.web.controller.query;

import com.pandawork.home.common.dto.YearMonthExportDto;
import com.pandawork.home.common.dto.YearQueaterExportDto;
import com.pandawork.home.common.entity.system.Department;
import com.pandawork.home.common.entity.system.Role;
import com.pandawork.home.service.check.*;
import com.pandawork.home.service.query.YearMonthService;
import com.pandawork.home.service.query.YearQueaterService;
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
    @Autowired
    YearMonthService yearMonthService;
    @Autowired
    YearQueaterService yearQueaterService;


    /**
     * 报表展示页面
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/month/result",method = RequestMethod.GET)
    public String queryResult(Model model, HttpSession session)throws Exception{
        List<YearMonthExportDto> list = yearMonthService.listAll();

        List<Department> departmentList = departmentService.listAll();
        List<Role> roleList = roleService.listAll();
        model.addAttribute("departmentList",departmentList);
        model.addAttribute("roleList",roleList);
        model.addAttribute("list",list);
        return "performance/month/month-list";
    }

    /**
     * 月工作计划展示
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/queater/result",method = RequestMethod.GET)
    public String monthList(Model model)throws Exception{
        List<YearQueaterExportDto> list = yearQueaterService.listAll();
        List<Department> departmentList = departmentService.listAll();
        List<Role> roleList = roleService.listAll();
        model.addAttribute("departmentList",departmentList);
        model.addAttribute("roleList",roleList);
        model.addAttribute("list",list);
        return "performance/month/queater-list";
    }



}
