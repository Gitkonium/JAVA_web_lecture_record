package class01;

public class Test02 {

	public static void main(String[] args) {

		// 배열 선언
		int[] datas = new int[5];

		// 값 넣기
		datas[0] = 5;
		datas[1] = 3;
		datas[2] = 1;
		datas[3] = 4;
		datas[4] = 2;

		 // 마지막 자리는 자동 정렬 되므로 arr.length - 1
		 for (int i = 0; i < datas.length - 1; i++) 
		 {

		 		// 현재 인덱스 값을 최소값이라 가정
		      	int minIndex = i;

		      	// 기준 값을 마지막 인덱스 값까지 비교한다.
		       	for (int j = i + 1; j < datas.length; j++) 
		        {
		                
		                // 기준 값이 더 크다면
		                if (datas[j] < datas[minIndex]) 
		                {
		                
		                	// 최소값 교체
		                	minIndex = j;
		                    
		            	}
		      	}
		        
		        // 기준 값을 임시저장
		        int temp = datas[i];
				
		        // 기준 값 자리에 최소값을 넣기
		        datas[i] = datas[minIndex];

				// 최소값 자리에 기준 값 넣기
		        datas[minIndex] = temp;

		  }
		 
		 //출력
		 for(int data : datas) {
			 
			 System.out.print(data + " ");
			 
		 }
		
	}

}
