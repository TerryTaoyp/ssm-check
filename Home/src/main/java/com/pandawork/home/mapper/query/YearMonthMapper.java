package com.pandawork.home.mapper.query;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.dto.YearMonthExportDto;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/9/2.
 */
public interface YearMonthMapper {
    /**
     * 列出所有的考核成绩
     * @return
     * @throws SSException
     */
    public List<YearMonthExportDto> listAll()throws SSException;
}
