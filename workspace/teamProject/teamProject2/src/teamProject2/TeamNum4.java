package class01; //ver 5.0 

// 정보수정 유효성 검사 진행중(15%)

//23.12.11 _ 15:55 // 정보수정 이름 공백입력 수정 
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
	private int cartCnt; // 카트에 담겨진 티켓수량

	Movie(int num, String name, int price) {
		this.num = num;
		this.name = name;
		this.price = price;
		this.cnt = 30; // 기본값 30으로 설정
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
	public String toString() { // 기본 출력문구?
		String msg = "[" + num + "] " + name + " " + price + "원";
		if (this.cnt <= 0) {
			msg += "[재고 없음] ";
		} else {
			msg += "[남은티켓 : " + this.cnt + "]";
		}
		return msg;

	}

	public void reservation(int ticketNum) {

		this.cnt = cnt - ticketNum; // 티켓을 구매했으면 티켓재고 감소
		this.sellTicket += ticketNum; // 구매한 티켓만큼 추가해서 팔린티켓 계산
	}

}

public class TeamNum4 {

	public static int mismatchCheck(Scanner sc) { // 정수가 아닌 다른 것 (ex. 문자열)등을 입력했을 때 작동하는 유효성검사
		int selectNum = 0;
		try {
			selectNum = sc.nextInt();
			sc.nextLine();
		} catch (java.util.InputMismatchException e) {
			sc.nextLine();
			return -1;
		}
		return selectNum;
	}

	public static boolean priceCheck(int newPrice, String newName, int PK, ArrayList<Movie> datas) {

		boolean flag = false;
		final int minPrice = 10000;
		final int maxPrice = 15000;
		if (minPrice <= newPrice && newPrice <= maxPrice) { // 범위강제
			datas.add(new Movie(PK, newName, newPrice));
			System.out.println("영화가 추가되었습니다.");
			flag = true;
			return flag;
		}
		return flag;
	}

