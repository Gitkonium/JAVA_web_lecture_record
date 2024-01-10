<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<body>

<% String data=(String)request.getAttribute("data"); %>

<form action="controller.jsp" method="POST">
	<input type="hidden" name="action" value="changeName">
	이름 <input type="text" name="name" value="<%=data%>" required> <br>
	<input type="submit" value="이름 변경">
</form>

<a href="controller.jsp?action=memberDelete">회원탈퇴</a>

<hr>

<a href="controller.jsp?action=main">메인으로 돌아가기</a>

</body>
</html>