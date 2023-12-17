package view;

import java.util.Scanner;

// 높은 응집도(관련된 코드끼리 묶어서 관리하는 것)
public class MemberView {
	private Scanner sc;
	public MemberView() {
		this.sc=new Scanner(System.in);
	}
	public String inputMemberID() {
		System.out.print("ID 입력 >> ");
		String mid=sc.next();
		return mid;
	}
	public void printFalse() {
		System.out.println("해당 기능 수행 실패...");
	}
	public void printTrue() {
		System.out.println("회원탈퇴가 완료되었습니다.");
		System.out.println("이용해주셔서 감사합니다.");
	}
	public void logout() {
		System.out.print("로그아웃중");
		for(int i=0;i<5;i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print(".");
		}
		System.out.println();
		System.out.println("로그아웃 완료!");
	}
	public void loginFalse() {
		System.out.println("로그인 실패!");
	}
	public void loginTrue() {
		System.out.println("로그인 성공!");
	}
	public void signUpFalse() {
		System.out.println("중복되는 ID라서 사용불가능합니다!");
	}
	public void signUpTrue() {
		System.out.println("회원가입 성공!");
	}
	public String inputMemberPW() {
		System.out.print("PW 입력 >> ");
		String mpw=sc.next();
		return mpw;
	}
	public String inputMemberName() {
		System.out.print("회원 이름 입력 >> ");
		String name=sc.next();
		return name;
	}
}
