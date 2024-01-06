<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error/error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러가 발생할 수 있는 코드를 작성</title>
</head>
<body>

<%
	String str="apple";
	int num=Integer.parseInt(str);
	
	// 에러의 유무보다는,
	// 에러가 발생했을때에 사용자의 서비스가 끊기지않도록 안내하는것이 중요!
%>

</body>
</html>