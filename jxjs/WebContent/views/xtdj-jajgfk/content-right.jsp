<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/views/xtdj-jajgfk/custom.css"/><jsp:text/>
<script type="text/javascript" src="${pageContext.request.contextPath}/views/xtdj-jajgfk/custom.js"><jsp:text/></script>
</head>
<body>
	<div class="table-wrapper">
		<img id="loading" src="${pageContext.request.contextPath}/images/loading.gif"/>
		<div class="table-main">
			<table id="dataTable"
				class="dataTable table table-hover table-striped">
				<thead>
					<tr id="table-main-thead-tr">
						<th>序号</th>
						<th>案号</th>
						<th>案件名称</th>
						<th>申请类型</th>
						<th>原审案号</th>
						<th>立案时间</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
			<div class="operating">
				<button class="btn loc-right" onclick="print()">打印</button>
				<button class="btn loc-right" onclick="exports()">导出</button>
				<div class="loc-right">列表：</div>			
			</div>
		</div>
	</div>

</body>
</html>