<%--
  Created by IntelliJ IDEA.
  User: Taoyongpan
  Date: 2017/9/3
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>考核计划管理</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- select2 -->
    <link rel="stylesheet" href="../../../resources/js/bower_components/select2/dist/css/select2.min.css">
    <jsp:include page="../common/link.jsp"/>
    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/link.html" -->

</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <jsp:include page="../common/header.jsp"/>
    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/header.html" -->
    <jsp:include page="../common/sidebar.jsp"/>
    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/sidebar.html" -->

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                考核计划管理
                <small>栏目</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">考核管理</a></li>
                <li class="active">考核计划管理</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">考核计划</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="example1" class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>考核计划名称</th>
                                    <th>考核性质</th>
                                    <th>考核开始时间</th>
                                    <th>考核结束时间</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${testPlanList}" var="testPlan" varStatus="status">
                                    <tr data-id="${status.index+1}">
                                        <td>${status.index+1}</td>
                                        <td class="name-text">${testPlan.testName}</td>
                                        <td class="nature-text">${testPlan.testTypeId}</td>
                                        <td class="position-text">${testPlan.startTime}</td>
                                        <td class="remark-text">${testPlan.finishTime}</td>
                                        <td>
                                            <button type="button" class="btn bg-olive change" data-toggle="modal" data-target="#modal-default" data-num="1">修改计划</button>
                                            <button type="button" class="btn bg-blue">分配权限</button>
                                            <button type="button" class="btn bg-red delete" data-num="1" href="${website}/testplan/del/${testPlan.id}">删除</button>
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
    <jsp:include page="../common/header.jsp"/>
    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/header.html" -->
    <jsp:include page="../common/control-sidebar.jsp"/>
    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/control-sidebar.html" -->

    <div class="control-sidebar-bg"></div>
    <div class="modal fade" id="modal-default">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">修改计划</h4>
                </div>
                <div class="modal-body">
                    <!-- 获取隐藏的点击按钮的次序 -->
                    <input type="hidden" id="dataId">
                    <div class="form-group">
                        <label>考核计划名称：</label>
                        <input type="text" class="form-control name a-require-text" placeholder="请输入..." name="role">
                    </div>

                    <div class="form-group">
                        <label>考核性质：</label>
                        <select class="form-control nature a-require-option">
                            <option value="-1">请选择</option>
                            <option value="1">月度考核</option>
                            <option value="2">年度考核</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <label>选择对象：</label>
                        <select class="form-control select2 position a-require-options" multiple="multiple" data-placeholder="请选择..." style="width: 100%;">
                            <option value="1">对象1</option>
                            <option value="2">对象2</option>
                        </select>
                    </div>

                    <div class="form-group none kind">
                        <label>考核方式：</label>
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" checked="checked" name="kind">
                                工作计划考核
                            </label>
                        </div>

                        <div class="checkbox">
                            <label>
                                <input type="checkbox">
                                绩效指标考核
                            </label>
                        </div>
                    </div>

                    <div class="form-group">
                        <label>备注信息：</label>
                        <textarea class="form-control remark a-require-text" rows="3" placeholder="请输入..."></textarea>
                    </div>
                    <p class="text-red tip"></p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default pull-left" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary J-ajax-submit">保存修改</button>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>
</div>
<!-- ./wrapper -->
<jsp:include page="../common/script.jsp"/>
<!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/script.html" -->
<!-- select2 -->
<script src="../../../resources/js/bower_components/select2/dist/js/select2.full.js"></script>
<script src="../../../resources/js/pages/js/common/verify.js"></script>
<script src="../../../resources/js/pages/js/evaluation/plan-management.js"></script>
<!-- page script -->
<script>
    $(function () {
        $('#example1').DataTable();
        $('.select2').select2();
    })
</script>
</body>
</html>
