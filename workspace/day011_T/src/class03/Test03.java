package class03;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// 학생부 프로그램
// CRUD
// 학생 추가 [관]
// 학생 목록 출력
// 1명 검색
// 1등 출력
// 학생 점수 변경 [관]
// 학생 삭제 [관]

class Student{
	// 접근제어자
	// public 메서드
	// private 멤버변수
	private int num; // PK : 사용자가 선택 xxx 프로그램에서 설정 O
	private String name;
	private int score;
	private static Random random=new Random();
	public Student(int num, String name){
		this.num=num;
		this.name=name;
		this.score=Student.random.nextInt(101);
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "["+this.num+"] "+this.name+"학생 "+this.score+"점";
	}
}

public class Test03 {
	
	public static int hasStudent(ArrayList<Student> datas,int num) {
		boolean flag=false; // 학생못찾음
		int i;
		for(i=0;i<datas.size();i++) {
			if(num==datas.get(i).getNum()) {
				flag=true; // 학생찾음
				break;
			}
		}
		
		if(!flag) { // 학생못찾음 상태라면,
			System.out.println("해당 번호의 학생은 없습니다...");
			i=-1;
		}
		
		return i;
	}

	public static void main(String[] args) {
		
		ArrayList<Student> datas=new ArrayList<Student>();

		int PK=1001;
		datas.add(new Student(PK++,"샘플01"));
		datas.add(new Student(PK++,"샘플02"));

		//System.out.println(datas);

		Scanner sc=new Scanner(System.in);
		
		while(true) {
			System.out.println("1. 목록출력");
			System.out.println("2. 학생검색");
			System.out.println("3. 1등출력");
			System.out.println("0. 프로그램 종료");
			System.out.print("입력 >> ");
			int action=sc.nextInt();
			if(action==0) {
				break;
			}
			else if(action==777) {
				while(true) {
					System.out.println("=== 관리자 모드 ===");
					System.out.println("1. 학생추가");
					System.out.println("2. 정보변경");
					System.out.println("3. 학생삭제");
					System.out.println("0. 관리자 모드 종료");
					System.out.print("입력 >> ");
					action=sc.nextInt();
					if(action==0) {
						break;
					}
					else if(action==1) {
						System.out.println(PK+"번 학생을 추가합니다.");
						System.out.print("이름입력 >> ");
						String name=sc.next();
						datas.add(new Student(PK++,name));
						System.out.println("학생추가완료!");
					}
					else if(action==2) {
						System.out.print("변경할 학생의 번호를 입력 >> ");
						int num=sc.nextInt();

						int i=hasStudent(datas,num);
						if(i<0) {
							continue;
						}

						int score;
						while(true) {
							System.out.print("재설정할 점수를 입력 >> ");
							score=sc.nextInt();
							if(0<=score && score<=100) {
								break;
							}
							System.out.println("0~100점 사이로 입력해주세요!");
						}

						datas.get(i).setScore(score);
						// 멤버변수의 값을 main()에서
						//             객체코드 외부에서 접근이 가능한 상황
						// JAVA는 디폴트가 public 상태
						// JAVA의 모든 멤버변수는 private 설정해야함!!!!!

						System.out.println("정보변경완료!");
					}
					else if(action==3) {
						System.out.print("삭제할 학생의 번호를 입력 >> ");
						int num=sc.nextInt();

						int i=hasStudent(datas,num);
						if(i<0) {
							continue;
						}

						datas.remove(i);
						System.out.println("학생삭제완료!");
					}
					else {
						System.out.println("다시!");
					}
				}
			}
			else if(action==1) {
				if(datas.size()==0) {
					System.out.println("데이터없음");
					continue;
				}
				for(Student data:datas) {
					System.out.println(data);
				}
			}
			else if(action==2) {
				System.out.print("학번입력 >> ");
				int num=sc.nextInt();
				boolean flag=false;
				for(Student data:datas) {
					if(data.getNum()==num) {
						System.out.println(data);
						flag=true;
						break;
					}
				}
				if(flag) {
					System.out.println("해당 학번은 검색결과가 없습니다...");
				}
			}
			else if(action==3) {
				int maxIndex=0;
				for(int i=1;i<datas.size();i++) {
					if(datas.get(maxIndex).getScore()<datas.get(i).getScore()) {
						// datas[maxIndex] == 학생 데이터
						// datas[maxIndex].score == 학생 점수 데이터
						maxIndex=i;
					}
				}
				System.out.println("1등은 "+datas.get(maxIndex)+"입니다.");
			}
			else {
				System.out.println("다시!");
			}
		}















	}

}
