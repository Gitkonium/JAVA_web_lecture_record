package teamProject2_3; //ver 5.1

// 정보수정 유효성 검사 진행중(15%)

// 23.12.11 _ 15:55 // 정보수정 이름 공백입력 수정 
// 각자 작성한 코드 조립
// 피드백 받으며 다듬기
// 유효성검사 및 모듈화 95%
// 장바구니 시작.

// 유효성검사 -> 모듈화 -> 장바구니

/*영화 예매프로그램 : 설계

프로그램을 만드는 목적 : 

손님은 상영중인 영화를 확인하고, 영화 예매를 한 뒤에 바로 구매하거나 장바구니에 담아 두고 수량 변경과 한번에 구매가 가능하다. 
관리자는 영화관에서 영화정보 추가 (상영관 , 티켓) / 특정 영화 
인기가 좋을 시 해당 영화를 추가로 상영 (재고 추가)하거나, 인기가 없으면 해당영화 삭제가 가능한 프로그램 입니다.                               

영화 예매 자판기 ( 주제 ) 
상영중인 영화목록 = R (손님)
영화 선택 = R (손님)
영화 예매 = U (손님)
   바로 구매하기 = U
   장바구니에 담아두기 = U  
   syso (A티켓을 장바구니에 담았습니다).

while ( 종료조건 ) { 
담아둔 영화목록 확인(장바구니) = CRUD (손님)
   장바구니 목록보기 = R    (손님)
	구매하기 = U (손님)
   영화 예매 수량 변경 = U  (손님)
   장바구니 비우기= D  (손님)
   메인 메뉴로 = 0  (손님)
}

영화 추가 = C (관리자)
영화 삭제 = D (관리자)
상영중인 영화 정보 수정 = U (관리자)
영화 예매 확인하기 = R (손님- 본인 정보만) , (관리자 - 전체내역)
매출확인하기 = R (관리자)*/

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Movie {

	private int num; // PK영화의 고유 키값
	private String name; // 영화 이름
	private int price; // 영화 가격
	private int cnt; // 남은수량
	private int sellTicket; // 판매된 티켓의 수량을 누적하여 받음
	private int cartCnt; // 카트에 담겨진 티켓수량

	// 영화 클래스의 생성자 PK번호와 제목, 가격을 강제로 초기화 한다.
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
	public String toString() { // 기본 출력문구
		String msg = "[" + num + "] " + name + " " + price + "원 ";
		if (this.cnt <= 0) {
			msg += "[재고 없음] ";
		} else {
			msg += "[티켓잔량 : " + this.cnt + "]";
		}
		return msg;

	}

	// 티켓의 수량을 변경하는 메소드
	public void reservation(int inputNum) {
		
		this.cnt = this.cnt - inputNum; // 티켓을 구매했으면 티켓재고 감소
		this.sellTicket += inputNum; // 구매한 티켓만큼 추가해서 팔린티켓 계산
	}

}

public class TeamNum4_1 {

	// 반복되는 호출로 인하여 static 으로 선언
	public static Scanner sc = new Scanner(System.in);
	// 티켓의 최소 가격 설정
	final static int minPrice = 10000;
	// 티켓의 최대 가격 설정
	final static int maxPrice = 15000;

	// 배열리스트에 저장된 영화 목록을 출력하는 메소드
	public static void printList(ArrayList<Movie> datas) {
		for (Movie data : datas) { // 영화 목록 출력
			System.out.println(data);
		}
	}

	// 올바른 숫자를 입력하지 않을때 메세지 출력
	public static void printWrongNum() {
		System.out.println("올바른 숫자를 입력해주세요.");
	}

	// 정수가 아닌 다른 것 (ex. 문자열)등을 입력했을 때 작동하는 유효성검사 메소드
	public static int mismatchCheck() {
		int inputNum;	// 입력값을 받아오는 변수
		try {
			inputNum = sc.nextInt();
			sc.nextLine();
		} catch (InputMismatchException e) {
			sc.nextLine();
			return -1;	// 잘못 입력했을 경우 배열리스트에 없는 값인 -1로 반환
		}
		return inputNum;
	}

