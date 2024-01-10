<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList,model.dto.*"%>
<%
request.setCharacterEncoding("UTF-8");
// getParameter() 해서 setXxx() 를 진행할때에 인코딩깨짐
// 얘 전(10번 라인 전)에 수행해야함!!!!!
%>
<jsp:useBean class="model.dao.ReplyDAO" id="rDAO" />
<jsp:useBean class="model.dto.ReplyDTO" id="rDTO" />
<jsp:useBean class="model.dao.MemberDAO" id="mDAO" />
<jsp:useBean class="model.dto.MemberDTO" id="mDTO" />
<jsp:setProperty name="rDTO" property="*" />
<jsp:setProperty name="mDTO" property="*" />
<%
String action = request.getParameter("action");
if (action.equals("main")) {
	ArrayList<ReplyDTO> rdatas = rDAO.selectAll(rDTO);
	request.setAttribute("rdatas", rdatas);

	ArrayList<MemberDTO> mdatas = mDAO.selectAll(mDTO);
	request.setAttribute("mdatas", mdatas);

	System.out.println("로그 1 : " + rdatas.size());

	pageContext.forward("main.jsp");
	// 새로운 요청 : GET
	// 기존 요청 정보를 모두 삭제시킴
	// 리다이렉트 방식
	// ↓
	// 기존 요청 정보를 유지하는 요청 방식을 사용해야한다!!!!!
	// 포워드 방식
} else if (action.equals("join")) {
	
	boolean flag = mDAO.insert(mDTO);
	
	if (flag) {
		
		response.sendRedirect("controller.jsp?action=main");
		
	} else {
		
		out.println("<script>alert('ID 중복 등으로 인해 회원가입에 실패하셨습니다!');history.go(-1);</script>");
		
	}
	
} else if (action.equals("joinPage")) {
	
	response.sendRedirect("join.jsp"); // V -> C -> V
	
} else if (action.equals("logout")) {
	
	session.removeAttribute("member");
	
	out.println("<script>alert('로그아웃이 완료되었습니다! :D');location.href='controller.jsp?action=main';</script>");
	
} else if (action.equals("testPage")) {
	
	response.sendRedirect("test.jsp");
	
} else if (action.equals("mypage")) {
	
	mDTO.setMid((String) session.getAttribute("member"));
	
	mDTO = mDAO.selectOne(mDTO);
	
	request.setAttribute("data", mDTO.getName());
	
	pageContext.forward("mypage.jsp");
	
} else if (action.equals("loginPage")) { // 컨트롤러야, 로그인 페이지로 이동해줘!~~
	
	response.sendRedirect("login.jsp"); // ㅇㅋ 이동할게~~~
	
} else if (action.equals("login")) {
	
	mDTO = mDAO.selectOne(mDTO);
	
	if (mDTO != null) {
		
		session.setAttribute("member", mDTO.getMid());
		
		response.sendRedirect("controller.jsp?action=main");
		
	} else {
		
		out.println("<script>alert('로그인에 실패했습니다...');history.go(-1);</script>");
		
	}
	
} else if (action.equals("replySelectOne")) {
	
	rDTO = rDAO.selectOne(rDTO);
	
	if (rDTO != null) {
		
		request.setAttribute("data", rDTO);
		
		pageContext.forward("reply.jsp");
		
	} else {
		
		out.println("<script>alert('없거나 볼 수 없는 댓글입니다!');location.href='controller.jsp?action=main';</script>");
		
	}
	
} else if (action.equals("replyInsert")) {
	
	boolean flag = rDAO.insert(rDTO);
	
	if (flag) {
		
		response.sendRedirect("controller.jsp?action=main");
		
	} else {
		
		out.println("<script>alert('댓글 추가에 실패했습니다...');location.href='controller.jsp?action=main';</script>");
		
	}
	
} else if (action.equals("replyUpdate")) {
	
	boolean flag = rDAO.update(rDTO);
	
	if (flag) {
		
		response.sendRedirect("controller.jsp?action=main");
		
	} else {
		
		out.println("<script>alert('댓글 변경에 실패했습니다...');location.href='controller.jsp?action=main';</script>");
		
	}
	
} else if (action.equals("replyDelete")) {
	
	boolean flag = rDAO.delete(rDTO);
	
	if (flag) {
		
		response.sendRedirect("controller.jsp?action=main");
		
	} else {
		
		out.println("<script>alert('댓글 삭제에 실패했습니다...');location.href='controller.jsp?action=main';</script>");
		
	}
	
} else if (action.equals("changeName")) {
	
	String mid = (String) session.getAttribute("member");
	
	mDTO.setMid(mid);
	
	boolean flag = mDAO.update(mDTO);
	
	if (flag) {
		
		response.sendRedirect("controller.jsp?action=logout");
		
	} else {
		
		out.println("<script>alert('이름변경에 실패했습니다...');location.href='controller.jsp?action=main';</script>");
		
	}
	
} else if (action.equals("memberDelete")) {

	// 해당 회원이 작성해둔 글 작성자를 모두 null로 변경
	// null --->> 탈퇴한 회원의 글입니다.

	String mid = (String) session.getAttribute("member");
	
	mDTO.setMid(mid);
	
	boolean flag = mDAO.delete(mDTO);
	
	if (flag) {
		
		response.sendRedirect("controller.jsp?action=logout");
		
	} else {
		
		out.println("<script>alert('회원탈퇴에 실패했습니다...');location.href='controller.jsp?action=main';</script>");
		
	}
	
} else {
	
	// 이상한 요청
	// 에러처리해야함!
	
}
%>


























