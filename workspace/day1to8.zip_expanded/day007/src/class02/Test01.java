package class02;

import java.util.Random;
import java.util.Scanner;

public class Test01 {

	// 숫자와 숫자를 더하는 코드
	// 함수화(모듈화)
	// 1. main()에서 잘 동작하는지 코드 확인
	// 2. 뜯어서
	// 3. 1유형 함수에 붙여넣기
	// 4. 빨간밑줄 → 인자
	public static void funcA(Scanner sc, Random rand) {
		System.out.print("정수 입력 >> ");
		int input = sc.nextInt();

		System.out.println("랜덤정수를 생성합니다...");
		int randNum = rand.nextInt(10) + 1; // 1~10
		System.out.println("생성된 정수는 [" + randNum + "]입니다.");

		int result = input + randNum;
		System.out.println(input + " + " + randNum + " = " + result);
	}

	public static void funcB(Random rand, int input) {
		System.out.println("랜덤정수를 생성합니다...");
		int randNum = rand.nextInt(10) + 1; // 1~10
		System.out.println("생성된 정수는 [" + randNum + "]입니다.");

		int result = input + randNum;
		System.out.println(input + " + " + randNum + " = " + result);
	}

	public static void funcC(int input, int randNum) {
		int result = input + randNum;
		System.out.println(input + " + " + randNum + " = " + result);
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random rand = new Random();

		funcA(sc, rand);
		/*
		 * System.out.print("정수 입력 >> "); int input=sc.nextInt();
		 * 
		 * System.out.println("랜덤정수를 생성합니다..."); int randNum=rand.nextInt(10)+1; // 1~10
		 * System.out.println("생성된 정수는 ["+randNum+"]입니다.");
		 * 
		 * int result=input+randNum;
		 * System.out.println(input+" + "+randNum+" = "+result);
		 */

		System.out.print("정수 입력 >> ");
		int input = sc.nextInt();

		funcB(rand, input);
		/*
		 * System.out.println("랜덤정수를 생성합니다..."); int randNum=rand.nextInt(10)+1; // 1~10
		 * System.out.println("생성된 정수는 ["+randNum+"]입니다.");
		 * 
		 * int result=input+randNum;
		 * System.out.println(input+" + "+randNum+" = "+result);
		 */

		System.out.print("정수 입력 >> ");
		int input2 = sc.nextInt();

		System.out.println("랜덤정수를 생성합니다...");
		int randNum = rand.nextInt(10) + 1; // 1~10
		System.out.println("생성된 정수는 [" + randNum + "]입니다.");

		funcC(input2, randNum);
		/*
		 * int result=input+randNum;
		 * System.out.println(input+" + "+randNum+" = "+result);
		 */

	}

}