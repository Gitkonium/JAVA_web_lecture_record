package view;

public class LogoutVIEW extends VIEW {
	
	public void printMenu() {
		System.out.println("6. 회원가입");
		System.out.println("7. 로그인");
	}
	
	public void printInfo() {
		System.out.println("중복되는 ID입니다! 다시 입력해주세요!");
	}
	public String inputMid() {
		System.out.print("ID 입력 >> ");
		String mid=sc.next();
		return mid;
	}
	public String inputMpw() {
		System.out.print("PW 입력 >> ");
		String mpw=sc.next();
		return mpw;
	}
	public String inputName() {
		System.out.print("이름 입력 >> ");
		String name=sc.next();
		return name;
	}
	public String inputGrade() {
		String result="USER";
		
		System.out.println("1. 사용자");
		System.out.println("2. 관리자");
		System.out.print("번호 입력 >> ");
		int action=sc.nextInt();
		
		if(action==2) {
			System.out.println("관리자 회원가입을 위한 비밀번호를 입력해주세요.");
			System.out.print("입력 >> ");
			int num=sc.nextInt();
			if(1234==num) { // '하드코딩'되어있는 비밀번호
				result="ADMIN";
			}
		}
		
		return result;
	}
	
}
