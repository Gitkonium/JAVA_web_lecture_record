<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- HTML 주석 -->
<%-- JSP 주석 --%>

<h1><%= new Date() %></h1>
<%
	out.println("<h1>스크립트릿</h1>");
	// 웹 페이지 코드내에서
	// JAVA를 사용하려고 탄생한 서버 프로그래밍 언어
%>

</body>
</html>