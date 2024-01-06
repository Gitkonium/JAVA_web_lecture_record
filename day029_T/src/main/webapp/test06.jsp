<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 내장객체 : session</title>
</head>
<body>

<%
	if(session.isNew()){
		out.println("<script>alert('세션을 새로 만듦!');</script>");
		session.setAttribute("userName", "작은 티모");
		// 기본 제공 시간 30분 (아마)
	}
%>

<h1><%= session.getAttribute("userName") %>님, 안녕하세요! :D</h1>

</body>
</html>