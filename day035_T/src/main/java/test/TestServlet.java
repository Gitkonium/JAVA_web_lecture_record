package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/apple.do")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public TestServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("JAVA 로그");
		
		System.out.println(request.getParameter("banana"));
		System.out.println(request.getParameter("kiwi"));
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		out.print("사과"); // != out.println("사과");
		
		// ID가 중복이라면? "사과"
		// 중복아니라면? "바나나"
	}

}
