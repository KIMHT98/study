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
	<form action="board" method="POST">
		<input type="hidden" name="action" value="update">
		<input type="hidden" name="id" value="${board.id }">
		
		<div>
			글제목  : <input type="text" name="title" value="${board.title }">
		</div>
		<div>
			글쓴이 : <input type="text" name="writer" value="${board.writer }" readonly>
		</div>
		<div>
			글내용 :
			<textarea rows="10" cols="30" name="content">${board.title }</textarea>
			>
		</div>
		<div>
			<button>수정</button>
		</div>





	</form>
</body>
</html>