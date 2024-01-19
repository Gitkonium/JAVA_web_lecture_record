<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>

<form action="join.do" method="POST">
	아이디 <input type="text" id="mid" name="mid" required> <input type="button" id="btn" value="ID 중복검사" onclick="check()"> <br>
	<span id="msg"></span> <br>
	비밀번호 <input type="password" name="mpw" required> <br>
	이름 <input type="text" name="name" required> <br>
	<input type="submit" value="회원가입">
</form>

<hr>

<a href="main.do">메인으로 돌아가기</a>

<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="js/check.js"></script>
			
</body>
</html>