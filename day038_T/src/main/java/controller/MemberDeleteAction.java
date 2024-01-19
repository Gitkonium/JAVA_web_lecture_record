package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.MemberDAO;
import model.dto.MemberDTO;

public class MemberDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		
		MemberDAO mDAO=new MemberDAO();
		MemberDTO mDTO=new MemberDTO();
		HttpSession session=request.getSession();
		String mid=(String)session.getAttribute("member");
		mDTO.setMid(mid);
		boolean flag=mDAO.delete(mDTO);
		if(flag){
			forward.setPath("logout.do");
			forward.setRedirect(true);
		}
		else{
			request.setAttribute("msg", "회원탈퇴에 실패했습니다...");
			
			forward.setPath("alert.do");
			forward.setRedirect(false);
		}
		
		return forward;
	}

}
