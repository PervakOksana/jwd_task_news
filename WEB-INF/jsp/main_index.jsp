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
<fmt:message bundle="${loc}" key="local.locbutton.name.ru"
	var="ru_button" />
<fmt:message bundle="${loc}" key="local.locbutton.name.en"
	var="en_button" />
<fmt:message bundle="${loc}" key="local.logination" var="logination" />
<fmt:message bundle="${loc}" key="local.enter.name" var="enter_name" />
<fmt:message bundle="${loc}" key="local.enter.password"
	var="enter_password" />
<fmt:message bundle="${loc}" key="local.send" var="send" />
<fmt:message bundle="${loc}" key="local.registration" var="registration" />
<fmt:message bundle="${loc}" key="local.rules" var="rules" />
<fmt:message bundle="${loc}" key="local.rules.one" var="rules_one" />
<fmt:message bundle="${loc}" key="local.rules.two" var="rules_two" />
<fmt:message bundle="${loc}" key="local.rules.three" var="rules_three" />
<fmt:message bundle="${loc}" key="local.rules.four" var="rules_four" />
<fmt:message bundle="${loc}" key="local.rules.five" var="rules_five" />
<fmt:message bundle="${loc}" key="local.registration.successful"
	var="reg_suc" />
<fmt:message bundle="${loc}" key="local.user.noexist" var="no_exist" />


<title>Main_page</title>



<style>
body {
	background: #1abc9c;
}

* {
	box-sizing: border-box;
}

.header {
	font-family: Segoe Script, sans-serif;
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
	<div
		style="font-family: Segoe Script, sans-serif; text-align: center; color: white;">

		<h1>
			<big><big><strong><c:out value="${title}" /> </strong></big></big>
		</h1>


	</div>
	<div>
		<a href='<c:url  value="/Controller?command=GoToIndexPage" />'
			style="margin-left: 20px;"></a> <a
			href="Controller?command=Localization&lang=en&page=gotoindexpage"
			style="float: right; margin-right: 40px;"><img src="img/eng.png" /></a>
		<a href="Controller?command=Localization&lang=ru&page=gotoindexpage"
			style="float: right; margin-right: 20px;"><img src="img/ru.png" /></a>
	</div>
	<br />

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
	<div class="column right" style="background-color: rgb(220, 220, 220);">
		<div class="container">
			<c:if test="${sessionScope.message eq \"registration\" }">
				<h1 align="center">
					<c:out value="${reg_suc}" />
				</h1>

			</c:if>
			<h3>
				<c:out value="${logination}" />
			</h3>
			<c:if test="${sessionScope.messageLog eq \"errorLog\" }">

				<p align="left">
					<c:out value="${no_exist}" />
				</p>

			</c:if>
			
			<form action="Controller" method="post">

				<input type="hidden" name="command" value="Logination" />
				<c:out value="${enter_name}" />
				<br /> <input type="text" name="login" value="" /> <br />
				<c:out value="${enter_password}" />
				<br /> <input type="password" name="password" value="" /> <br />
				<input type="submit" value="${send}" /> <br />
			</form>

			<c:if test="${sessionScope.message eq \"errorNew\" }">
				<p align="left">
					<c:out value="${rules}" />
				</p>
				<p align="left">
					<c:out value="${rules_one}" />
				</p>
				<p align="left">
					<c:out value="${rules_two}" />
				</p>
				<p align="left">
					<c:out value="${rules_three}" />
				</p>
				<p align="left">
					<c:out value="${rules_four}" />
				</p>
				<p align="left">
					<c:out value="${rules_five}" />
				</p>
			</c:if>
			<a href="Controller?command=registration">${registration}</a>
		</div>
		<br />


		<!--<form >
		<input type="hidden" name="command" value="Registration" /> <br /> <input
			type="submit" value="Регистрация" /> <br />
	</form>-->

	</div>




	<!-- List<News> news = (List<News>) request.getAttribute("news");
	for (News n : news) {
		out.println(n.getTitle());
	}}
	%>-->


</body>
</html>