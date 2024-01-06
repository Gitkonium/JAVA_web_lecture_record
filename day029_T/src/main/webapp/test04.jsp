<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립트릿 사용</title>
</head>
<body>

<%
	// JAVA 코드 공간
	for(int i=1;i<=5;i++){
		out.println(i+" <br>");
	}
%>

<hr>

<%
	for(int i=1;i<=5;i++){
%>
		<%=i%> <br>
<%
	}
%>


</body>
</html>