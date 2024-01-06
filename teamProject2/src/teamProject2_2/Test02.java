package teamProject2_2; //ver 4.4

// 정보수정 유효성 검사 진행중(15%)

//23.12.10 _ 17:00
// 각자 작성한 코드 조립
// 피드백 받으며 다듬기
// 유효성검사 및 모듈화 95%
// 장바구니 시작.

// 유효성검사 -> 모듈화 -> 장바구니

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Movie {

	private int num; // PK영화의 기본키
	private String name; // 영화 이름
	private int price; // 영화 가격
	private int cnt; // 남은수량
	private int sellTicket; // 판매된 티켓의 수량을 카운트
	private int cartCnt;

	Movie(int num, String name, int price) {
		this.num = num;
		this.name = name;
		this.price = price;
		this.cnt = 30; // 우선 고정값으로 넣었습니다 :) , 13~16번 라인 사이 다 수정가능
		this.sellTicket = 0;
		this.cartCnt = 0;
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

	public int getPrice() {
		
		return price;
		
	}

	public void setPrice(int price) {
		
		this.price = price;
		
	}

	public int getCnt() {
		
		return cnt;
		
	}

	public void setCnt(int cnt) {
		
		this.cnt = cnt;
		
	}

	public int getSellTicket() {
		
		return sellTicket;
		
	}

	public void setSellTicket(int sellTicket) {
		
		this.sellTicket = sellTicket;
		
	}
	
	public int getCartCnt() {
		
		return cartCnt;
		
	}

	public void setCartCnt(int cartCnt) {
		
		this.cartCnt = cartCnt;
		
	}

	@Override
	public String toString() { // 문구정리
		String msg = "[" + num + "] " + name + " " + price + "원";
		if (this.cnt <= 0) {
			msg += "[재고 없음] ";
		} else {
			msg += "[남은티켓 : " + this.cnt + "]";
		}
		return msg;

	}

	// 예약 메서드
	public void reservation(int ticketNum) {

		// 티켓 잔량 감소
		this.cnt = cnt - ticketNum;
		this.sellTicket += ticketNum;
	}

}

public class Test02 {

	public static int mismatchCheck(Scanner sc) { //
		int selectNum = 0;
		try {
			selectNum = sc.nextInt();
		} catch (java.util.InputMismatchException e) {
			sc.nextLine();
			return -1;
		}
		return selectNum;
	}

	public static boolean priceCheck(int newPrice, String newName, int PK, ArrayList<Movie> datas) { // 유효성검사가 아니라
		// 배열에 값을 추가함
		boolean flag = false;
		final int minPrice = 10000;
		final int maxPrice = 15000;
		if (minPrice <= newPrice && newPrice <= maxPrice) { // 범위강제
			datas.add(new Movie(PK++, newName, newPrice));
			System.out.println("영화가 추가되었습니다.");
			flag = true;
			return flag;
		}
		return flag;
	}

	public static void main(String[] args) {

		ArrayList<Movie> datas = new ArrayList<Movie>(); // 영화 배열
		ArrayList<Movie> cart = new ArrayList<Movie>(); // 장바구니 배열

		int PK = 1001; // 영화의 기본키

		// 샘플데이터
		datas.add(new Movie(PK++, "서울의 봄", 13000));
		datas.add(new Movie(PK++, "서울의 여름", 13000));
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("===영화 티켓 자판기===");
			System.out.println("1. 상영중인 영화목록"); // 지훈님
			System.out.println("2. 예매하기"); //// 지훈님
			System.out.println("3. 장바구니 = 예제"); // 택종님
			System.out.println("0. 프로그램 종료");
			System.out.print("메뉴를 선택해주세요 >> ");
			int action = sc.nextInt();
			if (action == 0) {
				break;
			} else if (action == 4885) {
				while (true) {
					System.out.println("===관리자 모드===");
					System.out.println("1. 영화 추가하기"); // 도연님
					System.out.println("2. 영화 정보 수정"); // 영화 이름 변경 , 티켓추가 // 형련
					System.out.println("3. 상영중인 영화 내리기"); // 영화삭제 //훈석님
					System.out.println("4. 예매 현황 확인하기"); // 모든 예매 상태 조회 //지원님
					System.out.println("5. 매출 확인하기"); // 지원님
					System.out.println("0. 관리자 모드 종료");
					System.out.print("메뉴를 선택해주세요 >> ");
					action = mismatchCheck(sc);
					if (action == -1) {
						System.out.println("메뉴 번호만 입력해주세요!");
						continue;
					}
					if (action == 0) {
						System.out.println("관리자 모드 종료");
						break;
					} else if (action == 1) { // 영화 추가하기 .도연
						// 추가할 영화의 제목과 가격을 입력하여 배열 리스트에 추가한다. 가격은 10000원 이상 15000원 이하의 정수만 입력이 가능하다.
						int price = 0;
						String name;
						while (true) {
							// 버퍼에 ?이 들어있는지 확인
							// 유력한 후보 엔터
							// sc.nextLine();// 영화제목 띄어쓰기를 위한 코드

							while (true) { // 169~175번라인 이름에 공백포함해서 수정하면 수정안되는 현상 물어보고 고치기 16:04
								System.out.print("영화의 제목을 입력하세요 >> ");
								name = sc.nextLine();
								if (name.trim().isEmpty()) {
									sc.nextLine();
									System.out.println("영화 이름을 공백으로 입력할 수 없습니다. 다시 입력해주세요");
									continue;
								}
								break;
							}

							try {
								System.out.print("가격을 입력하세요(10,000원 ~ 15,000원 사이) >> ");
								price = sc.nextInt();
							} catch (InputMismatchException e) {
								System.out.println("정수만 입력 가능합니다.");
								System.out.println("다시 입력해주세요");
								sc.nextLine();
								continue;
							}
							if (priceCheck(price, name, PK, datas)) {
								break;
							}
//							if (minPrice <= price && price <= maxPrice) {
//								datas.add(new Movie(PK++, name, price));
//								System.out.println("영화가 추가되었습니다.");
//								break;
//							}						
							System.out.println("입력값이 범위를 벗어났습니다. \n 다시 입력해주세요");
						}
					} else if (action == 2) { // 형련님
						// 의견 2) 변경할 항목을 정해서 변경
						// 1.항목 분리(이름, 가격, 재고) 3가지
						// 이름변경은 == 이름을 잘못입력하면 삭제하고 다시만드는게 맞다
						// 이름을 변경할 일이 오타를 제외하면 없다
						// 여기서 재고정보를 변경하면

						int i; // 여기 부분 나중에 변수 정리 다 해야할 것 같고
						int selectNum;
						int newCnt;
						int newPrice;
						String newName;
						boolean flag;

						for (i = 0; i < datas.size(); i++) { // 영화 목록 출력

							System.out.println("[" + datas.get(i).getNum() + "] " + datas.get(i).getName()
									+ " (티켓 잔량 : " + datas.get(i).getCnt() + ")");
						}

						while (true) { // if(입력값==배열에 Pk값)
							flag = false;
							System.out.print("수정할 영화 번호를 입력하세요 : ");
							selectNum = mismatchCheck(sc);
							// System.out.println("정수를 입력해주세요");
							if (selectNum == -1) { // -1을 입력하면
								System.out.println("올바른 번호를 입력해주세요");
								continue;
							}
							for (i = 0; i < datas.size(); i++) { // 해당 부분에서 찾은 i값이 if문 외부에 저장되니깐
								if (selectNum == datas.get(i).getNum()) {
									flag = true;
									break;
								}
							}
							if (flag) {
								break;
							}
							System.out.println("없는 번호의 영화입니다");
						}
						while (true) { // 240~ 247번라인 이름에 공백포함해서 수정하면 수정안되는 현상 물어보고 고치기 16:04
							System.out.print("새로운 영화 이름을 입력하세요 : ");
							newName = sc.nextLine();
							if (newName.trim().isEmpty()) {
								sc.nextLine();
								System.out.println("영화 이름을 공백으로 입력할 수 없습니다. 다시 입력해주세요");
								continue;
							}
							break;
						}

						// 반복문 while을 사용한다
						// 종료조건을 1순위로 작성해야한다
						while (true) { // 바르게 입력할 때까지
							flag = false;
							System.out.print("수정할 티켓 수량을 입력하세요 : ");
							newCnt = mismatchCheck(sc);

							if (newCnt == -1) {
								System.out.println("1 이상의 숫자만 입력해주세요");
								continue;
							}
							// 영화번호 범위검사
							if (selectNum == datas.get(i).getNum()) {
								if (datas.get(i).getCnt() + newCnt >= 0) { // +
									datas.get(i).setCnt(datas.get(i).getCnt() + newCnt);
									flag = true;
								} else {
									System.out.println("현재 남은티켓보다 많은 수량을 제거할 수 없습니다.");
									break;
								}
							}

							if (flag) {
								break;
							}
						}

						while (true) {
							System.out.print("새로운 영화 가격을 입력하세요(10,000원 ~ 15,000원 사이): ");
							newPrice = mismatchCheck(sc);

							if (newPrice == -1) { // -1을 입력하면
								System.out.println("숫자만 입력 가능합니다.");
								continue;
							}

							if (newPrice < 10000 || newPrice > 15000) { // 우선 여기까지~
								System.out.println("입력값이 범위를 벗어났습니다. \n 다시 입력해주세요");
								continue;
							}
							break;

						}

						if (selectNum == datas.get(i).getNum()) {
							datas.get(i).setName(newName);
							datas.get(i).setPrice(newPrice);
							datas.get(i).setCnt(newCnt);
						}

						System.out.println("영화 정보가 수정되었습니다.");

					} else if (action == 3) { // pk값을 입력받아 해당하는 영화를 삭제하는 기능 .훈석
						int selectNum = 0;// 삭제할 번호를 입력받는 변수
						System.out.println("영화 번호를 입력해서 상영중인 영화를 삭제합니다.");
						for (Movie data : datas) { // 영화 목록 출력
							System.out.println(data);
						}
						while (true) {
							System.out.print("삭제할 영화의 번호를 입력해주세요 >> ");
							selectNum = mismatchCheck(sc);
							System.out.println("정수만 입력 가능합니다");
							if (selectNum == -1) { // -1을 입력하면
								System.out.println("입력한 번호는 없는 영화입니다.");
								continue;
							}
							boolean flag = false;// 유효성 검사를 위한 변수
							for (int i = 0; i < datas.size(); i++) { // 배열의 첫 index부터 끝까지
								if (selectNum == datas.get(i).getNum()) { // 입력값과 배열의 i인덱스의 num값이 같다면
									System.out.println(
											"[" + datas.get(i).getNum() + "] " + datas.get(i).getName() + "영화가 삭제됩니다.");
									datas.remove(i);
									flag = true; // 값을 찾으면 true로 변경
									break;
								}
								// 죄송합니다
								// 절대로 코드를 즉석에서 수정하지 않는다.
							}
							if (!flag) { // 값을 찾지못해 flag값이 초기값(false)이면 실행
								System.out.println("입력한 번호는 없는 영화입니다.");
								continue;
							}
							break;
						}
					} else if (action == 4) { // 구매현황.지원님
						if (datas.isEmpty()) {
							System.out.println("현재 상영중인 영화가 없습니다.");
						}

						System.out.println();
						System.out.println("현재 예매(구매)현황 확인하기");
						System.out.println();

						for (Movie data : datas) {
							System.out.println(data.getName() + "의 판매된 티켓 : " + (data.getSellTicket()));
							// (30 - data.getCnt())
							// 티켓의 총 갯수와 현재 남은 티켓을 빼서 판매된 티켓을 계산
							// 티켓의 총량을 정할 변수?
							// 티켓을 추가할때 ?+=getCnt
							// 생산한 티켓의 총 수량을 기억하는 변수
							// 재고 변경시 현황과 어떻게 연계하여 코드를 작성해야할까? 30+50
							// 클래스에 추가하자(당선)
							// 멤버변수로 영화클래스에 팔린 영화표를 저장하는
							// (30 - data.getCnt()) == 팔린 영화표 변수로 대체
						}

					} else if (action == 5) { // 자판기 매출의 총액
						int total = 0;
						for (Movie data : datas) {
							System.out.println(
									data.getName() + "의 매출액은 " + data.getSellTicket() * data.getPrice() + "원 입니다.");
							total += data.getSellTicket() * data.getPrice();
						}
						System.out.println("총 매출액은 " + total + "원 입니다.");
					}
				}
			} else if (action == 1) { // 상영중인 영화목록

				System.out.println("===절찬 상영중===");

				for (Movie data : datas) {

					System.out.println(data);

				}

			} else if (action == 2) {

				int selectNum = 0;// 입력 값을 확인하고 반환 값을 저장하는 변수
				
				int i = 0;// 인덱스 값을 저장하는 변수

				int movieNum = 0;// 영화 번호 변수

				int ticketNum = 0;// 티켓 장수 변수

				boolean movieNumFlag = false;// 영화 번호의 입력 범위 확인용 변수

				boolean ticketNumFlag = false;// 티켓 수량의 입력 범위 확인용 변수

				while (true) {// 예매하기 기능 반복

					System.out.println("=============================");

					for (Movie data : datas) {

						System.out.println(data);

					}

					System.out.println("=============================");

					System.out.println("1. 영화 예매하기");

					System.out.println("2. 장바구니에 담기");

					System.out.print("입력 >>");

					selectNum = mismatchCheck(sc);// 정수 입력 값 확인 함수의 반환 값 저장

					if (selectNum == -1) {// 반환 값이 -1이면
						System.out.println("메뉴 번호만 입력해주세요!");
						continue;// while문 처음으로 돌아가기

					}

					if (selectNum == 1) {// 입력 받은 값이 1이면

						while (true) {// 영화의 번호 입력 반복문

							System.out.print("예매할 영화의 번호를 입력해주세요. >>");// 영화 번호 입력받기

							movieNum = mismatchCheck(sc);// 정수 입력 값 확인 함수의 반환 값 저장

							if (movieNum == -1) {// 반환 값이 -1이면
								System.out.println("올바른 숫자를 입력해주세요");
								continue;// while문 처음으로 돌아가기

							}

							for (i = 0; i < datas.size(); i++) {// 배열 만큼 반복

								if (datas.get(i).getNum() == movieNum) {// i번째 데이터의 PK 값이 영화 번호 입력 값과 같으면

									movieNumFlag = true;

									break;

								}

							}

							if (movieNumFlag == true) {// 영화 번호가 존재한다면

								break;// while문 탈출

							} else { // 존재한다면

								System.out.println("올바른 영화 번호를 입력해주세요.");// 안내 메세지 출력

							}

						}

						if (datas.get(i).getCnt() <= 0) {

							System.out.println("티켓이 매진되었습니다.");

							break;

						}

						while (true) {// 티켓의 장수 입력 반복문 , 음수 입력하는 경우에 문구 하나 추가 해주기

							System.out.print("예매할 티켓의 장수를 입력해주세요. >>");

							ticketNum = mismatchCheck(sc);// 정수 입력 값 확인 함수의 반환 값 저장

							if (ticketNum <= 0) {// 반환 값이 -1이면
								System.out.println("올바른 숫자를 입력해주세요.");
								continue;// while문 처음으로 돌아가기
							}

							for (i = 0; i < datas.size(); i++) {// 배열 만큼 반복

								if (datas.get(i).getNum() == movieNum) {// i번째 데이터의 PK 값이 영화 번호 입력 값과 같으면

									if (datas.get(i).getCnt() < ticketNum) {// 티켓 잔량이 입력 값보다 적다면

										System.out.println("티켓의 잔량을 초과하였습니다.");// 안내 메세지 출력

										break;// for문 탈출

									}

									if (datas.get(i).getCnt() > 0) {// 티켓 잔량이 1장 이상이라면

										datas.get(i).reservation(ticketNum);// 티켓 잔량을 감소 시키는 메서드 호출

										ticketNumFlag = true;// 티켓 허용 범위 플래그를 true로 변경

										System.out.println(
												datas.get(i).getName() + "의 티켓이 " + ticketNum + "장 예매완료 되었습니다.");// 예매완료메시지
																													// 출력

										break;// for문 탈출

									}

								}

							}

							if (ticketNumFlag == true) {// 입력 값이 허용범위 였다면

								break;// while문 탈출

							}

						}

					} else if (selectNum == 2) {
						
						while (true) {// 영화의 번호 입력 반복문

							System.out.print("장바구니에 담을 영화의 번호를 입력해주세요. >>");// 영화 번호 입력받기

							movieNum = mismatchCheck(sc);// 정수 입력 값 확인 함수의 반환 값 저장

							if (movieNum == -1) {// 반환 값이 -1이면
								System.out.println("올바른 숫자를 입력해주세요");
								continue;// while문 처음으로 돌아가기

							}

							for (i = 0; i < datas.size(); i++) {// 배열 만큼 반복

								if (datas.get(i).getNum() == movieNum) {// i번째 데이터의 PK 값이 영화 번호 입력 값과 같으면

									movieNumFlag = true;

									break;

								}

							}

							if (movieNumFlag == true) {// 영화 번호가 존재한다면

								break;// while문 탈출

							} else { // 존재한다면

								System.out.println("올바른 영화 번호를 입력해주세요.");// 안내 메세지 출력

							}

						}
						
						while (true) {// 티켓의 장수 입력 반복문 , 음수 입력하는 경우에 문구 하나 추가 해주기

							System.out.print("장바구니에 담을 티켓의 장수를 입력해주세요. >>");

							ticketNum = mismatchCheck(sc);// 정수 입력 값 확인 함수의 반환 값 저장

							if (ticketNum <= 0) {// 반환 값이 -1이면
								System.out.println("올바른 숫자를 입력해주세요.");
								continue;// while문 처음으로 돌아가기
							}

							for (i = 0; i < datas.size(); i++) {// 배열 만큼 반복

								if (datas.get(i).getNum() == movieNum) {// i번째 데이터의 PK 값이 영화 번호 입력 값과 같으면

									if (datas.get(i).getCnt() > 0) {// 티켓 잔량이 1장 이상이라면
										
										cart.add(new Movie(datas.get(i).getNum(), datas.get(i).getName(), datas.get(i).getPrice()));// cart배열에 데이터 추가
										
										ticketNumFlag = true;// 티켓 허용 범위 플래그를 true로 변경

										System.out.println(datas.get(i).getName() + "의 티켓 " + ticketNum + "장 장바구니에 저장되었습니다.");// 예매완료메시지출력

										break;// for문 탈출

									}

								}

							}
							
							for(i = 0;i<cart.size();i++) {
								
								if (cart.get(i).getNum() == movieNum) {
									
									cart.get(i).setCartCnt(ticketNum);
									
								}
								
							}

							if (ticketNumFlag == true) {// 입력 값이 허용범위 였다면

								break;// while문 탈출

							}

						}

					} else {

						System.out.println("올바른 메뉴 번호를 입력해주세요.");

					}
					
					break;
					
				}

			} else if (action == 3) { // 장바구니 관련 코드

				/*
				 * 장바구니 기능만 우선 구현 들어오면 바로 지금 담은 티켓 배열 출력해서 보여주기
				 * 
				 * 담자마자 티켓재고에 영향을 주는 방식이 아니라 구매하려고 할 때 영향을 끼치게끔 장바구니가 추가된다면 * 예매하기 기능에서 장바구니 담기
				 * 추가
				 * 
				 * if ( action==1) { 지원님 여기 , 형련 일괄구매 (장바구니목록)} 장바구니 사용 방법 : (장바구니에 담을 수 있는 수치가
				 * 현재 남은 티켓 이상 담지 못하게끔 설정해주기), 영화 종류가 많아도 한 번에 다 살 수 있게끔 담은 티켓 수량 , 가격 :
				 * 
				 * else if (action==2) { 도연님이 여기 , 훈석님 수량 변경 } 남은 티켓에서 입력가능한 방향으로 -> 사용자에게 입력값
				 * 받기 (이후에 범위 검사해서 범위 안에 있는 값이라면 통과시켜주기)
				 * 
				 * else if (action ==3) { 이건 누가 한다 => x , ㄴㄴ이건 안됨 장바구니 비우기} .clear() 진짜 비우시겠습니까?
				 * 네
				 * 
				 * else if (aciton==0){ 메인메뉴로 }
				 * 
				 */

			}

		}
	}

}
