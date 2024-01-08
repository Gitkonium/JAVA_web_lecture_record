<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>

<form action="test07.jsp" method="POST">
	<input type="hidden" name="action" value="join">
	ID <input type="text" name="mid" required> <br>
	PW <input type="password" name="mpw" required> <br>
	<input type="submit" value="회원가입">
</form>

</body>
</html>