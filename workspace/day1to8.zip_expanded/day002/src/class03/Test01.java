package class03;

public class Test01
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		//[문제1] 
		//i가 1
		//i가 3씩 증가
		//i의 변화를 출력. 단 출력값은 1부터
		//i가 20이 넘어갈 때 까지 계속
		
		int i = 1;
		
		while(true) 
		{
			
			System.out.println(i);
			
			i += 3;
			
			if(i<=20) 
			{
				
				break;
				
			}
			
		}
		
		/**디버깅표
		 * i     i<=20
		 * ===============
		 * 1       T
		 * 4	   T
		 * 7       T
		 * 10      T
		 * 13      T
		 * 16      T
		 * 19      T
		 * 22      F 
		 **/
		
		//[문제2]
		//i는 3입니다.
		//i를 영원히 마이너스
		//i의 변화를 출력. 단, 출력값은 2부터
		//i가 -5가 되면 종료
		
		i = 3;
		
		while(true) 
		{
			
			i--;
			
			System.out.println(i);
			
			if(i == -5) 
			{
				
				break;
				
			}
			
		}
		
		/**디버깅표
		 * i     i == -5
		 * ===============
		 * 2       T
		 * 1	   T
		 * 0       T
		 *-1       T
		 *-2       T
		 *-3       T
		 *-4       T
		 *-5       T 
		 **/

	}

}
