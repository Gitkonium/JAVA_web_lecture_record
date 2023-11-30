package class02;

import java.util.Scanner;

public class Test02 {

	// 확인용 로직

	// 1) 입력된 정수값이 범위에 해당하나요?
	// 사용자가 정수를 입력함
	// 이 입력값이 a~b 사이의 범위값이 맞는지 확인
	public static boolean funcA(int a, int b) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수입력 >> ");
		
		int input = sc.nextInt();

		if (a <= input && input <= b) {
			
			return true;
			
		}
		
		return false;
		
	}

	// 사용자가 정수를 입력함
	// 이 입력값이 a~b 사이의 범위값이 맞는지 확인
	// a~b 사이의 범위값으로 제대로 입력할때까지 계속하고,
	// 제대로 입력되었다면 main()으로 입력값 반환
	public static int funcB(int a, int b) {
		
		Scanner sc = new Scanner(System.in);
		
		int input;
		
		while (true) {
			
			System.out.print("정수입력 >> ");
			
			input = sc.nextInt();
			
			if (a <= input && input <= b) {
				
				break;
				
			}
			
		}
		
		return input;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
