package class02;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {

		// 변수 선언하기
		// 여러명의 학생 점수 데이터를 저장할 예정
		// 몇개인지 정확하지않아서 배열은 원래 사용 xxx
		// 그래서! 우리는! 학생의 최대 명수를 고정하고 사용하겠습니다!
		// 학생 최대 5명까지 저장가능한 프로그램 ☆
		int[] student=new int[5];
		int index=0; // 현재 저장된 학생의 명수
		// 프로그램을 만들때에는 R->C
		// 출력이 잘되는지 확인하기위해, "샘플데이터"가 필요!
		// 2명의 학생정보를 임의로 추가하겠습니당~~
		///// student[index++]=67;
		///// student[index++]=39;

		Scanner sc=new Scanner(System.in);
		// 사용자의 입력을 받아들이는 클래스(객체)

		// 프로그램이 몇회 동작하는지 정확히 모름!
		while(true){ // 무한루프와
			System.out.println("====================");
			System.out.println("   학생부 프로그램");
			System.out.println("====================");
			System.out.println(" 1. 학생 추가");
			System.out.println(" 2. 전체 출력");
			System.out.println(" 3. 학생 검색");
			System.out.println(" 4. 1등 출력");
			System.out.println(" 5. 정보 변경");
			System.out.println(" 6. 정보 삭제");
			System.out.println(" 7. 프로그램 종료");
			System.out.println("====================");
			System.out.print("번호입력>> ");
			int action=sc.nextInt(); // 사용자가 입력했던 값을 저장해야함 => 변수 필요

			if(action==7) { // 종료조건
				System.out.println();
				System.out.println("학생부 프로그램을 종료합니다...");
				System.out.println();
				break;
			}
			else if(action==1) { // 학생 추가
				System.out.println();

				if(student.length <= index) {
					System.out.println("해당 프로그램은 "+student.length+"명까지 지원하고있습니다.");
					System.out.println("관리자에게 문의주세요...");
					System.out.println();

					// 반복문을 멈추고싶지는않은데,
					// 한스텝 쉬어가고싶을때
					continue;
					// 해당 반복문의 가장처음으로 즉시 이동
					//    break : 해당 반복문의 바깥으로(가장뒤로) 즉시 이동
				}


				while(true) {
					System.out.println((index+1)+"번 학생을 추가합니다.");
					System.out.print("학생 점수 입력 >> ");
					int score=sc.nextInt();

					// 유효성 검사
					//  : 사용자의 거의 모든 입력값에 대하여 수행하는것이 바람직하다!
					//  목적 == 에러 최소화
					if(0<=score && score<=100) {
						student[index++]=score;
						System.out.println(index+"번 학생 추가완료!");
						System.out.println();
						break;
					}
					else {
						System.out.println("점수는 0~100점까지 입력 가능합니다.");
						System.out.println("확인 후 다시 입력해주세요!");
						System.out.println();
					}
				}
			}
			else if(action==2) { // 전체 출력
				System.out.println();

				if(index<=0) {
					System.out.println("출력할 학생 데이터가 없습니다!");
					System.out.println();
					continue;
				}

				System.out.println("전체 출력");
				// 처음부터 "존재하는 학생"만큼 출력하기
				//          == index
				// 범위가 존재 => for문
				for(int i=0;i<index;i++) {
					System.out.println((i+1)+"번 학생  "+student[i]+"점");
				}
				System.out.println();
			}
			else if(action==3) { // 학생 검색
				// 1) 학생의 번호를 사용자가 입력
				// 2) 해당 번호의 학생 점수 정보가 출력
				System.out.println();

				if(index<=0) {
					System.out.println("검색할 학생 데이터가 없습니다!");
					System.out.println();
					continue;
				}

				System.out.print("검색할 학생번호입력>> ");
				int stuNum = sc.nextInt();
				if(stuNum<1 || index<stuNum) { // 사용자가 잘못된 입력을 했다면 == 범위 외 입력
					System.out.println("해당 번호를 가진 학생은 존재하지않습니다!");
					System.out.println("확인 후 다시 이용해주세요...");
				}
				else {
					System.out.println(stuNum+"번 학생은 "+student[stuNum-1]+"점입니다.");
				}

				System.out.println();
			}
			else if(action==4) { // 1등 출력
				System.out.println();

				if(index<=0) {
					System.out.println("학생 데이터가 없습니다!");
					System.out.println();
					continue;
				}

				int maxIndex=0;
				for(int i=1;i<index;i++) { // 존재하는학생끝까지
					if(student[maxIndex] < student[i]) {
						maxIndex=i;
					}
				}

				System.out.println("1등은 "+(maxIndex+1)+"번 학생으로,");
				System.out.println(student[maxIndex]+"점 입니다!");

				System.out.println();
			}
			else if(action==5) { // 정보 변경
				System.out.println();

				if(index<=0) {
					System.out.println("변경 가능한 데이터가 없습니다...");
					System.out.println();
					continue;
				}

				System.out.print("학생번호입력 >> ");
				int stuNum=sc.nextInt();

				if(stuNum<=0 || index<stuNum) {
					System.out.println("해당 번호를 가진 학생은 없습니다...");
					System.out.println();
					continue;
				}

				// ※ 코드 깊이 줄이기
				System.out.println(stuNum+"번은 현재 "+student[stuNum-1]+"점입니다.");
				while(true) { // 무한루프와
					System.out.println("새점수 입력 >> ");
					int newScore=sc.nextInt();

					if(0<=newScore && newScore<=100) {
						student[stuNum-1]=newScore;
						System.out.println(stuNum+"번 학생의 점수가 변경되었습니다!");
						break; // 종료조건
					}
					
					System.out.println("점수가 올바르지않습니다. 다시 입력해주세요!");

				}

				System.out.println();
			}
			else if(action==6) { // 정보 삭제
				
				// 배열은 추가,삭제가 안됨
				// 배열 자체를 추가하거나 삭제할수없음
				// 지금은, 마지막 학생 제거로 하겠습니다~^^
				System.out.println();
				
				if(index<=0) {
					System.out.println("제거할 정보가 없습니다...");
					System.out.println();
					continue;
				}
				
				System.out.println(index+"번 학생 정보를 제거합니다...");
				index--;
				System.out.println("제거 완료!");
				System.out.println();
				
				
				
				
				
				
				
				
				
			}
		}













	}

}
