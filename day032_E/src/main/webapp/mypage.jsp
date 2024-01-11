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

<form action="changeName.do" method="POST">
	이름 <input type="text" name="name" value="<%=data%>" required> <br>
	<input type="submit" value="이름 변경">
</form>

<a href="memberDelete.do">회원탈퇴</a>

<hr>

<a href="main.do">메인으로 돌아가기</a>

</body>
</html>