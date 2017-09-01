package com.pandawork.home.service.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.entity.check.Summary;

/**
 * Created by Taoyongpan on 2017/8/30.
 */
public interface SummaryService {
    /**
     * 新增年度总结报告
     * @param summary
     * @throws SSException
     */
    public void addSummary(Summary summary)throws SSException;

    /**
     * 编辑年度总结报告
     * @param summary
     * @throws SSException
     */
    public void updateSummary(Summary summary)throws SSException;

    /**
     * 对年度总结报告进行打分
     * @param summary
     * @throws SSException
     */
    public void updateScore(Summary summary)throws SSException;

    /**
     * 根据被考核用户ID和当前年份查找年度总结报告
     * @param summary
     * @return
     * @throws SSException
     */
    public Summary queryByUser(Summary summary)throws SSException;
}
