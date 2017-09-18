package com.pandawork.home.service.query.impl;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.home.common.dto.YearMonthExportDto;
import com.pandawork.home.common.dto.YearQueaterExportDto;
import com.pandawork.home.common.exception.ChException;
import com.pandawork.home.mapper.query.ExportMapper;
import com.pandawork.home.service.query.ExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/9/18.
 */

@Service(value = "exportService")
public class ExportServiceImpl implements ExportService {

    @Autowired
    ExportMapper exportMapper;
    @Override
    public List<YearMonthExportDto> exportYearMonth() throws SSException {
        try {
            return exportMapper.exportYearMonth();
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.ExportFailed);
        }
    }

    @Override
    public YearMonthExportDto exportYearMonthById(int id) throws SSException {
        try {
            if (Assert.isNull(id)){
                return null;
            }
            return exportMapper.exportYearMonthById(id);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.ExportFailed);
        }
    }

    @Override
    public List<YearQueaterExportDto> exportYearQueater() throws SSException {
        try {
            return exportMapper.exportYearQueater();
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.ExportFailed);
        }
    }

    @Override
    public YearQueaterExportDto exportYearQueaterById(int id) throws SSException {
        try {
            if (Assert.isNull(id)){
                return null;
            }
            return exportMapper.exportYearQueaterById(id);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.ExportFailed);
        }

    }
}
