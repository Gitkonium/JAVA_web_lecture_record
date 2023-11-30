package class05;

import java.util.Scanner;

//문제 2
//나이를 별도로 입력할때에 1~100살까지만 입력할수있습니다.
//이외 범위를 입력하는 경우 재입력할수있게 '메서드'를 정의해보세요.
// HINT) int inputAge()

class Person2{
	
	//멤버 변수 이름
	String name;
	
	//멤버 변수 나이
	int age;
	
	// 생성자
	Person2(String n, int a){
		
		name = n;
		
		age = a;
		
	}
	
	//hello 메서드
	void hello(){
		
		System.out.println(name + "은 " + age + "살 입니다.");
		
	}
	
	// inputAge 메서드
	int inputAge() {
		
		// 입력 값이 0~100이면
		if(age >= 0 && age <= 100) {
			
			// 입력 값을 반환
			return age;
			
		}
		
		// -1 반환
		return -1;
		
	}
	
}

public class Test05 {

	public static void main(String[] args) {
		
		// Scanner 객체 호출
		Scanner sc = new Scanner(System.in);
		
		String n = "아무개";
		
		int a = 20;
		
		// Person2 객체 호출
		Person2 p2 = new Person2(n, a);
		
		// 탈출 할 때까지 반복
		while(true) {
			
			// 메세지 출력
			System.out.println("나이를 입력해주세요>>");
			
			// 입력 값을 저장
			p2.age = sc.nextInt();
			
			// inputAge() 메서드의 반환 값이 -1 아니면
			if(p2.inputAge() != -1 ) {
				
				// hello() 메서드 호출
				p2.hello();
				
				// 반복 탈출
				break;
				
			}
			// 반환 값이 -1일 경우
			else {
				
				// 다시 입력하도록 반복
				continue;
				
			}
			
		}
		
	}

}
