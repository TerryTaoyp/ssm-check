<%--
  Created by IntelliJ IDEA.
  User: Taoyongpan
  Date: 2017/9/3
  Time: 13:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>年度考核-打分详情</title>
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
                年度考核-打分
                <small>栏目</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">测评模块</a></li>
                <li class="active">打分详情</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box box-primary">
                        <div class="box-header">
                            <h3 class="box-title">xx的3月工作计划</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="example1" class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th>姓名</th>
                                    <th>所属部门</th>
                                    <th>月份</th>
                                    <th>工作计划</th>
                                    <th>完成情况</th>
                                    <th>您的打分</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>吴</td>
                                    <td>产品部</td>
                                    <td>横说竖说护手霜分</td>
                                    <td>90分</td>
                                    <td>90分</td>
                                    <td>暂未打分</td>
                                    <td>
                                        <button type="button" class="btn bg-green" data-toggle="modal" data-target="#modal-default">打分</button>
                                        <button type="button" class="btn bg-red disabled">已打分</button>
                                    </td>
                                </tr>
                                <tr>
                                    <td>张</td>
                                    <td>技术部</td>
                                    <td>横说竖说护手霜分</td>
                                    <td>90分</td>
                                    <td>90分</td>
                                    <td>暂未打分</td>
                                    <td>
                                        <button type="button" class="btn bg-green" data-toggle="modal" data-target="#modal-default">打分</button>
                                        <button type="button" class="btn bg-red disabled">已打分</button>
                                    </td>
                                </tr>
                                </tbody>
                                <tfoot>
                                <tr>
                                    <th>姓名</th>
                                    <th>所属部门</th>
                                    <th>月份</th>
                                    <th>工作计划</th>
                                    <th>完成情况</th>
                                    <th>您的打分</th>
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
        <jsp:include page="../../common/footer.jsp"/>
    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/footer.html" -->
        <jsp:include page="../../common/control-sidebar.jsp"/>
    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/control-sidebar.html" -->

    <div class="control-sidebar-bg"></div>
    <div class="modal fade" id="modal-default">
        <div class="modal-dialog">
            <form class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">打分</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>您的分数：</label>
                        <input type="text" class="form-control" placeholder="请输入0-100内数字..." required="required" name="role">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default pull-left" data-dismiss="modal">关闭</button>
                    <input type="submit" class="btn btn-primary" value="打分">
                </div>
            </form>
            <!-- /.modal-content -->
        </div>
    </div>
    <!-- ./wrapper -->
        <jsp:include page="../../common/script.jsp"/>
    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/script.html" -->

    <!-- CKeditor -->
    <script src="../../../../resources/js/bower_components/ckeditor/ckeditor.js"></script>
    <script>
        $(function () {
            $('#example1').DataTable();
        })
    </script>
</body>
</html>