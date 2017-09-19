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
     * 多条件查询
     * @return
     * @throws SSException
     */
    public List<YearMonthExportDto> exportYearMonthByConditions(int did,int rid,int year,String username)throws SSException;

    /**
     * 导出所有用户年度季度考核成绩信息
     * @return
     * @throws SSException
     */
    public List<YearQueaterExportDto> exportYearQueater()throws SSException;


    /**
     * 多条件季度查询
     * @return
     * @throws SSException
     */
    public List<YearQueaterExportDto> exportYearQueaterByConditions(int did,int rid,int year,String username)throws SSException;
}
