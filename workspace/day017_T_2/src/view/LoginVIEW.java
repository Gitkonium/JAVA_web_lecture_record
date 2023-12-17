package view;

import model.MemberDTO;

public class LoginVIEW extends VIEW {
	
	public void printMenu() {
		System.out.println("8. 로그아웃");
		System.out.println("9. 비밀번호변경");
		System.out.println("10. 회원탈퇴");
	}
	
	public void hello(MemberDTO data) {
		System.out.println(data.getName()+"님, 안녕하세요! :D");
	}
	
}
