package class01;

public class Test01 {

	public static void main(String[] args) {
		int[] arr = new int[5];

		arr[0] = 100;
		arr[1] = 5;
		arr[2] = 60;
		arr[3] = 1000;
		arr[4] = 30;

		// [100,5,60,1000,30]

		for (int i = 1; i < arr.length; i++) {
			int key = arr[i]; // 기준값
			for (int j = i - 1; j > -1; j--) {
				//j-- 부분을 j++로 바꾸는 방향으로 작성할 수 있는지?
				if (arr[j] > key) {
					arr[j + 1] = arr[j];
					arr[j] = key;
					//[5,100,60,1000,30]
					//[5,60,100,1000,30]
					//[5,60,100,30,1000]
					//[5,60,30,100,1000]
					//[5,30,60,100,1000]
					
				}

			}
			for (int a:arr) {
				System.out.print(" "+a);
			}
			System.out.println();
			System.out.println();
		}

	}

}
