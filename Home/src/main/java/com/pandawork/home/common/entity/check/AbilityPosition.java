package com.pandawork.home.common.entity.check;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Taoyongpan on 2017/8/12.
 * 能力指标考核问题表
 */
@Entity
@Table(name = "t_ability_position")
public class AbilityPosition {
    @Id
    private Integer id;
    //部门ID
    @Column(name = "did")
    private Integer did;
    //被考核用户的ID
    @Column(name = "be_check_id")
    private Integer beCheckId;
    //考核该用户的用户ID
    @Column(name = "check_id")
    private Integer checkId;
    //指标ID
    @Column(name = "target_id")
    private Integer targetId;
    //所占权重
    @Column(name = "weight")
    private String weight;
    //是否可用，0是不可用，1是可用
    @Column(name = "is_available")
    private Integer isAvailable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
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

    public Integer getTargetId() {
        return targetId;
    }

    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Integer getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Integer isAvailable) {
        this.isAvailable = isAvailable;
    }
}
