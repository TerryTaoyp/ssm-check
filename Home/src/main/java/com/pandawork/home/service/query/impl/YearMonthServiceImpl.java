package com.pandawork.home.service.query.impl;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.home.common.dto.YearMonthExportDto;
import com.pandawork.home.common.exception.ChException;
import com.pandawork.home.mapper.query.YearMonthMapper;
import com.pandawork.home.service.query.YearMonthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/9/17.
 */

@Service(value = "yearMonthService")
public class YearMonthServiceImpl implements YearMonthService {
    @Autowired
    YearMonthMapper yearMonthMapper;

    @Override
    public List<YearMonthExportDto> listAll() throws SSException {
        return yearMonthMapper.listAll();
    }

    @Override
    public List<YearMonthExportDto> queryByConditions(int did, int rid, int year, String username) throws SSException {
        try {
            return yearMonthMapper.queryByConditions(did, rid, year, username);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.ExportFailed);
        }
    }
}
