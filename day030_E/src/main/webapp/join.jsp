<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>

<form action="controller.jsp" method="POST">
	<input type="hidden" name="action" value="join">
	아이디 <input type="text" name="mid" required> <br>
	비밀번호 <input type="password" name="mpw" required> <br>
	이름 <input type="text" name="name" required> <br>
	<input type="submit" value="회원가입">
</form>

<hr>

<a href="controller.jsp?action=main">메인으로 돌아가기</a>

</body>
</html>