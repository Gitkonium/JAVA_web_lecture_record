package insertionSort;

public class InsertionSort01 
{

	public static void main(String[] args) 
	{
		
		//배열 선언
		int[] arr = {100,5,60,1000,30};
				
		//비교 기준 값을 넣는 변수
		int key;
				
		//1번 인덱스 부터 반복
		//기준 값 꺼내기 
		for(int i=1;i<arr.length;i++) 
		{
					
		        //기준 값 지정
			key = arr[i];
					
			int j;
					
			//0번 인덱스 부터 반복
		        //비교 값 꺼내기
			for(j=i-1;j>=0;j--) 
			{
						
				//비교 값이 기준 값보다 크다면
				if(arr[j] > key) 
				{
							
					//비교 값을 한 칸 뒤로 넣는다
					arr[j + 1] = arr[j];	
							
					//원래 비교 값 자리에 기준 값을 넣는다.
					arr[j] = key;
							
				}
					
			}
			
		}
		
		//정렬 된 데이터 출력
		for(int a : arr) 
		{
			
			System.out.println(a);
			
		}
		
	}

}
