package bubbleSort;

public class Test01 {

	public static void main(String[] args) {

		int[] arr = new int[5];

		arr[0] = 3;

		arr[1] = 2;

		arr[2] = 5;

		arr[3] = 1;

		arr[4] = 4;

		for (int j = 0; j < arr.length; j++) 
		{

			for (int i = 0; i < arr.length - 1 - j; i++) 
			{

				if (arr[i] > arr[i + 1]) 
				{
					
					int temp = arr[i];

					arr[i] = arr[i + 1];

					arr[i + 1] = temp;

				}

			}

		}
		
		for(int ar : arr) 
		{
			
			System.out.println(ar);			
			
		}

	}

}
