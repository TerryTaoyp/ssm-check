<%--
  Created by IntelliJ IDEA.
  User: Taoyongpan
  Date: 2017/9/5
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>月/季度考核-工作计划结果报表</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
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
                月季度考核-工作计划结果报表
                <small>栏目</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">成绩查询</a></li>
                <li class="active">月季度考核-工作计划结果报表</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box box-default">
                        <div class="box-header">
                            <h3 class="box-title">全部考核列表</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="example1" class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>考核计划名称</th>
                                    <th>部门</th>
                                    <th>姓名</th>
                                    <th>职位</th>
                                    <th>一月</th>
                                    <th>二月</th>
                                    <th>三月</th>
                                    <th>四月</th>
                                    <th>五月</th>
                                    <th>六月</th>
                                    <th>七月</th>
                                    <th>八月</th>
                                    <th>九月</th>
                                    <th>十月</th>
                                    <th>十一月</th>
                                    <th>十二月</th>
                                    <th>总结得分</th>
                                    <th>综合得分</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list}" var="list" varStatus="status">
                                    <tr>
                                        <td>${status.index+1}</td>
                                        <td>${list.year}年度成绩</td>
                                        <td>${list.department}</td>
                                        <td>${list.username}</td>
                                        <td>${list.role}</td>
                                        <td>${list.month1}</td>
                                        <td>${list.month2}</td>
                                        <td>${list.month3}</td>
                                        <td>${list.month4}</td>
                                        <td>${list.month5}</td>
                                        <td>${list.month6}</td>
                                        <td>${list.month7}</td>
                                        <td>${list.month8}</td>
                                        <td>${list.month9}</td>
                                        <td>${list.month10}</td>
                                        <td>${list.month11}</td>
                                        <td>${list.month12}</td>
                                        <td>${list.summaryScore}</td>
                                        <td>${list.yearScore}</td>
                                        <td>
                                            <button type="button" class="btn bg-green">打印此报表</button>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                                <tfoot>
                                <tr>
                                    <th>序号</th>
                                    <th>考核计划名称</th>
                                    <th>部门</th>
                                    <th>姓名</th>
                                    <th>职位</th>
                                    <th>一月</th>
                                    <th>二月</th>
                                    <th>三月</th>
                                    <th>四月</th>
                                    <th>五月</th>
                                    <th>六月</th>
                                    <th>七月</th>
                                    <th>八月</th>
                                    <th>九月</th>
                                    <th>十月</th>
                                    <th>十一月</th>
                                    <th>十二月</th>
                                    <th>总结得分</th>
                                    <th>综合得分</th>
                                    <th>
                                        操作
                                        <button type="button" class="btn bg-green">全部导出</button>
                                    </th>
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

    <div class="control-sidebar-bg"></div>
    <div class="modal fade" id="modal-default">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">查看详情</h4>
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
<!-- CKeditor -->
<script src="../../../../resources/js/bower_components/ckeditor/ckeditor.js"></script>
<!-- page script -->
<script>
    $(function () {
        $('#example1').DataTable();
    })
</script>
</body>
</html>
