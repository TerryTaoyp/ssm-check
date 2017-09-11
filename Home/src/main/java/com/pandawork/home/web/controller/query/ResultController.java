package com.pandawork.home.web.controller.query;

import com.pandawork.home.web.controller.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Taoyongpan on 2017/9/10.
 */
@Controller
@RequestMapping("/query")
public class ResultController extends AbstractController {


    /**
     * 报表展示页面
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/result",method = RequestMethod.GET)
    public String queryResult()throws Exception{
        return "performance/result";
    }

    /**
     * 月工作计划展示
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/month/plan",method = RequestMethod.GET)
    public String monthList()throws Exception{
        return "performance/month/plan";
    }

    /**
     * 副总经理结果查询
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/year/vice",method = RequestMethod.GET)
    public String yearVice()throws Exception{
        return "performance/year/vice-president";
    }

    /**
     * 综合绩效考评结果报表
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/year/synthetical",method = RequestMethod.GET)
    public String yearSynthetical()throws Exception{
        return "performance/year/synthetical";
    }

    /**
     * 能力指标考评结果报表
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/year/ability",method = RequestMethod.GET)
    public String yearAbility()throws Exception{
        return "performance/year/ability";
    }
}
