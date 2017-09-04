package com.pandawork.home.mapper.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.entity.check.WorkDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/8/30.
 */
public interface WorkDetailMapper {
    /**
     * 新增工作计划详情
     * @param workDetail
     * @throws SSException
     */
    public void addWorkDetail(@Param("workDetail") WorkDetail workDetail)throws SSException;

    /**
     * 编辑工作计划详情
     * @param workDetail
     * @throws SSException
     */
    public void updateWorkDetail(@Param("workDetail") WorkDetail workDetail)throws SSException;

    /**
     * 查出某一次工作计划考核的所有条数
     * @param wid
     * @return
     * @throws SSException
     */
    public List<WorkDetail> queryByWId(@Param("wid") int wid)throws SSException;

    /**
     * 删除
     * @param id
     * @return
     * @throws SSException
     */
    public boolean delWorkDetail(@Param("id") int id)throws SSException;
}
