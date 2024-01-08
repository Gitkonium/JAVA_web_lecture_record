<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>

<form action="controller_e.jsp" method="POST">

	<input type="hidden" name="action" value="login"/>

	아이디 <input type="text" name="mid" required> <br>
		
	비밀번호 <input type="password" name="mpw" required> <br>
	
	<input type="submit" value="로그인">
	
</form>

<hr>

<a href="메인페이지">메인으로 돌아가기</a>

</body>
</html>