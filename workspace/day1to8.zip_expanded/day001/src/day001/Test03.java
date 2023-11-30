package day001;

public class Test03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//데이터
		//유지를 하는게 핵심
		//유지를 위해서는 저장공간이 필요
		
		//정수
		int a = 10;
		
		//실수
		double b = 3.14;
		
		//문자
		char c = 'a';
		
		//문자열
		String d = "apple";
		
		//불린
		boolean e = false;
		
		//데이터 타입 = 자료형
		//변수를 정의할 때에는 자료형, 변수명,값 순
		//ex)int cnt = 28;
		//변수명도 함수명처럼 뜻이 잘 통하게 직관적으로 지어주어야한다.
		
		//int double char 등은 윈시타입. JAVA에 원래 없던 것. C언어에서 사용중인 자료형
		//Integer,Double,Boolean,Character,String이 원래 JAVA 타입. 클래스
		//C언어에는 String이 존재하지 않는다.
		
		//변수중에서 값이 절대 바뀌면 안되는 것들이 있다. ex)PI값
		//변하는 안된느 값 = 상수
		//변수를 상수화 하는 키워드 final
		final double PI = 3.14159;
		System.out.println(PI);
		//final을 사용하면 연산자를 사용할 수 없다.
		//PI = PI + 10;
		System.out.println(PI);
		
	}

}
