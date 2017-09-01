package com.pandawork.home.common.entity.check;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Taoyongpan on 2017/8/12.
 * 能力指标考核问题选项表
 */
@Entity
@Table(name = "t_ability_option")
public class AbilityOption {
    @Id
    private Integer id;
    //能力指标问题ID
    @Column(name = "position_id")
    private Integer positionId;
    //指标ID
    @Column(name = "target_id")
    private Integer targetId;
    //选项名字，例如优良中差，ABCD
    @Column(name = "option_name")
    private String optionName;
    //得分上限
    @Column(name = "max_score")
    private Double maxScore;
    //得分下限
    @Column(name = "min_score")
    private Double minScore;
    //该选项的具体内容
    @Column(name = "option_content")
    private String optionContent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public Integer getTargetId() {
        return targetId;
    }

    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public Double getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(Double maxScore) {
        this.maxScore = maxScore;
    }

    public Double getMinScore() {
        return minScore;
    }

    public void setMinScore(Double minScore) {
        this.minScore = minScore;
    }

    public String getOptionContent() {
        return optionContent;
    }

    public void setOptionContent(String optionContent) {
        this.optionContent = optionContent;
    }
}
