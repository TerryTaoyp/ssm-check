package com.pandawork.home.common.entity.check;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Taoyongpan on 2017/9/12.
 */
@Entity
@Table(name = "t_join_test")
public class JoinTest{
    @Id
    private Integer id;

    //此次考核计划的ID
    @Column(name = "test_id")
    private Integer testId;

    //参与 此考核计划的ID
    @Column(name = "uid")
    private Integer uid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}
