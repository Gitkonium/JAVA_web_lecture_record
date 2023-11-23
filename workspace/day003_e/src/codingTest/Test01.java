package codingTest;

// https://school.programmers.co.kr/learn/courses/30/lessons/181943
// 문자열 겹쳐쓰기

/* 문제 설명
 * 문자열 my_string, overwrite_string과 정수 s가 주어집니다. 
 * 문자열 my_string의 인덱스 s부터 overwrite_string의 길이만큼을 
 * 문자열 overwrite_string으로 바꾼 문자열을 return 하는 solution 함수를 작성해 주세요.
 */

/* 제한사항
 * my_string와 overwrite_string은 숫자와 알파벳으로 이루어져 있습니다.
 * 1 ≤ overwrite_string의 길이 ≤ my_string의 길이 ≤ 1,000
 * 0 ≤ s ≤ my_string의 길이 - overwrite_string의 길이
 */

public class Test01 
{

	public static void main(String[] args) 
	{
		
		//주어진 값 1
		String my_string = "He11oWor1d";
		
		//주어진 값 2
		String overwrite_string = "lloWorl";
		
		//주어진 값 3
		int s = 2;
		
		solution(my_string, overwrite_string, s);

	}
	
	//글자를 겹친 결과를 반환하는 메소드
	public static String solution(String str1, String str2, int s) 
	{ 
		
		//주어진 값 1의 0번부터 2번 까지의 문자열과 주어진 값 2의 문자열을 합체
		String answer = str1.substring(0, s) + str2;
		
		//주어진 값1의 길이가 결과 값보다 길다면
        if(str1.length() > answer.length()) {
        	
            answer += str1.substring(answer.length());
        }
        
        System.out.print(answer);
        
        return answer;
        
	}

}
