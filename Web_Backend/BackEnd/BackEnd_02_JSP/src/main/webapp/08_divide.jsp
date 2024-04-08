<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--  <%@ page errorPage="09_error.jsp" %>--%>
<%@ page errorPage="09_error.jsp" %><%--에러가 발생하면 해당 페이지로 넘기겠다. --%>
									<%--얘가 없으면 에러 페이지가 뜸 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러연습</title>
</head>
<body>
	<h2>정수를 0으로 나누어 보자</h2>
	<%= 2 / 0%>

	<a href="index.html">홈으로</a>
</body>
</html>