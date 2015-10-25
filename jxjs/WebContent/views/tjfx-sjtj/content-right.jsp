<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/views/tjfx-sjtj/custom.css"/><jsp:text/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/echarts-all.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/views/tjfx-sjtj/custom.js"><jsp:text/></script>
</head>
<body>
	<div id="statusStat" class="graph-container">
	</div>
	<div id="typeStat" class="graph-container">
	</div>
</body>
</html>