package codingTest;

// https://school.programmers.co.kr/learn/courses/30/lessons/181937

// n의 배수

// 문제 설명
// 정수 num과 n이 매개 변수로 주어질 때, num이 n의 배수이면 1을 return n의 배수가 아니라면 0을 return하도록 solution 함수를 완성해주세요.

// 제한사항
// 2 ≤ num ≤ 100
// 2 ≤ n ≤ 9

// 입력 : 98, 2
// 출력 : 1
public class Test01 {

	public static void main(String[] args) {
		
		int num = 98;
		
		int n = 2;
		
		System.out.println(funcA(num, n));
				
	}
	
	public static int funcA(int a, int b) {
		
		int result = 98 % 2;
		
		if(result == 0) {
			
			return 1;
			
		}
		else {
			
			return 0;
			
		}
		
	}

}
