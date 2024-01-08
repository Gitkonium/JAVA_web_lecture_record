<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글 상세 페이지</title>
</head>
<body>

<form action="컨트롤러" method="POST">
	댓글번호 <input readonly> <br>
	작성자 <input disabled> <br>
	내용 <input> <br>
	<input type="submit" value="내용 변경">
</form>

<a href="컨트롤러">댓글 삭제</a>

<hr>

<a href="컨트롤러">메인으로 돌아가기</a>

</body>
</html>