package codingTest;

// https://school.programmers.co.kr/learn/courses/30/lessons/181933

// flag에 따라 다른 값 반환하기

// 문제 설명
// 두 정수 a, b와 boolean 변수 flag가 매개변수로 주어질 때, flag가 true면 a + b를 false면 a - b를 return 하는 solution 함수를 작성해 주세요.

// 제한사항
// -1,000 ≤ a, b ≤ 1,000

// 입력 : -4 7 true
// 출력 : 3
public class Test04 {

	public static void main(String[] args) {
		
		int a = -4;
		
		int b = 7;
		
		boolean flag = true;
		
		System.out.println(funcA(a,b,flag));
		
	}
	
	public static int funcA(int a, int b, boolean flag) {
		
		if(flag == true) {
			
			return a + b;
			
		}
		else {
			
			return a - b;
			
		}
		
	}

}
