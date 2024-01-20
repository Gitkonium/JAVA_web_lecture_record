package controller.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// FrontController 에서
// 기능 클래스를 호출할때에
// 메서드명을 일괄적으로 강제하고싶어서 인터페이스 사용
public interface Action {

	ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	// execute() 수행결과로 반환할것들
	//  1. 어디로 가야할지 == 경로
	//  2. 어떻게 가야할지 == 리다이렉트 or 포워드
	// ☆ 반환이 2개이상이면, '자료형'을 새로 정의 => "클래스" 정의

}
