package class02;


//제어문 : 조건문(if)
//  만약 ~라면, ~한다면, 특정 조건을 만족한다면...
//제어문 : 반복문(while, for)
//	여러번 반복
//	while은 몇 번 반복할지 모를 때 사용
//	for는 몇 번 반복할지 알 때 사용 
public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//0인 i가 있습니다.
		//이 i값이 +1 될 예정이고,
		//이 행위를 3이 될 때까지 계속해주세요.
		
		int i = 0;
	
		//while문은 조건이 참일 때만 코드 실행
		while(i <= 3) 
		{
			
			i++;
			
			System.out.println("i= " + i);
			
		}
		//반복문을 사용하면 코드를 재사용 가능하다.
		//재사용 가능하기에 가독성이 좋다.
		//개발비용을 절감 가능하다.
		//개발 시간이 단축된다.
		//오류가 줄어듦 
		//테스트가 줄어듬
		
		/**디버깅표
		 * i     i <= 3
		 * =======================
		 * 0     T
		 * 1	 T
		 * 2	 T
		 * 3	 T
		 * 4	 F
		 **/
				
	}

}
