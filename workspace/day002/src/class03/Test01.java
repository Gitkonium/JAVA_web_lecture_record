package class03;

public class Test01 {

	public static void main(String[] args) {

		int i=1;

		while(i<=20) { // i가 20을 넘어가지않을때까지 계속
			System.out.println("i= "+i);
			i+=3;
		}
		
		System.out.println("===============================");
		
		i = 3; // 별도의 선언없이, 해당 변수를 재사용!
		while(true) {
			// 반드시 [종료조건]이 필요하다!
			i--;
			System.out.println("i= "+i);
			
			if(i==-5) {
				break;
			}
		}
		
		

	}

}
