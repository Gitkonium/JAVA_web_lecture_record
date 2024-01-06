package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.Student;

public class StudentView {
	private Scanner sc;
	public StudentView() {
		sc=new Scanner(System.in);
	}

	public void printMenu() {
		System.out.println("1. 추가");
		System.out.println("2. 목록");
		System.out.println("3. 검색");
		System.out.println("4. 변경");
		System.out.println("5. 삭제");
		System.out.println("0. 종료");
	}
	public int inputAction() {
		System.out.print("입력 >> ");
		int action=sc.nextInt();
		return action;
	}
	public String inputName() {
		System.out.print("학생이름입력 >> ");
		String name=sc.next();
		return name;
	}
	public int inputScore() {
		System.out.print("학생점수입력 >> ");
		int score=sc.nextInt();
		return score;
	}
	public int inputNum() {
		int num;
		while(true) {
			System.out.print("학생번호입력 >> ");
			num=sc.nextInt();
			if(1000<num&&num<2000) {
				break;
			}
			System.out.println("[로그] 번호입력이 올바르지않습니다...");
		}
		return num;
	}
	public void printTrue() {
		System.out.println("완료되었습니다! :D");
	}
	public void printFalse() {
		System.out.println("해당 번호의 학생은 없습니다...");
	}
	
	public void printStudentDatas(ArrayList<Student> datas) {
		System.out.println("==== 학 생 목 록 ====");
		for(Student data:datas) {
			System.out.println(data);
		}
		System.out.println("===================");
	}
	public void printStudentData(Student data) {
		System.out.println("==== 학 생 출 력 ====");
		System.out.println(data);
		System.out.println("===================");
	}
}







