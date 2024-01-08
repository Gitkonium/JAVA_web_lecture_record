<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean class="model.member.MemberDAO" id="mDAO" />
<jsp:useBean class="model.member.MemberDTO" id="mDTO" />
<jsp:setProperty name="mDTO" property="*" />

<%
	String action=request.getParameter("action");
	if(action.equals("login")){
		mDTO.setSearchCondition("login");
		mDTO=mDAO.selectOne(mDTO);
		if(mDTO == null){
			out.println("로그인 실패");
		}
		else{
			session.setAttribute("member", mDTO.getMid());
			response.sendRedirect("test01.jsp");
		}
	}
	else{
		mDTO.setSearchCondition("join");
		if(mDAO.selectOne(mDTO) == null){
			boolean rs=mDAO.insert(mDTO);
			if(rs){
				out.println("<script>alert('회원가입 완료! :D');location.href='test01.jsp';</script>");
			}
			else{
				out.println("회원가입 실패");
			}
		}
		else{
			out.println("회원가입 불가능 : ID 중복");
		}
	}
%>