	// 입력한 번호의 값을 검사하는 메소드
	public static int inputNum() {
		int inputNum;
		while (true) {// 티켓의 장수 입력 반복문 , 음수 입력하는 경우에 문구 하나 추가 해주기
			System.out.print("입력 >>");
			inputNum = mismatchCheck();// 정수 입력 값 확인 함수의 반환 값 저장
			if (inputNum < 0) {
				printWrongNum(); // 올바른 숫자를 입력하지 않을때 메세지 출력
				continue;// while문 처음으로 돌아가기
			}
			break;
		}
		return inputNum;
	}
	
	// 변경할 영화의 입력값을 검사하는 메소드
	public static int findObj(ArrayList<Movie> datas) {
		int i;
		while (true) { // 변경할 영화번호가 올바른 번호인지 확인하는 반복문
			boolean flag = false;
			System.out.println("해당 영화 번호를 입력하세요 : ");
			int inputNum = inputNum(); // 입력한 번호의 값을 검사하는 메소드 사용

			// PK로 객체 찾기 모듈화
			for (i = 0; i < datas.size(); i++) {
				if (inputNum == datas.get(i).getNum()) {
					flag = true;
					break;
				}
			}
			if (flag) {
				break;
			}
			printWrongNum();
		}
		return i;
	}

	// 입력한 가격을 검사하는 메소드
	public static int insertPrice() {
		int price;
		while (true) {
			System.out.println("가격을 입력하세요(10,000원 ~ 15,000원 사이)");
			price = inputNum();

			if (minPrice <= price && price <= maxPrice) { // 범위강제
				break;
			}
			printWrongNum(); // 올바른 숫자를 입력하지 않을때 메세지 출력
		}
		return price;
	}

	// 문자열 입력값을 검사하는 메소드
	public static String insertName() {
		String name;
		while (true) { // 변경할 영화이름이 제대로 입력됐는지 확인하는 반복문
			System.out.print("새로운 영화 이름을 입력하세요 : "); 
			name = sc.nextLine();
			// trim() = 공백이 입력될 경우 공백을 지우는 함수
			// isEmpty() = 빈값이 입력되면 true를 리턴하는 함수
			if (name.trim().isEmpty()) {
				System.out.println("영화 이름을 공백으로 입력할 수 없습니다. 다시 입력해주세요");
				continue;
			}
			break;
		}
		return name;
	}

	// 현재 배열리스트에 영화가 존재하지 않을 경우 메세지를 출력하는 메소드
	public static boolean emptyCheck(ArrayList<Movie> datas) {
		if (datas.isEmpty()) {
			System.out.println("현재 상영중인 영화가 없습니다.");
			return true;
		}
		return false;
	}

