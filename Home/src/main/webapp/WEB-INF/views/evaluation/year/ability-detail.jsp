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
    <jsp:include page="../../common/sidebar.jsp"/>

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
                                            <span class="time">
                                                <button type="button" class="btn bg-olive change" style="margin-left: 10px;" data-toggle="modal" data-target="#update-list"> 修改 </button>
                                                <button type="button" class="btn bg-red delete"> 删除 </button>
                                            </span>
                                            <h3 class="timeline-header">
                                                <a href="#">
                                                    【
                                                    <span class="type">
                                                    ${testPosition.targetType}
                                                    </span>
                                                    <span class="weight">${testPosition.weight}
                                                    </span>
                                                    】
                                                </a>
                                                <span class="title">${testPosition.target}</span>
                                            </h3>
                                            <div class="timeline-body box-body">
                                                <c:forEach items="${abilityOptionList}" var="option">
                                                    <c:if test="${testPosition.id == option.positionId}">
                                                        <div class="form-group">
                                                            <label>
                                                                <c:if test="${option.optionName == 1}">
                                                                    A.<span class="option1">${option.content}</span>
                                                                </c:if>
                                                            </label>
                                                            <a class="btn bg-olive btn-xs">优(${option.minScore}分~${option.maxScore}分)</a>
                                                        </div>
                                                        <div class="form-group">
                                                            <label>
                                                                <c:if test="${option.optionName == 2}">
                                                                    A.<span class="option2">${option.content}</span>
                                                                </c:if>
                                                            </label>
                                                            <a class="btn bg-olive btn-xs">良(${option.minScore}分~${option.maxScore}分)</a>
                                                        </div>
                                                        <div class="form-group">
                                                            <label>
                                                                <c:if test="${option.optionName == 3}">
                                                                    A.<span class="option3">${option.content}</span>
                                                                </c:if>
                                                            </label>
                                                            <a class="btn bg-olive btn-xs">中(${option.minScore}分~${option.maxScore}分)</a>
                                                        </div>
                                                        <div class="form-group">
                                                            <label class="4">
                                                                <c:if test="${option.optionName == 4}">
                                                                    A.<span class="option4">${option.content}</span>
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
                            <button type="button" class="btn bg-olive add" data-toggle="modal" data-target="#add-list">增添题目</button>
                            <!-- href="${website}/test/position/add/${id}" -->
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- /.content -->
    </div>
    <!-- 新增 -->
    <div class="modal fade" id="add-list">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">增添题目</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                      <label>计划名称：</label>
                        <input type="text" class="form-control" value="计划1" disabled="disabled">
                    </div>
                    
                    <div class="form-group">
                      <label>所属部门：</label>
                        <input type="text" class="form-control" value="产品部" disabled="disabled">
                    </div>

                    <div class="form-group">
                          <div class="form-group">
                              <div class="col-xs-6">
                                  <label>问题类型：</label>
                                    <select class="add-type form-control">
                                        <option>创新形</option>
                                        <option>创新形</option>
                                        <option>创新形</option>
                                    </select>
                              </div>
                              <div class="col-xs-6">
                                  <label>权重：</label>
                                    <input type="text" placeholder="请输入1-100之内的数字..." class="add-weight form-control">
                              </div>
                          </div>

                          <label>
                              问题题目：
                          </label>
                          <input type="text" class="form-control a-require-text add-title" placeholder="请输入...">

                          <label>
                           答案1：<a class="btn bg-olive btn-xs">优秀(10.0~10.0分)</a>
                           </label>
                          <input type="text" class="form-control add-option1" placeholder="请输入...">

                          <label>
                           答案2：<a class="btn btn-primary btn-xs">良好(8.0~9.0分)</a>
                           </label>
                          <input type="text" class="form-control add-option2" placeholder="请输入...">

                          <label>
                           答案3：<a class="btn bg-orange btn-xs">一般(6.0~7.0分)</a>
                           </label>
                          <input type="text" class="form-control add-option3" placeholder="请输入...">

                          <label>
                           答案4：<a class="btn bg-red btn-xs">不及格(0.0~5.0分)</a>
                           </label>
                          <input type="text" class="form-control add-option4" placeholder="请输入...">
                    </div>
                    <p class="text-red tip"></p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default pull-left" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary J-ajax-submit1 J-ajax-submit">修改</button>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>
    <!-- 更改 -->
    <div class="modal fade" id="update-list">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">修改题目</h4>
                </div>
                <div class="modal-body">
                    <input type="hidden" id="dataId">
                    <div class="form-group">
                      <label>计划名称：</label>
                        <input type="text" class="form-control" value="计划1" disabled="disabled">
                    </div>
                    
                    <div class="form-group">
                      <label>所属部门：</label>
                        <input type="text" class="form-control" value="产品部" disabled="disabled">
                    </div>

                    <div class="form-group">
                          <div class="form-group">
                              <div class="col-xs-6">
                                  <label>问题类型：</label>
                                    <select class="update-type form-control">
                                        <option selected="">创新形</option>
                                        <option selected="">创新形</option>
                                        <option selected="">创新形</option>
                                    </select>
                              </div>
                              <div class="col-xs-6">
                                  <label>权重：</label>
                                    <input type="text" placeholder="请输入1-100之内的数字..." class="update-weight form-control">
                              </div>
                          </div>

                          <label>
                              问题题目：
                          </label>
                          <input type="text" class="form-control a-require-text" placeholder="请输入...">

                          <label>
                           答案1：<a class="btn bg-olive btn-xs">优秀(10.0~10.0分)</a>
                           </label>
                          <input type="text" class="form-control update-option1" placeholder="请输入...">

                          <label>
                           答案2：<a class="btn btn-primary btn-xs">良好(8.0~9.0分)</a>
                           </label>
                          <input type="text" class="form-control update-option2" placeholder="请输入...">

                          <label>
                           答案3：<a class="btn bg-orange btn-xs">一般(6.0~7.0分)</a>
                           </label>
                          <input type="text" class="form-control update-option3" placeholder="请输入...">

                          <label>
                           答案4：<a class="btn bg-red btn-xs">不及格(0.0~5.0分)</a>
                           </label>
                          <input type="text" class="form-control update-option4" placeholder="请输入...">
                    </div>
                    <p class="text-red tip"></p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default pull-left" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary J-ajax-submit2 J-ajax-submit">修改</button>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>
    <jsp:include page="../../common/footer.jsp"/>

</div>
<!-- ./wrapper -->
<jsp:include page="../../common/script.jsp"/>
<script src="../../../../resources/js/pages/common/verify.js"></script>
<script src="../../../../resources/js/pages/evaluation/year/ability-detail.js"></script>
<!-- page script -->
</body>
</html>
