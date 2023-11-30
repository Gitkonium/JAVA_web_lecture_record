package class04;

import java.util.Random;

public class Test05 
{

	public static void main(String[] args) 
	{
		
		//랜덤 정수를 5개 저장할 수 있는 배열
		//1~6까지 랜덤하게 저장
		
		//1)2가 몇 번 나왔는지
		//2)총합이 몇인지
		//3)평균이 몇인지 >> 0.00 소수점까지
		//출력해주세요.
		
		//배열 선언
		int[] datas = new int[5];
		
		//랜덤 클래스 호출
		Random random = new Random();
		
		//배열에 랜덤 숫자 넣기
		for(int i=0;i<datas.length;i++) 
		{
			
			datas[i] = random.nextInt(6) + 1;
			
		}
		
		//--------------------------------------------------
		
		//2가 몇 번 나왔는지 구하기
		int count = 0;
		
		for(int data : datas) 
		{
			
			if(data == 2) 
			{
				
				count++;
				
			}
			
		}
		
		System.out.println("2가 " + count + "번 나왔습니다.");
		
		//--------------------------------------------------
		
		//총합 구하기
		int total = 0;
		
		for(int data : datas) 
		{
			
			total += data;
			
		}
		
		System.out.println("총합은 " + total + "입니다.");
		
		//--------------------------------------------------
		
		//평균 구하기
		double avg = 0;
		
		for(int data : datas) 
		{
			
			avg = total*1.00 / datas.length;
			
		}
		
		System.out.println("평균은 " + avg + "입니다.");
	
	}

}
