package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;

public class ErrorAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward=new ActionForward();
		forward.setPath("alert.do");
		forward.setRedirect(false);
		
		request.setAttribute("msg", "없는 action 이거나 forward 가 null 입니다...");
		return forward;
	}

}
