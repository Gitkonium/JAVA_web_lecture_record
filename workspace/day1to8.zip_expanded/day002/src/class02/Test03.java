package class02;

public class Test03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int i = 0;
		
		while(true) 
		{
			
			System.out.println("계속1");
			
			i++;
			
			//무한루프문은 반드시 종료조건과 함께 사용해야함
			if(i < 3) 
			{
				
				System.out.println("계속2");
				
				break;
				
			}
			
			System.out.println("계속3");
			
		}

	}

}
