package day001;

public class Test03 {

	public static void main(String[] args) {

		// 데이터 유지 => 저장공간
		int a=10; // 정수
		double b=3.14; // 실수
		char c='a'; // 단일 문자
		String d="apple"; // 문자열
		boolean e=true; // T/F
		// 데이터 타입 == 자료형
		// 변수를 선언,정의
		// 자료형 변수명=데이터,값,value,자료;
		int cnt=28;
		// 변수명(함수명처럼) 역시 가독성이 좋게 지어주어야함!!!
		
		// 원시타입
		// 원래 JAVA에 없던 겁니당
		// C언어가 사용중인 자료형이었는데...
		// JAVA가 야 우리도 쓰자~~~ 해서 만든 키워드
		Integer i1=new Integer(10);
		int i2=10;
		// Integer,Double,Boolean,Character,String,...
		// 클래스 == 자바의 기본단위
		// C에는 String 문자열 타입이 없어서.. .원시타입이 안됨
		// 그래서 그냥 JAVA에서 만든 String 클래스 사용중~^^
		
		//그냥 변수임
		// 변수중에서... 값이 절대로 바뀌면 안되는 값이 있어요
		final double PI=3.14159; // 원주율이니까 바뀌면 안됩니다!
		// 변하면 안되는 값 == 상수값
		// 변수를 상수화하는 키워드 final
		System.out.println(PI);
		System.out.println(PI);
		
		
	}

}
