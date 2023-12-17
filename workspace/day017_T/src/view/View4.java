package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.ProductDTO;

public class View4 {

	private Scanner sc;
	private int userMAX;
	private int adminMAX;
	public View4() {
		this.sc=new Scanner(System.in);
		this.userMAX=2;
		this.adminMAX=3;
	}

	public void adminInfo() {
		System.out.println("관리자 모드는 1234로 진입하실수있습니다.");
	}
	
	public void printMenu() { // 로그아웃 상태일때의 VIEW
		System.out.println("=== 자 판 기 ===");
		System.out.println("1. 메뉴목록출력");
		System.out.println("2. 메뉴선택");
		System.out.println("3. 이름으로검색");
		System.out.println("4. 회원가입");
		System.out.println("5. 로그인");
		System.out.println("0. 종료");
	}
	public void printLoginMenu() { // 로그인 상태일때의 VIEW
		// 4,5를 누를수없게 VIEW에서 유효성 검사 ☆
		System.out.println("=== 자 판 기 ===");
		System.out.println("1. 메뉴목록출력");
		System.out.println("2. 메뉴선택");
		System.out.println("3. 이름으로검색");
		System.out.println("6. 로그아웃");
		System.out.println("7. 비밀번호변경");
		System.out.println("8. 회원탈퇴");
		System.out.println("0. 종료");
	}
	public int inputInteger() {
		System.out.print("번호입력 >> ");
		int integer=sc.nextInt();
		return integer;
	}
	public void printAdminMenu() {
		System.out.println("=== 관 리 자 ===");
		System.out.println("1. 메뉴추가");
		System.out.println("2. 메뉴재고변경");
		System.out.println("3. 메뉴삭제");
		System.out.println("4. 메뉴재고추가");
		System.out.println("5. 메뉴가격변경");
		System.out.println("0. 관리자모드 종료");
	}
	public int inputNum() {
		System.out.print("메뉴번호입력 >> ");
		int num=sc.nextInt();
		return num;
	}
	public void printDeleteData01() {
		System.out.println("메뉴가 삭제되었습니다!");
	}
	public void printDeleteData02() {
		System.out.println("메뉴삭제에 실패했습니다...");
	}
	public String inputName() {
		System.out.print("메뉴이름입력 >> ");
		String name=sc.next();
		return name;
	}
	public int inputPrice() {
		System.out.print("메뉴가격입력 >> ");
		int price=sc.nextInt();
		return price;
	}
	public int inputCnt() {
		System.out.print("메뉴재고입력 >> ");
		int cnt=sc.nextInt();
		return cnt;
	}
	public void printInsertData(ProductDTO data) {
		System.out.println(data.getName()+"이(가) 추가되었습니다! :D");
	}
	public void printDatas(ArrayList<ProductDTO> datas) {
		if(datas.size()<=0) {
			System.out.println("출력할 메뉴가 없습니다...");
			return;
		}
		for(ProductDTO data:datas) {
			if(data.getCnt()<=0) {
				System.out.println("재고없음!");
				continue;
			}
			System.out.println(data);
		}
	}
	public void printNoData() {
		System.out.println("해당 데이터는 없습니다...");
	}
	public void printData(ProductDTO data) {
		if(data==null) {
			System.out.println("출력할 데이터가 없습니다...");
			return;
		}
		if(data.getCnt()<=0) {
			System.out.println(data.getName()+"는(은) 재고가 없습니다...");
			return;
		}
		System.out.println(data);
		System.out.println("구매완료!");
	}
}
