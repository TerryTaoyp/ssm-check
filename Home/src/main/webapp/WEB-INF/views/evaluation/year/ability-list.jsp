<%--
  Created by IntelliJ IDEA.
  User: Taoyongpan
  Date: 2017/9/3
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>年度考核-能力指标</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="../../../../resources/js/bower_components/select2/dist/css/select2.min.css">
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
                年度考核-能力指标
                <small>栏目</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">考核管理</a></li>
                <li class="active">能力指标考核</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box box-success">
                        <div class="box-header">
                            <h3 class="box-title">年度能力指标列表</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="example1" class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th>考核计划名称</th>
                                    <th>年份</th>
                                    <th>所属部门</th>
                                    <th>发布人</th>
                                    <th>备注信息</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>吴</td>
                                    <td>1月</td>
                                    <td>产品部</td>
                                    <td>经理</td>
                                    <td>收到对对对对对对多多多多多多多多多多多多多多多多多多多多多多多多</td>
                                    <td>
                                        <a href="#" class="btn bg-blue">查看详情</a>
                                        <button type="button" class="btn bg-olive" data-toggle="modal" data-target="#modal-default">修改计划</button>
                                        <button type="button" class="btn bg-red">删除此能力指标考核</button>
                                    </td>
                                </tr>
                                <tr>
                                    <td>张</td>
                                    <td>2月</td>
                                    <td>技术部</td>
                                    <td>经理</td>
                                    <td>收到对对对对对对多多多多多多多多多多多多多多多多多多多多多多多多</td>
                                    <td>
                                        <a href="#" class="btn bg-blue">查看详情</a>
                                        <button type="button" class="btn bg-olive" data-toggle="modal" data-target="#modal-default">修改计划</button>
                                        <button type="button" class="btn bg-red">删除此能力指标考核</button>
                                    </td>
                                </tr>
                                </tbody>
                                <tfoot>
                                <tr>
                                    <th>考核计划名称</th>
                                    <th>年份</th>
                                    <th>所属部门</th>
                                    <th>发布人</th>
                                    <th>备注信息</th>
                                    <th>操作</th>
                                </tr>
                                </tfoot>
                            </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
                <!-- /.col -->
            </div>
            <!-- /.row -->
            <a href="ability-add.html" class="btn bg-olive">添加能力指考核</a>
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
                    <h4 class="modal-title">修改计划</h4>
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
<!-- page script -->
<script src="../../../../resources/js/bower_components/select2/dist/js/select2.full.js"></script>
<script>
    $(function () {
        // 表格
        $('#example1').DataTable();
        // 下拉框
        $('.select2').select2();
    })
</script>
</body>
</html>
