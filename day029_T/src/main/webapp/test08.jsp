<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%	
	Integer count=(Integer)application.getAttribute("count");
	count++;
	application.setAttribute("count",count);
%>

<h1>방문자 수 : <%=application.getAttribute("count")%>명</h1>

</body>
</html>