<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃</title>
</head>
<body>
	<!-- 로그아웃 방법 -->
	<%-- <%session.removeAttribute("id");//세션이 가지고 있는 아이디 지우기 %> --%>
	<%session.invalidate();//세션을 아예 비우던지 %>
	
	<script>
		alert("로그아웃 됐다")
		location.href = "index.html";
		
	</script>
	
</body>
</html>