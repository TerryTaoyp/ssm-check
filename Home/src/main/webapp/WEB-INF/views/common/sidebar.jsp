<%--
  Created by IntelliJ IDEA.
  User: Taoyongpan
  Date: 2017/9/3
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Left side column. contains the logo and sidebar -->
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <i class="fa fa-bookmark-o fa-3x" style="color:#fff"></i>
            </div>
            <div class="pull-left info">
                <p>管理员</p>
                <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
            </div>
        </div>
        <!-- search form -->
        <form action="#" method="get" class="sidebar-form">
            <div class="input-group">
                <input type="text" name="q" class="form-control" placeholder="搜索...">
                <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
              </span>
            </div>
        </form>
        <!-- /.search form -->
        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu" data-widget="tree">
            <li class="header">考核系统栏目菜单</li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-dashboard"></i> <span>系统管理</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li class="treeview">
                        <a href="#"><i class="fa fa-circle-o"></i>角色管理
                            <span class="pull-right-container">
                  <i class="fa fa-angle-left pull-right"></i>
                </span>
                        </a>
                        <ul class="treeview-menu">
                            <li><a href="${website}/role/list"><i class="fa fa-circle-o"></i>列表展示</a></li>
                            <li><a href="${website}/role/toadd"><i class="fa fa-circle-o"></i>添加</a></li>
                        </ul>
                    </li>
                    <li class="treeview">
                        <a href="#"><i class="fa fa-circle-o"></i>权限管理
                            <span class="pull-right-container">
                  <i class="fa fa-angle-left pull-right"></i>
                </span>
                        </a>
                        <ul class="treeview-menu">
                            <li><a href="${website}/power/list"><i class="fa fa-circle-o"></i>列表展示</a></li>
                            <li><a href="${website}/power/toadd"><i class="fa fa-circle-o"></i>添加</a></li>
                        </ul>
                    </li>
                    <li class="treeview">
                        <a href="#"><i class="fa fa-circle-o"></i>部门管理
                            <span class="pull-right-container">
                  <i class="fa fa-angle-left pull-right"></i>
                </span>
                        </a>
                        <ul class="treeview-menu">
                            <li><a href="${website}/department/list"><i class="fa fa-circle-o"></i>列表展示</a></li>
                            <li><a href="${website}/department/toadd"><i class="fa fa-circle-o"></i>添加</a></li>
                        </ul>
                    </li>
                    <li><a href="${website}/user/list"><i class="fa fa-circle-o"></i>人员管理</a></li>
                    <li><a href="${website}/allot/list"><i class="fa fa-circle-o"></i>管辖分配</a></li>
                    <li><a href="${website}/user/accountlist"><i class="fa fa-circle-o"></i>账号管理</a></li>
                </ul>
            </li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-share"></i> <span>考核管理</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li class="treeview">
                        <a href="#"><i class="fa fa-circle-o"></i>考核计划管理
                            <span class="pull-right-container">
                  <i class="fa fa-angle-left pull-right"></i>
                </span>
                        </a>
                        <ul class="treeview-menu">
                            <li><a href="${website}/testplan/list"><i class="fa fa-circle-o"></i>列表展示</a></li>
                            <li><a href="${website}/testplan/toadd"><i class="fa fa-circle-o"></i>添加</a></li>
                        </ul>
                    </li>
                    <%--<li><a href="${website}/testplan/toallot"><i class="fa fa-circle-o"></i>考核分配</a></li>--%>
                    <li><a href="${website}/workplan/month/list"><i class="fa fa-circle-o"></i>月/季度考核管理列表</a></li>
                    <li class="treeview">
                        <a href="#"><i class="fa fa-circle-o"></i>年度考核管理
                            <span class="pull-right-container">
                  <i class="fa fa-angle-left pull-right"></i>
                </span>
                        </a>
                        <ul class="treeview-menu">
                            <li><a href="${website}/performance/list"><i class="fa fa-circle-o"></i>绩效综合能力列表</a></li>
                            <li><a href="${website}/ability/list"><i class="fa fa-circle-o"></i>能力指标列表</a></li>
                            <li><a href="${website}/summary/list"><i class="fa fa-circle-o"></i>个人总结</a></li>
                        </ul>
                    </li>
                </ul>
            </li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-files-o"></i> <span>测评模块</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="${website}/check/month/list"><i class="fa fa-circle-o"></i>月/季度考核</a></li>
                    <li class="none"><a href="http://www.appraisal.com/ssm-check/Home/src/main/webapp/WEB-INF/views/exam/month/evaluation-detail.html"><i class="fa fa-circle-o"></i>隐藏的详情</a></li>
                    <li class="none"><a href="http://www.appraisal.com/ssm-check/Home/src/main/webapp/WEB-INF/views/exam/month/exam-detail.html"><i class="fa fa-circle-o"></i>隐藏的详情</a></li>
                    <li class="treeview">
                        <a href="#"><i class="fa fa-circle-o"></i>年度度考核
                            <span class="pull-right-container">
                  <i class="fa fa-angle-left pull-right"></i>
                </span>
                        </a>
                        <ul class="treeview-menu">
                            <li><a href="${website}/check/year/ability"><i class="fa fa-circle-o"></i>能力指标评价</a></li>
                            <li><a href="${website}/check/year/performance"><i class="fa fa-circle-o"></i>年度绩效评价</a></li>
                            <li><a href="${website}/check/year/summary"><i class="fa fa-circle-o"></i>个人总结评价</a></li>
                            <li class="none"><a href="http://www.appraisal.com/ssm-check/Home/src/main/webapp/WEB-INF/views/exam/year/evaluation-detail.html"><i class="fa fa-circle-o"></i>隐藏的详情</a></li>
                            <li class="none"><a href="http://www.appraisal.com/ssm-check/Home/src/main/webapp/WEB-INF/views/exam/year/exam-detail.html"><i class="fa fa-circle-o"></i>隐藏的详情</a></li>
                        </ul>
                    </li>
                </ul>
            </li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-pie-chart"></i>
                    <span>成绩查询</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="${website}/query/result"><i class="fa fa-circle-o"></i> 测评结果展示报表</a></li>
                    <li class="none"><a href="http://www.appraisal.com/ssm-check/Home/src/main/webapp/WEB-INF/views/performance/result-detail.html"><i class="fa fa-circle-o"></i>隐藏的详情</a></li>
                    <li class="treeview">
                        <a href="#"><i class="fa fa-circle-o"></i>月/季度考核测评结果
                            <span class="pull-right-container">
                  <i class="fa fa-angle-left pull-right"></i>
                </span>
                        </a>
                        <ul class="treeview-menu">
                            <li><a href="${website}/query/month/plan"><i class="fa fa-circle-o"></i>工作计划结果报表</a></li>
                            <li class="none"><a href="http://www.appraisal.com/ssm-check/Home/src/main/webapp/WEB-INF/views/performance/month/plan-detail.html"><i class="fa fa-circle-o"></i>工作计划结果报表详情</a></li>
                            <%--<li><a href="http://www.appraisal.com/ssm-check/Home/src/main/webapp/WEB-INF/views/performance/month/evaluation.html"><i class="fa fa-circle-o"></i>绩效指标结果报表</a></li>--%>
                            <%--<li class="none"><a href="http://www.appraisal.com/ssm-check/Home/src/main/webapp/WEB-INF/views/performance/month/evaluation-detail.html"><i class="fa fa-circle-o"></i>绩效指标结果报表详情</a></li>--%>
                        </ul>
                    </li>
                    <li class="treeview">
                        <a href="#"><i class="fa fa-circle-o"></i>年度考核测评结果
                            <span class="pull-right-container">
                  <i class="fa fa-angle-left pull-right"></i>
                </span>
                        </a>
                        <ul class="treeview-menu">
                            <li><a href="${website}/query/year/vice"><i class="fa fa-circle-o"></i>副总经理考核结果报表</a></li>
                            <li><a href="${website}/query/year/synthetical"><i class="fa fa-circle-o"></i>综合绩效考评结果报表</a></li>
                            <li><a href="${website}/query/year/ability"><i class="fa fa-circle-o"></i>能力指标考评结果报表</a></li>
                        </ul>
                    </li>
                </ul>
            </li>
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>