<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인화면</title>
</head>
<body>
	<%
		if(session.getAttribute("id")==null){
			response.sendRedirect("07_LoginForm.jsp");
		}else{
			%>
			<%=session.getAttribute("id") %>
			<hr>
			<h1>메인페이지</h1>
		<%}
	%>
	<!-- 로그아웃 -->
	<form action="07_Logout.jsp" method = "POST">
		<button>로그아웃</button>
	</form>
</body>
</html> 