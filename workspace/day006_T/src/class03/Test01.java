package class03;

import java.util.Random;
import java.util.Scanner;

public class Test01 {
	
	public static void sample(int[] stuArr,int index) { // 샘플 데이터 추가
		// stuArr[index++]=80;
		Random rand=new Random();
		stuArr[index++]=rand.nextInt(101); // 0~100
		System.out.println();
		System.out.println((index+1)+"번학생의 점수는 "+stuArr[index]+"점입니다.");
		System.out.println((index+1)+"번학생 추가완료!");
		System.out.println();
		// ① 빨간밑줄 ▷ 인자로 데려와야하는 변수
		// ② main()에서도 적용이 되었는지 확인
		//   : main()측의 index는 변경되지 못함!
		// ③ return으로 변경? VS main()에서 직접 변경?
		//   : index값의 변화가 ++로 고정이어서(단순해서) 직접 변경 O
	}

	public static void main(String[] args) {
	      
		Scanner sc=new Scanner(System.in);
		int[] stuArr=new int[3];
		int index=0; // 현재 저장된 학생 데이터 개수
		
		/*
		// 샘플 데이터 추가
		stuArr[index++]=80;
		stuArr[index++]=72;
		*/
		sample(stuArr,index++);
		sample(stuArr,index++);
		
		while(true) {
			System.out.println();
			System.out.println(" === 학생부 프로그램 ===");
			System.out.println("1. 추가"); // 
			System.out.println("2. 목록출력"); //
			System.out.println("3. 검색"); //
			System.out.println("4. 변경"); //
			System.out.println("5. 삭제"); //
			System.out.println("0. 종료");
			System.out.print("입력 >> ");
			int action=sc.nextInt();
			System.out.println();
			if(action==0) { // 종료
				System.out.println();
				System.out.println("프로그램을 종료합니다...");
				System.out.println();
				break;
			}
			else if(action==2) { // 목록출력
				System.out.println();
				System.out.println(" === 목록출력 ===");
				for(int i=0;i<index;i++){
					System.out.println((i+1)+"번학생 : "+stuArr[i]);
				}
				System.out.println();
			}
		}		
		
	}

}
