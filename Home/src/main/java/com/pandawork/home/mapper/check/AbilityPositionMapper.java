package com.pandawork.home.mapper.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.entity.check.AbilityPosition;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/8/31.
 */
public interface AbilityPositionMapper {
    /**
     * 新增问题
     * @param abilityPosition
     * @throws SSException
     */
    public void addPosition(@Param("abilityPosition") AbilityPosition abilityPosition)throws SSException;

    /**
     * 删除问题
     * @param abilityPosition
     * @throws SSException
     */
    public void delPosition(@Param("abilityPosition") AbilityPosition abilityPosition)throws SSException;

    /**
     * 编辑问题
     * @param abilityPosition
     * @throws SSException
     */
    public void updatePosition(@Param("abilityPosition") AbilityPosition abilityPosition)throws SSException;

    /**
     * 根据部门ID列出所有问题
     * @param did
     * @return
     * @throws SSException
     */
    public List<AbilityPosition> queryByDid(@Param("did") int did)throws SSException;

    /**
     * 计算所有的条数
     * @return
     * @throws SSException
     */
    public int countAll()throws SSException;

}