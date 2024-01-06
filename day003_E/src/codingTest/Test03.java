package codingTest;

//https://school.programmers.co.kr/learn/courses/30/lessons/181941
//문자 리스트를 문자열로 변환하기

/* 문제 설명
 * 문자들이 담겨있는 배열 arr가 주어집니다. arr의 원소들을 순서대로 이어 붙인 문자열을 return 하는 solution함수를 작성해 주세요.
 */

/* 제한사항
 * 1 ≤ arr의 길이 ≤ 200
 * arr의 원소는 전부 알파벳 소문자로 이루어진 길이가 1인 문자열입니다.
 */

public class Test03 
{

	public static void main(String[] args) 
	{
		
		//배열선언
		String[] str = {"a", "b", "c"};
		
		//메소드의 리턴값을 변수에 저장
		String a = solution(str); 
		
		//출력
		System.out.print(a);
		
	}
	
	//배열의 요소를 합친 결과를 반환하는 메소드
	public static String solution(String[] arr) 
	{
		
		//결과 값을 넣을 변수
		String str = "";
		
		//배열 길이만큼 반복
		for(String s : arr) 
		{
			
			//글자를 하나씩 합체
			str += s;
	
		}
		
		//결과 값 리턴
		return str;
		
	}

}
