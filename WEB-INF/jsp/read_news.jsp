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
<fmt:message bundle="${loc}" key="local.welcome" var="welcome" />
<fmt:message bundle="${loc}" key="local.admin" var="admin" />
<fmt:message bundle="${loc}" key="local.logout" var="logout" />
<fmt:message bundle="${loc}" key="local.update" var="update" />
<fmt:message bundle="${loc}" key="local.delete" var="delete" />
<fmt:message bundle="${loc}" key="local.delete.message" var="delete_message" />

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
	padding: 20px;
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
	    <a href="Controller?command=Localization&lang=en&page=ReadNews&link_id=${requestScope.news.id}" style=" float: right; margin-right:40px; "><img src="img/eng.png"/></a> 
		<a href="Controller?command=Localization&lang=ru&page=ReadNews&link_id=${requestScope.news.id}" style="float: right; margin-right:20px;"><img src="img/ru.png"/></a>
	</div>	
	<br />
	<div class="column left"
		style="background-color: rgba(240, 240, 240, 1)">

		<h2>
			<c:out value="${requestScope.news.title}" />
			<br />
		</h2>
		<font size="4"><p align="justify">
				<c:out value="${requestScope.news.content}" />
			</p> </font> <font size="4"><p>
				<br />
				<c:out value="${requestScope.news.data}" />
			</p> <br />
			 <c:if test="${(sessionScope.role eq \"admin\")}">
				<c:if test="${message != null}">
					<a
						href='<c:url value="/Controller?command=UpdateNews&link_id=${requestScope.news.id}" />'>${update}</a>
					</br>
					<a href='<c:url value="/Controller?command=DeleteNews&link_id=${requestScope.news.id}"  />'
						onclick="return confirm('${delete_message}')">${delete}</a>
					</br>

				</c:if>
			</c:if> </font>
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
</body>
</html>