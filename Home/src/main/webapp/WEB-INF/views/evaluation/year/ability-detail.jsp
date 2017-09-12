<%--
  Created by IntelliJ IDEA.
  User: Taoyongpan
  Date: 2017/9/11
  Time: 8:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>年度考核-能力指标详情</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/link.html" -->
    <jsp:include page="../../common/link.jsp"/>
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
                吴的绩效综合能力详情
                <small>栏目</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">考核管理</a></li>
                <li class="active">绩效综合能力考核详情</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <div class="box box-success">
                        <div class="box-header">
                            <h3 class="box-title">绩效综合能力题目预览</h3>
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
                                                    A.答案1
                                                </label>
                                                <a class="btn bg-olive btn-xs">优秀(9~10分)</a>
                                            </div>
                                            <div class="form-group">
                                                <label>
                                                    B.答案1
                                                </label>
                                                <a class="btn btn-primary btn-xs">良好(7~8分)</a>
                                            </div>
                                            <div class="form-group">
                                                <label>
                                                    C.答案1
                                                </label>
                                                <a class="btn bg-orange btn-xs">一般(5~6分)</a>
                                            </div>
                                            <div class="form-group">
                                                <label>
                                                    D.答案1
                                                </label>
                                                <a class="btn bg-red btn-xs">不及格(0~4分)</a>
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
                                                    A.答案1
                                                </label>
                                                <a class="btn bg-olive btn-xs">优秀(9~10分)</a>
                                            </div>
                                            <div class="form-group">
                                                <label>
                                                    B.答案1
                                                </label>
                                                <a class="btn btn-primary btn-xs">良好(7~8分)</a>
                                            </div>
                                            <div class="form-group">
                                                <label>
                                                    C.答案1
                                                </label>
                                                <a class="btn bg-orange btn-xs">一般(5~6分)</a>
                                            </div>
                                            <div class="form-group">
                                                <label>
                                                    D.答案1
                                                </label>
                                                <a class="btn bg-red btn-xs">不及格(0~4分)</a>
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
                            <a href="ability-list.html" class="btn btn-primary">返回列表</a>
                            <a href="ability-update.html" class="btn bg-olive">修改题目</a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <jsp:include page="../../common/footer.jsp"/>
    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/footer.html" -->

    <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->
<jsp:include page="../../common/script.jsp"/>
<!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/script.html" -->
<!-- page script -->
</body>
</html>
