package class05;

import java.util.Scanner;

//문제 4
//사용자가 이름을 입력했을때, "정말 이 이름으로 하시겠습니까?"라고 질문하고,
// "네"라고 하면 해당 이름을 사용해주세요.
// "네" 이외의 입력시 재입력하게해주세요.
//문제 4-2
//문제 4의 기능을 모듈화 해보세요.
// HINT) String inputName()

class Person4 {

	// 멤버 변수 이름
	String name;

	// 멤버 변수 나이
	int age;

	// 생성자
	Person4(String n, int a) {

		name = n;

		age = a;

	}

	// hello 메서드
	void hello() {

		System.out.println(name + "은 " + age + "살 입니다.");

	}

	// inputAge 메서드
	int inputAge() {

		// 입력 값이 0~100이면
		if (age >= 0 && age <= 100) {

			// 입력 값을 반환
			return age;

		}

		// -1 반환
		return -1;

	}

}

public class Test07 {

	public static void main(String[] args) {

		String n = "아무개";

		int a = 20;

		String answer;

		// Scanner 객체 호출
		Scanner sc = new Scanner(System.in);

		// Person2 객체 호출
		Person4 p4 = new Person4(n, a);

		while (true) {

			// 메세지 출력
			System.out.println("이름을 입력해주세요>>");

			// 이름 지정
			p4.name = sc.next();

			if (p4.name != "") {

				System.out.println("정말 이 이름으로 하시겠습니까?");

				answer = sc.next();

				if (answer.equals("네")) {
					
					break;

				} else {

					continue;
					
				}

			}

			break;

		}

		// 탈출 할 때까지 반복
		while (true) {

			// 메세지 출력
			System.out.println("나이를 입력해주세요>>");

			// 입력 값을 저장
			p4.age = sc.nextInt();

			// inputAge() 메서드의 반환 값이 -1 아니면
			if (p4.inputAge() != -1) {

				// hello() 메서드 호출
				p4.hello();

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