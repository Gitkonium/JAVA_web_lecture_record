package codingTest;

// https://school.programmers.co.kr/learn/courses/30/lessons/181928

// 이어 붙인 수

// 문제 설명
// 정수가 담긴 리스트 num_list가 주어집니다. num_list의 홀수만 순서대로 이어 붙인 수와 짝수만 순서대로 이어 붙인 수의 합을 return하도록 solution 함수를 완성해주세요.

// 제한사항
// 2 ≤ num_list의 길이 ≤ 10
// 1 ≤ num_list의 원소 ≤ 9
// num_list에는 적어도 한 개씩의 짝수와 홀수가 있습니다.

// 입력 : [3, 4, 5, 2, 1]
// 출력 : 393

public class Test03 {

	public static void main(String[] args) {

		int[] num_list = new int[5];

		num_list[0] = 3;
		num_list[1] = 4;
		num_list[2] = 5;
		num_list[3] = 2;
		num_list[4] = 1;

		System.out.print(solution(num_list));

	}

	public static int solution(int[] num_list) {

		String oddNum = "";

		String evenNum = "";

		for (int x : num_list) {

			if (x % 2 == 0) {

				evenNum += Integer.toString(x);

			} else {
				
				
				oddNum += Integer.toString(x);

			}

		}
		
		return Integer.parseInt(evenNum) + Integer.parseInt(oddNum);

	}

}
