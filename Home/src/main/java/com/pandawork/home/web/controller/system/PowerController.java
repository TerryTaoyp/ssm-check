package com.pandawork.home.web.controller.system;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.home.common.entity.system.Power;
import com.pandawork.home.service.system.PowerService;
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
@RequestMapping("/power")
public class PowerController extends AbstractController {
    @Autowired
    PowerService powerService;

    /**
     * 列出所有权限
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(Model model)throws Exception{

        List<Power> powerList = powerService.listAll();
        model.addAttribute("powerList",powerList);
        return "system/jurisdiction-list";
    }

    /**
     * 删除
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/ajax/del/{id}",method = RequestMethod.GET)
     public JSONObject del(@PathVariable("id") int id)throws Exception{
        try{
            powerService.delPower(id);
            return sendJsonObject(1);
        }catch (SSException e){
            LogClerk.errLog.error(e);
            return sendErrMsgAndErrCode("操作失败！");
        }
     }
    /**
     * 跳转到新增页面
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/toadd",method = RequestMethod.GET)
    public String toAdd()throws Exception{
        return "system/jurisdiction-add";
    }

    /**
     * 新增权限
     * @param power
     * @param detail
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(@RequestParam("power") int power,@RequestParam("detail") String detail)throws Exception{
        try {
            Power power1 = new Power();
            power1.setPower(power);
            power1.setDetail(detail);
            powerService.addPower(power1);
            return "redirect:/power/list";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    /**
     * 根据ID更新
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/ajax/update/{id}")
    public JSONObject update(@PathVariable("id") int id)throws Exception{
        Power power = powerService.queryById(id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("power",power);
        return sendJsonObject(jsonObject);
    }
}
