package codingTest;

//https://school.programmers.co.kr/learn/courses/30/lessons/181941

//문자 리스트를 문자열로 변환하기

/* 문제 설명
 * 문자들이 담겨있는 배열 arr가 주어집니다. arr의 원소들을 순서대로 이어 붙인 
 * 문자열을 return 하는 solution함수를 작성해 주세요.
 */

/* 제한사항
 * 1 ≤ arr의 길이 ≤ 200
 * arr의 원소는 전부 알파벳 소문자로 이루어진 길이가 1인 문자열입니다.
 */

// 입력 : ["a","b","c"]
// 출력 : abc
public class Test01 
{

	public static void main(String[] args) 
	{
		
		//배열 선언
		String[] arr = {"a","b","c"};
		
		//함수가 리턴한 결과 값 변수에 담기
		String newStr = ad(arr);
		
		//출력
		System.out.print(newStr);
		
		
	}

	//원소들을 순서대로 이어 붙인 문자열을 return 하는 함수
	public static String ad(String[] arr) 
	{
		
		//새로운 문자열을 담는 변수
		String newStr = "";
		
		//문자열을 하나씩 꺼냄
		for(String s : arr) 
		{
			
			//합체
			newStr += s;
			
		}
		
		//새로운 문자열을 반환
		return newStr;
		
	}

}
