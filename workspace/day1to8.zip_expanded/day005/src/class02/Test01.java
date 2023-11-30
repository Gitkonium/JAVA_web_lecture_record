package class02;

// 함수 : output 함수명(input)
// input, 매개변수, args, 인자, 인수, 파라미터, 입력값
// output, return, 반환값, 결과값, 출력값
// 기능 -> 해당 함수의 기능을 유추할 수 있는 이름으로 작성
public class Test01 
{
	
	// 함수 4유형
	// input X output X
	
		// public static void 함수명(){}
		// 선언 된 상태
		// 함수를 사용하려면 호출 해야한다.
		public static void hello() 
		{
			
			System.out.print("안녕하세요");
			
		}
		
		public static void clue() 
		{
			
			System.out.print("dqd");
			
		}
		
		public static void printInfo() 
		{
			
			System.out.print("dqd");
			
		}
	
	// input O output X
	// input X output O
	// input O output O
	
	//main(String[] args) 
	public static void main(String[] args) 
	{
		
		// ★ 
		// 수 많은 JAVA 기본 함수들이 "호출" 하지 않았기에 "사용" 되고
		// 수 많은 기본 함수들은 선언(정의)만 된 상태
		
		// 선언된 함수를 호출하는 코드
		// 코드를 재사용
		// 가독성이 좋아짐
		// 개발시간 단축
		// 개발비용 절감
		// 오류의 파급효과 줄어듦
		// 성능향상에 유리함
		hello();
		
		clue();
		
		printInfo();
		printInfo();
		

	}

}
