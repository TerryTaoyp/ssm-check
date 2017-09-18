package com.pandawork.home.web.controller;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.home.common.dto.YearMonthExportDto;
import com.pandawork.home.common.dto.YearQueaterExportDto;
import com.pandawork.home.common.util.ExcelUtil;
import com.pandawork.home.service.query.ExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * ExportController
 *
 * @author typ
 * @date 2017/9/18 12:46
 */

@Controller
@RequestMapping(value = "/export")
public class ExportController extends AbstractController {

    @Autowired
    ExportService exportService;
    /**
     * 导出年度月度绩效考核的成绩
     * @throws SSException
     */
    @RequestMapping(value = "/month",method = RequestMethod.GET)
    public void exportYearMonth(HttpServletRequest request, HttpServletResponse response)throws SSException{
        try {
            List<YearMonthExportDto> listMonth = exportService.exportYearMonth();

            String filename = "年度月度考核.xls";//设置下载时Excel的名称
            filename = ExcelUtil.encodeFilename(filename, request);//处理中文文件名
            ExcelUtil.writeExcel(listMonth, "recruit", filename, response);//调用Excel工具类生成Excel
        }catch (SSException e){
            e.printStackTrace();
            LogClerk.errLog.error(e);
        }
    }

    /**
     * 导出年度月度绩效考核的某一条成绩
     * @param id
     * @param response
     * @param request
     */
    @RequestMapping(value = "/month/{id}",method = RequestMethod.GET)
    public void exportYearMonthById(@PathVariable("id") int id, HttpServletResponse response, HttpServletRequest request){
        try {
            YearMonthExportDto yearMonthExportDto = exportService.exportYearMonthById(id);

            List<YearMonthExportDto> list = new ArrayList<>();
//            list.set(0, yearMonthExportDto);
            list.add(0,yearMonthExportDto);
            String filename = yearMonthExportDto.getUsername()+".xls";//设置下载时Excel的名称
            filename = ExcelUtil.encodeFilename(filename, request);//处理中文文件名
            ExcelUtil.writeExcel(list, "recruit", filename, response);//调用Excel工具类生成Excel
        } catch (SSException e) {
            e.printStackTrace();
            LogClerk.errLog.error(e);
        }
    }

    /**
     * 导出所有的年度季度考核的成绩
     * @param request
     * @param response
     */
    @RequestMapping(value = "/quarter",method = RequestMethod.GET)
    public void exportYearQueater(HttpServletRequest request,HttpServletResponse response){
        try {
            List<YearQueaterExportDto> list = exportService.exportYearQueater();
            String filename = "年度季度考核.xls";//设置下载时Excel的名称
            filename = ExcelUtil.encodeFilename(filename, request);//处理中文文件名
            ExcelUtil.writeExcel(list, "recruit", filename, response);//调用Excel工具类生成Excel
        } catch (SSException e) {
            e.printStackTrace();
            LogClerk.errLog.error(e);
        }
    }

    /**
     * 导出所有的年度季度考核的成绩
     * @param request
     * @param response
     */
    @RequestMapping(value = "/quarter/{id}",method = RequestMethod.GET)
    public void exportYearQueaterById(@PathVariable("id") int id,HttpServletRequest request,HttpServletResponse response){
        try {
            YearQueaterExportDto yearQueaterExportDto = exportService.exportYearQueaterById(id);
            String filename = "年度季度考核.xls";//设置下载时Excel的名称
            filename = ExcelUtil.encodeFilename(filename, request);//处理中文文件名
            ExcelUtil.writeExcel((List) yearQueaterExportDto, "recruit", filename, response);//调用Excel工具类生成Excel
        } catch (SSException e) {
            e.printStackTrace();
            LogClerk.errLog.error(e);
        }
    }
}