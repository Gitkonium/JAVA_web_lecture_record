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
		forward.setPath("main.do");
		forward.setRedirect(true);
		
		request.setCharacterEncoding("UTF-8");
		
		MemberDAO mDAO=new MemberDAO();
		MemberDTO mDTO=new MemberDTO();
		mDTO.setMid(request.getParameter("mid"));
		mDTO.setMpw(request.getParameter("mpw"));
		mDTO.setName(request.getParameter("name"));
		boolean flag=mDAO.insert(mDTO);
		
		return forward;
	}

}
