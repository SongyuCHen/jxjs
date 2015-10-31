<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-datetimepicker.css"/><jsp:text/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/views/xtdj-xsajcs/custom.css"/><jsp:text/>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker.js"><jsp:text/></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/locales/bootstrap-datetimepicker.zh-CN.js"><jsp:text/></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/views/xtdj-xsajcs/custom.js"><jsp:text/></script>


</head>
<body>
	<div class="search-area">
		
			<div class="float-left float-gap">
				<div class="float-left time-text">
					<label class="control-label">案号</label>
				</div>
				<div class="float-left time-input">
					<input type="text" class="form-control" name="caseNumber" id="caseNumber"/>
				</div>				
			</div>
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
				<button class="btn btn-success" onclick="search();">查询</button>
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
						<th>案号</th>
						<th>案件名称</th>
						<th>立案日期</th>
						<th>结案日期</th>
						<th>办案法院</th>
						<th>案由</th>
					</tr>
				</thead>
				<tbody>
				<!-- 
					<tr>
						<td class="checkTD"><input type="checkbox" /></td>
						<td>1</td>
						<td>(2013)临刑初字第146号</td>
						<td>麻花藤</td>
						<td>定西中级人民法院</td>
						<td>抄袭</td>
						<td>2015-09-23</td>
						<td>二年</td>
					</tr>
				 -->
					</tbody>
			</table>
			<div class="operating">
				<button class="btn btn-primary" onclick="chuanshu()">传输</button>
				<button class="btn loc-right" onclick="print()">打印</button>
				<button class="btn loc-right" onclick="exports()">导出</button>
				<div class="loc-right">列表：</div>			
			</div>
		</div>
	</div>

</body>
</html>