package com.pandawork.home.web.controller.system;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.home.common.entity.system.Power;
import com.pandawork.home.common.entity.system.Role;
import com.pandawork.home.service.system.PowerService;
import com.pandawork.home.service.system.RoleService;
import com.pandawork.home.web.controller.AbstractController;
import net.sf.json.JSONObject;
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
@RequestMapping("/role")
public class RoleController extends AbstractController {

    @Autowired
    RoleService roleService;
    @Autowired
    PowerService powerService;


    /**
     * 列出所有角色
     * @return
     * @throws SSException
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(Model model) throws Exception {

        List<Role> roleList = roleService.queryByIsDelete(1);
        model.addAttribute("roleList",roleList);
        return "system/role-list";
    }

    /**
     * 删除角色
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/ajax/del/{id}",method = RequestMethod.GET)
    public JSONObject del(@PathVariable("id") int id)throws Exception{
        try{
            Role role  = roleService.queryById(id);
            roleService.delRole(role);
            return sendJsonObject(1);
        }catch (SSException e)
        {
            LogClerk.errLog.error(e);
            return sendErrMsgAndErrCode("操作失败！");
        }
    }

    /**
     * 跳转到添加角色页面
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/toadd",method = RequestMethod.GET)
    public String toAdd(Model model)throws Exception{
        List<Power> powerList = powerService.listAll();
        model.addAttribute("powerList",powerList);
        return "system/role-add";
    }

    /**
     * 新增角色
     * @param name
     * @param pid
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(@RequestParam("name") String name,@RequestParam("pid") int pid)throws Exception{
        try{
            Role role = new Role();
            role.setName(name);
            role.setPid(pid);
            roleService.addRole(role);
            return "redirect:/role/list";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    /**
     * 跳转至更新角色
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/ajax/update/{id}",method = RequestMethod.GET)
    public JSONObject update(@PathVariable("id") int id)throws Exception{
        Role role = roleService.queryById(id);
        List<Power> powerList = powerService.listAll();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("powerList",powerList);
        jsonObject.put("role",role);
        return sendJsonObject(jsonObject);
    }

    /**
     * 更新角色
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/update/{id}",method = RequestMethod.GET)
    public String update(@PathVariable("id") int id,@RequestParam("pid") int pid,@RequestParam("name") String name)throws Exception{
        Role role = roleService.queryById(id);
        role.setName(name);
        role.setPid(pid);
        roleService.updateRole(role);
        return "redirect:/role/list";
    }
}
