package com.pandawork.home.service.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.entity.check.WorkPlan;

/**
 * Created by Taoyongpan on 2017/8/29.
 */
public interface WorkPlanService {
    /**
     * 新增工作计划
     * @param workPlan
     * @throws SSException
     */
    public void addWorkPlan(WorkPlan workPlan)throws SSException;

    /**
     * 更新工作计划
     * @param workPlan
     * @throws SSException
     */
    public void updateWorkPlan(WorkPlan workPlan)throws SSException;
}
