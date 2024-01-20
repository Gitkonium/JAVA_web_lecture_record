<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.dto.*,java.util.ArrayList" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="kim" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
<style type="text/css">
	.info {
		width: 250px;
	}
</style>
</head>
<body>

<kim:memberInfoBox2 member='${member}' />

<hr>

<c:set var="msg" value="안녕하세요! :D" />
${msg}

<hr>

<ul>
	<c:if test="${fn:length(rdatas) <= 0}">
		출력할 댓글이 없습니다!
	</c:if>
	<c:if test="${fn:length(rdatas) > 0}">
		<c:forEach var="data" items="${rdatas}">
			<li><a href="replySelectOne.do?rid=${data.rid}">${data.rid}번 댓글 ${data.writer}님이 작성</a></li>
		</c:forEach>
	</c:if>
</ul>

<hr>

		<form action="replyInsert.do" method="POST">
			<input type="hidden" name="writer" value="${member}" >
			<c:if test="${member!=null}">
				<input type="text" name="content" required placeholder="댓글 작성"> <input type="submit" value="댓글추가">
			</c:if>
			<c:if test="${member==null}"> <!-- 로그아웃 상태라면 -->
				<input class="info" type="text" name="content" disabled value="댓글을 작성하시려면 로그인하세요."> <br>
			</c:if>		
		</form>

<hr>

<ul>
	<c:if test="${fn:length(mdatas) <= 0}">
		출력할 회원이 없습니다!
	</c:if>
	<c:if test="${fn:length(mdatas) > 0}">
		<c:forEach var="data" items="${mdatas}">
			<li>${data.name}님</li>
		</c:forEach>
	</c:if>
</ul>

</body>
</html>