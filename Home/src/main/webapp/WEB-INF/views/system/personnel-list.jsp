<%--
  Created by IntelliJ IDEA.
  User: Taoyongpan
  Date: 2017/9/4
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>人员管理</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <jsp:include page="../common/link.jsp"/>
    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/link.html" -->

</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <jsp:include page="../common/header.jsp"/>
    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/header.html" -->
    <jsp:include page="../common/sidebar.jsp"/>
    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/sidebar.html" -->

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                单位人员管理
                <small>栏目</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">系统管理</a></li>
                <li class="active">人员管理</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">人员管理</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="example1" class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>用户名</th>
                                    <th>员工姓名</th>
                                    <th>所属部门</th>
                                    <th>职位</th>
                                    <th>联系方式</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${userList}" var="user" varStatus="status">
                                    <tr data-id="${status.index+1}">
                                        <td>${status.index+1}</td>
                                        <td>${user.username}</td>
                                        <td>${user.realName}</td>
                                        <c:forEach items="${departmentList}" var="department">
                                            <c:if test="${department.id == user.did}">
                                                <td>${department.name}</td>
                                            </c:if>
                                        </c:forEach>
                                        <c:forEach items="${roleList}" var="role">
                                            <c:if test="${user.rid == role.id}">
                                                <td>${role.name}</td>
                                            </c:if>
                                        </c:forEach>
                                        <td>${user.phone}</td>
                                        <td>
                                            <button type="button" class="btn bg-blue">查看详情</button>
                                            <button type="button" class="btn bg-olive change" data-toggle="modal" data-target="#modal-default" data-num="${status.index+1}">修改</button>
                                            <button type="button" class="btn bg-red delete" data-num="${status.index+1}"><a href="${website}/user/del/${user.id}">删除</a></button>
                                        </td>
                                    </tr>
                                    <tr data-id="1">
                                        <td>章</td>
                                        <td class="department-text">技术部</td>
                                        <td class="position-text">经理</td>
                                        <td>132</td>
                                        <td class="remark-text">收到对</td>
                                        <td>
                                            <button type="button" class="btn bg-blue">查看详情</button>
                                            <button type="button" class="btn bg-olive change" data-toggle="modal" data-target="#modal-default" data-num="1">修改</button>
                                            <button type="button" class="btn bg-red delete" data-num="1">删除</button>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
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
    <jsp:include page="../common/footer.jsp"/>
    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/footer.html" -->
    <jsp:include page="../common/control-sidebar.jsp"/>
    <!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/control-sidebar.html" -->

    <!-- Add the sidebar's background. This div must be placed
         immediately after the control sidebar -->
    <div class="control-sidebar-bg"></div>
    <div class="modal fade" id="modal-default">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">修改人员信息</h4>
                </div>
                <div class="modal-body">
                    <input type="hidden" id="dataId">
                    <div class="form-group">
                        <label>所属部门：</label>
                        <select class="form-control a-require-option department">
                            <option value="-1">请选择</option>
                            <option>技术部</option>
                            <option>产品部</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>职位：</label>
                        <select class="form-control a-require-option position">
                            <option>部门经理</option>
                            <option>部门副经理</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>备注信息：</label>
                        <textarea class="form-control remark a-require-text" rows="3" placeholder="请输入..."></textarea>
                    </div>
                    <p class="text-red tip"></p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default pull-left" data-dismiss="modal">关闭</button>
                    <a href="javascript:;" class="btn btn-primary J-ajax-submit">修改</a>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>
</div>
<!-- ./wrapper -->
<jsp:include page="../common/script.jsp"/>
<!--#include file="/ssm-check/Home/src/main/webapp/WEB-INF/views/common/script.html" -->
<!-- page script -->
<script src="../../../resources/js/pages/js/common/verify.js"></script>
<script src="../../../resources/js/pages/js/system/personnel-list.js"></script>
<script>
    $(function () {
        $('#example1').DataTable();
    })
</script>
</body>
</html>
