package class06;

import java.util.Random;
import java.util.Scanner;

public class Test03 {

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
		while(true) {
			System.out.print((index+1)+"번학생의 점수 입력 >> ");
			int score=sc.nextInt();
			if(checkScore(score)) {
				stuArr[index++]=score;
				break;
			}
		}		
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
	public static void printStu(int[] stuArr,int index,Scanner sc) {
		System.out.println();
		while(true) {
			System.out.print("검색할 학생 번호 입력 >> ");
			int stuNum=sc.nextInt();
			if(checkStuNum(stuNum,index)) {
				System.out.println(stuNum+"번 학생의 점수: "+stuArr[stuNum-1]+"점");
				break;
			}
		}
		System.out.println();
	}
	public static void updateStu(int[] stuArr,int index,Scanner sc) {
		System.out.println();
		while(true) {
			System.out.print("변경할 학생의 번호 입력 >> ");
			int stuNum=sc.nextInt();
			if(checkStuNum(stuNum,index)) {
				while(true) {
					System.out.print("변경할 점수 입력 >> ");
					int score=sc.nextInt();
					if(checkScore(score)) {
						stuArr[stuNum-1]=score;
						System.out.println(stuNum+"번 학생의 점수 "+score+"점으로 변경완료!");
						break;
					}
				}
				break;
			}
		}		
		System.out.println();
	}
	public static void deleteStu(int index) {
		System.out.println();
		System.out.println(index+"번학생 삭제완료!");
		System.out.println();
	}
	public static void printInfo() {
		System.out.println();
		System.out.println("없는 번호입니다...확인후 다시 시도해주세요!");
		System.out.println();
	}

	// 대부분의 유효성 검사 로직은
	// 모듈화하여 사용됩니다!
	// input: 확인대상
	// output: 가능여부(boolean)
	// 함수명: hasXxx(), isXxx(), checkXxx(), flagXxx(), ...
	public static boolean hasStu(int index) {
		if(index<=0) {
			System.out.println("학생데이터가 전혀 없습니다...");
			return false;
		}
		return true;
	}
	public static boolean checkInsert(int[] stuArr,int index) {
		if(index>=stuArr.length) {
			System.out.println("학생부가 가득찼습니다...");
			return false;
		}
		return true;
	}
	public static boolean checkScore(int score) {
		if(0<=score && score<=100) {
			return true;
		}
		System.out.println("점수는 0~100점까지만 가능합니다...");
		return false;
	}
	public static boolean checkStuNum(int stuNum,int index) {
		if(1<=stuNum && stuNum<=index) {
			return true;
		}
		System.out.println("해당 번호의 학생은 없습니다...");
		return false;
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
		///sample(stuArr,index++); // 선 함수실행
		///sample(stuArr,index++); // 후 연산자수행

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

				if(!checkInsert(stuArr,index)) {
					continue;
				}

				insertStu(stuArr,index++,sc);
			}
			else if(action==2) { // 목록출력

				// hasStu(index)함수의 output이 boolean이면 유리하겠다!
				if(!hasStu(index)) {
					// flase여야 if통과 => !(NOT) 추가하기
					continue;
				}

				printStuArr(stuArr,index);
				// 1) 우선 기능을 main()에서 완성시켜야함!
				// 2) 모듈화 시작 : main()에서 작성완료한 코드를 뜯기
			}
			else if(action==3) { // 검색
				if(!hasStu(index)) {
					continue;
				}
				printStu(stuArr,index,sc);
			}
			else if(action==4) { // 변경
				if(!hasStu(index)) {
					continue;
				}
				updateStu(stuArr,index,sc);
			}
			else if(action==5) { // 삭제
				if(!hasStu(index)) {
					continue;
				} // 함수화(모듈화)의 큰 장점! 코드의 재사용성이 증가!!!
				deleteStu(index--);
			}
			else {
				printInfo();
			}
		}		

	}

}












