package class04;

import java.util.Random;

//우리가 원하는대로 값 저장하기
// 1. 랜덤값 저장
// 2. 외부에서 값을 입력받는 방법
public class Test03 
{

	public static void main(String[] args) 
	{
		
		
		int[] datas = new int[5];
		
		//int, double, String 등은 원시 타입이라 바로 값 저장 가능
		//int[], Random(클래스, 객체) 등은 힙 메모리 영억에서 생성하여 사용할 수 있음
		// == new 연산자를 사용해야만 한다.
		//Random, Scanner 등 이미 만들어진 클래스(객체) 들이 엄청 많음
		//클래스가 너무 많긴 때문에 라이브러리에 저장되어 있다.
		//ctrl + shift + O => 자동 import
		Random random = new Random();
		
		for(int i=0; i <datas.length;i++) 
		{
			
			//random.nextInt(1000) => 0~999중 랜덤
			datas[i] = random.nextInt(1000);
			
		}
		
		for(int data : datas) 
		{
			
			System.out.print(data + " ");
			
		}

	}

}
