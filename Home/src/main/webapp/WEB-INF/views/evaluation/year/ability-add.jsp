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
    <!-- select2 -->
    <link rel="stylesheet" href="../../../../resources/js/bower_components/select2/dist/css/select2.min.css">
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
                            <select class="form-control require-option">
                                <option selected="selected" value="-1">请选择</option>
                                <option>2月考核计划</option>
                                <option>3月考核计划</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <label>所属部门</label>
                            <select class="form-control require-option">
                                <option selected="selected" value="-1">请选择</option>
                                <option>产品部</option>
                                <option>技术部</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <label>月份</label>
                            <select class="form-control require-option">
                                <option selected="selected" value="-1">请选择</option>
                                <option>1月</option>
                                <option>2月</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <div class="alert alert-info alert-dismissible">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                <h4>问题1</h4>
                                <label>问题1：</label>
                                <input type="text" class="form-control" placeholder="请输入..." name="role">

                                <label>
                                    答案1：<a class="btn bg-olive btn-xs">优秀(10.0~10.0分)</a>
                                </label>
                                <input type="text" class="form-control" placeholder="请输入..." name="role">

                                <label>
                                    答案2：<a class="btn btn-primary btn-xs">良好(8.0~9.0分)</a>
                                </label>
                                <input type="text" class="form-control" placeholder="请输入..." name="role">

                                <label>
                                    答案3：<a class="btn bg-orange btn-xs">一般(6.0~7.0分)</a>
                                </label>
                                <input type="text" class="form-control" placeholder="请输入..." name="role">

                                <label>
                                    答案4：<a class="btn bg-red btn-xs">不及格(0.0~5.0分)</a>
                                </label>
                                <input type="text" class="form-control" placeholder="请输入..." name="role">
                            </div>
                        </div>
                        <button type="button" class="btn btn-block bg-olive">增加问题</button>

                        <div class="form-group">
                            <label>发布人：</label>
                            <input type="text" class="form-control require-text" placeholder="请输入..." name="role">
                        </div>

                        <div class="form-group">
                            <label>工作内容：</label>
                            <textarea id="editor1" name="editor1" rows="10" cols="80">
                       请在这里输入工作计划...
                </textarea>
                        </div>

                        <div class="box-footer">
                            <input type="submit" class="btn btn-primary J-submit" value="提交">
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
    <jsp:include page="../../common/footer.jsp"/>
    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/footer.html" -->

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
                    <button type="button" class="btn btn-primary J-submit">保存修改</button>
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
<script src="../../../../resources/js/bower_components/ckeditor/ckeditor.js"></script>
<script src="../../../../resources/js/bower_components/select2/dist/js/select2.full.js"></script>
<script src="../../../../resources/js/pages/js/common/verify.js"></script>
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
