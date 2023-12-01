package day009_E;

// https://school.programmers.co.kr/learn/courses/30/lessons/181924

// 수열과 구간 쿼리 3

// 문제 설명
// 정수 배열 arr와 2차원 정수 배열 queries이 주어집니다. queries의 원소는 각각 하나의 query를 나타내며, [i, j] 꼴입니다.
// 각 query마다 순서대로 arr[i]의 값과 arr[j]의 값을 서로 바꿉니다.
// 위 규칙에 따라 queries를 처리한 이후의 arr를 return 하는 solution 함수를 완성해 주세요.

// 제한사항
// 1 ≤ arr의 길이 ≤ 1,000
//		0 ≤ arr의 원소 ≤ 1,000,000
// 1 ≤ queries의 길이 ≤ 1,000
//		0 ≤ i < j < arr의 길이

// 입력 : [0, 1, 2, 3, 4], [[0, 3],[1, 2],[1, 4]]
// 출력 : [3, 4, 1, 0, 2]

public class Test02 {

	public static void main(String[] args) {

		int[] arr = new int[5];
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 3;
		arr[4] = 4;
		
		int[][] queries = new int[][] {{0,3},{1,2},{1,4}};
		
		for(int x : solution(arr, queries)) {
			
			System.out.println(x);
			
		}

	}
	
	public static int[] solution(int[] arr, int[][] queries) {
		
		for(int i=0;i<queries.length;i++) {
			
			int[] newArr = queries[i];
			
			int num1 = arr[newArr[0]];
			
			int num2 = arr[newArr[1]];
					
			arr[newArr[0]] = num2;
			
			arr[newArr[1]] = num1;
			
		}
		
		return arr;
		
	}

}
