<%--
  Created by IntelliJ IDEA.
  User: Taoyongpan
  Date: 2017/9/3
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>年度考核-绩效综合能力</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <jsp:include page="../../common/link.jsp"/>
    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/link.html" -->

</head>
<body class="hold-transition skin-blue sidebar-mini">
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
                绩效综合能力考核设置
                <small>栏目</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">考核管理</a></li>
                <li class="active">绩效综合能力考核</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box box-success">
                        <div class="box-header">
                            <h3 class="box-title">工作计划设置</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="example1" class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>考核年份</th>
                                    <th>1月</th>
                                    <th>2月</th>
                                    <th>3月</th>
                                    <th>4月</th>
                                    <th>5月</th>
                                    <th>6月</th>
                                    <th>7月</th>
                                    <th>8月</th>
                                    <th>9月</th>
                                    <th>10月</th>
                                    <th>11月</th>
                                    <th>12月</th>
                                    <th>平均得分</th>
                                    <th>年度总结得分</th>
                                    <th>您的得分</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${performanceList}" var="performance" varStatus="status">
                                    <tr>
                                        <td>${status.index+1}</td>
                                        <c:forEach items="${performanceYear}" var="year">
                                            <td>${year.year}</td>
                                            <c:forEach items="${workPlanList}" var="workPlan">
                                                <c:if test="${workPlan.month == 1 && workPlan.year == year.year}">
                                                    <td>${workPlan.monthScore}</td>
                                                </c:if>
                                                <c:if test="${workPlan.month ==2 && workPlan.year == year.year}">
                                                    <td>${workPlan.monthScore}</td>
                                                </c:if>
                                                <c:if test="${workPlan.month == 3 && workPlan.year == year.year}">
                                                    <td>${workPlan.monthScore}</td>
                                                </c:if>
                                                <c:if test="${workPlan.month == 4 && workPlan.year == year.year}">
                                                    <td>${workPlan.monthScore}</td>
                                                </c:if>
                                                <c:if test="${workPlan.month == 5 && workPlan.year == year.year}">
                                                    <td>${workPlan.monthScore}</td>
                                                </c:if>
                                                <c:if test="${workPlan.month == 6 && workPlan.year == year.year}">
                                                    <td>${workPlan.monthScore}</td>
                                                </c:if>
                                                <c:if test="${workPlan.month == 7 && workPlan.year == year.year}">
                                                    <td>${workPlan.monthScore}</td>
                                                </c:if>
                                                <c:if test="${workPlan.month == 8 && workPlan.year == year.year}">
                                                    <td>${workPlan.monthScore}</td>
                                                </c:if>
                                                <c:if test="${workPlan.month == 9 && workPlan.year == year.year}">
                                                    <td>${workPlan.monthScore}</td>
                                                </c:if>
                                                <c:if test="${workPlan.month == 10 && workPlan.year == year.year}">
                                                    <td>${workPlan.monthScore}</td>
                                                </c:if>
                                                <c:if test="${workPlan.month == 11 && workPlan.year == year.year}">
                                                    <td>${workPlan.monthScore}</td>
                                                </c:if>
                                                <c:if test="${workPlan.month == 12 && workPlan.year == year.year}">
                                                    <td>${workPlan.monthScore}</td>
                                                </c:if>
                                            </c:forEach>
                                            <c:if test="${year.year == performance.year}">
                                                <td>${performance.suggestScore}</td>
                                            </c:if>
                                            <c:if test="${year.year == performance.year}">
                                                <td>${performance.summaryScore}</td>
                                            </c:if>
                                            <c:if test="${year.year == performance.year}">
                                                <td>${performance.yearScore}</td>
                                            </c:if>
                                            </tr>
                                        </c:forEach>
                                </c:forEach>
                                </tbody>

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
    <jsp:include page="../../common/control-sidebar.jsp"/>
    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/control-sidebar.html" -->

    <div class="control-sidebar-bg"></div>
    <div class="modal fade" id="modal-default">
        <div class="modal-dialog">
            <form class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">打分</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>您的分数</label>
                        <input type="text" class="form-control" placeholder="请输入0-100内数字..." required="required" name="role">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default pull-left" data-dismiss="modal">关闭</button>
                    <input type="submit" class="btn btn-primary" value="打分">
                </div>
            </form>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>
</div>
<!-- ./wrapper -->
<jsp:include page="../../common/script.jsp"/>
<!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/script.html" -->

<!-- page script -->
<!-- CKeditor -->
<script src="../../../../resources/js/bower_components/ckeditor/ckeditor.js"></script>
<script>
    $(function () {
        $('#example1').DataTable();
        CKEDITOR.replace('editor1');
    })
</script>
</body>
</html>
