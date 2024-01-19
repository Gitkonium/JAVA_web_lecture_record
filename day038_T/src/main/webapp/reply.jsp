<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.dto.ReplyDTO" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글 상세 페이지</title>
</head>
<body>

<form action="replyUpdate.do" method="POST">
	댓글번호 <input type="number" name="rid" value="${data.rid}" readonly> <br>
	작성자 <input type="text" name="writer" value="${data.writer}" disabled> <br>
	내용 <input type="text" name="content" value="${data.content}" required> <br>
	<c:if test="${data.writer==member}">
		<input type="submit" value="내용 변경">
	</c:if>
</form>

<c:if test="${data.writer==member}">
	<a href="replyDelete.do?rid=${data.rid}">댓글 삭제</a>
</c:if>

<hr>

<a href="main.do">메인으로 돌아가기</a>

</body>
</html>