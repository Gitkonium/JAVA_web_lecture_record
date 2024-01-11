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

public class MypageAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ActionForward forward = new ActionForward();
		forward.setPath("mypage.jsp");
		forward.setRedirect(false);
		
		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("UTF-8");
		
		MemberDAO mDAO=new MemberDAO();
		MemberDTO mDTO=new MemberDTO();
		mDTO.setMid((String)session.getAttribute("member"));
		mDTO.setMpw(request.getParameter("mpw"));
		mDTO = mDAO.selectOne(mDTO);
		
		request.setAttribute("data", mDTO.getName());
		
		return forward;
		
	}

}
