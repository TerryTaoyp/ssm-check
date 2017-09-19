package com.pandawork.home.service.query.impl;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.home.common.dto.YearQueaterExportDto;
import com.pandawork.home.common.exception.ChException;
import com.pandawork.home.mapper.query.YearQueaterMapper;
import com.pandawork.home.service.query.YearQueaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/9/17.
 */
@Service(value = "yearQueaterService")
public class YearQueaterServiceImpl implements YearQueaterService {
    @Autowired
    YearQueaterMapper yearQueaterMapper;

    @Override
    public List<YearQueaterExportDto> listAll() throws SSException {
        return yearQueaterMapper.listAll();
    }

    @Override
    public List<YearQueaterExportDto> queryDtoByConditions(int did, int rid, int year, String username) throws SSException {
        try {
            return yearQueaterMapper.queryDtoByConditions(did,rid,year,username);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw  SSException.get(ChException.ExportFailed);
        }
    }
}
