package class04;

import java.util.Random;

public class Test06 {

	public static void main(String[] args) {
		
		// 일반검색
		// 1~10중에 5개의 정수를 저장
		
		Random rand=new Random();
		int[] datas=new int[5];
		for(int i=0;i<datas.length;i++) {
			datas[i]=rand.nextInt(5)+1; // 1~10
		}
		for(int data:datas) {
			System.out.print(data +" ");
		}
		System.out.println();
		
		
		int key=2; // 우리가 찾을 정수
		int keyIndex=-1; // 우리가 찾을 정수가 존재하는 위치.index
		// 검색시 초기화값은 "대상의 범위가 아닌값"으로 해야합니다!!!!!
		
		for(int i=0;i<datas.length;i++) {
			if(key == datas[i]) {
				keyIndex=i;
				System.out.println("찾았다!");
				break; // 찾았으면 즉시 종료
			}
		}
		
		
		if(keyIndex>=0) {
			System.out.println("찾는 값 "+key+"는 ["+keyIndex+"]에 있습니다.");
		}
		else {
			System.out.println(key+"은 없습니다...");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
