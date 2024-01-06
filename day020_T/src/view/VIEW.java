package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.BoardDTO;
import model.MemberDTO;

public class VIEW {
	private Scanner sc;
	public VIEW() {
		sc=new Scanner(System.in);
	}
	
	public BoardDTO boardInsert(){
		BoardDTO bDTO=new BoardDTO();
		System.out.println("제목입력 >> ");
		bDTO.setTitle(sc.next());
		System.out.println("내용입력 >> ");
		bDTO.setContent(sc.next());
		return bDTO;
	}
	
	public int loginMenu(BoardDTO data,MemberDTO loginINFO) {
		if(loginINFO!=null && data.getWriter().equals(loginINFO.getMid())) {
			System.out.println("1. 변경");
			System.out.println("2. 삭제");
		}
		System.out.println("0. 메인화면으로 이동");
		System.out.print("번호입력 >> ");
		return sc.nextInt();
	}
	
	public int inputBid() {
		System.out.print("글 번호 입력 >> ");
		return sc.nextInt();
	}
	public void printData(BoardDTO data) {
		if(data==null) {
			System.out.println("출력할 정보가 없습니다...");
			return;
		}
		System.out.println("제목: "+data.getTitle());
		System.out.println("내용: "+data.getContent());
		System.out.println("작성자: "+data.getName());
		System.out.println("작성일: "+data.getRegdate());
	}
	public void printDatas(ArrayList<BoardDTO> datas) {
		for(BoardDTO data:datas) {
			System.out.println("["+data.getBid()+"]  "+data.getName()+"   "+data.getTitle());
		}
	}
	
	public void loginlogout(MemberDTO data) {
		if(data != null) { // 로그인
			System.out.println(data.getName()+"님, 안녕하세요! :D");
		}
		else { // 로그아웃
			System.out.println("로그인하고 이용해주세요!");
		}
	}
	
	public MemberDTO login() {
		MemberDTO mDTO=new MemberDTO();
		System.out.print("ID입력 >> ");
		mDTO.setMid(sc.next());
		System.out.print("PW입력 >> ");
		mDTO.setMpw(sc.next());
		return mDTO;
	}
	
	public void printMenu() {
		System.out.println("0. 종료");
		System.out.println("1. 로그인");
		System.out.println("2. 로그아웃");
		System.out.println("3. 글 작성");
		System.out.println("4. 글 목록 출력");
		System.out.println("5. 글 내용 보기");
	}
	public int inputAction() {
		System.out.print("번호입력 >> ");
		return sc.nextInt();
	}
	public void printTrue() {
		System.out.println("성공!");
	}
	public void printFalse() {
		System.out.println("실패...");
	}
}
