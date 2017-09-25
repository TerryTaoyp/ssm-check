package com.pandawork.home.service.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.dto.AllotDto;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/9/23.
 */
public interface AbilityAllotService {

    /**
     * 能力指标测试一般员工的测试范围
     * @param did
     * @return
     * @throws SSException
     */
    public List<AllotDto> generalCheck(int did)throws SSException;

    /**
     * 部门副经理的测试范围，需要添加上直系副总经理
     * @param did
     * @return
     * @throws SSException
     */
    public List<AllotDto> deputyCheck(int did)throws SSException;

    /**
     * 部门经理的测试范围，需要添加上直系的副总经理
     * @param did
     * @return
     * @throws SSException
     */
    public List<AllotDto> dManagerCheck(int did)throws SSException;

    /**
     * 总经理的考核范围
     * @return
     * @throws SSException
     */
    public List<AllotDto> topManagerCheck()throws SSException;
}