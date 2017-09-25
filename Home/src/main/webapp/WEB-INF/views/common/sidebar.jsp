<%--
  Created by IntelliJ IDEA.
  User: Taoyongpan
  Date: 2017/9/3
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
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
                <p>${sessionScope.username}，您好</p>
                <a href="#" id="nowTime"></a>
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
            <c:if test="${sessionScope.power!=4 && sessionScope.power!=5}">
                <c:if test="${sessionScope.power <= 2}">
                    <li class="treeview">
                        <a href="#">
                            <i class="fa fa-dashboard"></i> <span>系统管理</span>
                            <span class="pull-right-container">
                                <i class="fa fa-angle-left pull-right"></i>
                            </span>
                        </a>
                        <ul class="treeview-menu">
                            <li><a href="${website}/role/list"><i class="fa fa-circle-o"></i>角色管理</a></li>
                            <li><a href="${website}/power/list"><i class="fa fa-circle-o"></i>权限分配</a></li>
                            <li><a href="${website}/department/list"><i class="fa fa-circle-o"></i>部门管理</a></li>
                            <li><a href="${website}/user/list"><i class="fa fa-circle-o"></i>人员管理</a></li>
                            <li><a href="${website}/allot/list"><i class="fa fa-circle-o"></i>管辖分配</a></li>
                            <li><a href="${website}/user/account/list"><i class="fa fa-circle-o"></i>账号管理</a></li>
                        </ul>
                    </li>
                </c:if>

                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-share"></i> <span>考核管理</span>
                        <span class="pull-right-container">
                          <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>

                    <ul class="treeview-menu">
                        <c:if test="${sessionScope.power<=3}">
                            <li><a href="${website}/testplan/list"><i class="fa fa-circle-o"></i>考核计划管理</a></li>
                        </c:if>

                        <li><a href="${website}/workplan/month/list"><i class="fa fa-circle-o"></i>月/季度考核管理列表</a></li>
                        <li class="treeview">
                            <a href="#"><i class="fa fa-circle-o"></i>年度考核管理
                                <span class="pull-right-container">
                                  <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="${website}/performance/list"><i class="fa fa-circle-o"></i>绩效综合能力列表</a></li>
                                <c:if test="${sessionScope.power<=3}">
                                    <li><a href="${website}/ability/list"><i class="fa fa-circle-o"></i>能力指标列表</a></li>
                                </c:if>
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
                        <li class="treeview">
                            <a href="#"><i class="fa fa-circle-o"></i>年度考核
                                <span class="pull-right-container">
                                  <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="${website}/check/year/ability/list"><i class="fa fa-circle-o"></i>能力指标评价</a></li>
                                <li><a href="${website}/check/year/summary/list"><i class="fa fa-circle-o"></i>年度绩效评价</a></li>
                            </ul>
                        </li>
                    </ul>
                </li>
            </c:if>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-pie-chart"></i>
                    <span>成绩查询</span>
                    <span class="pull-right-container">
                      <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="${website}/query/month/result"><i class="fa fa-circle-o"></i>年度月度考核测评结果</a></li>
                    <li><a href="${website}/query/quarter/result"><i class="fa fa-circle-o"></i>年度季度考核测评结果</a></li>
                </ul>
            </li>
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>