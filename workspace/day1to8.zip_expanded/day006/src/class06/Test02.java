package class06;

import java.util.Random;
import java.util.Scanner;

public class Test02 {
	
	// 샘플 데이터 추가
	// 기능을 함수화
	// 모듈화
	public static void sample(int[] stuArr,int index) {
		Random rand=new Random();
		stuArr[index]=rand.nextInt(101); // 0~100
		System.out.println();
		System.out.println((index+1)+"번학생의 점수는 "+stuArr[index]+"점입니다.");
		System.out.println((index+1)+"번학생 추가완료!");
		System.out.println();
	}
	public static void insertStu(int[] stuArr,int index,Scanner sc) {
		System.out.println();
		System.out.print((index+1)+"번학생의 점수 입력 >> ");
		int score=sc.nextInt();
		stuArr[index++]=score;
		System.out.println(index+"번학생 추가완료!");
		System.out.println();
	}
	public static void printStuArr(int[] stuArr,int index) {
		System.out.println();
		System.out.println(" === 목록출력 ===");
		for(int i=0;i<index;i++){
			System.out.println((i+1)+"번학생 : "+stuArr[i]);
		}
		System.out.println();
	}
	public static void printStu(int[] stuArr,Scanner sc) {
		System.out.println();
		System.out.print("검색할 학생 번호 입력 >> ");
		int stuNum=sc.nextInt();
		System.out.println(stuNum+"번 학생의 점수: "+stuArr[stuNum-1]+"점");
		System.out.println();
	}
	public static void updateStu(int[] stuArr,Scanner sc) {
		System.out.println();
		System.out.print("변경할 학생의 번호 입력 >> ");
		int stuNum=sc.nextInt();
		System.out.print("변경할 점수 입력 >> ");
		int score=sc.nextInt();
		stuArr[stuNum-1]=score;
		System.out.println(stuNum+"번 학생의 점수 "+score+"점으로 변경완료!");
		System.out.println();
	}
	public static void deleteStu(int index) {
		System.out.println();
		System.out.println(index+"번학생 삭제완료!");
		System.out.println();
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
		sample(stuArr,index++); // 선 함수실행
		sample(stuArr,index++); // 후 연산자수행
		
		while(true) {
			System.out.println();
			System.out.println(" === 학생부 프로그램 ===");
			System.out.println("1. 추가");
			System.out.println("2. 목록출력");
			System.out.println("3. 검색");
			System.out.println("4. 변경");
			System.out.println("5. 삭제");
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
			else if(action==1) { // 추가
				insertStu(stuArr,index++,sc);
			}
			else if(action==2) { // 목록출력
				printStuArr(stuArr,index);
				// 1) 우선 기능을 main()에서 완성시켜야함!
				// 2) 모듈화 시작 : main()에서 작성완료한 코드를 뜯기
			}
			else if(action==3) { // 검색
				printStu(stuArr,sc);
			}
			else if(action==4) { // 변경
				updateStu(stuArr,sc);
			}
			else if(action==5) { // 삭제
				deleteStu(index--);
			}
		}		
		
	}

}












