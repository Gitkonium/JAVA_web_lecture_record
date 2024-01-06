package class04;

import java.util.Random;

// 우리가 원하는대로 값 저장하기
// 1. 랜덤값 저장
// 2. 외부에서 값을 입력받는 방법
public class Test03 {

	public static void main(String[] args) {
		
		int[] datas=new int[5];
		
	
		Random rand=new Random();
		// ctrl+shift+O
		// 자동 import 임포트
		
		for(int i=0;i<datas.length;i++) {
			datas[i] = rand.nextInt(1000);
			// rand.nextInt(1000)
			// 0~999
		}
		
		System.out.print("[ ");
		for(int data:datas) {
			System.out.print(data+" ");
		}
		System.out.println("]");
		
		
		
		
		
		
		
		
		
		
		
	}

}
