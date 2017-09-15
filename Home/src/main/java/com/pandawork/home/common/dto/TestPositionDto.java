package com.pandawork.home.common.dto;

/**
 * Created by Taoyongpan on 2017/9/15.
 */
public class TestPositionDto {

    //考核计划的ID
    private Integer testId;
    //考核计划的问题
    private String position;
    //考核计划指标
    private String target;
    //考核计划指标类型
    private String targetType;
    //考核计划权重
    private String weight;
    //此问题是否可用
    private Integer isAvailable;
    //选项名字
    private String optionName;
}
