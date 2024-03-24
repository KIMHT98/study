<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>글 수정</h2>
	<form action="video" method="POST">
		<input type="hidden" name="action" value="update">
		<input type="hidden" name="id" value="${review.id }">
		
		<div>
			글제목  : <input type="text" name="title" value="${review.title }">
		</div>
		<div>
			글쓴이 : <input type="text" name="writer" value="${review.writer }" readonly>
		</div>
		<div>
			글내용 :
			<textarea rows="10" cols="30" name="content">${review.content}</textarea>
			>
		</div>
		<div>
			<button>수정</button>
		</div>





	</form>
</body>
</html>