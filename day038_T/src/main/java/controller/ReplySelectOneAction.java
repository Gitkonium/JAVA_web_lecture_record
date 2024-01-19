package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ReplyDAO;
import model.dto.ReplyDTO;

public class ReplySelectOneAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		
		ReplyDAO rDAO=new ReplyDAO();
		ReplyDTO rDTO=new ReplyDTO();
		rDTO.setRid(Integer.parseInt(request.getParameter("rid")));
		rDTO=rDAO.selectOne(rDTO);
		if(rDTO != null){
			request.setAttribute("data", rDTO);
			
			forward.setPath("reply.jsp");
			forward.setRedirect(false);
		}
		else{
			request.setAttribute("msg", "없거나 볼 수 없는 댓글입니다!");
			
			forward.setPath("alert.do");
			forward.setRedirect(false);
		}
		
		return forward;
	}

}
