<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fun"%>
<%@include file="base.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>案件处理-待审批列表</title>
</head>
<body>
<jsp:include page="header.jsp" />
<div class="content-wrapper">
	<div class="content-left">
		<ul>
			<li class="main-cat">案件处理</li>
			<li class="sub-cat">待审批列表</li>
			<li class="sub-cat">已审批列表</li>
			<li class="sub-cat">已立案列表</li>
			
		</ul>
	</div>
	<div class="content-right">
		<div class="searching">
		</div>
		<div class="table-main">
		</div>
	</div>
</div>

<jsp:include page="footer.jsp" />
</body>
</html>