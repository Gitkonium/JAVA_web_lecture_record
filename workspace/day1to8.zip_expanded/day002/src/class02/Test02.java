package class02;

public class Test02 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		int i = 1;
		while(i < 5) 
		{
			
			i++;
			
			i*=-1;
			
			System.out.println("i= " + i);
			
		}
		
		System.out.println("최종 i= " + i);
		
		/**디버깅표
		 * i     i < 5     i*=-1
		 * ======================
		 * 1       T
		 * 2                 -2
		 *-2       T         
		 *-1                  1
		 * 1       T          
		 * 2                 -2        
		 **/
		
		//결과는 무한히 반복되기에 반복문을 탈출하지 못 하고 최종  i값은 도출 할 수 없다.
		//반복문은 조건식에 따라 루프가 무한히 실행될 수 있다.
		//while은 일부러 무한루프문을 만들어서 사용할때에 가장많이 활용됨
		
	}

}
