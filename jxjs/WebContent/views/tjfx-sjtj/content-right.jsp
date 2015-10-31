<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/views/tjfx-sjtj/custom.css"/><jsp:text/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/echarts-all.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/views/tjfx-sjtj/custom.js"><jsp:text/></script>
</head>
<body>
	<div class="search-area">
		<div class="float-left float-gap">
			<div class="float-left time-text">
				<label class="label-control">开始时间</label>
			</div>
			<div class="float-left time-input">
				<div class="input-group date form_date">
					<input type="text" class="form-control" id="startDate1" readonly />
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
					<input type="text" class="form-control"  id="endDate1" readonly />
					<span class="input-group-addon" id="addSpan">
						<span class="glyphicon glyphicon-calendar"></span>
					</span>
				</div>
			</div>
		</div>
			
		<div class="float-left float-gap">
			<button class="btn btn-success" onclick="tongji1();">统计</button>
		</div>
		
	</div>
	<div id="statusStat" class="graph-container">
	</div>
	
	<div class="search-area">
		<div class="float-left float-gap">
			<div class="float-left time-text">
				<label class="label-control">开始时间</label>
			</div>
			<div class="float-left time-input">
				<div class="input-group date form_date">
					<input type="text" class="form-control" id="startDate2" readonly />
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
					<input type="text" class="form-control"  id="endDate2" readonly />
					<span class="input-group-addon" id="addSpan">
						<span class="glyphicon glyphicon-calendar"></span>
					</span>
				</div>
			</div>
		</div>
		<div class="float-left float-gap">
			<div class="float-left time-text">
				<label class="label-control">类型</label>
			</div>
			<div class="float-left time-input">
				<select class="form-control">
					<option>全部</option>
					<option>减刑</option>
					<option>假释</option>
				</select>	
			</div>
		</div>
			
		<div class="float-left float-gap">
			<button class="btn btn-success" onclick="tongji2();">统计</button>
		</div>
		
	</div>
	<div id="typeStat" class="graph-container">
	</div>
</body>
</html>