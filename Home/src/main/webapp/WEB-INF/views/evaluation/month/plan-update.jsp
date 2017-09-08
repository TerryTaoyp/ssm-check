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
    <title>xx月度考核-工作计划详情</title>
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
                月考核工作计划详情
                <small>栏目</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">考核管理</a></li>
                <li class="active">工作计划详情</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="box box-success">
                <div class="box-header with-border">
                    <h3 class="box-title">增添新工作计划</h3>
                </div>
                <!-- /.box-header -->
                <div class="box-body">
                    <form role="form">

                        <div class="form-group">
                            <label>所属考核计划：</label>
                            <select class="form-control require-option">
                                <option value="-1" selected="selected">请选择</option>
                                <option>8月考核计划</option>
                                <option>7月考核计划</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <label>部门：</label>
                            <select class="form-control require-option">
                                <option value="-1" selected="selected">请选择</option>
                                <option>产品部</option>
                                <option>技术部</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <label>发布人：</label>
                            <input type="text" class="form-control require-text" placeholder="请输入..." name="role">
                        </div>

                        <div class="form-group">
                            <label>计划比重：</label>
                            <select class="form-control require-option">
                                <option value="-1" selected="selected">请选择</option>
                                <option>1%</option>
                                <option>2%</option>
                            </select>
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
    <jsp:include page="../../common/control-sidebar.jsp"/>
    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/control-sidebar.html" -->

    <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->
<jsp:include page="../../common/script.jsp"/>
<!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/script.html" -->
<script src="../../../../resources/js/bower_components/ckeditor/ckeditor.js"></script>
<script src="../../../../resources/js/pages/js/common/verify.js"></script>
<!-- page script -->
<script>
    $(function () {
        $('#example1').DataTable();
        CKEDITOR.replace('editor1');
    })
</script>
</body>
</html>
