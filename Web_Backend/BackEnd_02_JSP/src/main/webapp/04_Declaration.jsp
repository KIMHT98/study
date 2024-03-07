<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!int A = 10;
	int B = -20;

	String name = "SSAFY";

	public int add(int A, int B){
		return A+B;
	}
	public int abs(int A) {
		return A > 0 ? A : -A;
	}%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선언부</title>
</head>
<body>

	<% int C = 10;
	//여기서는 메서드를 정의할 수 없다
	//자바는 메소드 안에서 메소드를 정의할 수 없기 때문
	//얘는 servlet에서 service()메소드에 입력되는 값
	out.print(add(A,B));
	out.print("<br>");
	out.print(abs(B));
	out.print("<br>");%>
	<a href="index.html">홈으로</a>

</body>
</html>