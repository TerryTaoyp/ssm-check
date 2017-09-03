<%--
  Created by IntelliJ IDEA.
  User: Taoyongpan
  Date: 2017/9/3
  Time: 10:43
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
    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet" href="../../../../resources/js/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="../../../../resources/js/bower_components/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="../../../../resources/js/bower_components/Ionicons/css/ionicons.min.css">
    <!-- DataTables -->
    <link rel="stylesheet" href="../../../../resources/js/bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="../../../../resources/js/dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="../../../../resources/js/dist/css/skins/_all-skins.min.css">



    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Google Font -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
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
                能力指标设置
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
            <div class="box box-success">
                <div class="box-header with-border">
                    <h3 class="box-title">增添新能力指标考核</h3>
                </div>
                <!-- /.box-header -->
                <div class="box-body">
                    <form role="form">
                        <div class="form-group">
                            <label>考核计划</label>
                            <select class="form-control select2" style="width: 100%;">
                                <option selected="selected">1月考核计划</option>
                                <option>2月考核计划</option>
                                <option>3月考核计划</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <label>所属部门</label>
                            <select class="form-control">
                                <option>产品部</option>
                                <option>技术部</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <label>题目数量</label>
                            <select class="form-control">
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <label>问题1：</label>
                            <input type="text" class="form-control" placeholder="请输入..." required="required" name="role">
                            <label>答案数量</label>
                            <select class="form-control">
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                            </select>
                            <label>问题1-答案1：</label>
                            <input type="text" class="form-control" placeholder="请输入..." required="required" name="role">
                            <label>问题1-答案2：</label>
                            <input type="text" class="form-control" placeholder="请输入..." required="required" name="role">
                            <label>问题1-答案3：</label>
                            <input type="text" class="form-control" placeholder="请输入..." required="required" name="role">
                        </div>

                        <div class="form-group">
                            <label>问题2：</label>
                            <input type="text" class="form-control" placeholder="请输入..." required="required" name="role">
                            <label>答案数量</label>
                            <select class="form-control">
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                            </select>
                            <label>问题2-答案1：</label>
                            <input type="text" class="form-control" placeholder="请输入..." required="required" name="role">
                            <label>问题2-答案2：</label>
                            <input type="text" class="form-control" placeholder="请输入..." required="required" name="role">
                            <label>问题2-答案3：</label>
                            <input type="text" class="form-control" placeholder="请输入..." required="required" name="role">
                        </div>

                        <div class="form-group">
                            <label>月份</label>
                            <select class="form-control">
                                <option>1月</option>
                                <option>2月</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <label>发布人：</label>
                            <input type="text" class="form-control" placeholder="请输入..." required="required" name="role">
                        </div>

                        <div class="form-group">
                            <label>工作内容：</label>
                            <textarea id="editor1" name="editor1" rows="10" cols="80">
                       请在这里输入工作计划...
                </textarea>
                        </div>

                        <div class="box-footer">
                            <input type="submit" class="btn btn-primary" value="提交">
                        </div>
                    </form>
                </div>
                <!-- /.box-body -->
            </div>
            <!-- /.row -->
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/footer.html" -->

    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/control-sidebar.html" -->

    <div class="control-sidebar-bg"></div>
    <div class="modal fade" id="modal-default">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">打分</h4>
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

<!-- jQuery 3 -->
<script src="../../../../resources/js/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="../../../../resources/js/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- DataTables -->
<script src="../../../../resources/js/bower_components/datatables.net/js/jquery.dataTables.js"></script>
<script src="../../../../resources/js/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<!-- SlimScroll -->
<script src="../../../../resources/js/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="../../../../resources/js/bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="../../../../resources/js/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../../../../resources/js/dist/js/demo.js"></script>
<!-- page script -->
<script src="../../../../resources/js/bower_components/ckeditor/ckeditor.js"></script>
<script src="../../../../resources/js/bower_components/select2/dist/js/select2.full.js"></script>
<script>
    $(function () {
        // 表格
        $('#example1').DataTable();
        // 富文本编辑器
        CKEDITOR.replace('editor1');
        // 下拉框
        $('.select2').select2();
    })
</script>
</body>
</html>
