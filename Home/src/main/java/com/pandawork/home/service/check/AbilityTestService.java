package com.pandawork.home.service.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.entity.check.AbilityTest;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/9/23.
 */
public interface AbilityTestService {

    /**
     * 新增能力指标
     * @param abilityTest
     * @throws SSException
     */
    public void addAbilityTest(AbilityTest abilityTest)throws SSException;

    /**
     * 根据考核用户的ID和考核计划的ID查找
     * @param testId
     * @param beCheckId
     * @return
     * @throws SSException
     */
    public List<AbilityTest> queryByTestIdAndUid(int testId, int beCheckId)throws SSException;
}
