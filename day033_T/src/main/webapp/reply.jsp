<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.dto.ReplyDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글 상세 페이지</title>
</head>
<body>

<%
	String member=(String)session.getAttribute("member");
	ReplyDTO data=(ReplyDTO)request.getAttribute("data");
%>

<form action="replyUpdate.do" method="POST">
	댓글번호 <input type="number" name="rid" value="${data.rid}" readonly> <br>
	작성자 <input type="text" name="writer" value="${data.writer}" disabled> <br>
	내용 <input type="text" name="content" value="${data.content}" required> <br>
	<% if(data.getWriter().equals(member)){ %>
		<input type="submit" value="내용 변경">
	<% } %>
</form>

<% if(data.getWriter().equals(member)){ %>
	<a href="replyDelete.do?rid=<%=data.getRid()%>">댓글 삭제</a>
<% } %>

<hr>

<a href="main.do">메인으로 돌아가기</a>

</body>
</html>