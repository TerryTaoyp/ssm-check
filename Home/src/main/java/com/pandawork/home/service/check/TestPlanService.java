package com.pandawork.home.service.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.entity.check.TestPlan;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/8/28.
 */
public interface TestPlanService {
    /**
     * 新增考核类型
     * @param testPlan
     * @throws SSException
     */
    public void addTestPlan(TestPlan testPlan)throws SSException;

    /**
     * 更新考核类型
     * @param testPlan
     * @throws SSException
     */
    public void updateTestPlan(TestPlan testPlan)throws SSException;

    /**
     * 删除考核类型
     * @param testPlan
     * @throws SSException
     */
    public void delTestPlan(TestPlan testPlan)throws SSException;

    /**
     * 根据ID查询
     * @param id
     * @return
     * @throws SSException
     */
    public TestPlan queryTestPlan(int id)throws SSException;

    /**
     * 列出所有的考核计划
     * @return
     * @throws SSException
     */
    public List<TestPlan> listAll()throws SSException;

    /**
     * 计算考核计划的总数
     * @return
     * @throws SSException
     */
    public int countAll()throws SSException;

    /**
     * 根据用户ID查找考核计划
     * @param uid
     * @return
     * @throws SSException
     */
    public List<TestPlan> queryByUid(int uid)throws SSException;
}
