package class04;

public class Test02 
{

	public static void main(String[] args) 
	{
		
		//[10 2 5 -3 1]
		//최소값을 찾아주세요
		
		//최소값은
		//3번 index에 있는 -3입니다.
		//라고 출력해주세요
		
		int datas[] = {10, 2, 5, -3, 1};
		
		int minIndex = 0;
		
		for(int i=1; i<datas.length;i++) 
		{
			
			if(datas[i] < datas[minIndex]) 
			{
					
			    minIndex = i;
				
			}
			
		}
		
		System.out.print(minIndex + "번 index에 있는 " + datas[minIndex] + "입니다.");
		
	}

}
