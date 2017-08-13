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


    AddDepartmentFailed("新增部门失败",100),
    DelDepartmentFailed("删除部门失败",101),
    UpdateDepartmentFailed("更新部门信息失败",102),
    QueryDepartmentByIdFailed("根据名字查找部门信息失败",103),
    QueryDepartmentByNameFailed("根据名字查找部门信息失败",104),
    QueryDepartmentByIsDeleteFailed("根据部门删除状态查找失败",105)


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
