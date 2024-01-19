package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ReplyDAO;
import model.dto.ReplyDTO;

public class ReplyDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		
		ReplyDAO rDAO=new ReplyDAO();
		ReplyDTO rDTO=new ReplyDTO();
		rDTO.setRid(Integer.parseInt(request.getParameter("rid")));
		boolean flag=rDAO.delete(rDTO);
		if(flag){
			forward.setPath("main.do");
			forward.setRedirect(true);
		}
		else{
			request.setAttribute("msg", "댓글 삭제에 실패했습니다...");
			
			forward.setPath("alert.do");
			forward.setRedirect(false);
		}
		
		return forward;
	}

}
