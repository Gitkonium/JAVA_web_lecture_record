package codingTest;

//https://school.programmers.co.kr/learn/courses/30/lessons/181939

//더 크게 합치기

/* 문제 설명
 * 연산 ⊕는 두 정수에 대한 연산으로 두 정수를 붙여서 쓴 값을 반환합니다. 예를 들면 다음과 같습니다.
 * 		12 ⊕ 3 = 123
 * 		3 ⊕ 12 = 312
 * 양의 정수 a와 b가 주어졌을 때, a ⊕ b와 b ⊕ a 중 더 큰 값을 return 하는 solution 함수를 완성해 주세요.
 * 단, a ⊕ b와 b ⊕ a가 같다면 a ⊕ b를 return 합니다.
 */

/* 제한사항
 * 1 ≤ a, b < 10,000
 */

// 입력 : 9, 91
// 출력 : 991

public class Test03 
{

	public static void main(String[] args) 
	{
		
		//주어진 값 1
		int a = 9;
		
		//주어진 값 2
		int b = 91;
		
		//새로운 숫자를 변수에 저장
		int newInt = s(a, b);
		
		//출력
		System.out.print(newInt);
		
	}
	
	public static int s(int a, int b) 
	{
		
		//새로운 숫자를 담는 변수
		int newInt = 0;
		
		//새로운 문자열을 담는 변수
		String newStr = "";

		//a숫자를 문자열로 변환
		String a2 =  Integer.toString(a);
		
		//b숫자를 문자열로 변환
		String b2 =  Integer.toString(b);
		
		//문자열로 변환한 숫자a,b를 합체
		newStr = a2 + b2;
		
		//새로운 문자열을 숫자로 변환
		newInt = Integer.parseInt(newStr);
		
		//새로운 숫자를 반환
		return newInt;
		
	}

}
