package codingTest;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/181927

// 마지막 두 원소

// 문제 설명
// 정수 리스트 num_list가 주어질 때, 마지막 원소가 그전 원소보다 크면 마지막 원소에서 그전 원소를 뺀 값을
// 마지막 원소가 그전 원소보다 크지 않다면 마지막 원소를 두 배한 값을 추가하여 return하도록 solution 함수를
// 완성해주세요.

// 제한사항
// 2 ≤ num_list의 길이 ≤ 10
// 1 ≤ num_list의 원소 ≤ 9


// 입력 : [2, 1, 6]
// 출력 : [2, 1, 6, 5]
public class Test01 {

	public static void main(String[] args) {
		
		// 배열 선언
		int[] num_list = new int[3];
		
		// 배열에 값 넣기
		num_list[0] = 2;
		num_list[1] = 1;
		num_list[2] = 6;
		
		// 리턴 값을 하나씩 꺼내서 출력
		for(int x : solution(num_list)) {
			
			System.out.println(x);
			
		}

	}
	
	public static int[] solution(int[] num_list) {	
		
		// 배열의 마지막 값이 바로 앞 값도 크다면
		if(num_list[num_list.length - 1] > num_list[num_list.length - 2]) {
			
			// 마지막 값에서 바로 앞 값을 뺀다.
			int result = num_list[num_list.length - 1] - num_list[num_list.length - 2];
			
			// 배열 사이즈를 하나 늘린 새로운 배열 선언
			int[] newArray = Arrays.copyOf(num_list, 4);
			
			// 배열 마지막에 뺀 값을 넣는다.
			newArray[newArray.length - 1] = result;
			
			// 값 반환
			return newArray;
			
		}
		
		return num_list;
		
	}

}
