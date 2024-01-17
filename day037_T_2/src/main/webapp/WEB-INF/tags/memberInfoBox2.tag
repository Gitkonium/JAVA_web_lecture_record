<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ attribute name="member" %>

<%
	if(member != null && !member.equals("")){ // 로그인 상태
%>
		<a href="logout.do">로그아웃</a> | <a href="testPage.do">마이페이지</a>
<%
	}
	else{ // 로그아웃 상태
%>
		<a href="loginPage.do">로그인</a> | <a href="joinPage.do">회원가입</a>
<%
	}
%>