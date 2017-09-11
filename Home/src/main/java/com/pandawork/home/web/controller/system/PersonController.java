package com.pandawork.home.web.controller.system;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.home.common.entity.system.Department;
import com.pandawork.home.common.entity.system.Role;
import com.pandawork.home.common.entity.user.User;
import com.pandawork.home.service.system.DepartmentService;
import com.pandawork.home.service.system.RoleService;
import com.pandawork.home.service.user.UserService;
import com.pandawork.home.web.controller.AbstractController;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/9/4.
 */

@Controller
@RequestMapping("/user")
public class PersonController extends AbstractController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    DepartmentService departmentService;

    /**
     * 获取用户列表
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String toPerson(Model model)throws Exception{
        try{
            List<User> userList = userService.queryByIsDelete(1);
            List<Role> roleList = roleService.listAll();
            List<Department> departmentList = departmentService.listAll();
            model.addAttribute("userList",userList);
            model.addAttribute("roleList",roleList);
            model.addAttribute("departmentList",departmentList);
            return "system/personnel-list";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    /**
     * 根据ID删除用户信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/ajax/del/{id}",method = RequestMethod.GET)
    public JSONObject del(@PathVariable("id") int id){
        try{
            User user = userService.queryById(id);
            user.setIsDelete(0);
            userService.delUser(user);

            return sendJsonObject(AJAX_SUCCESS_CODE);
        }catch (SSException e){
            LogClerk.errLog.error(e);
            return sendErrMsgAndErrCode("操作失败！");
        }
    }

    /**
     * 跳转到人员列表
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/account/list",method = RequestMethod.GET)
    public String toAccount(Model model)throws Exception{
        try{
            List<User> userList = userService.queryByIsDelete(1);
            List<Role> roleList = roleService.listAll();
            List<Department> departmentList = departmentService.listAll();
            model.addAttribute("userList",userList);
            model.addAttribute("roleList",roleList);
            model.addAttribute("departmentList",departmentList);
            return "system/account-list";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    /**
     * 审核
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/status/{id}",method = RequestMethod.GET)
    public String status(@PathVariable("id") int id)throws Exception{
        try{
            User user = userService.queryById(id);
            int i = user.getStatus();
            if (i==0){
                i =1;
            }else {
                i=0;
            }
            user.setStatus(i);
            userService.statusUser(user);
            return "redirect:/user/account/list";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    /**
     * 编辑用户信息
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/ajax/update/{id}")
    public JSONObject update(@PathVariable("id") int id)throws Exception{
        User user = userService.queryById(id);
        List<Role> roleList = roleService.listAll();
        List<Department> departmentList = departmentService.listAll();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user",user);
        jsonObject.put("roleList",roleList);
        jsonObject.put("departmentList",departmentList);
        return  sendJsonObject(jsonObject);
    }
}