	public static void main(String[] args) {
	

		ArrayList<Movie> datas = new ArrayList<Movie>(); // 영화 배열리스트
		ArrayList<Movie> cart = new ArrayList<Movie>(); // 장바구니 배열리스트

		int PK = 1001; // 영화번호 기본값

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("===영화 티켓 자판기===");
			System.out.println("1. 상영중인 영화목록");
			System.out.println("2. 예매하기");
			System.out.println("3. 장바구니 = 예제");
			System.out.println("0. 프로그램 종료");
			System.out.print("메뉴를 선택해주세요 >> ");
			int action = mismatchCheck(sc);
			if (action < 0) {
				System.out.println("메뉴 번호만 입력해주세요!");
				continue;
			}
			if (action == 0) {
				break;
			} else if (action == 4885) {
				while (true) {
					System.out.println("===관리자 모드===");
					System.out.println("1. 영화 추가하기");
					System.out.println("2. 영화 정보 수정");
					System.out.println("3. 상영중인 영화 내리기");
					System.out.println("4. 예매 현황 확인하기");
					System.out.println("5. 매출 확인하기");
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
					} else if (action == 1) { // 영화의 제목과 가격을 입력 후 영화 추가
						int price = 0;
						String name;
						while (true) { //영화이름이 제대로 입력됐는지 확인하는 반복문
							System.out.print("영화 이름을 입력하세요 : ");
							name = sc.nextLine();
							if (name.trim().isEmpty()) {
								System.out.println("영화 이름을 공백으로 입력할 수 없습니다. 다시 입력해주세요");
								continue;
							}
							break;
						}
						while (true) {

							try {
								System.out.print("가격을 입력하세요(10,000원 ~ 15,000원 사이) >> ");
								price = sc.nextInt();
							} catch (InputMismatchException e) {
								System.out.println("정수만 입력 가능합니다.");
								System.out.println("다시 입력해주세요");
								sc.nextLine();
								continue;
							}
							if (priceCheck(price, name, PK++, datas)) {
								break;
							} System.out.println("입력값이 범위를 벗어났습니다. \n 다시 입력해주세요");
						}
						

					} else if (action == 2) {
						int i;
						int selectNum; // 수정할 영화 번호
						int newCnt; // 변경할 티켓 수량
						int newPrice; // 변경할 티켓 가격
						String newName; // 변경할 영화 이름
						boolean flag;

						for (i = 0; i < datas.size(); i++) { // 영화 목록 출력

							System.out.println("[" + datas.get(i).getNum() + "] " + datas.get(i).getName()
									+ " (티켓 잔량 : " + datas.get(i).getCnt() + ")");
						}

						while (true) { // 변경할 영화번호가 올바른 번호인지 확인하는 반복문
							flag = false;
							System.out.print("수정할 영화 번호를 입력하세요 : ");
							selectNum = mismatchCheck(sc); // 정수를 입력했는지 확인하는 유효성검사
							if (selectNum == -1) {
								System.out.println("올바른 번호를 입력해주세요");
								continue;
							}
							for (i = 0; i < datas.size(); i++) {
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
						while (true) { // 변경할 영화이름이 제대로 입력됐는지 확인하는 반복문
							System.out.print("새로운 영화 이름을 입력하세요 : ");
							newName = sc.nextLine();
							if (newName.trim().isEmpty()) {
								System.out.println("영화 이름을 공백으로 입력할 수 없습니다. 다시 입력해주세요");
								continue;
							}
							break;
						}
						datas.get(i).setName(newName); // 새로운 이름으로 변경.

						while (true) { // 변경할 티켓 수량이 티켓의 갯수, 최대,최소 가격의 범위를 만족하는지 확인하는 반복문
							flag = false;
							System.out.print("수정할 티켓 수량을 입력하세요 : ");
							newCnt = mismatchCheck(sc);

							if (newCnt < 0) {
								System.out.println("0 이상의 숫자만 입력해주세요");
								continue;
							}

							if (selectNum == datas.get(i).getNum()) {
								if (datas.get(i).getCnt() + newCnt >= 0) {
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
						datas.get(i).setCnt(newCnt); // 새로 입력한 티켓수량으로 변경

						while (true) {
							System.out.print("새로운 영화 가격을 입력하세요(10,000원 ~ 15,000원 사이): ");
							newPrice = mismatchCheck(sc);

							if (newPrice == -1) { // -1을 입력하면
								System.out.println("숫자만 입력 가능합니다.");
								continue;
							}

							if (newPrice < 10000 || newPrice > 15000) { // 275번 수정필요 12/11 17:10
								System.out.println("입력값이 범위를 벗어났습니다. \n 다시 입력해주세요");
								continue;
							}
							break;

						}
						datas.get(i).setPrice(newPrice); // 새로 설정한 이름으로 영화 제목 변경

						System.out.println("영화 정보가 수정되었습니다.");

					} else if (action == 3) { // 현재 등록된 영화를 제거하는 기능
						int selectNum = 0;
						System.out.println("영화 번호를 입력해서 상영중인 영화를 삭제합니다.");
						for (Movie data : datas) { // 영화 목록 출력
							System.out.println(data);
						}

						while (true) {
							System.out.print("삭제할 영화의 번호를 입력해주세요 >> ");
							selectNum = mismatchCheck(sc);
							System.out.println("정수만 입력 가능합니다");
							if (selectNum == -1) {
								System.out.println("입력한 번호는 없는 영화입니다.");
								continue;
							}

							boolean flag = false; // 유효성 검사를 위한 변수
							for (int i = 0; i < datas.size(); i++) {
								if (selectNum == datas.get(i).getNum()) {
									System.out.println(
											"[" + datas.get(i).getNum() + "] " + datas.get(i).getName() + "영화가 삭제됩니다.");
									flag = true; // 값을 찾으면 true로 변경
									datas.remove(i);
									break;
								}

							}
							if (!flag) { // 값을 찾지못해 flag값이 들어오지 못하면 실행되는 안내문
								System.out.println("입력한 번호는 없는 영화입니다.");
								continue;
							}
							break;
						}
					} else if (action == 4) {
						if (datas.isEmpty()) { // 상영중인 영화가 없다면
							System.out.println("현재 상영중인 영화가 없습니다.");
						}
						System.out.println();
						System.out.println("현재 예매(구매)현황 확인하기");
						System.out.println();

						for (Movie data : datas) {
							System.out.println(data.getName() + "의 판매된 티켓 : " + (data.getSellTicket()));
						}

					} else if (action == 5) { // 총 매출을 확인하는 코드
						int total = 0;
						for (Movie data : datas) {
							System.out.println(
									data.getName() + "의 매출액은 " + data.getSellTicket() * data.getPrice() + "원 입니다.");
							total += data.getSellTicket() * data.getPrice();
						}
						System.out.println("총 매출액은 " + total + "원 입니다.");
					}
				}
			} else if (action == 1) { // 상영중인 영화목록을 보여주는 코드
				if (datas.isEmpty()) {
					System.out.println("현재 상영중인 영화가 없습니다.");
					continue;
				}

				System.out.println("===절찬 상영중===");

				for (Movie data : datas) {

					System.out.println(data);

				}

			} else if (action == 2) { // 영화티켓을 구매하는 기능
				if (datas.isEmpty()) {
					System.out.println("현재 상영중인 영화가 없습니다.");
					continue;
				}
				int i = 0;

				int movieNum = 0; // 영화 번호 변수

				int ticketNum = 0; // 티켓 갯수를 확인하는 변수

				boolean movieNumFlag = false; // 영화 번호의 입력 범위 확인용 변수

				boolean ticketNumFlag = false; // 티켓 수량의 입력 범위 확인용 변수

				int selectNum = 0;// 입력 값을 확인하고 반환 값을 저장하는 변수

				while (true) {// 티켓 구매 반복문 (올바르게 입력되는지)

					System.out.println("=============================");

					for (Movie data : datas) {

						System.out.println(data);

					}

					System.out.println("=============================");

					System.out.println("1. 영화 예매하기");

					System.out.println("2. 장바구니에 담기");

					System.out.print("입력 >>");

					selectNum = mismatchCheck(sc);// 올바른 정수만 입력됐는지 확인하는 유효성 검사

					if (selectNum == -1) {
						System.out.println("메뉴 번호만 입력해주세요!");
						continue;

					}

					if (selectNum == 1) {

						while (true) { // 영화번호가 올바르게 입력됐는지 찾는 반복문

							System.out.print("예매할 영화의 번호를 입력해주세요. >>");

							movieNum = mismatchCheck(sc); // 정수 입력 유효성검사

							if (movieNum == -1) {
								System.out.println("올바른 숫자를 입력해주세요");
								continue;

							}

							for (i = 0; i < datas.size(); i++) {

								if (datas.get(i).getNum() == movieNum) {
									// i번째 데이터의 영화번호 값이 입력된 값과 같으면 통과
									movieNumFlag = true;

									break;

								}

							}

							if (movieNumFlag == true) {// 영화 번호가 존재한다면

								break;// while문 탈출

							} else { // 존재하지 않는다면

								System.out.println("올바른 영화 번호를 입력해주세요."); // 안내 메세지 출력

							}

						}

						if (datas.get(i).getCnt() <= 0) { // 현재 해당영화의 티켓 재고가 0보다 같거나 작다면

							System.out.println("티켓이 매진되었습니다.");

							break;

						}

						while (true) {// 올바른 티켓 갯수를 입력할 때까지 확인하는 반복문 , 음수를 입력하는 경우 안내문구 추가

							System.out.print("예매할 티켓의 장수를 입력해주세요. >>");

							ticketNum = mismatchCheck(sc);

							if (ticketNum <= 0) {
								System.out.println("올바른 숫자를 입력해주세요.");
								continue;// while문 처음으로 돌아가기
							}

							for (i = 0; i < datas.size(); i++) { // 배열 만큼 반복

								if (datas.get(i).getNum() == movieNum) { // i번째 데이터의 영화번호 값이 입력한 번호와 같다면

									if (datas.get(i).getCnt() < ticketNum) {// 티켓 잔량이 입력 값보다 적다면

										System.out.println("티켓의 잔량을 초과하였습니다.");// 안내 메세지 출력

										break;// for문 탈출

									}

									if (datas.get(i).getCnt() > 0) {// 티켓 잔량이 1장 이상이라면

										datas.get(i).reservation(ticketNum);// 티켓 잔량을 감소 시키는 메서드 호출

										ticketNumFlag = true;// 티켓 수량 확인 플래그를 true로 변경

										System.out.println(
												datas.get(i).getName() + "의 티켓이 " + ticketNum + "장 예매완료 되었습니다.");// 예매완료메시지
																													// ,
																													// 출력

										break;// for문 탈출

									}

								}

							}

							if (ticketNumFlag == true) {// 입력한 값이 허용범위안에 있다면

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

								if (datas.get(i).getNum() == movieNum) {// i번째 데이터의 영화번호 값이 입력한 번호와 같다면

									movieNumFlag = true;

									break;

								}

							}

							if (movieNumFlag == true) { // 영화번호의 입력값이 올바르게 확인됐다면

								break;// while문 탈출

							} else { // 존재하지 않는 입력번호가 들어왔다면

								System.out.println("올바른 영화 번호를 입력해주세요.");// 안내 메세지 출력

							}

						}

						while (true) {// 티켓의 장수 입력 반복문 , 음수 입력하는 경우에 문구 하나 추가 해주기

							System.out.print("장바구니에 담을 티켓의 장수를 입력해주세요. >>");

							ticketNum = mismatchCheck(sc);// 정수 입력 값 확인 함수의 반환 값 저장

							if (ticketNum <= 0) {
								System.out.println("올바른 숫자를 입력해주세요.");
								continue;// while문 처음으로 돌아가기
							}

							for (int j = 0; j < cart.size(); j++) { // 장바구니 배열에서 해당하는 값을 찾는 for문
								if (cart.get(j).getNum() == movieNum) { // 장바구니 배열의 J번째 영화번호가 , 실제 영화번호와 값이 같다면
									ticketNumFlag = true; // 티켓범위를 확인하는 변수를 true로 변경하고
									cart.get(j).setCartCnt(cart.get(j).getCartCnt() + ticketNum); // 장바구니 J번째에 담긴 티켓 수량에
																									// 새로 입력한 값을 추가함.
									System.out
											.println(datas.get(i).getName() + "의 티켓 " + ticketNum + "장 장바구니에 저장되었습니다.");
									break;
								}
							}
							if (ticketNumFlag) { // 만약 값이 올바른 범위에서 조정 됐다면 while문 탈출
								break;
							}

							for (i = 0; i < datas.size(); i++) {

								if (datas.get(i).getNum() == movieNum) {// i번째 데이터의 영화번호 값이 입력한 번호와 같다면

									if (datas.get(i).getCnt() > 0) {// i번째 배열에 있는 티켓 수량이 0보다 크다면

										datas.get(i).setCartCnt(ticketNum); // 영화배열 i번째 데이터에 장바구니에 담긴 티켓수량을 저장한다

										cart.add(datas.get(i)); // 장바구니 배열에 해당 값을 추가함

										ticketNumFlag = true;

										System.out.println(
												datas.get(i).getName() + "의 티켓 " + ticketNum + "장 장바구니에 저장되었습니다.");

										break;

									}

								}

							}

							if (ticketNumFlag == true) {// 입력 값이 허용범위내에서 들어왔다면

								break;// while문 탈출

							}

						}

					} else {

						System.out.println("올바른 메뉴 번호를 입력해주세요.");

					}

					break;
				}

			} else if (action == 3) {
				// 장바구니 관련 코드
				/*
				 * -* 장바구니 기능만 우선 구현 들어오면 바로 지금 담은 티켓 배열 출력해서 보여주기
				 * 
				 * 담자마자 티켓재고에 영향을 주는 방식이 아니라 구매하려고 할 때 영향을 끼치게끔 장바구니가 추가된다면 * 예매하기 기능에서 장바구니 담기
				 * 추가
				 * 
				 * if ( action==1) 장바구니 사용 방법 : (장바구니에 담을 수 있는 수치가 현재 남은 티켓 이상 담지 못하게끔 설정해주기),
				 * 영화 종류가 많아도 한 번에 다 살 수 있게끔 담은 티켓 수량과 가격을 계산하여 총 금액을 출력해줌
				 * 
				 * else if (action==2) 남은 티켓 수량과 비교하여 최대값과 같은값 내에서만 입력을 받아주고, 해당 값으로 변환
				 * 
				 * 
				 * else if (action ==3) 장바구니 비우기 .clear() 진짜 비우시겠습니까? , 재확인문구 출력
				 *
				 *
				 * else if (aciton==0){ 메인메뉴로 }
				 * 
				 */

				while (true) {
					if (cart.isEmpty()) { // 만약 장바구니안이 비어있다면
						System.out.println("장바구니에 예매내역이 없습니다.");
						break;
					}
					System.out.println();
					System.out.println("장바구니에 담겨있는 티켓 수량");

					int total = 0;
					for (Movie data : cart) {
						System.out.println("[" + data.getNum() + "] [" + data.getName() + "] " + "가격 :"
								+ data.getPrice() + "원 수량 :" + data.getCartCnt() + "매");
						total += data.getPrice() * data.getCartCnt();
					}
					System.out.println("총 금액은 " + total + "원입니다.");
					System.out.println();
					System.out.println("1. 구매하기"); // 장바구니 전체 구매
					System.out.println("2. 티켓수량변경");
					System.out.println("3. 장바구니비우기");
					System.out.println("0. 메인메뉴로");
					action = mismatchCheck(sc);// 정수 입력 값 확인 함수의 반환 값 저장
					if (action < 0) {
						System.out.println("올바른 숫자를 입력해주세요.");
						continue;// while문 처음으로 돌아가기
					}
					if (action == 0) {
						break;
					} else if (action == 1) {
						while (true) {
							boolean flag = false;
							for (Movie data : cart) {
								System.out.println("[" + data.getNum() + "] [" + data.getName() + "] " + "가격 :"
										+ data.getPrice() + "원 수량 :" + data.getCartCnt() + "매");
							}
							System.out.println("총 금액은 " + total + "원입니다.");

							System.out.println("결제할 상품이 맞으십니까?");
							System.out.println("맞으시면 1, 장바구니로 돌아가시려면 2를 입력해주십시오");
							System.out.print("입력 >> ");
							action = mismatchCheck(sc);// 정수 입력 값 확인 함수의 반환 값 저장
							if (action <= 0) {
								System.out.println("올바른 숫자를 입력해주세요.");
								continue;// while문 처음으로 돌아가기
							}

							int i = 0;
							int j = 0;

							if (action == 1) {

								for (i = 0; i < cart.size(); i++) {
									Movie cartNum = cart.get(i);

									for (j = 0; j < datas.size(); j++) {
										Movie movieNum = datas.get(j);

										if (cartNum.getNum() == movieNum.getNum()) {

											movieNum.reservation(cartNum.getCartCnt());

										}

									}

								}
								cart.clear();
								System.out.println("구매 완료하셨습니다.");
								break;
							} else if (action == 2) {
								System.out.println("장바구니로 돌아갑니다.");
								break;
							}
							System.out.println("잘못입력하셨습니다.");
						}

					} else if (action == 2) { // 장바구니 예매한 티켓의 갯수를 변경
						// cart 배열리스트에 저장된 티켓의 갯수만 변경 할 수 있다.

						int i = 0;
						int selectNum;
						int ticketNum;

						while (true) {

							System.out.print("영화 번호를 입력하세요 : ");
							selectNum = mismatchCheck(sc);// 정수 입력 값 확인 함수의 반환 값 저장
							if (selectNum <= 0) {// 반환 값이 -1이면
								System.out.println("올바른 숫자를 입력해주세요.");
								continue;// while문 처음으로 돌아가기
							}

							boolean flag = false;
							for (i = 0; i < cart.size(); i++) {
								if (cart.get(i).getNum() == selectNum) {
									System.out.println("예매한 티켓의 수 : " + cart.get(i).getCartCnt());
									flag = true;
									break;
								}
							}
							if (flag) {
								break;
							}
							System.out.println("올바른 숫자를 입력해주세요.");

						}

						if (cart.get(i).getNum() == selectNum) {
							while (true) {

								System.out.print("변경할 티켓의 수량을 입력하세요 : ");
								ticketNum = mismatchCheck(sc);// 정수 입력 값 확인 함수의 반환 값 저장

								if (ticketNum <= 0) {// 반환 값이 -1이면
									System.out.println("올바른 숫자를 입력해주세요.");
									continue;// while문 처음으로 돌아가기
								}

								if (0 <= ticketNum && ticketNum <= datas.get(i).getCnt()) {
									cart.get(i).setCartCnt(ticketNum);
									System.out.println("변경한 티켓 수 : " + cart.get(i).getCartCnt());
									System.out.println("변경 되었습니다. ");
									break;
								}

								System.out.println("티켓의 수량을 제대로 입력해주세요");
							}

						}

					} else if (action == 3) {

						while (true) {

							System.out.println("삭제를 하시겠습니까?");
							System.out.println("맞으시면 1번, 장바구니로 돌아가시려면 0번을 입력해주세요");
							System.out.print("입력 >> ");

							try {

								action = sc.nextInt();

							} catch (InputMismatchException e) {

								sc.nextLine();
								System.out.println("올바른 번호를 입력해주새요.");
								continue;

							}
							if (action == 1) {

								cart.clear();
								System.out.println("장바구니비우기완료!");
								break;

							} else if (action == 0) {

								System.out.println("장바구니로 돌아갑니다.");
								break;
							}

							System.out.println("올바른 번호를 입력해주세요.");

						}

					}

				} // 장바구니while문 끝

			} // eles if(action == 3) 3.장바구니확인 끝
			else {
				System.out.println("메뉴 번호만 입력해주세요!");
			}
		} // 전체프로그램 끝
		

	} // main()함수 끝

}