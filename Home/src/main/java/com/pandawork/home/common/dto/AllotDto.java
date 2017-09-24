package com.pandawork.home.common.dto;

/**
 * Created by Taoyongpan on 2017/9/15.
 */
public class AllotDto {
    //用户ID
    private Integer id;
    //用户名字
    private String username;
    //真实姓名
    private String realName;
    //部门名字
    private String department;
    //角色名字
    private String role;
    //权限等级
    private Integer power;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }
}
