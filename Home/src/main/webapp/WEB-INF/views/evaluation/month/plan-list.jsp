<%--
  Created by IntelliJ IDEA.
  User: Taoyongpan
  Date: 2017/9/3
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>月度考核-工作计划列表</title>
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
                工作计划设置
                <small>栏目</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">考核管理</a></li>
                <li class="active">工作计划</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box box-success">
                        <div class="box-header">
                            <h3 class="box-title">工作计划列表</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="example1" class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>所属考核名称</th>
                                    <th>所属考核计划</th>
                                    <th>考核开始时间</th>
                                    <th>考核结束时间</th>
                                    <th>是否开启</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${testPlanList}" var="testPlan" varStatus="status">
                                    <tr data-id="${status.index+1}">
                                        <td>${status.index+1}</td>
                                        <td>${testPlan.testName}</td>
                                        <c:forEach items="${testTypeList}" var="testType">
                                            <c:if test="${testPlan.testTypeId == testType.id}">
                                                <td>${testType.name}</td>
                                            </c:if>
                                        </c:forEach>
                                        <td>${testPlan.startTime}</td>
                                        <td>${testPlan.finishTime}</td>
                                        <c:if test="${testPlan.isAvailable ==1}">
                                            <td>已开启</td>
                                        </c:if>
                                        <c:if test="${testPlan.isAvailable ==0}">
                                            <td>未开启</td>
                                        </c:if>
                                        <td>
                                            <a href="${website}/workplan/month/detail/${testPlan.id}" class="btn bg-blue">查看详情</a>
                                            <%--<button type="button" class="btn bg-red delete" data-num="1">删除</button>--%>
                                        </td>
                                    </tr>
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

    <div class="control-sidebar-bg"></div>
    <div class="modal fade" id="modal-default">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">修改职位</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>所属考核计划：</label>
                        <select class="form-control">
                            <option>8月考核</option>
                            <option>7月考核</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <label>所属部门：</label>
                        <select class="form-control">
                            <option>产品部</option>
                            <option>技术部</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <label>发布人：</label>
                        <input type="text" class="form-control" placeholder="请输入..." required="required" name="role">
                    </div>

                    <div class="form-group">
                        <label>备注信息：</label>
                        <textarea class="form-control" rows="3" placeholder="请输入..."></textarea>
                    </div>

                    <div class="box-footer">
                        <input type="submit" class="btn btn-primary" value="提交">
                    </div>
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
<script src="../../../../resources/js/pages/evaluation/month/plan-list.js"></script>
<!-- page script -->
<script>
    $(function () {
        $('#example1').DataTable()
    })
</script>
</body>
</html>
