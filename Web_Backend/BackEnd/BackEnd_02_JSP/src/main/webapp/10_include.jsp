<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>다른 JSP include</title>
</head>
<body>
	<%@ include file = "/template/Header.jsp" %><%--헤더 --%>
	<h2>메인 내용</h2>
	<!-- 푸터도 가능 -->
	<%@ include file = "/template/Footer.jsp" %><%--푸터 --%>
</body>
</html>