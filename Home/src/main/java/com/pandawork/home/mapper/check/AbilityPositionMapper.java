package com.pandawork.home.mapper.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.entity.check.AbilityPosition;
import org.apache.ibatis.annotations.Param;

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


}
