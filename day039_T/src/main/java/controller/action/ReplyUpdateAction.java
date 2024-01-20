package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.dao.ReplyDAO;
import model.dto.ReplyDTO;

public class ReplyUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		
		ReplyDAO rDAO=new ReplyDAO();
		ReplyDTO rDTO=new ReplyDTO();
		rDTO.setContent(request.getParameter("content"));
		rDTO.setRid(Integer.parseInt(request.getParameter("rid")));
		boolean flag=rDAO.update(rDTO);
		if(flag){
			forward.setPath("main.do");
			forward.setRedirect(true);
		}
		else{
			request.setAttribute("msg", "댓글 변경에 실패했습니다...");
			
			forward.setPath("alert.do");
			forward.setRedirect(false);
		}
		
		return forward;
	}

}
