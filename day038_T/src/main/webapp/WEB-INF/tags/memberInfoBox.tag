<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${not empty member}">
	<a href="logout.do">로그아웃</a> | <a href="testPage.do">마이페이지</a>
</c:if>
<c:if test="${empty member}">
	<a href="loginPage.do">로그인</a> | <a href="joinPage.do">회원가입</a>
</c:if>