package com.pandawork.home.mapper.query;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.dto.YearQueaterExportDto;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/9/2.
 */
public interface YearQueaterMapper {

    /**
     * 显示季度查询结果
     * @return
     * @throws SSException
     */
    public List<YearQueaterExportDto> listAll()throws SSException;
}
