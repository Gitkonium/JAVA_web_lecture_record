package codingTest;

import java.util.Random;

//https://school.programmers.co.kr/learn/courses/30/lessons/181944
//홀짝 구분하기
//자연수 n이 입력으로 주어졌을 때 만약 n이 짝수이면 "n is even"을, 홀수이면 "n is odd"를 출력하는 코드를 작성해 보세요.
//입력 : 랜덤 숫자
//출력 : "n is even" 혹은 "n is odd"를 출력
public class Test08 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		//랜덤 함수 호출
		Random random = new Random();
		
		//랜덤한 정수를 변수에 넣기
		int n = random.nextInt(10);
		
		//짝수일 경우
		if(n%2 == 0) 
		{
			
			System.out.println(n + " is even");
			
		}
		//짝수가 아닐 경우
		else 
		{
			
			System.out.println(n + " is odd");
			
		}

	}

}
