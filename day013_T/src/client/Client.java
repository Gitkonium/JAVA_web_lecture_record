package client;

import controller.StudentCtrl;

public class Client {
	public static void main(String[] args) {

		// 계산기 프로그램을 실행할 예정

		// LP, UF, 데이터(ERD)

		// 기능 : 더하기,빼기,곱하기
		// 정수 1 입력 >> 10
		// 연산자 입력 >> + : String
		// 정수 2 입력 >> 5
		// 결과는 10 + 5 = 15 입니다.

		StudentCtrl app=new StudentCtrl();
		app.startApp();

	}
}
