<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/views/xtdj-jxjssq/custom.css"/><jsp:text/>
<script type="text/javascript" src="${pageContext.request.contextPath}/views/xtdj-jxjssq/custom.js"><jsp:text/></script>
</head>
<body>
<div class="search-area">
		<form id="searchForm" method="post" class="form-horizontal" action="${pageContext.request.contextPath}/xtdj/jxjssq/search">
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
					<label class="control-label">当事人</label>
				</div>
				<div class="float-left time-input">
					<input type="text" class="form-control" name="dsr" id="dsr"/>
				</div>				
			</div>
			<div class="float-left float-gap">
				<button type="submit" class="btn btn-success">查询</button>
			</div>
		</form>
	</div>
	
	<div class="table-wrapper">
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
					</tr>
				</thead>
				<tbody>
					<tr>
						<td class="checkTD"><input type="checkbox" /></td>
						<td>1</td>
						<td>(2013)临刑初字第146号</td>
						<td>麻花藤</td>
						<td>定西中级人民法院</td>
						<td>减刑</td>
						<td>2015-09-23</td>
						<td>1</td>
					</tr>
					</tbody>
			</table>
			<div class="operating">
				<button class="btn btn-primary">申请</button>
				<button class="btn loc-right" onclick="print()">打印</button>
				<button class="btn loc-right" onclick="exports()">导出</button>
				<div class="loc-right">列表：</div>			
			</div>
		</div>
	</div>

</body>
</html>