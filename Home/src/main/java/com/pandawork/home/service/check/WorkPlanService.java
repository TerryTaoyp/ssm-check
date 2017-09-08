package com.pandawork.home.service.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.entity.check.WorkPlan;

import java.util.List;

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

    /**
     * 根据用户 ID查找用户的工作计划
     * @param uid
     * @return
     * @throws SSException
     */
    public List<WorkPlan> queryByUid(int uid)throws SSException;

    /**
     * 根据考核计划ID查找工作计划
     * @param testId
     * @return
     * @throws SSException
     */
    public WorkPlan queryByTestId(int testId)throws SSException;
}
