package class04;

import java.util.Random;

public class Test06 {

	public static void main(String[] args) 
	{
		
		// 일반검색
		// 1~10중에 5개의 정수를 저장

		//랜덤 클래스 호출
		Random r = new Random();
		
		//배열 선언
		int[] datas = new int[5];
		
		//래열에 랜덤 숫자 넣기
		for(int i=0; i<datas.length;i++) 
		{
			
			datas[i] = r.nextInt(10) + 1;
			
		}
		
		//숫자 출력
		for(int data : datas) 
		{
			
			System.out.print(data + " ");
			
		}
		
		//줄바꿈
		System.out.println();
		
		//우리가 찾을 정수
		int key = 2;
		
		//우리가 찾을 정수가 존재하는 위치.index
		//검색 시 초기화 값은 "대상의 범위가 아닌 값"으로 해야한다.
		int keyIndex = -1;
		
		for(int i=0;i<datas.length;i++) 
		{
			
			if(key == datas[i]) 
			{
				
				keyIndex=i;
				
				System.out.println("찾았다");
				
				 break;
				
			}
			
		}
		
		if(keyIndex > -1) 
		{
				
			System.out.print("찾는 값 " + key + "는 [" + keyIndex + "]에 있습니다.");
			
		}

	}

}
