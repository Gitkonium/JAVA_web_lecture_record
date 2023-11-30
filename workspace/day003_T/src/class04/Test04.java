package class04;

import java.util.Random;

public class Test04 {

	public static void main(String[] args) {
		
		
		// 3개의 랜덤 정수를 저장해주세요.
		// 랜덤값은 1~10까지 중에서 저장됩니다.
		
		int[] datas=new int[3];
		Random rand=new Random();
		for(int i=0;i<datas.length;i++) {
			datas[i]=rand.nextInt(10) + 1;
			// 0~9
			// 1~10
		}
		
		for(int data:datas) {
			System.out.println(data);
		}
		
		
	}

}
