<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
</head>
<body>
	<h2>글 등록</h2>
	<form action="board" method="POST">
		<input type="hidden" name="action" value="write">
		<div>
			글제목  : <input type="text" name="title">
		</div>
		<div>
			글쓴이 : <input type="text" name="writer">
		</div>
		<div>
			글내용 :
			<textarea rows="10" cols="30" name="content"></textarea>
			>
		</div>
		<div>
			<button>등록</button>
		</div>





	</form>
</body>
</html>