package class01;

// 가장 쉬운(기본인) 정렬 로직 3가지
// 과제는 코드를 직접 작성하고, 디버깅표 직접 그려보기

public class Test01 {

	public static void main(String[] args) {
		int [] arr = new int [5];
		
		arr[0] = 5;
		arr[1] = 3;
		arr[2] = 1;
		arr[3] = 4;
		arr[4] = 2;
		
		for (int a = 0; a < arr.length-1; a++) {
			int minIndex=a;
			for (int i = a+1; i < arr.length; i++) {
				if(arr[minIndex]>arr[i]) {
					minIndex =i;
				}
			}
			int temp = arr[a];
			arr[a] = arr[minIndex];
			arr[minIndex] = arr[a];
			for(int data: arr) {
				System.out.println(data+" ");
			}
			System.out.println();
		}
	}

}
