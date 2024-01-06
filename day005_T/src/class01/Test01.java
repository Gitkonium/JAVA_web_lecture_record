package class01;

public class Test01 {

	
	public static void main(String[] args) {
		
		
		
		int[] ar = {3,2,5,1,4};
		
		int[] arr= new int[5];
		arr[0]=3;
		arr[1]=2;
		arr[2]=5;
		arr[3]=1;
		arr[4]=4;
		
		
		// 정렬을 몇번할지 결정하는 반복문
		// 배열의 요소개수만큼 수행하겠다! == 5번 정렬하겠다!
		for (int j = 0; j < ar.length; j++) {
			boolean flag = true;
			
			
			// 배열을 1회 정렬할때 사용되는 반복문
			for (int i = 0; i < ar.length-1-j; i++) {
				// 임시 저장변수, 임시 변수
				// 변수값들을 서로 교환하려면 반드시 tmp가 필요함!
				// tmp,temp 변수명이 발견된다면?
				// 아~ 교환하려나보다~~ 예상가능함
				
				if(ar[i]>ar[i+1]) {
					int temp = ar[i];
					ar[i] = ar[i+1];
					ar[i+1]=temp;
					flag = false;
				}
			}
			// 1번 정렬을 마친상태 == 1회전 정렬이 끝났다.
			
			
			
			
			if(flag) {
				break;
			}
			
			
			for (int p = 0; p < ar.length; p++) {
				System.out.print(ar[p]+" ");
			}

			System.out.println();
		}
		
		
				
				
	}

}
