<%--
  Created by IntelliJ IDEA.
  User: Taoyongpan
  Date: 2017/9/3
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>月/季度测试</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet" href="../../../../resources/js/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="../../../../resources/js/bower_components/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="../../../../resources/js/bower_components/Ionicons/css/ionicons.min.css">
    <!-- iCheck for checkboxes and radio inputs -->
    <link rel="stylesheet" href="../../../../resources/js/plugins/iCheck/all.css">
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
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
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
                月/季度考核能力指标考核
                <small>栏目</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">测评管理</a></li>
                <li class="active">年度考核</li>
            </ol>
        </section>

        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <form>
                        <div class="box box-warning">
                            <div class="box-header">
                                <h3 class="box-title">绩效综合能力目录</h3>
                            </div>
                            <div class="box-body">
                                <ul class="timeline">
                                    <!-- timeline time label -->
                                    <li class="time-label">
                        <span class="bg-green">
                          考核开始
                        </span>
                                    </li>
                                    <!-- /.timeline-label -->
                                    <!-- timeline item -->
                                    <li>
                                        <i class="fa bg-blue">1</i>

                                        <div class="timeline-item">
                                            <span class="time"><i class="fa fa-clock-o"></i> 12:05</span>

                                            <h3 class="timeline-header">
                                                <a href="#">【创新题20%】</a>
                                                你觉得公司怎么样？
                                            </h3>

                                            <div class="timeline-body box-body">
                                                <div class="form-group">
                                                    <label>
                                                        <input type="radio" name="r1" class="minimal">
                                                        A.答案1
                                                    </label>
                                                    <a class="btn bg-olive btn-xs">优秀(10.0~10.0分)</a>
                                                </div>
                                                <div class="form-group">
                                                    <label>
                                                        <input type="radio" name="r1" class="minimal">
                                                        B.答案1
                                                    </label>
                                                    <a class="btn btn-primary btn-xs">良好(8.0~9.0分)</a>
                                                </div>
                                                <div class="form-group">
                                                    <label>
                                                        <input type="radio" name="r1" class="minimal">
                                                        C.答案1
                                                    </label>
                                                    <a class="btn bg-orange btn-xs">一般(6.0~7.0分)</a>
                                                </div>
                                                <div class="form-group">
                                                    <label>
                                                        <input type="radio" name="r1" class="minimal">
                                                        D.答案1
                                                    </label>
                                                    <a class="btn bg-red btn-xs">不及格(0.0~5.0分)</a>
                                                </div>

                                            </div>
                                            <div class="timeline-footer">
                                                <div class="form-group">
                                                    <label>请输入分数：</label>
                                                    <input type="text" class="form-control" placeholder="10.0-10.0" required="required" name="role">
                                                </div>
                                            </div>
                                        </div>
                                    </li>

                                    <li>
                                        <i class="fa bg-blue">2</i>

                                        <div class="timeline-item">
                                            <span class="time"><i class="fa fa-clock-o"></i> 12:05</span>

                                            <h3 class="timeline-header">
                                                <a href="#">【创新题20%】</a>
                                                你觉得公司怎么样？
                                            </h3>

                                            <div class="timeline-body box-body">
                                                <div class="form-group">
                                                    <label>
                                                        <input type="radio" name="r1" class="minimal">
                                                        A.答案1
                                                    </label>
                                                    <a class="btn bg-olive btn-xs">优秀(10.0~10.0分)</a>
                                                </div>
                                                <div class="form-group">
                                                    <label>
                                                        <input type="radio" name="r1" class="minimal">
                                                        B.答案1
                                                    </label>
                                                    <a class="btn btn-primary btn-xs">良好(8.0~9.0分)</a>
                                                </div>
                                                <div class="form-group">
                                                    <label>
                                                        <input type="radio" name="r1" class="minimal">
                                                        C.答案1
                                                    </label>
                                                    <a class="btn bg-orange btn-xs">一般(6.0~7.0分)</a>
                                                </div>
                                                <div class="form-group">
                                                    <label>
                                                        <input type="radio" name="r1" class="minimal">
                                                        D.答案1
                                                    </label>
                                                    <a class="btn bg-red btn-xs">不及格(0.0~5.0分)</a>
                                                </div>

                                            </div>
                                            <div class="timeline-footer">
                                                <div class="form-group">
                                                    <label>请输入分数：</label>
                                                    <input type="text" class="form-control" placeholder="10.0-10.0" required="required" name="role">
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="time-label">
                        <span class="bg-green">
                          考核结束
                        </span>
                                    </li>
                                    <!-- /.timeline-label -->
                                    <li>
                                        <i class="fa fa-clock-o bg-gray"></i>
                                    </li>
                                </ul>
                            </div>
                            <div class="box-footer">
                                <input type="submit" class="btn btn-primary" value="提交">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </section>
    </div>
    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/footer.html" -->

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
<!-- iCheck -->
<script src="../../../../resources/js/plugins/iCheck/icheck.min.js"></script>
<!-- FastClick -->
<script src="../../../../resources/js/bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="../../../../resources/js/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../../../../resources/js/dist/js/demo.js"></script>
<!-- page script -->
<script>
    $(function () {
        //iCheck for checkbox and radio inputs
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
            radioClass   : 'iradio_minimal-blue'
        })
    })
</script>
</body>
</html>
