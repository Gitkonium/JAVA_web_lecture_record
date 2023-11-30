package class05;

public class Test06 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		//[문제1]
		//반 삼각형
		
		//[문제2]
		//반 역삼각형
		
		/*[2]디버깅표
		 * y     y>=0     x     ???
		 * =========================
		 * 4      T       4      T
		 * 				  3      T 	
		 *                2      T
		 *                1      T
		 *                0      T
		 * 3      T       3      T
		 *                2      T
		 *                1      T
		 *                0      T
		 * 2      T       2      T
		 * 				  1      T
		 *                0      T
		 * 1      T       1      T
		 *                0      T
		 * 0      T       0      T                	
		 */
		
//		 for(int y = 4; y>=0; y--) 
//		 {
//			 
//			 for(int x = 0; x<=y; x++) 
//			 {
//				 
//				 System.out.print("*");
//				 
//			 }
//			 
//			 System.out.println("");
//			 
//		 }
		
		//[문제3]
		//반대 역삼각성

		for(int y = 0; y<=5; y++) 
		{
			
			for(int x=0; x<5; x++) 
			{
				
				System.out.print("*");
				
			}
			
			System.out.println("");
			
		}
			

	}

}
