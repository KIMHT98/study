<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>
<c:out value="Hello JSTL"></c:out><br>
<c:out value="Hello JSTL"/><br>
<hr>
<h3>C:set</h3>
<c:set var="name" value="Kim"/>${name }<br>
<c:set var="name2" >Kim2</c:set>${name2 }<br>

<c:set var="person" value = "<%= new com.ssafy.dto.Person() %>"/>
<c:set target="${person}" property="name" value="kim2"></c:set>
<%--property는 setter를 호출 --%>
${person}<br>

</body>
</html>