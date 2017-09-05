package com.pandawork.home.web.controller.system;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.home.common.entity.system.Allot;
import com.pandawork.home.common.entity.system.Department;
import com.pandawork.home.common.entity.user.User;
import com.pandawork.home.service.system.AllotService;
import com.pandawork.home.service.system.DepartmentService;
import com.pandawork.home.service.user.UserService;
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
 * Created by Taoyongpan on 2017/9/5.
 * 管辖分配的Controller
 */
@Controller
@RequestMapping("/allot")
public class AllotController extends AbstractController {

    @Autowired
    AllotService allotService;
    @Autowired
    UserService userService;
    @Autowired
    DepartmentService departmentService;

    /**
     * 获取列表
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(Model model)throws Exception{
        try{
            List<Allot> allotList  = allotService.listAll();
            List<User> userList = userService.listAll();
            List<Department> departmentList = departmentService.listAll();
            List<User> userList1 = userService.queryByRole(9);
            model.addAttribute("allotList",allotList);
            model.addAttribute("userList",userList);
            model.addAttribute("departmentList",departmentList);
            model.addAttribute("userList1",userList1);
            return "system/allot-list";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    /**
     * 根据ID删除
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/del/{id}",method = RequestMethod.GET)
    public String del(@PathVariable("id") int id)throws Exception{
        try{
            allotService.delAllot(id);
            return "redirect:/allot/list";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    /**
     * 新增
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(@RequestParam("uid") int uid, @RequestParam("did") int did)throws Exception{
        try{
            Allot allot = new Allot();
            allot.setUid(uid);
            allot.setDid(did);
            allotService.addAllot(allot);
            return "redirect:/allot/list";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }
}
