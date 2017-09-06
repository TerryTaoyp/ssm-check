package com.pandawork.home.web.controller;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.framework.web.spring.controller.Base;
import com.pandawork.home.service.check.TestPlanService;
import com.pandawork.home.service.check.TestTypeService;
import com.pandawork.home.service.check.WorkPlanService;
import com.pandawork.home.service.system.AllotService;
import com.pandawork.home.service.system.DepartmentService;
import com.pandawork.home.service.system.PowerService;
import com.pandawork.home.service.system.RoleService;
import com.pandawork.home.service.user.UserService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AbstractController extends Base {

    //每页的数据条数
    public static final int pageSize = 15;
    // ajax默认成功代码
    protected final static int AJAX_SUCCESS_CODE = 0;
    // ajax默认失败代码
    protected final static int AJAX_FAILURE_CODE = 1;

    //保存成功
    protected final static String SAVE_SUCCESS_MSG = "保存成功!";

    // 添加成功
    protected final static String NEW_SUCCESS_MSG = "提交成功!";

    // 修改成功
    protected final static String UPDATE_SUCCESS_MSG = "修改成功!";

    //该学生审核已通过，如需修改请与就业中心联系
    protected final static String UPDATE_ERROR_MSG = "该学生审核已通过，如需修改请与就业中心联系";


    // 系统异常返回页面
    protected final static String ADMIN_SYS_ERR_PAGE = "forward:/500.jsp";

    public void init(HttpServletRequest request, HttpServletResponse response) {
        super.init(request, response); // 执行父类的初始化
    }

    /**
     * 发送json对象
     *
     * @param json
     * @return
     */
    public JSONObject sendJsonObject(JSONObject json) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 0);
        if (json != null) {
            jsonObject.put("data", json);
        }
        return jsonObject;
    }

    /**
     * 发送无数据与的json对象
     *
     * @param code
     * @return
     */
    protected JSONObject sendJsonObject(int code) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", code);
        return jsonObject;
    }

    /**
     * 发送json对象
     *
     * @param json
     * @return
     */
    protected JSONObject sendJsonObject(JSONObject json, int code) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", code);
        if (json != null) {
            jsonObject.put("data", json);
        }
        return jsonObject;
    }

    /**
     * 发送json数组对象
     *
     * @param jsonArray
     * @return
     */
    public
    @ResponseBody
    JSONObject sendJsonArray(JSONArray jsonArray) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 0);
        jsonObject.put("data", jsonArray);
        return jsonObject;
    }

    /**
     * 发送json数组对象
     *
     * @param jsonArray
     * @return
     */
    public JSONObject sendJsonArray(JSONArray jsonArray, int dataCount) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 0);
        jsonObject.put("data", jsonArray);
        jsonObject.put("dataCount", dataCount);
        return jsonObject;
    }

    // 发送ajax错误信息
    public JSONObject sendErrMsgAndErrCode(SSException e) {
        JSONObject json = new JSONObject();
        json.put("errMsg", e.getMessage());
        json.put("code", e.getCode());
        return json;
    }

    // 发送ajax错误信息(字符串)
    public JSONObject sendErrMsgAndErrCode(String e) {
        JSONObject json = new JSONObject();
        json.put("errMsg", e);
        json.put("code", 1);
        return json;
    }
    @Autowired
    protected static UserService userService;
    @Autowired
    protected static RoleService roleService;
    @Autowired
    protected static PowerService powerService;
    @Autowired
    protected static DepartmentService departmentService;
    @Autowired
    protected static AllotService allotService;
    @Autowired
    protected static WorkPlanService workPlanService;
    @Autowired
    protected static TestPlanService testPlanService;
    @Autowired
    protected static TestTypeService testTypeService;

}
