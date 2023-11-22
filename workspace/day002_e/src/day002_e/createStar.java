package day002_e;

public class createStar 
{

	public static void main(String[] args) 
	{
			
		//별찍기(반쪽짜리 역삼각형)
		
		/* ***** 
		 *  **** 
		 *   ***
		 *    **
		 *     *
		 */
		
		//i가 4가 될 때까지 반복
		for(int i=0; i<5; i++) 
		{
			
			//j가 i보다 작을 동안만 반복
			//i의 두 번째 반복부터 작동
			//두 번째 반복부터 공백을 만듬
			for(int j=0; j<i; j++) 
			{
				
				System.out.print(" ");
				
			}

			//역삼각형이기에 l은 5부터 시작
			//i가 0일 경우, 5번 반복 => 별5개 출력
			//i가 1일 경우, 4번 반복 => 별4개 출력
			for(int l=5; l>i; l--) 
			{
				
				System.out.print("*");
				
			}
			
			//i 반복이 한번 끝났을 때 줄바꿈을 출력
			System.out.println();
			
		}
	
	}

}
