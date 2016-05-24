<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-datetimepicker.css"/><jsp:text/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/views/tjfx-jccx/custom.css"/><jsp:text/>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker.js"><jsp:text/></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/locales/bootstrap-datetimepicker.zh-CN.js"><jsp:text/></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/views/tjfx-jccx/custom.js"><jsp:text/></script>
</head>
<body>
	<div class="search-area">

		<div class="float-left float-gap">
			<div class="float-left time-text">
				<label class="label-control">开始时间</label>
			</div>
			<div class="float-left time-input">
				<div class="input-group date form_date">
					<input type="text" class="form-control" name="startDate" id="startDate" readonly />
					<span class="input-group-addon" id="addSpan">
						<span class="glyphicon glyphicon-calendar"></span>
					</span>
				</div>
			</div>
		</div>

		<div class="float-left float-gap">
			<div class="float-left time-text">
				<label class="label-control">结束时间</label>
			</div>
			<div class="float-left time-input">
				<div class="input-group date form_date">
					<input type="text" class="form-control" name="endDate" id="endDate" readonly />
					<span class="input-group-addon" id="addSpan">
						<span class="glyphicon glyphicon-calendar"></span>
					</span>
				</div>
			</div>
		</div>
			
		<div class="float-left float-gap">
			<label class="label-control">条件</label>
			<select class="select-control select-condition" name="condition" id="condition">
				<c:forEach items="${conditionList }" var="condition">
					<option>${condition }</option>
				</c:forEach>
			</select>
		</div>
			
		<div class="float-left float-gap">
			<button class="btn btn-success" onclick="tongji();">统计</button>
		</div>

	</div>
	
	<div class="table-wrapper">
		<img id="loading" src="${pageContext.request.contextPath}/images/loading.gif"/>
		<div class="table-main">
			<table id="dataTable"
				class="dataTable table table-hover table-striped">
				<thead>
					<tr id="table-main-thead-tr">
						<th><input type="checkbox" id="checkAll" onclick="checkAll();"/></th>
						<th>序号</th>
						<th>原审案号</th>
						<th>当事人</th>
						<th>生效法院</th>
						<th>申请类型</th>
						<th>申请时间</th>
						<th>申请次数</th>
						<th>处理状态</th>
						<th>已服刑期</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>