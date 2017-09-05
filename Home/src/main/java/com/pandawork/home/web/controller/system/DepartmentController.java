package com.pandawork.home.web.controller.system;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.home.common.entity.system.Department;
import com.pandawork.home.service.system.DepartmentService;
import com.pandawork.home.web.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/9/4.
 */
@Controller
@RequestMapping("/department")
public class DepartmentController extends AbstractController {

    @Autowired
    DepartmentService departmentService;

    /**
     * 列表页面
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(Model model)throws Exception{
        try{
            List<Department> departmentList = departmentService.queryByIsDelete(1);
            model.addAttribute("departmentList",departmentList);
            return "system/department-list";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }

    }

    /**
     * 跳转到登录页面
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/toadd",method = RequestMethod.GET)
    public String toAdd()throws Exception{
        return "system/department-add";
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/del/{id}",method = RequestMethod.GET)
    public String del(@PathVariable("id") int id)throws Exception{
        try{
            Department department = departmentService.queryById(id);
            department.setIsDelete(0);
            departmentService.delDepartment(department);
            return "redirect:/department/list";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }

    }

    /**
     * 新增部门
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(@RequestParam("name") String name)throws Exception{
        try{
            Department department = new Department();
            department.setName(name);
            departmentService.addDepartment(department);
            return "redirect:/department/list";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }

    }
}
