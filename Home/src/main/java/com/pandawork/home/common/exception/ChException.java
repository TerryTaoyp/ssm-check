package com.pandawork.home.common.exception;

import com.pandawork.core.common.exception.IBizExceptionMes;

/**
 * Created by Taoyongpan on 2017/8/12.
 */
public enum  ChException implements IBizExceptionMes{
    //登陆注册相关的异常
    UserExist("该用户名已经存在",1),
    QueryByRnameFailed("根据真是姓名查找用户失败",2),
    QueryByUnameFailed("根据用户名查找用户失败",3),
    LoginFailed("根据用户名和密码查找失败",4),
    AddPowerFailed("新增权限失败",5),
    DelPowerFailed("删除权限失败",6),
    UpdatePowerFailed("更新权限等级失败",7),
    QueryPowerByIdFailed("根据ID查找权限失败",8),
    QueryPowerByPowerFailed("根据权限等级查找失败",9),
    ListAllPowerFailed("列出所有权限失败",10),
    QueryMoreUserFailed("多条件查询失败",11),
    CountAllUserFalied("计算用户总条数失败",12),
    DelUserFailed("删除用户失败",13),
    StatusUserFailed("审核用户失败",14),
    UpdatePasswordFailed("修改用户密码",15),
    UpdateRealNameFailed("修改真实姓名失败",16),
    UpdateUserFailed("更新用户的基本信息失败",17),
    IsJoinCheckFailed("是否参与审核失败",18),


    AddDepartmentFailed("新增部门失败",100),
    DelDepartmentFailed("删除部门失败",101),
    UpdateDepartmentFailed("更新部门信息失败",102),
    QueryDepartmentByIdFailed("根据名字查找部门信息失败",103),
    QueryDepartmentByNameFailed("根据名字查找部门信息失败",104),
    QueryDepartmentByIsDeleteFailed("根据部门删除状态查找失败",105),
    ListAllDepartmentFailed("列出所有部门失败",106),



    AddRoleFailed("新增角色失败",201),
    DelRoleFailed("删除角色失败",202),
    UpdateRoleFailed("编辑角色信息失败",203),
    ListAllRoleFailed("列出所有角色失败",204),
    QueryRoleByIdFailed("根据ID查找角色失败",205),
    QueryRoleByNameFailed("根据名字查找角色失败",206),
    QueryRoleByIsDeleteFailed("根据删除状态查找角色失败",207),


    AddTestPlanFailed("新增考核计划失败",1001),
    UpdatePlanFailed("更新考核计划失败",1002),
    DelPlanFailed("删除考核计划失败",1003),
    QueryPlanFailed("查询考核计划失败",1004),
    ListTestPlanFailed("列出所有用户失败",1005),
    CountTestPlanFailed("计算总数失败",1006),

    AddTestTypeFailed("新增考核计划类别失败",1007),
    DelTestTypeFailed("删除考核计划类别失败",1008),
    UpdateTestTypeFailed("更新考核计划类别失败",1009),
    ListAllTestTypeFailed("列出所由考核计划类别失败",1010),
    AddWorkPlanFailed("添加工作计划失败",1011),
    UpdateWorkPlanFailed("更新工作计划失败",1012),



    AddWorkDetailFailed("新增工作详情失败",1100),
    UpdateWorkDetailFailed("更新工作详情失败",1101),
    QueryWorkDetailByWidFailed("根据工作计划ID查找失败",1102),
    DelWorkDetailFailed("删除工作计划详情失败",1103),


    AddSummaryFailed("新增年度总结报告失败",1200),
    UpdateSummaryFailed("更新年度总结报告失败",1201),
    UpdateSummaryScoreFailed("打分失败",1202),
    QuerySummaryByUserFailed("根据被考核用户ID和当前年份查找年度总结报告失败",1203),


    AddAbilityTargetTypeFailed("新增类型失败",1300),
    DelAbilityTargetTypeFailed("删除失败",1301),
    UpdateAbilityTargetTypeFailed("更新失败",1302),
    ListTargetTypeFailed("列出失败",1303),
    AddAbilityTargetFailed("新增指标失败",1304),
    DelAbilityTargetFailed("删除指标失败",1305),
    UpdateAbilityTarget("更新指标失败",1306),
    ListTargetFailed("列出所有指标失败",1307),
    AddOptionFailed("新增选项失败",1308),
    DelOptionFailed("删除问题选项失败",1309),
    UpdateOptionFailed("编辑选项失败",1310),
    QueryOptionByPositionId("根据问题ID查找失败",1311)
    ;
    private String mes;
    private int code;

    ChException(String mes, int code) {
        this.mes = mes;
        this.code = code;
    }

    @Override
    public String getMes() {
        return mes;
    }

    @Override
    public int getCode() {
        //return Integer.parseInt(SMSEXCPTIONCODE + "" + code);
        return code;
    }

}
