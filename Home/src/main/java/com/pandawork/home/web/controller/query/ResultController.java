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
import org.springframework.web.bind.annotation.RequestParam;

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
     * 越大越报表展示页面
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/month/result",method = RequestMethod.GET)
    public String queryResult(Model model, HttpSession session)throws Exception{
        int power = (int) session.getAttribute("power");
        List<YearMonthExportDto> list = yearMonthService.listAll();
        List<Department> departmentList = departmentService.listAll();
        List<Role> roleList = roleService.listAll();
        model.addAttribute("departmentList",departmentList);
        model.addAttribute("roleList",roleList);
        model.addAttribute("list",list);
        return "performance/month/month-list";
    }
    /**
     * 根据条件查询
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/month/query",method = RequestMethod.POST)
    public String monthQuery(@RequestParam(value = "did",required = false, defaultValue = "-1") int did,                                   @RequestParam(value = "rid",required = false, defaultValue = "-1") int rid,
                             @RequestParam(value = "year",required = false, defaultValue = "-1") int year,                                 @RequestParam(value = "username",required = false, defaultValue = "") String username,Model model)throws Exception{
        List<YearMonthExportDto> list = yearMonthService.queryByConditions(did, rid, year, username);
        List<Department> departmentList = departmentService.listAll();
        List<Role> roleList = roleService.listAll();
        model.addAttribute("departmentList",departmentList);
        model.addAttribute("roleList",roleList);
        model.addAttribute("list",list);
        return "performance/month/month-list";
    }
    /**
     * 季度工作计划展示
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/quarter/result",method = RequestMethod.GET)
    public String quarterList(Model model)throws Exception{
        List<YearQueaterExportDto> list = yearQueaterService.listAll();
        List<Department> departmentList = departmentService.listAll();
        List<Role> roleList = roleService.listAll();
        model.addAttribute("departmentList",departmentList);
        model.addAttribute("roleList",roleList);
        model.addAttribute("list",list);
        return "performance/month/queater-list";
    }

    /**
     * 根据条件查询
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/quarter/query",method = RequestMethod.POST)
    public String quarterQuery(@RequestParam(value = "did",required = false, defaultValue = "-1") int did, @RequestParam(value = "rid",required = false, defaultValue = "-1") int rid,
                               @RequestParam(value = "year",required = false, defaultValue = "-1") int year, @RequestParam(value = "username",required = false, defaultValue = "") String username,Model model)throws Exception{
        List<YearQueaterExportDto> list = yearQueaterService.queryDtoByConditions(did, rid, year, username);
        List<Department> departmentList = departmentService.listAll();
        List<Role> roleList = roleService.listAll();
        model.addAttribute("departmentList",departmentList);
        model.addAttribute("roleList",roleList);
        model.addAttribute("list",list);
        return "performance/month/queater-list";
    }


}
