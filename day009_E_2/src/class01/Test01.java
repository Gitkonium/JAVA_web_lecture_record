package class01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://school.programmers.co.kr/learn/courses/30/lessons/181923

// 수열과 구간 쿼리 2

// 문제 설명
// 정수 배열 arr와 2차원 정수 배열 queries이 주어집니다. queries의 원소는 각각 하나의 query를 나타내며, [s, e, k] 꼴입니다.
// 각 query마다 순서대로 s ≤ i ≤ e인 모든 i에 대해 k보다 크면서 가장 작은 arr[i]를 찾습니다.
// 각 쿼리의 순서에 맞게 답을 저장한 배열을 반환하는 solution 함수를 완성해 주세요.
// 단, 특정 쿼리의 답이 존재하지 않으면 -1을 저장합니다.

// 제한사항
// 1 ≤ arr의 길이 ≤ 1,000
// 		0 ≤ arr의 원소 ≤ 1,000,000
// 1 ≤ queries의 길이 ≤ 1,000
// 		0 ≤ s ≤ e < arr의 길이
//		0 ≤ k ≤ 1,000,000

// 입력 : [0, 1, 2, 4, 3], [[0, 4, 2],[0, 3, 2],[0, 2, 2]]
// 출력 : [3, 4, -1]

public class Test01 {

	public static void main(String[] args) {

		// 크기 5의 배열 선언
		int[] arr = new int[5];

		// 배열 초기화
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;
		arr[4] = 3;

		// 2차원 배열 선언 및 초기화
		int[][] queries = new int[][] { { 0, 4, 2 }, { 0, 3, 2 }, { 0, 2, 2 } };

		// 리턴 값을 하나씩 출력
		for (Integer x : soulution(arr, queries)) {

			System.out.println(x);

		}

	}

	public static int[] soulution(int[] arr, int[][] queries) {

		int[] answer = new int[queries.length];

		Arrays.fill(answer, -1);

		for (int i = 0; i < queries.length; i++) {

			int s = queries[i][0];

			int e = queries[i][1];

			int k = queries[i][2];

			int minGreaterValue = Integer.MAX_VALUE;

			for (int j = s; j <= e; j++) {

				if (arr[j] > k && arr[j] < minGreaterValue) {

					minGreaterValue = arr[j];

				}

			}

			if (minGreaterValue != Integer.MAX_VALUE) {

				answer[i] = minGreaterValue;

			}

		}

		return answer;

	}

}
