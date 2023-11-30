package class01;

public class Test05 
{

	public static void main(String[] args) 
	{
		
		/* 디버깅표
		 * a a<5 i i<5 공백
		 * ===============
		 * 0  T  0  T   F  a==i F
		 *       1  T   F
		 *       2  T   F
		 *       3  T   F
		 *       5  F  
		 *       
		 * 1  T  0  T   T  
		 *       1  T   F
		 *       2  T   F
		 *       3  T   F
		 *       4  T   F  
		 *       5  F
		 *               
		 */
		
		
		
		for(int a=0;a<5;a++) 
		{
			
			for(int i =0;i<5;i++) 
			{
				
				if(i<a) 
				{
					
					System.out.print(" ");
					
				}
				else
				{
					
					System.out.print("*");
					
				}
				
			}
		
			System.out.println();
			
		}

	}

}
