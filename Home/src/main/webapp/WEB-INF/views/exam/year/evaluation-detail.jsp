<%--
  Created by IntelliJ IDEA.
  User: Taoyongpan
  Date: 2017/9/3
  Time: 13:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>年度考核列表</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <jsp:include page="../../common/link.jsp"/>
</head>
<body class="hold-transition skin-black sidebar-mini">
<div class="wrapper">
    <jsp:include page="../../common/header.jsp"/>
    <jsp:include page="../../common/sidebar.jsp"/>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                年度考核列表
                <small>栏目</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">测评模块</a></li>
                <li class="active">年度考核列表</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box box-primary">
                        <div class="box-header">
                            <h3 class="box-title">考核列表</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="example1" class="table table-bordered table-striped">
                                <c:if test="${testPlan.testTypeId==2}">
                                    <thead>
                                    <tr>
                                        <th>序号</th>
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
                                        <th>平均得分</th>
                                        <th>年度总结得分</th>
                                        <th>最终得分</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>1</td>
                                        <c:forEach items="${workPlanList}" var="workPlan" varStatus="status">
                                            <td>
                                            <c:if test="${workPlan.month == 1}">
                                                ${workPlan.monthScore}
                                            </c:if>
                                            </td>
                                            <td>
                                                <c:if test="${workPlan.month == 2}">
                                                    ${workPlan.monthScore}
                                                </c:if>
                                            </td>
                                            <td>
                                                <c:if test="${workPlan.month == 3}">
                                                    ${workPlan.monthScore}
                                                </c:if>
                                            </td>
                                            <td>
                                                <c:if test="${workPlan.month == 4}">
                                                    ${workPlan.monthScore}
                                                </c:if>
                                            </td>
                                            <td>
                                                <c:if test="${workPlan.month == 5}">
                                                    ${workPlan.monthScore}
                                                </c:if>
                                            </td>
                                            <td>
                                                <c:if test="${workPlan.month == 6}">
                                                    ${workPlan.monthScore}
                                                </c:if>
                                            </td>
                                            <td>
                                                <c:if test="${workPlan.month == 7}">
                                                    ${workPlan.monthScore}
                                                </c:if>
                                            </td>
                                            <td>
                                                <c:if test="${workPlan.month == 8}">
                                                    ${workPlan.monthScore}
                                                </c:if>
                                            </td>
                                            <td>
                                                <c:if test="${workPlan.month == 9}">
                                                    ${workPlan.monthScore}
                                                </c:if>
                                            </td>
                                            <td>
                                                <c:if test="${workPlan.month == 10}">
                                                    ${workPlan.monthScore}
                                                </c:if>
                                            </td>
                                            <td>
                                                <c:if test="${workPlan.month == 11}">
                                                    ${workPlan.monthScore}
                                                </c:if>
                                            </td>
                                            <td>
                                                <c:if test="${workPlan.month == 12}">
                                                    ${workPlan.monthScore}
                                                </c:if>
                                            </td>
                                        </c:forEach>
                                        <td class="suggestScore">${score}</td>
                                        <td>${performance2.summaryScore}</td>
                                        <td class="score-text">${performance2.yearScore}</td>
                                        <td>
                                            <button type="button" class="btn bg-green mark" data-toggle="modal" data-target="#modal-default">打分</button>
                                        </td>
                                    </tr>
                                    </tbody>
                                </c:if>
                                <c:if test="${tesPlan.testTypeId==1}">
                                    <thead>
                                    <tr>
                                        <th>序号</th>
                                        <th>一季度</th>
                                        <th>二季度</th>
                                        <th>三季度</th>
                                        <th>四季度</th>
                                        <th>平均得分</th>
                                        <th>年度总结得分</th>
                                        <th>最终得分</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <c:forEach items="${workPlanList}" var="workPlan" varStatus="status">
                                            <td>${status.index+1}</td>
                                            <td>
                                            <c:if test="${workPlan.queater == 1}">
                                                ${workPlan.queaterScore}
                                            </c:if>
                                            </td>
                                            <td>
                                                <c:if test="${workPlan.queater == 2}">
                                                    ${workPlan.queaterScore}
                                                </c:if>
                                            </td>
                                            <td>
                                                <c:if test="${workPlan.queater == 3}">
                                                    ${workPlan.queaterScore}
                                                </c:if>
                                            </td>
                                            <td>
                                                <c:if test="${workPlan.queater == 4}">
                                                    ${workPlan.queaterScore}
                                                </c:if>
                                            </td>
                                            <td class="suggestScore">${score}</td>
                                            <td>${performance2.summaryScore}</td>
                                            <td class="score-text">${performance2.yearScore}</td>
                                            <td>
                                                <button type="button" class="btn bg-green mark" data-toggle="modal" data-target="#modal-default">打分</button>
                                            </td>
                                        </c:forEach>
                                    </tr>
                                    </tbody>
                                </c:if>
                            </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
                <!-- /.col -->
            </div>
            <!-- /.row -->
            <a href="${website}/check/year/user/${id}" class="btn bg-blue">返回列表</a>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <jsp:include page="../../common/footer.jsp"/>

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
                    <input type="hidden" id="dataId" value="${performance2.beCheckId}">
                    <input type="hidden" class="year" value="${performance2.year}">
                    <div class="form-group">
                        <label>您的分数</label>
                        <input type="text" class="form-control score a-require-text" placeholder="请输入0-100内数字..." name="role">
                    </div>
                    <p class="text-red tip"></p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default pull-left" data-dismiss="modal">关闭</button>
                    <button type="submit" class="btn btn-primary J-ajax-submit">打分</button>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>
</div>
<!-- ./wrapper -->
<jsp:include page="../../common/script.jsp"/>
<script src="../../../../resources/js/pages/common/verify.js"></script>
<script src="../../../../resources/js/pages/exam/year/evaluation-detail.js"></script>
<!-- page script -->
<script>
    $(function () {
        $('#example1').DataTable();
    })
</script>
</body>
</html>
