package day001;

public class Test06 {
	public static void main(String[] args) {
		// 산술,대입,증감,복합대입 연산자
		// 연산자 우선순위 ★
		// 디버깅표 그리기 ★★★
		
		int total=0;
		int num1=1000;
		int num2=2000;
		int num3=1200;
		
		total+=num1; // 복합대입연산자
		total+=num2; // -= *=
		total+=num3;
		System.out.println("총 금액: "+total);
		
	}
}
