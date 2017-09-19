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
     * 多条件查询
     * @return
     * @throws SSException
     */
    public List<YearMonthExportDto> exportYearMonthByConditions(@Param("did") int did, @Param("rid") int rid,@Param("year") int year,@Param("username") String username)throws SSException;

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
    public List<YearQueaterExportDto> exportYearQueaterByConditions(@Param("did") int did,@Param("rid") int rid,@Param("year") int year,@Param("username") String username)throws SSException;
}
