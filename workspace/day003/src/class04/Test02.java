package class04;

public class Test02 {

	public static void main(String[] args) {
		int[] datas=new int[5];
		datas[0]=10;
		datas[1]=2;
		datas[2]=5;
		datas[3]=-3;
		datas[4]=1;
		
		System.out.print("[ ");
		for(int data:datas) {
			System.out.print(data+" ");
		}
		System.out.println("]");
		
		int minIndex=0; // 위치
		for(int i=1;i<datas.length;i++) {
			if(datas[minIndex] > datas[i]) {
				minIndex=i;
			}
		}
		System.out.println("최소값은 "+datas[minIndex]);
		System.out.println("위치는 ["+minIndex+"]");
		
		
	}

}
