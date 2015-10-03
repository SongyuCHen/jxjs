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
		<form id="searchForm" method="post" class="form-horizontal" action="${pageContext.request.contextPath}/tjfx/cx">
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
				<select class="select-control select-condition" name="condition">
					<c:forEach items="${conditionList }" var="condition">
						<option>${condition }</option>
					</c:forEach>
				</select>
			</div>
			
			<div class="float-left float-gap">
				<button type="submit" class="btn btn-success">统计</button>
			</div>
		</form>
	</div>
	
	<div class="table-wrapper">
		
	</div>
</body>
</html>