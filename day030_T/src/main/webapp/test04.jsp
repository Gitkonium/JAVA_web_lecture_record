<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>

<form action="test07.jsp" method="POST">
	<input type="hidden" name="action" value="login">
	ID <input type="text" name="mid" required> <br>
	PW <input type="password" name="mpw" required> <br>
	<input type="submit" value="로그인">
</form>

</body>
</html>