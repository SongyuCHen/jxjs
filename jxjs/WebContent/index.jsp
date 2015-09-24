<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/login.css" />
<title>登录</title>
</head>
<body>
	<div class="page">

		<div class="login-title"></div>

		<div class="login-panel">
			<div class="form-wrapper">
				<form class="form-horizontal" action="login" method="post">
					<div class="form-group">
						<label for="inputDW" class="col-sm-4 control-label">单位：</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="inputDW"/>
						</div>
					</div>
					<div class="form-group">
						<label for="inputID" class="col-sm-4 control-label">用户名：</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="inputID"/>
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword" class="col-sm-4 control-label">密码：</label>
						<div class="col-sm-8">
							<input type="password" class="form-control" id="inputPassword"/>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-8">
							<div class="checkbox">
								<label> <input type="checkbox"> 记住密码
								</label>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-2">
							<button type="submit" class="btn btn-primary">登录</button>
						</div>
						<div class="col-sm-offset-2 col-sm-2">
							<button class="btn btn-primary">重置</button>
						</div>
					</div>
				</form>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/uiadjuster.js">
		<jsp:text/>
	</script>
</body>
</html>