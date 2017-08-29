package com.pandawork.home.mapper.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.entity.check.TestType;

/**
 * Created by Taoyongpan on 2017/8/28.
 */
public interface TestTypeMapper {

    /**
     * 新增考核计划类型
     * @param testType
     * @throws SSException
     */
    public void addTestType(TestType testType)throws SSException;

    /**
     * 删除考核计划类型
     * @param testType
     * @throws SSException
     */
    public void delTestType(TestType testType)throws SSException;


}
