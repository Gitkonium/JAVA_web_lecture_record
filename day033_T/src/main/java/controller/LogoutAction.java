package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		forward.setPath("alert.do");
		forward.setRedirect(false); // 전달할 데이터가 있으면 무조건 포워드 !
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session=request.getSession();
		session.removeAttribute("member");
		
		request.setAttribute("msg", "로그아웃이 완료되었습니다! :D");
		
		return forward;
	}

}
