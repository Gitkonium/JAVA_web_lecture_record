<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃</title>
</head>
<body>

<%
	session.removeAttribute("member");
	// session.removeAttribute("cart");
	
	// session.invalidate();
	
	
	
	response.sendRedirect("test01.jsp");
%>

</body>
</html>