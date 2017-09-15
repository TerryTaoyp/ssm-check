<%--
  Created by IntelliJ IDEA.
  User: Taoyongpan
  Date: 2017/9/11
  Time: 8:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
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
                                <c:forEach items="${testPositionList}" var="testPosition" varStatus="status">
                                    <li>
                                        <i class="fa bg-blue">${status.index+1}</i>
                                        <div class="timeline-item">
                                            <h3 class="timeline-header">
                                                <a href="#">【${testPosition
                                                .targetType}${testPosition.weight}】</a>
                                                ${testPosition.target}
                                            </h3>
                                            <div class="timeline-body box-body">
                                                <c:forEach items="${abilityOptionList}" var="option">
                                                    <c:if test="${testPosition.id == option.positionId}">
                                                        <div class="form-group">
                                                            <label>
                                                                <c:if test="${option.optionName == 1}">
                                                                    A.${option.content}
                                                                </c:if>
                                                            </label>
                                                            <a class="btn bg-olive btn-xs">优(${option.minScore}分~${option.maxScore}分)</a>
                                                        </div>
                                                        <div class="form-group">
                                                            <label>
                                                                <c:if test="${option.optionName == 2}">
                                                                    A.${option.content}
                                                                </c:if>
                                                            </label>
                                                            <a class="btn bg-olive btn-xs">良(${option.minScore}分~${option.maxScore}分)</a>
                                                        </div>
                                                        <div class="form-group">
                                                            <label>
                                                                <c:if test="${option.optionName == 3}">
                                                                    A.${option.content}
                                                                </c:if>
                                                            </label>
                                                            <a class="btn bg-olive btn-xs">中(${option.minScore}分~${option.maxScore}分)</a>
                                                        </div>
                                                        <div class="form-group">
                                                            <label>
                                                                <c:if test="${option.optionName == 4}">
                                                                    A.${option.content}
                                                                </c:if>
                                                            </label>
                                                            <a class="btn bg-olive btn-xs">差(${option.minScore}分~${option.maxScore}分)</a>
                                                        </div>
                                                    </c:if>
                                                </c:forEach>
                                            </div>
                                        </div>
                                    </li>
                                </c:forEach>

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
                            <a href="${website}/ability/list" class="btn btn-primary">返回列表</a>
                            <a href="${website}/test/position/add/${id}" class="btn bg-olive">修改题目</a>
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
