package class01;

import java.util.Random;

public class Test01 
{

	public static void main(String[] args) 
	{
		
		//배열 선언
		int[] arr = {10000,2000,100000,1000,30};
		
		//비교 기준값을 넣는 변수
		int key;
		
		//1번 인덱스 부터 반복
		for(int i=1;i<arr.length;i++) 
		{
			
			//비교 기준 값 지정
			key = arr[i];
			
			int j;
			
			//0번 인덱스 부터 반복
			for(j=i-1;j>=0;j--) 
			{
				
				//비교 값이 기준 값보다 크다면
				if(arr[j] > key) 
				{
					
					//비교 값을 한 칸 뒤로 넣는다
					arr[j + 1] = arr[j];	
					
					//원래 비교 값 자리에 기준 값을 넣는다.
					arr[j] = key;
					
				}
			
			}
	
		}
		
		for(int a : arr) 
		{
			
			System.out.println(a);
			
		}

	}

}
