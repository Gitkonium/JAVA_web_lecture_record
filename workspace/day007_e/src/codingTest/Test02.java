package codingTest;

// https://school.programmers.co.kr/learn/courses/30/lessons/181929

// 원소들의 곱과 합

// 문제 설명
// 정수가 담긴 리스트 num_list가 주어질 때, 모든 원소들의 곱이 모든 원소들의 합의 제곱보다 작으면 1을 크면 0을 return하도록 solution 함수를 완성해주세요.

// 제한사항
// 2 ≤ num_list의 길이 ≤ 10
// 1 ≤ num_list의 원소 ≤ 9

// 입력 : [3, 4, 5, 2, 1]
// 출력 : 1

public class Test02 {

	public static void main(String[] args) {

		int[] num_list = new int[5];

		num_list[0] = 3;
		num_list[1] = 4;
		num_list[2] = 5;
		num_list[3] = 2;
		num_list[4] = 1;

		System.out.println(solution(num_list));

	}

	public static int solution(int[] arr) {

		int m = 0;

		int n = 0;

		for (int a : arr) {

			// 값을 하나씩 곱함
			m *= a;

			// 값을 하나씩 더함
			n += a;

		}

		// 더한 값을 제곱
		n = n * n;
		
		if(m < n) {
			
			return 1;
			
		}

		return 0;

	}

}
