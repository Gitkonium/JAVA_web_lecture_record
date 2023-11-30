package class01;

//버블정렬
public class Test01 
{

	public static void main(String[] args) 
	{
		
		int[] ar = {3,2,5,1,4};
		 
		// 정렬을 몇 번할지 결정하는 반복문
		//배열의 요수 개수 만큼 수행하겠다.
		for (int j = 0; j < ar.length; j++) 
		{
	    	  
			boolean flag = true;
			
			// 배열 1회 정렬할 떼 사용되는 반복문
			for (int i = 0; i < ar.length-1-j; i++) 
			{
				
				// 임시 저장변수, 임시 변수
				// 변수값들을 서로 교환하려면 반드시
				int temp = 0;
	            
				if(ar[i]>ar[i+1]) 
				{
	            	
					temp = ar[i];
	               
					ar[i] = ar[i+1];
	               
					ar[i+1]=temp;
	               
					flag = false;
					
				}
	            
			}
	         
			if(flag) 
			{
	        	 
				break;
	            
			}
	         
			for (int p = 0; p < ar.length; p++) 
			{
	        	 
				System.out.print(ar[p]+" ");
	            
			}

			System.out.println();
	         
		}
	      
	}
	
}
