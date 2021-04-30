<%@ page language="java" contentType="text/html; charset=utf-8"
	import="by.htp.les.bean.UserLoginationInfo, java.util.ArrayList,java.util.List,by.htp.les.bean.News"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<fmt:setLocale value="${sessionScope.local }" />
<fmt:setBundle basename="localization.local" var="loc" />
<fmt:message bundle="${loc}" key="local.title" var="title" />
<fmt:message bundle="${loc}" key="local.read" var="read" />
<fmt:message bundle="${loc}" key="local.add" var="add" />
<fmt:message bundle="${loc}" key="local.welcome" var="welcome" />
<fmt:message bundle="${loc}" key="local.admin" var="admin" />
<fmt:message bundle="${loc}" key="local.logout" var="logout" />
<fmt:message bundle="${loc}" key="local.add.news.title" var="news_title" />
<fmt:message bundle="${loc}" key="local.brief" var="brief" />
<fmt:message bundle="${loc}" key="local.content" var="content" />
<fmt:message bundle="${loc}" key="local.update.news" var="update_news" />
<fmt:message bundle="${loc}" key="local.update.id" var="update_id" />
<fmt:message bundle="${loc}" key="local.save" var="save" />
<fmt:message bundle="${loc}" key="local.cancel" var="cancel" />

<title>Insert title here</title>
<style>
body {
	background: #1abc9c;
}

* {
	box-sizing: border-box;
}

.column {
	float: left;
	padding: 10px;
	height: 600px;
}

.left {
	width: 75%;
}

.right {
	width: 25%;
}

.row:after {
	content: "";
	display: table;
	clear: both;
}

input {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=submit] {
	width: 100%;
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #45a049;
}

div.container {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 40px;
}
</style>
</head>
<body>
	 <div style="font-family: Segoe Script, sans-serif; text-align: center; color: white;">

		<h1>
			<big><big><strong><c:out value="${title}" /> </strong></big></big>
		</h1>
	
	</div>
	<div>
	    <a href='<c:url  value="/Controller?command=gotomainpage" />' style="  margin-left:20px;"><img src="img/back.png"/></a>
	    <a href="Controller?command=Localization&lang=en&page=updatenews&link_id=${requestScope.news.id}" style=" float: right; margin-right:40px; "><img src="img/eng.png"/></a> 
		<a href="Controller?command=Localization&lang=ru&page=updatenews&link_id=${requestScope.news.id}" style="float: right; margin-right:20px;"><img src="img/ru.png"/></a>
	</div>	
	<br />
	<div class="column left"
		style="background-color: rgba(240, 240, 240, 1)">


		<div class="container">
			<h3>${update_news}</h3>
			<form action="Controller" method="post">
				<font size="4"><p align="justify">
						<input type="hidden" name="command" value="savenews" /> 
						${update_id}<br />
						<input type="text" name="id" value="${requestScope.news.id}"
							readonly />
							 ${news_title}<br /> <input type="text"
							name="title" value="${requestScope.news.title}" /> 
						${brief}<br /> <input type="text" name="brief"
							value="${requestScope.news.brief}" /> 
							${content}<br /> <input
							maxlength="1000" type="text" name="content"
							value="${requestScope.news.content}" />  <input
							type="submit" value="${save}" /> 
					<form>
						<input type="hidden" name="command" value="gotomainpage" /> 
						<input type="submit" value="${cancel}" /> 
					</form>
					</p></font>
			</form>
		</div>
	</div>
	<div class="column right" style="background-color: rgb(220, 220, 220);">
		<div class="container">
			<c:if test="${(sessionScope.role eq \"admin\")}">
				<c:if test="${message != null}">
					<h1 align="center">${welcome}</h1>
					<h1 align="center">
						${admin}
						<c:out value="${message}" />
					</h1>
				</c:if>
			</c:if>
			<c:if test="${(sessionScope.role eq \"user\")}">
				<c:if test="${message != null}">
					<h1 align="center">${welcome}</h1>
					<h1 align="center">
						<c:out value="${message}" />
					</h1>
				</c:if>
			</c:if>
			<br /> <a href="Controller?command=Logout">${logout}</a>
		</div>
	</div>
</body>
</html>
