package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.StudentDTO;

public class StudentView {
	
	private Scanner sc;
	public StudentView() {
		sc=new Scanner(System.in);
	}
	
	public void printMenu() {
		System.out.println("학생부");
		System.out.println("1. 추가");
		System.out.println("2. 목록");
		System.out.println("3. 검색");
		System.out.println("4. 변경");
		System.out.println("5. 삭제");
		System.out.println("6. 점수로 학생들 검색");
		System.out.println("7. 이름으로 학생들 검색");
		System.out.println("0. 종료");
	}
	public int inputAction() {
		System.out.print("메뉴입력 >> ");
		int action=sc.nextInt();
		return action;
	}
	public String inputName() {
		System.out.print("이름입력 >> ");
		String name=sc.next();
		return name;
	}
	public int inputScore() {
		System.out.print("점수입력 >> ");
		int score=sc.nextInt();
		return score;
	}
	public int inputNum() {
		System.out.print("번호입력 >> ");
		int num=sc.nextInt();
		return num;
	}
	public void printTrue() {
		System.out.println("기능 수행 완료 !");
	}
	public void printFalse() {
		System.out.println("기능 수행 실패 ...");
	}
	public void printDatas(ArrayList<StudentDTO> datas) {
		if(datas.size()<=0) {
			System.out.println("검색결과가 없습니다...");
			return;
		}
		for(StudentDTO data:datas) {
			System.out.println(data);
		}
	}
	public void printData(StudentDTO data) {
		System.out.println("현재 출력된 학생");
		System.out.println(" ▼▼▼");
		System.out.println(data);
	}
	public void printUpdateMenu() {
		System.out.println("===변경중...===");
		System.out.println("1. 성적변경");
		System.out.println("2. 이름변경");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
