package codingTest;

//https://school.programmers.co.kr/learn/courses/30/lessons/181949
//대소문자 바꿔서 출력하기
//영어 알파벳으로 이루어진 문자열 str이 주어집니다. 각 알파벳을 대문자는 소문자로 소문자는 대문자로 변환해서 출력하는 코드를 작성해 보세요.
//입력 : aBcDeFg
//출력 : AbCdEfG
public class Test04 
{

	public static void main(String[] args) 
	{
		
		// TODO Auto-generated method stub
		
		int i = 0;
		
		//주어진 문자열
		String str = "aBcDeFg";
		
		//글자를 잘라 배열에 넣음
		char[] charArray = str.toCharArray();
		
		//배열 길이 만큼 반복
		while(i < charArray.length) 
		{
			
			//글자가 대문자일 경우
			if(Character.isUpperCase(charArray[i]) == true) 
			{
				
				//글자를 소문자로 변환
				charArray[i] = Character.toLowerCase(charArray[i]);
			
			}
			//글자가 소문자일 경우
			else if(Character.isLowerCase(charArray[i]) == true) 
			{
				
				//글자를 대문자로 변환
				charArray[i] = Character.toUpperCase(charArray[i]);
				
			}
			
			//i 1증가
			i++;
			
		}
		
		//새로운 반복을 위해 i를 0으로 초기화
		i = 0;
		
		//기존 문자열 삭제
		str = "";
		
		while(i < charArray.length) 
		{
			
			//글자 합치기
			str += charArray[i];
			
			//i 1증가
			i++;
			
		}
		
		//완성된 글자 출력
		System.out.print(str);
		
	}

}
