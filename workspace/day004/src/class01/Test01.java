package class01;

import java.util.Random;

// 복습할 내용
// 1. 별찍기
// 2. 배열 forEach
// 3. 배열에서 값 찾기
public class Test01 {

	public static void main(String[] args) {


		for(int a=0;a<4;a++) {
			for(int i=0;i<=a;i++) {
				System.out.print("*");
			}
			System.out.println();
		}

		// 가로별..
		// 그걸 몇번 반복하는지?(세로)
		// 디버깅표를 먼저 그리고,
		// 그 다음 코드 완성!

		
		
		
		
		
		
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		// 배열 사용시 3요소를 모두 만족했는지 반드시 확인!
		int[] datas=new int[3];
		datas[0]=10;
		datas[1]=20;
		datas[2]=30;
		 // [ 10 20 30 ]
		 // [10] [20] [30]
		
		// 반복문 사용시
		//  while VS for 잘 선택하기!
		System.out.print("[ ");
		for(int i=0;i<datas.length;i++){
			System.out.print(datas[i]+" ");
		}
		System.out.println("]");
		
		// 배열과 for문이 잘 어울리므로
		// forEach문을 제공
		for(int data:datas) {
			System.out.println("배열의 요소 : "+data);
		}
		
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		Random rand=new Random();
		int[] numArr=new int[5];
		for(int i=0;i<numArr.length;i++) {
			numArr[i]=rand.nextInt(10)+1;
			// 1~10
			
			// 23~40
			// 0~17 + 23
			// rand.nextInt(18)+23
		}
		
		for(int num:numArr) {
			System.out.print(num+" ");
		}
		System.out.println();
		
		
		int key=5;
		int keyIndex=-1; // 초기화 할 값은 범위밖에서 찾아야한다!
		for(int i=0;i<numArr.length;i++) {
			if(key==numArr[i]) {
				System.out.println("찾았다!");
				keyIndex=i;
				break; // 가장 먼저 찾은 요소만 출력됨
			}
		}
		
		if(keyIndex >= 0) {
			System.out.println(key+"의 위치는 ["+keyIndex+"] 입니다.");
		}
		else {
			System.out.println(key+"는 없습니다...");
		}
		
		
		






	}

}
