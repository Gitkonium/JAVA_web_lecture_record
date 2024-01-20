package controller.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do") // new 가 사실은 작성되어있었던것!!!!!
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HandlerMapper handler;
	
	public FrontController() {
		super();
		handler=new HandlerMapper();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	
	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uri=request.getRequestURI();
		String cp=request.getContextPath();
		String commend=uri.substring(cp.length());
		System.out.println("FC : "+commend);

		Action action=handler.getAction(commend);
		// 나한테 Action 객체주라~~
		// => 팩토리 패턴 : 요청에 대해 알맞는 객체를 반환하는 패턴
		// HM 가 가장 대표적인 팩토리 패턴을 활용하는 클래스
		ActionForward forward = action.execute(request, response);
		
		if(forward.isRedirect()) {
			response.sendRedirect(forward.getPath());
		}
		else {
			RequestDispatcher dispatcher=request.getRequestDispatcher(forward.getPath());
			dispatcher.forward(request, response);
			// pageContext.forward(forward.getPath());
		}
		
	}
}
