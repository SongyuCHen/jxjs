<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/views/ajcl-ysplb/custom.css"/><jsp:text/>
<script type="text/javascript" src="${pageContext.request.contextPath}/views/ajcl-ysplb/custom.js"><jsp:text/></script>
</head>
<body>
	<div class="searching">
		<img
			src="${pageContext.request.contextPath}/images/searching-logo.png" />
		<input id="dataTable-search-input" type="text" class="form-control" />
	</div>
	<div class="table-wrapper">
		<img id="loading" src="${pageContext.request.contextPath}/images/loading.gif"/>
		<div class="table-main">
			<table id="dataTable"
				class="dataTable table table-hover table-striped">
				<thead>
					<tr id="table-main-thead-tr">
						<th width="5%"><input type="checkbox" id="checkAll" onclick="checkAll();"/></th>
						<th width="10%">序号</th>
						<th width="20%">原审案号</th>
						<th width="10%">当事人</th>
						<th width="15%">生效法院</th>
						<th width="10%">申请类型</th>
						<th width="15%">申请时间</th>
						<th width="15%">审批时间</th>
					</tr>
				</thead>
				<tbody>					
				</tbody>
			</table>
			<div class="operating">
				<button class="btn btn-primary" onclick="lian()">立案</button>
				<button class="btn loc-right" onclick="print()">打印</button>
				<button class="btn loc-right" onclick="exports()">导出</button>
				<div class="loc-right">列表：</div>			
			</div>
		</div>
	</div>
</body>
</html>