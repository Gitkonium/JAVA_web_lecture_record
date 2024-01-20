package controller.async;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDAO;
import model.dto.MemberDTO;

/**
 * Servlet implementation class Check
 */
@WebServlet("/check.do")
public class Check extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Check() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO mDAO=new MemberDAO();
		MemberDTO mDTO=new MemberDTO();
		mDTO.setSearchCondition("ID중복검사");
		mDTO.setMid(request.getParameter("mid"));
		mDTO=mDAO.selectOne(mDTO);
		
		int flag=0;
		if(mDTO==null) {
			flag=1;
		}
		
		PrintWriter out=response.getWriter();
		out.print(flag);
		System.out.println(flag);
	}

}
