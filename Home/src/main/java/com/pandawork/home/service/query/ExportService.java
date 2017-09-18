package com.pandawork.home.service.query;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.dto.YearMonthExportDto;
import com.pandawork.home.common.dto.YearQueaterExportDto;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/9/18.
 */
public interface ExportService {

    /**
     * 导出所有用户年度月度考核成绩信息
     * @return
     * @throws SSException
     */
    public List<YearMonthExportDto> exportYearMonth()throws SSException;

    /**
     * 导出年度月度考核的某一条信息
     * @param id
     * @return
     * @throws SSException
     */
    public YearMonthExportDto exportYearMonthById(int id)throws SSException;

    /**
     * 导出所有用户年度季度考核成绩信息
     * @return
     * @throws SSException
     */
    public List<YearQueaterExportDto> exportYearQueater()throws SSException;

    /**
     * 导出年度季度考核的某一条信息
     * @param id
     * @return
     * @throws SSException
     */
    public YearQueaterExportDto exportYearQueaterById(int id)throws SSException;
}
