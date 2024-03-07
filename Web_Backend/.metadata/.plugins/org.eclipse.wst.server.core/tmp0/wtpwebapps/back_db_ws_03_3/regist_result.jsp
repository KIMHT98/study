<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 등록 결과</title>
<style>
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	border: 1px solid black;
}

th:nth-child(1) {
	width: 120px;
}
</style>
</head>
<body>
	<%@ include file = "header.jsp" %>
	<%if (request.getAttribute("isbn").equals("")||request.getAttribute("price").equals("")||
			request.getAttribute("title").equals("")||request.getAttribute("desc").equals("")||
			request.getAttribute("author").equals("")){ %>
	<p>등록된 도서가 없습니다.</p>
	<a href="regist.jsp">추가 등록</a>
	<%}else{%>
	<h2>등록 도서 정보</h2>
	<table>
		<thead>
			<th>항목</th>
			<th>내용</th>
		</thead>
		<tbody>
			<tr>
				<td>도서번호</td>
				<td><%=request.getAttribute("isbn")%></td>
			</tr>
			<tr>
				<td>도서명</td>
				<td><%=request.getAttribute("title")%></td>
			</tr>
			<tr>
				<td>저자</td>
				<td><%=request.getAttribute("author")%></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><%=request.getAttribute("price")%></td>
			</tr>
			<tr>
				<td>설명</td>
				<td><%=request.getAttribute("desc")%></td>
			</tr>
		</tbody>
	</table>
	<a href="regist.jsp">추가 등록</a>
	<%} %>
</body>