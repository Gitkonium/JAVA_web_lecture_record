package class05;

//중첩제어문
public class Test01 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		int a = 10;
		
		if(a > 0) 
		{
			
			if(a%2 == 0) 
			{
				
				if(a < 100) 
				{
					
					System.out.println("헬로");
					
				}
		
			}
			
		}
		
		if(a>0 && a%2 == 0 && a < 100)
		{
			
			System.out.println("헬로");
			
		}

	}

}
