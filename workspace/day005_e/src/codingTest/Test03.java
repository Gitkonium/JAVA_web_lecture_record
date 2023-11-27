package codingTest;

//https://school.programmers.co.kr/learn/courses/30/lessons/181935

// 홀짝에 따라 다른 값 반환하기

// 문제 설명
// 양의 정수 n이 매개변수로 주어질 때, n이 홀수라면 n 이하의 홀수인 모든 양의 정수의 합을 return 하고 
// n이 짝수라면 n 이하의 짝수인 모든 양의 정수의 제곱의 합을 return 하는 solution 함수를 작성해 주세요.

// 제한사항
// 1 ≤ n ≤ 100

// 입력 : 7
// 출력 : 16

public class Test03 {

	public static void main(String[] args) {
		
		int num = 7;
		
		System.out.println(funcA(num));

	}
	
	public static int funcA(int num) {
		
		int total = 0;
		
		//1~7까지 반복
		for(int i=1;i<8;i++) {
			
			//i를 2로 나눴을 때 나머지가 0이 아니면
			if(i%2!=0) {
				
				//더하기
				total += i;
				
			}
			
		}
		
		return total;
		
	}

}
