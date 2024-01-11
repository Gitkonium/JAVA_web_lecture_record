package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dataType.ActionForward;
import impl.Action;
import model.dao.MemberDAO;
import model.dto.MemberDTO;

public class ChangeNameAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ActionForward forward=new ActionForward();
		forward.setPath("main.do");
		forward.setRedirect(true);
		
		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("UTF-8");
		
		MemberDAO mDAO=new MemberDAO();
		MemberDTO mDTO=new MemberDTO();
		
		mDTO.setName((String)request.getAttribute("name"));
		mDTO.setMid((String)session.getAttribute("member"));
		boolean flag = mDAO.update(mDTO);
		
		return forward;
		
	}
	
}
