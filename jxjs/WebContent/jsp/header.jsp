<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fun"%>

<div id="header">
	<div class="banner">
		<div class="logo">
			<img src="${pageContext.request.contextPath}/images/logo.jpg"/>
		</div>
		<div class="title">
			<img src="${pageContext.request.contextPath}/images/title.jpg"/>
		</div>
		<div class="menu-right">
        		<ul>
                <li><a href="javascript:void(0);"  onclick=""><img src="${pageContext.request.contextPath}/images/User-Lock-256.png"/></a></li>
                <li><a href="javascript:void(0);"><img src="${pageContext.request.contextPath}/images/Login-Door-256.png"/></a></li>
                </ul>
        </div>
        
        <div class="menu-main">
        	<ul>
        		<li>首页</li>
        		<li class="bgblue">案件处理</li>
        		<li>统计分析</li>
        		<li>系统对接</li>
        		<li>系统管理</li>
        	</ul>
        </div>
	</div>
	<div class="welcome-bar">
		<div class="welcome-words">
			欢迎 【天尊】 使用本系统，北京时间2015-09-22 星期二 20:15
		</div>
	</div>
</div>