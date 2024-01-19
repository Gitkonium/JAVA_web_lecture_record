package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDAO;
import model.dao.ReplyDAO;
import model.dto.MemberDTO;
import model.dto.ReplyDTO;

public class MainAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward=new ActionForward();
		forward.setPath("main.jsp");
		forward.setRedirect(false);
		// pageContext.forward("main.jsp");
		
		request.setCharacterEncoding("UTF-8");
		
		ReplyDAO rDAO=new ReplyDAO();
		ReplyDTO rDTO=new ReplyDTO();
		ArrayList<ReplyDTO> rdatas=rDAO.selectAll(rDTO);
		request.setAttribute("rdatas", rdatas);
		
		MemberDAO mDAO=new MemberDAO();
		MemberDTO mDTO=new MemberDTO();
		ArrayList<MemberDTO> mdatas=mDAO.selectAll(mDTO);
		request.setAttribute("mdatas", mdatas);
		
		return forward;
	}

}
