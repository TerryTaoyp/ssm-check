<%--
  Created by IntelliJ IDEA.
  User: Taoyongpan
  Date: 2017/9/3
  Time: 13:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>年度考核列表</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <jsp:include page="../../common/link.jsp"/>
    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/link.html" -->
</head>
<body class="hold-transition skin-black sidebar-mini">
<div class="wrapper">
    <jsp:include page="../../common/header.jsp"/>
    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/header.html" -->
    <jsp:include page="../../common/sidebar.jsp"/>
    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/sidebar.html" -->

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                年度考核列表
                <small>栏目</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">测评模块</a></li>
                <li class="active">年度考核列表</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box box-primary">
                        <div class="box-header">
                            <h3 class="box-title">考核列表</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="example1" class="table table-bordered table-striped">
                                <c:if test="${testPlan.testTypeId==2}">
                                    <thead>
                                    <tr>
                                        <th>序号</th>
                                        <th>一月</th>
                                        <th>二月</th>
                                        <th>三月</th>
                                        <th>四月</th>
                                        <th>五月</th>
                                        <th>六月</th>
                                        <th>七月</th>
                                        <th>八月</th>
                                        <th>九月</th>
                                        <th>十月</th>
                                        <th>十一月</th>
                                        <th>十一月</th>
                                        <th>平均得分</th>
                                        <th>年度总结得分</th>
                                        <th>最终得分</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>1</td>
                                        <c:forEach items="${workPlanList}" var="workPlan" varStatus="status">
                                            <c:if test="${workPlan.month == 1}">
                                                <td>${workPlan.monthScore}</td>
                                            </c:if>
                                            <c:if test="${workPlan.month == 2}">
                                                <td>${workPlan.monthScore}</td>
                                            </c:if>
                                            <c:if test="${workPlan.month == 3}">
                                                <td>${workPlan.monthScore}</td>
                                            </c:if>
                                            <c:if test="${workPlan.month == 4}">
                                                <td>${workPlan.monthScore}</td>
                                            </c:if>
                                            <c:if test="${workPlan.month == 5}">
                                                <td>${workPlan.monthScore}</td>
                                            </c:if>
                                            <c:if test="${workPlan.month == 6}">
                                                <td>${workPlan.monthScore}</td>
                                            </c:if>
                                            <c:if test="${workPlan.month == 7}">
                                                <td>${workPlan.monthScore}</td>
                                            </c:if>
                                            <c:if test="${workPlan.month == 8}">
                                                <td>${workPlan.monthScore}</td>
                                            </c:if>
                                            <c:if test="${workPlan.month == 9}">
                                                <td>${workPlan.monthScore}</td>
                                            </c:if>
                                            <c:if test="${workPlan.month == 10}">
                                                <td>${workPlan.monthScore}</td>
                                            </c:if>
                                            <c:if test="${workPlan.month == 11}">
                                                <td>${workPlan.monthScore}</td>
                                            </c:if>
                                            <c:if test="${workPlan.month == 12}">
                                                <td>${workPlan.monthScore}</td>
                                            </c:if>
                                        </c:forEach>
                                        <th>${score}</th>
                                        <td>${summary.summaryScore}</td>
                                        <td></td>
                                        <td>
                                            <a href="exam-detail.html" class="btn bg-green">打分</a>
                                        </td>
                                    </tr>
                                    </tbody>
                                </c:if>
                                <c:if test="${tesPlan.testTypeId==1}">
                                    <thead>
                                    <tr>
                                        <th>序号</th>
                                        <th>一季度</th>
                                        <th>二季度</th>
                                        <th>三季度</th>
                                        <th>四季度</th>
                                        <th>平均得分</th>
                                        <th>年度总结得分</th>
                                        <th>最终得分</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <c:forEach items="${workPlanList}" var="workPlan" varStatus="status">
                                            <td>${status.index+1}</td>
                                            <c:if test="${workPlan.queater == 1}">
                                                <td>${workPlan.queaterScore}</td>
                                            </c:if>
                                            <c:if test="${workPlan.queater == 2}">
                                                <td>${workPlan.queaterScore}</td>
                                            </c:if>
                                            <c:if test="${workPlan.queater == 3}">
                                                <td>${workPlan.queaterScore}</td>
                                            </c:if>
                                            <c:if test="${workPlan.queater == 4}">
                                                <td>${workPlan.queaterScore}</td>
                                            </c:if>
                                            <th>${score}</th>
                                            <td>${summary.summaryScore}</td>
                                            <td></td>
                                            <td>
                                                <a href="exam-detail.html" class="btn bg-green">打分</a>
                                            </td>
                                        </c:forEach>
                                    </tr>
                                    </tbody>
                                </c:if>
                            </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
                <!-- /.col -->
            </div>
            <!-- /.row -->
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <jsp:include page="../../common/footer.jsp"/>
    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/footer.html" -->

    <div class="control-sidebar-bg"></div>
    <div class="modal fade" id="modal-default">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">查看详情</h4>
                </div>
                <div class="modal-body">
                    <p>One fine body&hellip;</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default pull-left" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary">保存修改</button>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>
</div>
<!-- ./wrapper -->
<jsp:include page="../../common/script.jsp"/>
<!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/script.html" -->

<!-- CKeditor -->
<script src="../../../../resources/js/bower_components/ckeditor/ckeditor.js"></script>
<!-- page script -->
<script>
    $(function () {
        $('#example1').DataTable();
    })
</script>
</body>
</html>
