<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지 가기전의 페이지</title>
</head>
<body>

<form action="controller.jsp" method="POST">
	<input type="hidden" name="action" value="mypage">
	비밀번호 확인 <input type="password" name="mpw" required> <input type="submit" value="마이페이지 입장">
</form>

<hr>

<a href="controller.jsp?action=main">메인으로 돌아가기</a>

</body>
</html>