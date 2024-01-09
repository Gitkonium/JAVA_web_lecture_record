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

<form action="controller.jsp" method="POST">
	<input type="hidden" name="action" value="replyUpdate">
	댓글번호 <input type="number" name="rid" value="<%=data.getRid()%>" readonly> <br>
	작성자 <input type="text" name="writer" value="<%=data.getWriter()%>" disabled> <br>
	내용 <input type="text" name="content" value="<%=data.getContent()%>" required> <br>
	<% if(data.getWriter().equals(member)){ %>
		<input type="submit" value="내용 변경">
	<% } %>
</form>

<% if(data.getWriter().equals(member)){ %>
	<a href="controller.jsp?action=replyDelete&rid=<%=data.getRid()%>">댓글 삭제</a>
<% } %>

<hr>

<a href="controller.jsp?action=main">메인으로 돌아가기</a>

</body>
</html>