package com.pandawork.home.service.check.impl;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.home.common.entity.check.WorkPlan;
import com.pandawork.home.common.exception.ChException;
import com.pandawork.home.mapper.check.WorkPlanMapper;
import com.pandawork.home.service.check.WorkPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/8/29.
 */
@Service(value = "workPlanService")
public class WorkPlanServiceImpl implements WorkPlanService {

    @Autowired
    WorkPlanMapper workPlanMapper;
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class,Exception.class, RuntimeException.class})
    public void addWorkPlan(WorkPlan workPlan) throws SSException {
        try{
            if (Assert.isNull(workPlan)){
                return;
            }
            workPlanMapper.addWorkPlan(workPlan);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.AddWorkPlanFailed);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class,Exception.class, RuntimeException.class})
    public void updateWorkPlan(WorkPlan workPlan) throws SSException {
        try{
            if (Assert.isNull(workPlan)){
                return;
            }
            workPlanMapper.updateWorkPlan(workPlan);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.UpdateWorkPlanFailed);
        }
    }

    @Override
    public List<WorkPlan> queryByUid(int uid) throws SSException {
        try{
            if (Assert.isNull(uid)){
                return null;
            }
            return workPlanMapper.queryByUid(uid);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QueryWorkPlanByUidFailed);
        }
    }

    @Override
    public WorkPlan queryByTestId(int testId) throws SSException {
        try{
            if (Assert.isNull(testId)){
                return null;
            }
            return workPlanMapper.queryByTestId(testId);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QueryWorkPlanByUidFailed);
        }
    }
}
