package codingTest;


//https://school.programmers.co.kr/learn/courses/30/lessons/181942
//문자열 섞기

/* 문제 설명
 * 길이가 같은 두 문자열 str1과 str2가 주어집니다.
 * 두 문자열의 각 문자가 앞에서부터 서로 번갈아가면서 한 번씩 등장하는 문자열을 만들어 return 하는 solution 함수를 완성해 주세요.
 */

/* 제한사항
 * 1 ≤ str1의 길이 = str2의 길이 ≤ 10
 * str1과 str2는 알파벳 소문자로 이루어진 문자열입니다.
 */
public class Test02 {

	public static void main(String[] args) {
		
		//주어진 값 1
		String str1 = "aaa";
		
		//주어진 값 2
		String str2 = "bbb";
		
		//결과를 넣는 변수
		String answer = "";
		 
		//주어진 값 1의 길이만큼 반복
		for(int i = 0; i < str1.length(); i++)
		{
	        
			//주어진 값 1의 i번 글자와 주어진 값 2의 i번 글자를 합체
			answer += String.valueOf(str1.charAt(i)) + str2.charAt(i);
				
		}
		
		//출력
		System.out.print(answer);
		
	}

}
