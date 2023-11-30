package class04;

import java.util.Random;

public class Test02 
{
	
//	문제1) funcB() 함수가 있습니다.
//	funcB()는 int 변수를 2개 입력값으로 받아와서
//	둘의 합을 Console에 출력하는 함수입니다.
	
	public static void funcB(int a, int b) 
	{
		
		int result = a + b;
		
		System.out.println(result);
		
	}

//	문제2) funcC() 함수가 있습니다.
//	funcC()는 랜덤정수 3개(랜덤 범위 1~10)를 생성하고
//	생성된 3개의 정수 평균값(xx.xxxxxx의 형태)을
//	반환하는 함수입니다.
	
	public static double funcC() 
	{
		
		Random r = new Random();
		
		int[] datas = new int[3];
		
		for(int i =0; i<datas.length;i++) 
		{
			
			datas[i] = r.nextInt(10) + 1;
			
		}
		
		int total = 0;
		
		for(int data : datas) 
		{
			
			total += data;
			
		}
		
		
		double avg = total*1.00 / 3;
		
		return avg;
		
	}

//	문제3) funcD() 함수가 있습니다.
//	funcD()는 int 변수를 2개 입력값으로 받아와서
//	둘중 더 큰 정수를 Console에 출력하는 함수입니다.
//	단, 둘의 크기가 동일하면 그냥 그 값을 출력합니다.

	public static void funcD(int a, int b) 
	{
		
		if(a > b) 
		{
			
			System.out.println(a);
			
		}
		else if(a < b) 
		{
			
			System.out.println(b);
			
		}
		else if(a == b) 
		{
			
			System.out.println(a);
			
		}
		
	}
	
	public static void main(String[] args) 
	{
		
		funcB(10,20);
		
		System.out.println(funcC());
		
		funcD(30,60);
		
	}

}
