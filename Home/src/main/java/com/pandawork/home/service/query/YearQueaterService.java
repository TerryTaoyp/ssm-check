package com.pandawork.home.service.query;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.dto.YearQueaterExportDto;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/9/17.
 */
public interface YearQueaterService {
    /**
 * 显示季度查询结果
 * @return
 * @throws SSException
 */
public List<YearQueaterExportDto> listAll()throws SSException;
    /**
     * 根据条件查询
     * @param did
     * @param rid
     * @param year
     * @param username
     * @return
     * @throws SSException
     */
    public List<YearQueaterExportDto> queryDtoByConditions(int did,int rid,int year,String username)throws SSException;
}
