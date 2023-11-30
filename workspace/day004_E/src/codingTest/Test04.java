package codingTest;


// https://school.programmers.co.kr/learn/courses/30/lessons/181938

// 두 수의 연산값 비교하기

/* 문제 설명
 * 연산 ⊕는 두 정수에 대한 연산으로 두 정수를 붙여서 쓴 값을 반환합니다. 예를 들면 다음과 같습니다.
 *		12 ⊕ 3 = 123
 *		3 ⊕ 12 = 312
 * 양의 정수 a와 b가 주어졌을 때, a ⊕ b와 2 * a * b 중 더 큰 값을 return하는 solution 함수를 완성해 주세요.
 * 단, a ⊕ b와 2 * a * b가 같으면 a ⊕ b를 return 합니다.
 */

/* 제한사항
 * 1 ≤ a, b < 10,000
 */

// 입력 : 2, 91
// 출력 : 364

public class Test04 
{

	public static void main(String[] args) 
	{
		
		int a = 2;
		
		int b = 91;
		
		System.out.println(s(a,b));
		
	}
	
	public static int s(int a, int b) 
	{
		
		//새로운 숫자를 담는 변수
		int newInt = 0;
		
		//새로운 숫자를 담는 변수
		int newInt2 = 0;
		
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
		
		newInt2 = 2*a*b;
		
		if(newInt > newInt2) 
		{
			
			return newInt;
			
		}
		else
		{
			
			return newInt2;
			
		}
		
	}

}
