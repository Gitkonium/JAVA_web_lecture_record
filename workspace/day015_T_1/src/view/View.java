package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.ProductDTO;

public class View {

	private Scanner sc;
	private int userMAX;
	private int adminMAX;
	public View() {
		this.sc=new Scanner(System.in);
		this.userMAX=2;
		this.adminMAX=3;
	}

	public void printMenu() {
		System.out.println("=== 자 판 기 ===");
		System.out.println("1. 메뉴목록출력");
		System.out.println("2. 메뉴선택");
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
		System.out.println("0. 관리자모드 종료");
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
