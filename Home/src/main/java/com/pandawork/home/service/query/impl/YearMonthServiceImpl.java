package com.pandawork.home.service.query.impl;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.dto.YearMonthExportDto;
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
}
