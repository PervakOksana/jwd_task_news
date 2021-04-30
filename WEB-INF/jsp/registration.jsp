<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.ArrayList,java.util.List,by.htp.les.bean.News"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<fmt:setLocale value="${sessionScope.local }" />
<fmt:setBundle basename="localization.local" var="loc" />
<fmt:message bundle="${loc}" key="local.title" var="title" />
<fmt:message bundle="${loc}" key="local.welcome" var="welcome" />
<fmt:message bundle="${loc}" key="local.admin" var="admin" />
<fmt:message bundle="${loc}" key="local.registration" var="registration" />
<fmt:message bundle="${loc}" key="local.registration.login" var="registration_login" />
<fmt:message bundle="${loc}" key="local.registration.password" var="registration_password" />
<fmt:message bundle="${loc}" key="local.registration.name" var="registration_name" />
<fmt:message bundle="${loc}" key="local.registration.surname" var="registration_surname" />
<fmt:message bundle="${loc}" key="local.send"	var="send" />

<title>Insert title here</title>
<style>
body {
	background: #1abc9c;
}

* {
	box-sizing: border-box;
}

.header {
	font-family: Segoe Script, sans-serif;
	text-align: center;
	color: white;
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
	    <a href='<c:url  value="/Controller?command=gotoindexpage" />' style="  margin-left:20px;"><img src="img/back.png"/></a>
	    <a href="Controller?command=Localization&lang=en&page=registration" style=" float: right; margin-right:40px; "><img src="img/eng.png"/></a> 
		<a href="Controller?command=Localization&lang=ru&page=registration" style="float: right; margin-right:20px;"><img src="img/ru.png"/></a>
	</div>	
	<br />
	<div class="row">
		<div class="column left"
			style="background-color: rgba(240, 240, 240, 1)">
			<table>
				<c:forEach var="n" items="${requestScope.news}">

					<h2>
						<c:out value="${n.title}" />
						<br />
					</h2>
					<font size="4"><p align="justify">
							<c:out value="${n.brief}" />
							<br />
						</p></font>


				</c:forEach>
			</table>
		</div>
		<div class="column right"
			style="background-color: rgb(220, 220, 220);">
			<div class="container">
				<h3>${registration}</h3>
				<form action="Controller" method="post">
					<input type="hidden" name="command" value="savenewuser" /> 
					${registration_login}<br /> <input type="text" name="login" value="" /> <br />
					${registration_password}<br /> <input type="password" name="password"value="" /> <br />
					${registration_name}<br /> <input type="text" name="name"value="" /> <br />
					${registration_surname}<br /> <input type="text" name="surname"value="" /> <br />
					<input type="submit" value="${send}" /> <br />
				</form>
				
				
			</div>
			<br />
</body>
</html>






