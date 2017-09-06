<%--
  Created by IntelliJ IDEA.
  User: Taoyongpan
  Date: 2017/9/3
  Time: 13:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>年度测试</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="../../../../resources/js/plugins/iCheck/all.css">
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
                年度考核能力指标考核
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
    <jsp:include page="../../common/footer.jsp"/>
    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/footer.html" -->
    <jsp:include page="../../common/control-sidebar.jsp"/>
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
<jsp:include page="../../common/script.jsp"/>
<!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/script.html" -->

<!-- page script -->
<!-- iCheck -->
<script src="../../../../resources/js/plugins/iCheck/icheck.min.js"></script>
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
