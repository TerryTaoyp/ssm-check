package com.pandawork.home.mapper.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.entity.check.Summary;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Taoyongpan on 2017/8/30.
 */
public interface SummaryMapper {
    /**
     * 新增年度总结报告
     * @param summary
     * @throws SSException
     */
    public void addSummary(@Param("summary") Summary summary)throws SSException;

    /**
     * 编辑年度总结报告
     * @param summary
     * @throws SSException
     */
    public void updateSummary(@Param("summary") Summary summary)throws SSException;

    /**
     * 对年度总结报告进行打分
     * @param summary
     * @throws SSException
     */
    public void updateScore(@Param("summary") Summary summary)throws SSException;

    /**
     * 根据被考核用户ID和当前年份查找年度总结报告
     * @param summary
     * @return
     * @throws SSException
     */
    public Summary queryByUser(@Param("summary") Summary summary)throws SSException;


}
