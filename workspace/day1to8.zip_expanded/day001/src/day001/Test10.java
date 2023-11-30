package day001;

public class Test10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num = 10;
		// num가 양수면 양수입니다.
		// 음수면 음수입니다.
		
		//코드 진행시에 선택을 해야할 때 조건문 사용
		//코드의 흐름을 제어할 수 있는 문법 = 제어문
		//그 중 하나가 if문(다자택일)

		//num이 양수일 경우
		if(num > 0) 
		{
			
			System.out.println(num + "은 양수입니다.");
			
		}
		//num이 음수일 경우
		else if(num < 0) 
		{
			
			System.out.println(num + "은 음수입니다.");
			
		}
		//num이 음수가 아닐 경우
		else 
		{
			
			System.out.println(num + "은 양수입니다.");
			
		}
		
	}

}
