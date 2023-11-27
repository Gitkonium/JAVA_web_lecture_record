package codingTest;

// https://school.programmers.co.kr/learn/courses/30/lessons/181936

// 공배수

// 문제 설명
// 정수 number와 n, m이 주어집니다. number가 n의 배수이면서 m의 배수이면 1을 아니라면 0을 return하도록 solution 함수를 완성해주세요.

// 제한사항
// 10 ≤ number ≤ 100
// 2 ≤ n, m < 10

// 입력 : 60 2 3
// 출력 : 1

public class Test02 {

	public static void main(String[] args) {
		
		int number = 60;
		
		int n = 2;
		
		int m = 3;
		
		System.out.println(funcA(number,n,m));

	}
	
	public static int funcA(int number, int n, int m) {
		
		if( number % n == 0 && number % m == 0 ) {
			
			return 1;
			
		}
		else {
			
			return 0;
			
		}
		
	}

}
