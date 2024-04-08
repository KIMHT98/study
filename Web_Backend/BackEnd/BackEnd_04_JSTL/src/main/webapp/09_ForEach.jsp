<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>드라마 반복</title>
</head>
<body>
	<%
	String[] dramaList = { "파리의 연인", "고려거란전쟁", "주몽", "자이언트" };
	pageContext.setAttribute("dramaList", dramaList);
	%>
	<h3>C : forEach</h3>
	<ol>
		<c:forEach items="${dramaList}" var="drama">
			<li>${drama}</li>
		</c:forEach>
	</ol>
	<hr>
	<c:forEach var = "drama" items = "${dramaList}" varStatus="status" begin="1" end="3" step="2"> 
		<div>${status.index} : ${drama} index</div>
	</c:forEach>
	<hr>
	<c:forEach var = "drama" items = "${dramaList}" varStatus="status" step="2"> 
		<div>${status.count} : ${drama} count</div>
	</c:forEach>

</body>
</html>