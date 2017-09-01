package com.pandawork.home.common.entity.check;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Taoyongpan on 2017/8/12.
 * 年度总结报告表对应的实体
 */
@Entity
@Table(name = "t_summary")
public class Summary {
    @Id
    private Integer id;
    //被考核用户的ID
    @Column(name = "be_check_id")
    private Integer beCheckId;
    //考核该用户的用户ID
    @Column(name = "check_id")
    private Integer checkId;
    //当前年份
    @Column(name = "year")
    private Integer year;
    //年度总结内容
    @Column(name = "content")
    private String content;
    //年度总结报告得分
    @Column(name = "summary_score")
    private Double summaryScore;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBeCheckId() {
        return beCheckId;
    }

    public void setBeCheckId(Integer beCheckId) {
        this.beCheckId = beCheckId;
    }

    public Integer getCheckId() {
        return checkId;
    }

    public void setCheckId(Integer checkId) {
        this.checkId = checkId;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Double getSummaryScore() {
        return summaryScore;
    }

    public void setSummaryScore(Double summaryScore) {
        this.summaryScore = summaryScore;
    }
}
