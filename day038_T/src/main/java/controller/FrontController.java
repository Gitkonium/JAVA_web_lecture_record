package controller;

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
	
	private MainAction mainAction;
	private JoinAction joinAction;
	private JoinPageAction joinPageAction;
	private LogoutAction logoutAction;
	private TestPageAction testPageAction;
	private LoginPageAction loginPageAction;
	private MypageAction mypageAction;
	private LoginAction loginAction;
	private ReplySelectOneAction replySelectOneAction;
	private ReplyInsertAction replyInsertAction;
	private ReplyUpdateAction replyUpdateAction;
	private ReplyDeleteAction replyDeleteAction;
	private ChangeNameAction changeNameAction;
	private MemberDeleteAction memberDeleteAction;
	private AlertAction alertAction;
	private GobackAction gobackAction;
	private ErrorAction errorAction;

	public FrontController() {
		super();
		mainAction=new MainAction();
		joinAction=new JoinAction();
		joinPageAction=new JoinPageAction();
		logoutAction=new LogoutAction();
		testPageAction=new TestPageAction();
		loginPageAction=new LoginPageAction();
		mypageAction=new MypageAction();
		loginAction=new LoginAction();
		replySelectOneAction=new ReplySelectOneAction();
		replyInsertAction=new ReplyInsertAction();
		replyUpdateAction=new ReplyUpdateAction();
		replyDeleteAction=new ReplyDeleteAction();
		changeNameAction=new ChangeNameAction();
		memberDeleteAction=new MemberDeleteAction();
		alertAction=new AlertAction();
		gobackAction=new GobackAction();
		errorAction=new ErrorAction();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	
	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// controller.jsp 의 코드를 옮겨올예정!

		String uri=request.getRequestURI();
		String cp=request.getContextPath();
		String action=uri.substring(cp.length());
		System.out.println("FC : "+action);

		ActionForward forward = null;
		if(action.equals("/main.do")) { // ◀ if(action.equals("main")){
			forward = mainAction.execute(request, response);
		}
		else if(action.equals("/join.do")) {
			forward = joinAction.execute(request, response);
		}
		else if(action.equals("/joinPage.do")) {
			forward = joinPageAction.execute(request, response);
		}
		else if(action.equals("/logout.do")) {
			forward = logoutAction.execute(request, response);
		}
		else if(action.equals("/testPage.do")) {
			forward = testPageAction.execute(request, response);
		}
		else if(action.equals("/mypage.do")) {
			forward = mypageAction.execute(request, response);
		}
		else if(action.equals("/loginPage.do")) {
			forward = loginPageAction.execute(request, response);
		}
		else if(action.equals("/login.do")) {
			forward = loginAction.execute(request, response);
		}
		else if(action.equals("/replySelectOne.do")) {
			forward = replySelectOneAction.execute(request, response);
		}
		else if(action.equals("/replyInsert.do")) {
			forward = replyInsertAction.execute(request, response);
		}
		else if(action.equals("/replyUpdate.do")) {
			forward = replyUpdateAction.execute(request, response);
		}
		else if(action.equals("/replyDelete.do")) {
			forward = replyDeleteAction.execute(request, response);
		}
		else if(action.equals("/changeName.do")) {
			forward = changeNameAction.execute(request, response);
		}
		else if(action.equals("/memberDelete.do")) {
			forward = memberDeleteAction.execute(request, response);
		}
		else if(action.equals("/alert.do")) {
			forward = alertAction.execute(request, response);
		}
		else if(action.equals("/goback.do")) {
			forward = gobackAction.execute(request, response);
		}
		else{
			forward = errorAction.execute(request, response);
		}
		
		if(forward == null) {
			// 에러 상황
			forward = errorAction.execute(request, response);
		}
		
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
