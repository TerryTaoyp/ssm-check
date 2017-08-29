package com.pandawork.home.mapper.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.entity.check.TestPlan;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/8/28.
 */
public interface TestPlanMapper {
    /**
     * 添加考核计划
     * @param testPlan
     * @throws SSException
     */
    public void addTestPlan(@Param("testPlan") TestPlan testPlan)throws SSException;

    /**
     * 修改考核计划
     * @param testPlan
     * @throws SSException
     */
    public void updateTestPlan(@Param("testPlan")TestPlan testPlan)throws SSException;

    /**
     * 删除考核计划
     * @param testPlan
     * @throws SSException
     */
    public void delTestPlan(@Param("testPlan")TestPlan testPlan)throws SSException;

    /**
     * 根据ID查找考核计划
     * @param id
     * @return
     * @throws SSException
     */
    public TestPlan queryById(@Param("id")int id)throws SSException;

    /**
     * 列出所有的考核计划类型
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
}
