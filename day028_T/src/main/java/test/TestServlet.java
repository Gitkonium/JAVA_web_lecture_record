package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @ 어노테이션이 필요함
// @WebServlet
//  1) 서블릿 클래스라는 사실을 빠르게 인식할 수 있음
//  2) 어떤 요청을 할때 해당 서블릿이 실행되어야하는지를 알수있음
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    // 웹에서는 기본 생성자가 필수!
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	// GET 요청일때 수행하는 메서드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out=response.getWriter();
		out.println("<h1>서블릿을 직접 이용해보겠습니다! :D</h1>");
		
	}

	// POST 요청일때 수행하는 메서드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
