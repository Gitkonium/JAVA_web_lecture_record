package codingTest;

//https://school.programmers.co.kr/learn/courses/30/lessons/181945
//문자열 돌리기
//문자열 str이 주어집니다.
//문자열을 시계방향으로 90도 돌려서 아래 입출력 예와 같이 출력하는 코드를 작성해 보세요.
//입력 : abcde
/*출력 : a
 *	    b
 *	    c
 *	    d
 *	    e
 */
public class Test07 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		//주어진 값
		String str = "abcde";
		
		//글자를 잘라 배열에 넣음
		char[] charArray = str.toCharArray();
		
		//배열 길이만 큼 반복
		for(int i=0; i<charArray.length; i++) 
		{
			
			//배열의 i번째 데이터를 꺼내서 출력 및 줄바꿈
			System.out.println(charArray[i]);
			
		}

	}

}
