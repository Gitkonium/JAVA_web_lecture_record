package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.MemberDAO;
import model.dto.MemberDTO;

public class MypageAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		forward.setPath("mypage.jsp");
		forward.setRedirect(false);
		
		MemberDAO mDAO=new MemberDAO();
		MemberDTO mDTO=new MemberDTO();
		HttpSession session=request.getSession();
		mDTO.setMid((String)session.getAttribute("member"));
		mDTO.setMpw(request.getParameter("mpw"));
		mDTO=mDAO.selectOne(mDTO);
		request.setAttribute("data", mDTO.getName());
		
		return forward; // 현재 코드에서는 비밀번호를 틀리면 500 에러가 발생합니다!
	}

}
