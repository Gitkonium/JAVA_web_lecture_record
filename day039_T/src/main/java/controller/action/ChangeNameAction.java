package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.common.Action;
import controller.common.ActionForward;
import model.dao.MemberDAO;
import model.dto.MemberDTO;

public class ChangeNameAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
				
		MemberDAO mDAO=new MemberDAO();
		MemberDTO mDTO=new MemberDTO();
		HttpSession session=request.getSession();
		String mid=(String)session.getAttribute("member");
		mDTO.setMid(mid);
		mDTO.setName(request.getParameter("name"));
		boolean flag=mDAO.update(mDTO);
		System.out.println(flag+" "+mDTO);
		if(flag){
			forward.setPath("logout.do");
			forward.setRedirect(true);
		}
		else{
			request.setAttribute("msg", "이름변경에 실패했습니다...");
			
			forward.setPath("alert.do");
			forward.setRedirect(false);
		}
		
		return forward;
	}

}
