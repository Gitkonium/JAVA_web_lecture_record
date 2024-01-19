package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDAO;
import model.dto.MemberDTO;

public class JoinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward=new ActionForward();
		
		MemberDAO mDAO=new MemberDAO();
		MemberDTO mDTO=new MemberDTO();
		mDTO.setMid(request.getParameter("mid"));
		mDTO.setMpw(request.getParameter("mpw"));
		mDTO.setName(request.getParameter("name"));
		boolean flag=mDAO.insert(mDTO);
		if(flag) {
			forward.setPath("main.do");
			forward.setRedirect(true);
		}
		else {
			request.setAttribute("msg", "ID 중복 등으로 인해 회원가입에 실패하셨습니다!");
			
			forward.setPath("goback.jsp");
			forward.setRedirect(false);
		}

		return forward;
	}

}
