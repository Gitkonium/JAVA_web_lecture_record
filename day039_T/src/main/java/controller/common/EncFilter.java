package controller.common;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

@WebFilter({ "*.do", "*.jsp" })
// new 가 미리 작성되어있음
// 서블릿 컨테이너(톰캣)가 싱글톤 유지 + 제때에 메서드를 수행시켜줌
// ★ 컨테이너의 역할 == 객체를 생성(new 를 대신해줌) 및 관리(싱글톤 유지) 및 수행(.메서드() 를 해줌) ★
public class EncFilter extends HttpFilter implements Filter {
       
	private String encoding; // 로직부분에 하드코딩을 없애기위해 존재하는 멤버변수
	
    public EncFilter() {
        super();
   }

	public void destroy() {	
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if(request.getCharacterEncoding() == null) {
			request.setCharacterEncoding(encoding); // 하드코딩 : 유지보수 용이성을 망가뜨리는 주범ㅠ
		}
		System.out.println(" [로그] 필터 서블릿 클래스에서 작성한 로그");
		
		chain.doFilter(request, response);
		// 다음 필터가 존재한다면, 그곳으로 이동해라.
		// 더이상 수행할 필터가 없다면, 원래 수행하던 요청으로 돌아가라.
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// 최초에 단한번 실행되는 메서드 : 유사 생성자
		this.encoding=fConfig.getServletContext().getInitParameter("encoding");
		// 컴파일을 다시해야함 == 서버를 OFF->ON 해야함
		// 결국 이 모습도 하드코딩...
	}

}
// 인코딩 설정을 분리함으로써
// 1) 결합도를 낮추고
// 2) 응집도를 높일수있음
// => 유지보수 용이해짐



















