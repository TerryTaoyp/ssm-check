package com.pandawork.home.common.entity.check;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Taoyongpan on 2017/8/12.
 * 考核计划表
 */
@Entity
@Table(name = "t_test_plan")
public class TestPlan {
    @Id
    private Integer id;
    //用户ID
    @Column(name = "uid")
    private Integer uid;
    //考核计划 类型ID
    @Column(name = "test_type_id")
    private Integer testTypeId;
    //开始考核的时间
    @Column(name = "start_time")
    private String startTime;
    //考核结束时间
    @Column(name = "finish_time")
    private String finishTime;
    //考核名字
    @Column(name = "test_name")
    private String testName;
    //是否可用，0是不可用，1是可用
    @Column(name = "is_available")
    private Integer isAvailable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getTestTypeId() {
        return testTypeId;
    }

    public void setTestTypeId(Integer testTypeId) {
        this.testTypeId = testTypeId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public Integer getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Integer isAvailable) {
        this.isAvailable = isAvailable;
    }
}
