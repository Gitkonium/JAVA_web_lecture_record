<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList,model.dto.*"%>

<%
request.setCharacterEncoding("UTF-8");
%>

<jsp:useBean class="model.dao.ReplyDAO" id="rDAO" />
<jsp:useBean class="model.dto.ReplyDTO" id="rDTO" />
<jsp:useBean class="model.dao.MemberDAO" id="mDAO" />
<jsp:useBean class="model.dto.MemberDTO" id="mDTO" />
<jsp:setProperty name="mDTO" property="*" />

<%
String action = request.getParameter("action");

if (action.equals("main")) { // 메인페이지
	
	ArrayList<ReplyDTO> rdatas=rDAO.selectAll(rDTO);
	request.setAttribute("rdatas", rdatas);
	
	ArrayList<MemberDTO> mdatas=mDAO.selectAll(mDTO);
	request.setAttribute("mdatas", mdatas);
	
	pageContext.forward("main_e.jsp");

} else if (action.equals("join")) { // 회원가입

	boolean flag = mDAO.insert(mDTO);

	if (flag) {

		response.sendRedirect("controller_e.jsp?action=main");

	} else {
		
		out.println("<script>alert('ID 중복 등으로 인해 회원가입에 실패하셨습니다!');history.go(-1);</script>");
		
	}

} else if (action.equals("joinPage")) { // 회원가입 페이지로 이동

	response.sendRedirect("join_e.jsp");

} else if(action.equals("login")){ // 로그인
	
	ArrayList<ReplyDTO> rdatas=rDAO.selectAll(rDTO);
	request.setAttribute("rdatas", rdatas);
	
	ArrayList<MemberDTO> mdatas=mDAO.selectAll(mDTO);
	request.setAttribute("mdatas", mdatas);
	
 	mDTO = mDAO.selectOne(mDTO); // 아이디 정보 가져오기

 	session.setAttribute("member", mDTO.getMid()); // 세션에 아이디 저장
	
 	pageContext.forward("main_e.jsp"); // 페이징
	
} else if (action.equals("logout")) { // 로그아웃
	
	ArrayList<ReplyDTO> rdatas=rDAO.selectAll(rDTO);
	request.setAttribute("rdatas", rdatas);
	
	ArrayList<MemberDTO> mdatas=mDAO.selectAll(mDTO);
	request.setAttribute("mdatas", mdatas);
	
	session.removeAttribute("member");

	pageContext.forward("main_e.jsp");

} else if (action.equals("mypage")) { // 마이페이지로 이동

} else if (action.equals("loginPage")) { // 로그인 페이지로 이동
	
	response.sendRedirect("login_e.jsp");

} else if (action.equals("replySelectOne")) { // 댓글 상세 페이지로 이동

} else if (action.equals("replyInsert")) { // 댓글추가

} else {

	// 이상한 요청
	// 에러처리해야함!

}
%>