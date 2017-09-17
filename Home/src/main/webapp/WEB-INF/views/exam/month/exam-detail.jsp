<%--
  Created by IntelliJ IDEA.
  User: Taoyongpan
  Date: 2017/9/3
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>月/季度考核-打分详情</title>
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
                月/季度考核-打分
                <small>栏目</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">测评模块</a></li>
                <li class="active">打分详情</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box box-primary">
                        <div class="box-header">
                            <h3 class="box-title">
                                <c:forEach items="${testPlanList}" var="testPlan">
                                    <c:if test="${testPlan.id == workPlan.testId}">
                                        ${testPlan.testName}
                                    </c:if>
                                </c:forEach>
                            </h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="example1" class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>被考核者姓名</th>
                                    <th>工作计划内容</th>
                                    <th>开始时间</th>
                                    <th>结束时间</th>
                                    <th>权重</th>
                                    <th>预期工作成果</th>
                                    <th>工作完成情况</th>
                                    <th>考核得分</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${workDetailList}" var="workDetail" varStatus="status">
                                <tr>
                                    <td>${status.index+1}</td>
                                    <td>
                                    <c:forEach items="${userList}" var="user">
                                        <c:if test="${user.id == workPlan.beCheckId}">
                                            ${user.username}
                                        </c:if>
                                    </c:forEach>
                                    </td>
                                    <td>${workDetail.planContent}</td>
                                    <td>${workDetail.startTime}</td>
                                    <td>${workDetail.endTime}</td>
                                    <td>${workDetail.weight}</td>
                                    <td>${workDetail.expectResult}</td>
                                    <td><input type="text" value="${workDetail.completion}"></td>
                                    <td><input type="text" value="${workDetail.testScore}"/></td>
                                    <td>
                                        <%--<button type="button" class="btn bg-green" data-toggle="modal" data-target="#modal-default">确定</button> --%>
                                        <button type="button" class="btn bg-green">确定</button>
                                        <button type="button" class="btn bg-red ">修改</button>
                                    </td>
                                </tr>
                                </c:forEach>
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
<script>
    $(function () {
        $('#example1').DataTable();
    })
</script>
</body>
</html>
