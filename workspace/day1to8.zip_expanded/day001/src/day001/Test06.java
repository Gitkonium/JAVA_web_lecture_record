package day001;

public class Test06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//산슬, 대입, 증감
		//연산자는 우선순위가 있다 ★
		//디버깅표 그리기 ★
		
		int total = 0;
		int num1 = 1000;
		int num2= 2000;
		int num3 = 3000;
		
		//복합 대입연산자
		total += num1;
		total += num2;
		total += num3;
		
		System.out.println("총 금액" + total);

	}

}
