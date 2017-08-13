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
    LoginFailed("根据用户名和密码查找失败",4)
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
