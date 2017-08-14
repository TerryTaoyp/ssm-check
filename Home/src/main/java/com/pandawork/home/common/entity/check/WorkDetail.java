package com.pandawork.home.common.entity.check;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Taoyongpan on 2017/8/12.
 * 工作计划每条的详情表对应的实体
 */
@Entity
@Table(name = "t_work_detail")
public class WorkDetail {
    @Id
    private Integer id;
    //工作计划化ID
    @Column(name = "wid")
    private Integer wid;
    //该条工作计划的开始时间
    @Column(name = "start_time")
    private String startTime;
    //该条工作计划的结束时间
    @Column(name = "end_time")
    private String endTime;
    //该条工作计划的内容
    @Column(name = "plan_content")
    private String planContent;
    //预期结果
    @Column(name = "expect_result")
    private String expectResult;
    //该条工作计划所占的权重
    @Column(name = "weight")
    private String weight;
    //工作计划完成说明
    @Column(name = "completion")
    private String completion;
    //该条 工作计划得分
    @Column(name = "test_score")
    private Double testScore;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getPlanContent() {
        return planContent;
    }

    public void setPlanContent(String planContent) {
        this.planContent = planContent;
    }

    public String getExpectResult() {
        return expectResult;
    }

    public void setExpectResult(String expectResult) {
        this.expectResult = expectResult;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getCompletion() {
        return completion;
    }

    public void setCompletion(String completion) {
        this.completion = completion;
    }

    public Double getTestScore() {
        return testScore;
    }

    public void setTestScore(Double testScore) {
        this.testScore = testScore;
    }
}
