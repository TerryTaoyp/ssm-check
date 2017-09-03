<%--
  Created by IntelliJ IDEA.
  User: Taoyongpan
  Date: 2017/9/3
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>考核计划管理</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet" href="../../../resources/js/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="../../../resources/js/bower_components/font-awesome/css/font-awesome.min.css">
    <!-- select2 -->
    <link rel="stylesheet" href="../../../resources/js/bower_components/select2/dist/css/select2.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="../../../resources/js/bower_components/Ionicons/css/ionicons.min.css">
    <!-- DataTables -->
    <link rel="stylesheet" href="../../../resources/js/bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="../../../resources/js/dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="../../../resources/js/dist/css/skins/_all-skins.min.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/header.html" -->

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
            <div class="box box-success">
                <div class="box-header with-border">
                    <h3 class="box-title">增添新考核计划</h3>
                </div>
                <!-- /.box-header -->
                <div class="box-body">
                    <form role="form">

                        <div class="form-group">
                            <label>考核计划名称：</label>
                            <input type="text" class="form-control" placeholder="请输入..." required="required" name="role">
                        </div>

                        <div class="form-group">
                            <label>考核性质</label>
                            <select class="form-control">
                                <option>月度考核</option>
                                <option>年度考核</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <label>选择对象：</label>
                            <select class="form-control select2" multiple="multiple" data-placeholder="请选择..." style="width: 100%;">
                                <option>对象1</option>
                                <option>对象2</option>

                            </select>
                        </div>

                        <div class="form-group">
                            <label>考核方式：</label>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox">
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
                            <textarea class="form-control" rows="3" placeholder="请输入..."></textarea>
                        </div>

                        <div class="box-footer">
                            <input type="submit" class="btn btn-primary" value="提交">
                        </div>
                    </form>
                </div>
                <!-- /.box-body -->
            </div>
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
                                    <th>考核计划名称</th>
                                    <th>考核性质</th>
                                    <th>考核对象</th>
                                    <th>备注信息</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>2月考核计划</td>
                                    <td>月度考核</td>
                                    <td>经理</td>
                                    <td>收到对对对对对对多多多多多多多多多多多多多多多多多多多多多多多多</td>
                                    <td>
                                        <button type="button" class="btn bg-olive" data-toggle="modal" data-target="#modal-default">修改计划</button>
                                        <button type="button" class="btn bg-blue">分配权限</button>
                                        <button type="button" class="btn bg-red">删除</button>
                                    </td>
                                </tr>
                                <tr>
                                    <td>2月考核计划</td>
                                    <td>月度考核</td>
                                    <td>经理</td>
                                    <td>收到对对对对对对多多多多多多多多多多多多多多多多多多多多多多多多</td>
                                    <td>
                                        <button type="button" class="btn bg-olive" data-toggle="modal" data-target="#modal-default">修改计划</button>
                                        <button type="button" class="btn bg-blue">分配权限</button>
                                        <button type="button" class="btn bg-red">删除</button>
                                    </td>
                                </tr>
                                </tbody>
                                <tfoot>
                                <tr>
                                    <th>考核计划名称</th>
                                    <th>考核性质</th>
                                    <th>考核对象</th>
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
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/header.html" -->

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
                    <div class="form-group">
                        <label>考核计划名称：</label>
                        <input type="text" class="form-control" placeholder="请输入..." required="required" name="role">
                    </div>

                    <div class="form-group">
                        <label>选择对象：</label>
                        <select class="form-control select2" multiple="multiple" data-placeholder="请选择..." style="width: 100%;">
                            <option>对象1</option>
                            <option>对象2</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <label>考核性质</label>
                        <select class="form-control">
                            <option>月度考核</option>
                            <option>年度考核</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <label>考核方式：</label>
                        <div class="checkbox">
                            <label>
                                <input type="checkbox">
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
                        <textarea class="form-control" rows="3" placeholder="请输入..."></textarea>
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

<!-- jQuery 3 -->
<script src="../../../resources/js/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="../../../resources/js/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- DataTables -->
<script src="../../../resources/js/bower_components/datatables.net/js/jquery.dataTables.js"></script>
<script src="../../../resources/js/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<!-- SlimScroll -->
<script src="../../../resources/js/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="../../../resources/js/bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="../../../resources/js/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../../../resources/js/dist/js/demo.js"></script>
<!-- select2 -->
<script src="../../../resources/js/bower_components/select2/dist/js/select2.full.js"></script>
<!-- page script -->
<script>
    $(function () {
        $('#example1').DataTable();
        $('.select2').select2();
    })
</script>
</body>
</html>
