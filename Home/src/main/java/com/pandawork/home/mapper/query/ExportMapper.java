package com.pandawork.home.mapper.query;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.dto.YearMonthExportDto;
import com.pandawork.home.common.dto.YearQueaterExportDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/9/18.
 */
public interface ExportMapper {
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
    public YearMonthExportDto exportYearMonthById(@Param("id") int id)throws SSException;

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
    public YearQueaterExportDto exportYearQueaterById(@Param("id") int id)throws SSException;
}
