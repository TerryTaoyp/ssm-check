package com.pandawork.home.service.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.entity.check.WorkDetail;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/8/30.
 */
public interface WorkDetailService {

    /**
     * 新增工作计划详情
     * @param workDetail
     * @throws SSException
     */
    public void addWorkDetail(WorkDetail workDetail)throws SSException;

    /**
     * 编辑工作计划详情
     * @param workDetail
     * @throws SSException
     */
    public void updateWorkDetail(WorkDetail workDetail)throws SSException;

    /**
     * 查出某一次工作计划考核的所有条数
     * @param wid
     * @return
     * @throws SSException
     */
    public List<WorkDetail> queryByWId(int wid)throws SSException;

    /**
     * 删除
     * @param id
     * @return
     * @throws SSException
     */
    public boolean delWorkDetail(int id)throws SSException;

    /**
     * 根据ID查找
     * @param id
     * @return
     * @throws SSException
     */
    public WorkDetail queryById(int id)throws SSException;

    /**
     * 根据被考核用户ID和工作计划ID查找
     * @param uid
     * @param wid
     * @return
     * @throws SSException
     */
    public List<WorkDetail> queryByUidAndWid(int uid, int wid)throws SSException;
}
