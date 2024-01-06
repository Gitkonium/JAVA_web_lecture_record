<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 내장객체 : application</title>
</head>
<body>

<%
	application.setAttribute("count", 0);
%>

	<a href="test08.jsp">방문자 수 확인하기</a>

</body>
</html>