	public static void main(String[] args) {

		ArrayList<Movie> datas = new ArrayList<Movie>(); // 영화 배열리스트
		ArrayList<Movie> cart = new ArrayList<Movie>(); // 장바구니 배열리스트
		
		int i;	// 인덱스 값을 찾을 수 있게 변수 선언
		int inputNum; // 티켓 갯수를 확인하는 변수
		boolean flag = false;	// 배열리스트에 반복 종료 조건을 확인 하기 위한 플래그 변수 선언
		Movie objectI;		// == datas.get(i) 영화 객체의 특정 값을 비교하기 위해 변수 선언

		int PK = 1001; // 영화번호 기본값

		while (true) { // 프로그램시작(무한루프)
			System.out.println("=== 영화 티켓 자판기 ===");
			System.out.println("1. 상영중인 영화목록");
			System.out.println("2. 티켓구매하기");
			System.out.println("3. 장바구니");
			System.out.println("0. 프로그램 종료");
			System.out.println("메뉴를 선택해주세요");
			int action = inputNum(); // 입력한 번호의 값을 검사하는 메소드 사용
			if (action == 0) { // 종료조건 : 0을 입력받으면 프로그램 종료
				break;
			} else if (action == 8) {
				while (true) { // 관리자 모드 시작(무한루프)
					System.out.println();
					System.out.println("=== 관리자 모드 ===");
					System.out.println("1. 영화 추가하기");
					System.out.println("2. 영화 정보 수정");
					System.out.println("3. 상영중인 영화 내리기");
					System.out.println("4. 구매 현황 확인하기");
					System.out.println("5. 매출 확인하기");
					System.out.println("0. 관리자 모드 종료");
					System.out.println("메뉴를 선택해주세요");
					action = inputNum(); // 입력한 번호의 값을 검사하는 메소드 사용
					if (action == 0) { // 종료조건 : 0을입력받으면 프로그램 종료
						System.out.println("관리자 모드 종료");
						break;

					} else if (action == 1) { // 영화의 제목과 가격을 입력 후 영화 추가
						String name = insertName();	// 문자열 입력값을 검사하는 메소드 사용
						int price = insertPrice();		// 입력한 가격을 검사하는 메소드 사용
						System.out.println("영화가 추가되었습니다.");
						datas.add(new Movie(PK++, name, price));

					} else if (action == 2) {
						if (emptyCheck(datas)) { // 현재 배열리스트에 영화가 존재하지 않을 경우 메세지를 출력하는 메소드 사용
							continue;
						}
						int newCnt; // 변경할 티켓 수량
						int newPrice; // 변경할 티켓 가격
						String newName; // 변경할 영화 이름

						printList(datas); // 배열리스트에 저장된 영화 목록을 출력 메소드 사용
						// 변경할 영화의 입력값을 검사하는 메소드 사용
						objectI = datas.get(findObj(datas));  
						newName = insertName();	// 문자열 입력값을 검사하는 메소드 사용
						objectI.setName(newName); // 새로운 이름으로 변경.

						while (true) { // 변경할 티켓 수량이 티켓의 갯수, 최대,최소 가격의 범위를 만족하는지 확인하는 반복문
							System.out.print("수정할 티켓 수량을 입력하세요 (최대 500장) ");
							newCnt = mismatchCheck();
							if (newCnt < 0 && newCnt <= 500) {
								printWrongNum(); // 올바른 숫자를 입력하지 않을때 메세지 출력
								continue;
							}
							break;
						}
						objectI.setCnt(newCnt); // 새로 입력한 티켓수량으로 변경
						newPrice = insertPrice();// 입력한 가격을 검사하는 메소드
						objectI.setPrice(newPrice); // 새로 설정한 이름으로 영화 제목 변경
						System.out.println("영화 정보가 수정되었습니다.");
					} else if (action == 3) { // 현재 등록된 영화를 제거하는 기능
						if (emptyCheck(datas)) {	// 현재 배열리스트에 영화가 존재하지 않을 경우 메세지를 출력하는 메소드 사용
							continue;
						}
						System.out.println("영화 번호를 입력해서 상영중인 영화를 삭제합니다.");
						printList(datas);	// 배열리스트에 저장된 영화 목록을 출력 메소드 사용
						i = findObj(datas); 	// 변경할 영화의 입력값을 검사하는 메소드 사용
						Movie ObjectI = datas.get(i);
						System.out.println("[" + ObjectI.getNum() + "] " + ObjectI.getName() + "영화가 삭제됩니다.");
						datas.remove(i);
					} else if (action == 4) { 
						if (emptyCheck(datas)) { // 상영중인 영화가 없다면 // 현재 배열리스트에 영화가 존재하지 않을 경우 메세지를 출력하는 메소드 사용
							continue;
						}
						System.out.println("현재 구매현황 확인하기");
						System.out.println();

						for (Movie data : datas) {
							System.out.println(data.getName() + "의 판매된 티켓 : " + (data.getSellTicket()));
						}

					} else if (action == 5) { // 총 매출을 확인하는 코드
						if (emptyCheck(datas)) { // 현재 배열리스트에 영화가 존재하지 않을 경우 메세지를 출력하는 메소드 사용
							continue;
						}
						int total = 0;
						for (Movie data : datas) {
							System.out.println(
									data.getName() + "의 매출액은 " + data.getSellTicket() * data.getPrice() + "원 입니다.");
							total += data.getSellTicket() * data.getPrice();
						}
						System.out.println("총 매출액은 " + total + "원 입니다.");
					} else {
						printWrongNum();// 올바른 숫자를 입력하지 않을때 메세지 출력
					}
				}
			} else if (action == 1) { // 상영중인 영화목록을 보여주는 코드
				if (emptyCheck(datas)) { // 현재 배열리스트에 영화가 존재하지 않을 경우 메세지를 출력하는 메소드 사용
					continue;
				}
				System.out.println("===절찬 상영중===");
				printList(datas);	// 배열리스트에 저장된 영화 목록을 출력 메소드 사용

			} else if (action == 2) { // 영화티켓을 구매하는 기능
				if (emptyCheck(datas)) {	// 현재 배열리스트에 영화가 존재하지 않을 경우 메세지를 출력하는 메소드 사용
					continue;
				}

				while (true) {// 티켓 구매 반복문 (올바르게 입력되는지)

					System.out.println("=============================");
					printList(datas);	// 배열리스트에 저장된 영화 목록을 출력 메소드 사용
					System.out.println("=============================");
					System.out.println("1. 영화 구매하기");
					System.out.println("2. 장바구니에 담기");

					inputNum = inputNum(); // 입력한 번호의 값을 검사하는 메소드 사용

					if (inputNum == 1) { // PK로 객체 찾기

						i = findObj(datas);	// 변경할 영화의 입력값을 검사하는 메소드 사용
						objectI = datas.get(i); 
						if (objectI.getCnt() <= 0) { // 현재 해당영화의 티켓 재고가 0보다 같거나 작다면
							System.out.println("티켓이 매진되었습니다.");
							break;
						}

						while (true) {// 올바른 티켓 갯수를 입력할 때까지 확인하는 반복문 , 음수를 입력하는 경우 안내문구 추가

							System.out.println("구매할 티켓의 장수를 입력해주세요.");
							inputNum = inputNum(); // 입력한 번호의 값을 검사하는 메소드 사용
							if (inputNum == 0) {
								printWrongNum();// 올바른 숫자를 입력하지 않을때 메세지 출력
								continue;
							}

							if (objectI.getCnt() < inputNum) {// 티켓 잔량이 입력 값보다 적다면 continue;
								System.out.println("티켓의 잔량을 초과하였습니다.");
								continue;
							}
							objectI.reservation(inputNum);// 티켓 잔량을 감소 시키는 메서드 호출
							System.out.println(objectI.getName() + "의 티켓이 " + inputNum + "장 구매완료 되었습니다.");
							flag = true;
							// 구매 완료 메세지 출력
							break;
						}
						if (flag) {
							break;
						}

					} else if (inputNum == 2) { // PK로 객체 찾기

						i = findObj(datas); 	// 변경할 영화의 입력값을 검사하는 메소드 사용
						objectI = datas.get(i);

						while (true) {// 티켓의 장수 입력 반복문 , 음수 입력하는 경우에 문구 하나 추가 해주기
							System.out.println("장바구니에 담을 티켓의 장수를 입력해주세요");
							inputNum = inputNum(); // 입력한 번호의 값을 검사하는 메소드 사용

							// 카트 객체 찾기
							flag = false;
							for (int j = 0; j < cart.size(); j++) { // 장바구니 배열에서 해당하는 값을 찾는 for문
								if (cart.get(j).getNum() == objectI.getNum()) { // 장바구니 배열의 J번째 영화번호가 , 실제 영화번호와 값이 같다면
									flag = true; // 티켓범위를 확인하는 변수를 true로 변경하고
									System.out.println(objectI.getName() + "의 티켓 " + inputNum + "장 장바구니에 저장되었습니다.");
									cart.get(j).setCartCnt(cart.get(j).getCartCnt() + inputNum); // 장바구니 J번째에 담긴 티켓 수량에
									break;
								}
							}

							if (flag) { // 만약 값이 올바른 범위에서 조정 됐다면 while문 탈출
								break;
							} // 플래그조심1 플래그 변수명을 기존과 다르게 설정하거나 플래그를 false로 미리 초기화했어야함

							if (inputNum < objectI.getCnt()) {// i번째 배열에 있는 티켓 수량이 0보다 크다면
								objectI.setCartCnt(inputNum); // 영화배열 i번째 데이터에 장바구니에 담긴 티켓수량을 저장한다
								cart.add(objectI); // 장바구니 배열에 해당 값을 추가함
								flag = true;
								System.out.println(objectI.getName() + "의 티켓 " + inputNum + "장 장바구니에 저장되었습니다.");
								break;
							} else {
								System.out.println("입력값이 남은 수량보다 많습니다.");
								continue;
							}

						}

					} else {
						printWrongNum();// 올바른 숫자를 입력하지 않을때 메세지 출력
					}
					if (flag == true) {// 입력 값이 허용범위내에서 들어왔다면
						break; // while문 탈출
					}
				}

			} else if (action == 3) {
				// 장바구니 관련 코드
				/*
				 * -* 장바구니 기능만 우선 구현 들어오면 바로 지금 담은 티켓 배열 출력해서 보여주기
				 * 
				 * 담자마자 티켓재고에 영향을 주는 방식이 아니라 구매하려고 할 때 영향을 끼치게끔 장바구니가 추가된다면 * 구매하기 기능에서 장바구니 담기
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
					if (emptyCheck(cart)) { // 현재 배열리스트에 영화가 존재하지 않을 경우 메세지를 출력하는 메소드 사용
						System.out.println("장바구니의 예매내역이 없습니다.");
						break;
					}
					System.out.println();
					System.out.println("장바구니에 담겨있는 티켓 수량");

					int total = 0; // 장바구니 출력문구
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
					action = mismatchCheck();// 정수 입력 값 확인 함수의 반환 값 저장
					if (action < 0) {
						printWrongNum();// 올바른 숫자를 입력하지 않을때 메세지 출력
						continue;// while문 처음으로 돌아가기
					}
					if (action == 0) { // 종료조건
						break;
					} else if (action == 1) {
						while (true) {
							for (Movie data : cart) {
								System.out.println("[" + data.getNum() + "] [" + data.getName() + "] " + "가격 :"
										+ data.getPrice() + "원 수량 :" + data.getCartCnt() + "매");
							}
							System.out.println("총 금액은 " + total + "원입니다.");

							System.out.println("결제할 상품이 맞으십니까?");
							System.out.println("맞으시면 1, 장바구니로 돌아가시려면 2를 입력해주십시오");
							System.out.print("입력 >> ");
							action = inputNum();
							if (action == 1) {

								for (i = 0; i < cart.size(); i++) {
									Movie cartObj = cart.get(i);

									for (int j = 0; j < datas.size(); j++) {
										Movie movieObj = datas.get(j);
										if (cartObj.getNum() == movieObj.getNum()) {
											// 티켓의 수량을 변경하는 메소드 사용
											movieObj.reservation(cartObj.getCartCnt());
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
							printWrongNum();// 올바른 숫자를 입력하지 않을때 메세지 출력
						}

					} else if (action == 2) { // 장바구니 예매한 티켓의 갯수를 변경
						// cart 배열리스트에 저장된 티켓의 갯수만 변경 할 수 있다.
						// 카트 객체 찾기

						i = findObj(cart);	// 변경할 영화의 입력값을 검사하는 메소드 사용
						objectI = cart.get(i);
						System.out.println("예매한 티켓의 수 : " + objectI.getCartCnt());

						while (true) {

							System.out.print("변경할 티켓의 수량을 입력하세요 : ");

							inputNum = inputNum();	// 입력한 번호의 값을 검사하는 메소드 사용
							// 변경할 영화의 입력값을 검사하는 메소드 사용
							if (0 <= inputNum && inputNum <= datas.get(findObj(datas)).getCnt()) {
								objectI.setCartCnt(inputNum);
								System.out.println("변경한 티켓 수 : " + objectI.getCartCnt());
								System.out.println("변경 되었습니다. ");
								break;
							}

							printWrongNum();// 올바른 숫자를 입력하지 않을때 메세지 출력
						}

					} else if (action == 3) {

						while (true) {
							System.out.println("삭제를 하시겠습니까?");
							System.out.println("맞으시면 1번, 장바구니로 돌아가시려면 0번을 입력해주세요");
							System.out.print("입력 >> ");
							action = inputNum();	// 입력한 번호의 값을 검사하는 메소드 사용
							if (action == 1) {
								cart.clear();
								System.out.println("장바구니 비우기 완료!");
								break;

							} else if (action == 0) {
								System.out.println("장바구니로 돌아갑니다.");
								break;
							}

							printWrongNum();// 올바른 숫자를 입력하지 않을때 메세지 출력
						}
					}
				} // 장바구니while문 끝

			} // eles if(action == 3) 3.장바구니확인 끝
			else {
				printWrongNum();// 올바른 숫자를 입력하지 않을때 메세지 출력
			}
		} // 전체프로그램 끝

	} // main()함수 끝

}