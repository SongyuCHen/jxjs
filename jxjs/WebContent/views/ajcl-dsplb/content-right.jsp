<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath}/views/ajcl-dsplb/custom.js"><jsp:text/></script>
</head>
<body>
	<div class="searching">
		<img
			src="${pageContext.request.contextPath}/images/searching-logo.png" />
		<input id="dataTable-search-input" type="text" class="form-control" />
		<button class="btn btn-info" onclick="dataTable_search();">检索</button>
	</div>
	<div class="table-wrapper">
		<div class="table-main">
			<table id="dataTable"
				class="dataTable table table-hover table-striped" width="100%">
				<thead>
					<tr id="table-main-thead-tr">
						<th><input type="checkbox" /></th>
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
						<td><input type="checkbox" /></td>
						<td>1</td>
						<td>(2014)临刑初字第146号</td>
						<td>麻花藤</td>
						<td>定西中级人民法院</td>
						<td>减刑</td>
						<td>2015-09-23</td>
						<td>1</td>
					</tr>
					<tr>
						<td><input type="checkbox" /></td>
						<td>2</td>
						<td>(2014)临刑初字第146号</td>
						<td>麻花藤</td>
						<td>定西中级人民法院</td>
						<td>减刑</td>
						<td>2015-09-23</td>
						<td>1</td>
					</tr>
					<tr>
						<td><input type="checkbox" /></td>
						<td>3</td>
						<td>(2014)临刑初字第146号</td>
						<td>麻花藤</td>
						<td>定西中级人民法院</td>
						<td>减刑</td>
						<td>2015-09-23</td>
						<td>1</td>
					</tr>
					<tr>
						<td><input type="checkbox" /></td>
						<td>4</td>
						<td>(2014)临刑初字第146号</td>
						<td>麻花藤</td>
						<td>定西中级人民法院</td>
						<td>减刑</td>
						<td>2015-09-23</td>
						<td>1</td>
					</tr>
					<tr>
						<td><input type="checkbox" /></td>
						<td>5</td>
						<td>(2014)临刑初字第146号</td>
						<td>麻花藤</td>
						<td>定西中级人民法院</td>
						<td>减刑</td>
						<td>2015-09-23</td>
						<td>1</td>
					</tr>
					<tr>
						<td><input type="checkbox" /></td>
						<td>6</td>
						<td>(2014)临刑初字第146号</td>
						<td>麻花藤</td>
						<td>定西中级人民法院</td>
						<td>减刑</td>
						<td>2015-09-23</td>
						<td>1</td>
					</tr>
					<tr>
						<td><input type="checkbox" /></td>
						<td>7</td>
						<td>(2014)临刑初字第146号</td>
						<td>麻花藤</td>
						<td>定西中级人民法院</td>
						<td>减刑</td>
						<td>2015-09-23</td>
						<td>1</td>
					</tr>
					<tr>
						<td><input type="checkbox" /></td>
						<td>8</td>
						<td>(2014)临刑初字第146号</td>
						<td>麻花藤</td>
						<td>定西中级人民法院</td>
						<td>减刑</td>
						<td>2015-09-23</td>
						<td>1</td>
					</tr>
					<tr>
						<td><input type="checkbox" /></td>
						<td>9</td>
						<td>(2014)临刑初字第146号</td>
						<td>麻花藤</td>
						<td>定西中级人民法院</td>
						<td>减刑</td>
						<td>2015-09-23</td>
						<td>1</td>
					</tr>
					<tr>
						<td><input type="checkbox" /></td>
						<td>10</td>
						<td>(2014)临刑初字第146号</td>
						<td>麻花藤</td>
						<td>定西中级人民法院</td>
						<td>减刑</td>
						<td>2015-09-23</td>
						<td>1</td>
					</tr>
					<tr>
						<td><input type="checkbox" /></td>
						<td>11</td>
						<td>(2014)临刑初字第146号</td>
						<td>麻花藤</td>
						<td>定西中级人民法院</td>
						<td>减刑</td>
						<td>2015-09-23</td>
						<td>1</td>
					</tr>
					<tr>
						<td><input type="checkbox" /></td>
						<td>12</td>
						<td>(2014)临刑初字第146号</td>
						<td>麻花藤</td>
						<td>定西中级人民法院</td>
						<td>减刑</td>
						<td>2015-09-23</td>
						<td>1</td>
					</tr>
					<tr>
						<td><input type="checkbox" /></td>
						<td>13</td>
						<td>(2014)临刑初字第146号</td>
						<td>麻花藤</td>
						<td>定西中级人民法院</td>
						<td>减刑</td>
						<td>2015-09-23</td>
						<td>1</td>
					</tr>
					<tr>
						<td><input type="checkbox" /></td>
						<td>14</td>
						<td>(2014)临刑初字第146号</td>
						<td>麻花藤</td>
						<td>定西中级人民法院</td>
						<td>减刑</td>
						<td>2015-09-23</td>
						<td>1</td>
					</tr>
				</tbody>
			</table>
			<div class="operating">
				<button class="btn btn-primary">审批</button>
				<button class="btn btn-primary">退回</button>
				<button class="btn loc-right" onclick="print()">打印</button>
				<button class="btn loc-right" onclick="exports()">导出</button>
				<div class="loc-right">列表：</div>			
			</div>
		</div>
	</div>
</body>
</html>

