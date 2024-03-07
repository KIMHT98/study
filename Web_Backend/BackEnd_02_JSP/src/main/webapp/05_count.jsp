<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%! int count1 = 0; %><!-- 얘는 멤버 변수 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>호출</title>
</head>
<body>
	<%
	int count2 = 0;//얘는 메서드 안에서 선언된 지역 변수
				   //새로 고침을 하면 count2는 매번 선언 및 초기화 되는 것이므로
				   //++이 의미 없음
	out.print("count1 : "+(count1++)+"<br>");
	out.print("count2 : "+(count2++)+"<br>");
	
	%>
	<a href="index.html">홈으로</a>
</body>
</html>