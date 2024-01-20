package controller.common;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class CrawlingListener implements ServletContextListener {

    public CrawlingListener() {
    }

	public void contextDestroyed(ServletContextEvent sce)  { 
    }

	public void contextInitialized(ServletContextEvent sce)  { 
		Crawling crawling=new Crawling();
		crawling.sample();
		// 여기에 크롤링 관련 코드를 작성
		
		ServletContext sc=sce.getServletContext();
		sc.setAttribute("teemo","작은 티모");
		// sc == application
		System.out.println(" [로그] 리스너 서블릿 클래스에서 작성한 로그");
		// "서블릿 컨테이너의 시작"에 반응한다는것을 확인!!!
    }
	
}
