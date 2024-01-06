package codingTest;

//https://school.programmers.co.kr/learn/courses/30/lessons/181940

//문자열 곱하기

/* 문제 설명
 * 문자열 my_string과 정수 k가 주어질 때, my_string을 k번 
 * 반복한 문자열을 return 하는 solution 함수를 작성해 주세요.
 */

/* 제한사항
 * 1 ≤ my_string의 길이 ≤ 100
 * my_string은 영소문자로만 이루어져 있습니다.
 * 1 ≤ k ≤ 100
 */

// 입력 : string, 3
// 출력 : stringstringstring
public class Test02 
{

	public static void main(String[] args) 
	{
		
		//주어진 값1
		String my_string = "string";
		
		//주어진 값2
		int k = 3;
		
		System.out.println(solution(my_string,k));

	}
	
	//k번 반복한 문자열을 return 하는 함수
	public static String solution(String my_string, int k) 
	{
		
		//새로운 문자열을 담는 변수
		String newStr = "";
		
		//k번 반복하여 문자를 합체
		for(int i=0;i<k;i++) 
		{
			
			//문자 합체
			newStr+= my_string;
			
		}

		//새로운 문자열을 반환
		return newStr;
		
	}

}
