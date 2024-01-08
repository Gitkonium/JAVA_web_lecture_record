<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.dto.*,java.util.ArrayList" %>
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

<%
	String member=(String)session.getAttribute("member");
	if(member != null){ // 로그인 상태
%>
		<a href="controller.jsp?action=logout">로그아웃</a> | <a href="controller.jsp?action=mypage">마이페이지</a>
<%
	}
	else{ // 로그아웃 상태
%>
		<a href="controller.jsp?action=loginPage">로그인</a> | <a href="controller.jsp?action=joinPage">회원가입</a>
<%
	}
%>

<hr>

<ul>
	<%
		ArrayList<ReplyDTO> rdatas=(ArrayList<ReplyDTO>)request.getAttribute("rdatas");
		if(rdatas.size()<=0){
			out.println("출력할 댓글이 없습니다!");
		}
		else{
			for(ReplyDTO data:rdatas){
	%>
			<li><a href="controller.jsp?action=replySelectOne"><%=data.getRid()%>번 댓글 <%=data.getWriter()%>님이 작성</a></li>
	<%
			}
		}
	%>
</ul>

<hr>

		<form action="controller.jsp?action=replyInsert" method="POST">
			<input type="hidden" name="writer" value="<%=member%>" >
			<%
				if(member != null){
			%>	
				<input type="text" name="content" required placeholder="댓글 내용 입력"> <br>
				<input type="submit" value="댓글추가">
			<%		
				}
				else{ // 로그아웃 상태라면
			%>
				<input class="info" type="text" name="content" disabled value="댓글을 작성하시려면 로그인하세요."> <br>
			<%
				}
			%>
		
		</form>

<hr>

<ul>
	<%
		ArrayList<MemberDTO> mdatas=(ArrayList<MemberDTO>)request.getAttribute("mdatas");
		if(mdatas.size()<=0){
			out.println("출력할 회원이 없습니다!");
		}
		else{
			for(MemberDTO data:mdatas){
	%>
				<li><%=data.getName()%>님</li>
	<%
			}
		}
	%>
</ul>

</body>
</html>