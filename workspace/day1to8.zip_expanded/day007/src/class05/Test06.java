package class05;

import java.util.Scanner;

//문제 3
//사용자에게 이름도 입력받아보세요! ㅎㅎ

class Person3{
	
	//멤버 변수 이름
	String name;
	
	//멤버 변수 나이
	int age;
	
	// 생성자
	Person3(String n, int a){
		
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

public class Test06 {

	public static void main(String[] args) {
		
		// Scanner 객체 호출
		Scanner sc = new Scanner(System.in);
		
		String n = "아무개";
		
		int a = 20;
		
		// Person2 객체 호출
		Person3 p3 = new Person3(n,a);
		
		// 메세지 출력
		System.out.println("이름을 입력해주세요>>");
		
		// 이름 지정
		p3.name = sc.next();
		
		// 탈출 할 때까지 반복
		while(true) {
			
			// 메세지 출력
			System.out.println("나이를 입력해주세요>>");
			
			// 입력 값을 저장
			p3.age = sc.nextInt();
			
			// inputAge() 메서드의 반환 값이 -1 아니면
			if(p3.inputAge() != -1 ) {
				
				// hello() 메서드 호출
				p3.hello();
				
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