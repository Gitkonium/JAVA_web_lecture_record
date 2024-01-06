package team;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ConvenienceStore {
	static Scanner sc = new Scanner(System.in); // 스캐너
	static ArrayList<Item> basketDatas = new ArrayList<Item>(); // 장바구니 데이터 리스트
	static ArrayList<Item> itemDatas = new ArrayList<Item>(); // 아이템 데이터 리스트

	// 정수값 입력 받기
	// 주어진 메시지를 출력하고 사용자로부터 정수값을 입력받는 메서드
	// @param msg 출력할 메시지 문자열
	// @return 입력받은 정수값
	public static int getNum(String msg) {
		System.out.println(msg);
		return sc.nextInt();
	}

	// 문자열 입력 받기
	// 주어진 메시지를 출력하고 사용자로부터 문자열을 입력받는 메서드
	// @param msg 출력할 메시지 문자열
	// @return 입력받은 문자열값
	public static String getWrite(String msg) {
		System.out.println(msg);
		return sc.next();
	}

	// 모드 선택 페이지 출력
	// @param 없음
	// @return 없음
	public static void selectModePage() {
		System.out.println("========== 모드 선택 ==========");
		System.out.println("◆  1. 관리자 모드");
		System.out.println("◆  2. 유저 모드");
		System.out.println("◆  0. 편의점 나"
				+ "가기");
	}

	// 손님 메뉴 페이지 출력
	// @param 없음
	// @return 없음
	public static void customerPage() {
		System.out.println("◆  1. 구매하기");
		System.out.println("◆  2. 장바구니 확인하기");
		System.out.println("◆  0. 뒤로가기");
	}

	// 관리자 기능 페이지
	// @param 없음
	// @return 없음
	public static void adminPage() {
		System.out.println("========== 관리자 페이지 ==========");
		System.out.println("◆  1. 제품 조회");
		System.out.println("◆  2. 제품 추가");
		System.out.println("◆  3. 재고 추가");
		System.out.println("◆  4. 제품 삭제");
		System.out.println("◆  5. 비밀번호 변경");
		System.out.println("◆  6. 폐점 하기");
		System.out.println("◆  0. 뒤로 가기");
	}

	// 에러 메시지 출력
	// @param 없음
	// @return 없음
	public static void errMsg() {
		System.out.println("오류가 발생했습니다. 관리자에게 문의해주세요");
	}

	// 비밀번호 형식 정보 출력
	// @param 없음
	// @return 없음
	public static void pwFormInfo() {
		System.out.println("비밀번호를 설정합니다");
		System.out.println("비밀번호는 네 자리 숫자입니다.");
		System.out.println("주의! 알파벳과 특수문자는 사용할 수 없습니다.");
	}

	// 해당하는 제품이 있는지 확인 후 해당하는 제품번호를 찾아 반환
	// @param itemNo 찾을 제품번호, itemDatas 제품 데이터 리스트
	// @return 찾은 제품의 번호(존재하면), 없으면 -1
	public static int hasItemNo(int itemNo, ArrayList<Item> itemDatas) {
		int i;
		boolean find = false;

		// 제품 데이터 리스트를 순회하며 입력된 제품번호와 일치하는 제품을 찾음
		for (i = 0; i < itemDatas.size(); i++) {
			if (itemDatas.get(i).getNum() == itemNo) {
				find = true;
				break;
			}
		}

		// 찾은 경우 해당 제품번호 반환, 찾지 못한 경우 에러 메시지 출력 후 -1 반환
		if (!find) {
			System.out.println("해당하는 제품이 존재하지 않습니다.");
			return -1;
		}

		return itemDatas.get(i).getNum();
	}

	// 해당하는 제품의 재고 확인 후 없는 아이템의 재고 0값을 반환
	// @param itemNo 확인할 제품번호, itemDatas 제품 데이터 리스트
	// @return 제품의 현재 재고 또는 0(재고 소진 시)
	public static int hasItemStock(int itemNo, ArrayList<Item> itemDatas) {
		// 입력된 제품번호에 해당하는 제품의 재고 확인
		if (itemDatas.get(itemNo - 1).getStock() <= 0) {
			System.out.println("해당 제품은 재고가 소진되어 구매가 안됩니다. 관리자에게 문의해주세요");
			return 0;
		}

		return itemDatas.get(itemNo - 1).getStock();
	}

	// 제품 재고 확인 후 추가
	// @param itemDatas 제품 데이터 리스트
	// @return 없음
	public static void addStock(ArrayList<Item> itemDatas) {
		int select;

		while (true) {
			// 모든 제품을 출력하고, 사용자로부터 제품 번호 입력 받음
			if (searchAllItem(itemDatas)) {
				select = inputExceptionCheck("제품 번호를 입력해주세요");
				int getItemNum = hasItemNo(select, itemDatas);

				// 입력된 제품번호에 해당하는 제품이 존재하는 경우
				if (getItemNum >= 0) {
					// 사용자로부터 재고 수량을 입력 받고 해당 제품의 재고에 추가
					int addStock = inputExceptionCheck("재고수량을 입력해주세요");
					itemDatas.get(getItemNum - 1).setStock(itemDatas.get(getItemNum - 1).getStock() + addStock);
					System.out.println(itemDatas.get(getItemNum - 1));
				}
				break;
			}
			break;
		}
	}

	// 비밀번호 길이 검사
	// 입력받은 비밀번호의 길이가 4인지 확인하는 메서드
	// @param inputPw 입력받은 비밀번호
	// @return 비밀번호의 길이가 4이면 true, 아니면 false를 반환
	public static boolean pwLengthCheck(String inputPw) {
		// TODO 안승준
		if (inputPw.length() == 4) {
			return true; // 비밀번호 길이가 4이면 true 반환
		}
		return false; // 비밀번호 길이가 4가 아니면 false 반환
	}

	// 비밀번호 표현 검사 [정규 표현식]
	// 입력받은 비밀번호가 숫자로만 구성되어 있는지 확인하는 정규 표현식 메서드
	// @param inputPw 입력받은 비밀번호
	// @return 비밀번호가 숫자로만 구성되어 있으면 true, 아니면 false를 반환
	public static boolean pwExpressNumCheck(String inputPw) {
		// TODO 안승준
		String keyNum = "^[\\d]*$"; // 숫자로만 구성된 문자열을 나타내는 정규 표현식
		if (Pattern.matches(keyNum, inputPw)) {
			return true; // 비밀번호가 숫자로만 구성되어 있으면 true 반환
		}
		return false; // 비밀번호가 숫자로만 구성되어 있지 않으면 false 반환
	}

	// 비밀번호 설정 메서드
	// 사용자로부터 비밀번호를 입력받아 지정된 조건을 만족할 때까지 반복하는 메서드
	// @param pw 이전에 입력받은 비밀번호
	// @return 조건을 충족한 비밀번호를 반환
	public static String pwSetting(String pw) {
		// TODO 안승준
		while (true) {
			pwFormInfo(); // 비밀번호 설정에 관련된 정보를 출력하는 메서드 호출
			pw = getWrite("설정하실 비밀번호를 입력해주세요"); // 사용자로부터 비밀번호 입력 받음
			if (pwLengthCheck(pw) && pwExpressNumCheck(pw)) {
				// 비밀번호의 길이가 4이고, 숫자로만 구성되어 있다면 조건 충족
				break; // 반복문 종료
			}
			System.out.println("다시 입력해주세요"); // 조건을 만족하지 않으면 다시 입력하라는 안내 메시지 출력
		}
		return pw; // 조건을 충족한 비밀번호 반환
	}

	// 관리자 접근 허용
	// 입력받은 비밀번호와 관리자 비밀번호를 비교하여 접근을 허용 또는 거부하는 메서드
	// @param pw 관리자 비밀번호
	// @return 비밀번호가 일치하면 true, 일치하지 않으면 false를 반환
	public static boolean adminAccess(String pw) {
		String inputPw; // 사용자가 입력한 비밀번호를 저장하는 변수
		while (true) {
			inputPw = getWrite("비밀번호를 입력해주세요"); // 사용자로부터 비밀번호 입력 받음

			System.out.print("접속중");
			for (int i = 0; i < 5; i++) {
				try {
					Thread.sleep(500);
					System.out.print(".");
				} catch (Exception e) {
					errMsg();
				}
			}
			System.out.println();

			if (!inputPw.equals(pw)) {
				// 입력받은 비밀번호가 관리자 비밀번호와 일치하지 않으면
				System.out.println("비밀번호가 틀렸습니다.");
				return false; // 비밀번호가 틀렸으므로 false 반환
			}
			return true; // 비밀번호가 일치하면 true 반환
		}
	}

	// 제품 조회
	// @param itemDatas 제품 데이터 리스트
	// @return 제품이 존재하는지 여부(true or false)
	public static boolean searchAllItem(ArrayList<Item> itemDatas) { // 구본승
		// 장바구니에 제품이 존재하지 않을 때
		if (itemDatas.size() == 0) {
			System.out.println("제품이 존재하지 않습니다.");
			return false;
		}
		// 존재하면 모든 제품 조회
		System.out.println("===== 상품 목록 =====");
		for (Item item : itemDatas) {
			System.out.println(item);
		}
		return true; // 제품이 있다
	}

	// 제품 추가 - [관] 정주영
	// @param PK 제품 PK, itemDatas 제품 데이터 리스트
	// @return 없음
	public static void addItem(int PK, ArrayList<Item> itemDatas) {
		String itemName = getWrite("제품 이름을 입력해주세요"); // 추가할 제품 이름 입력
		int getPrice = inputExceptionCheck("가격을 입력해주세요"); // 추가할 제품 가격 입력
		itemDatas.add(new Item(PK, itemName, getPrice)); // 제품 추가시 입력받은 제품이름, 제품가격으로 제품 데이터에 추가
		System.out.println(itemDatas.get(itemDatas.size() - 1).getName() + "제품이 추가 되었습니다.");// TODO 메세지 변경하기
	}

	// 제품 삭제 - 천지성
	// @param itemDatas 제품 데이터 리스트
	// @return 없음
	// 제품 삭제
	public static void itemDelete(ArrayList<Item> itemDatas) {
		int select;
		while (true) {
			System.out.println(" ===== 제품 삭제 =====");
			if (searchAllItem(itemDatas)) { // 어떤 제품을 삭제할 것인지 제품 모두 조회
				System.out.println("0. 뒤로가기");
				select = inputExceptionCheck("삭제 할 제품 번호를 입력해주세요"); // 삭제할 제품 번호 입력
				if (select == 0) { // 뒤로가기
					break;
				}
				if (hasItemNo(select, itemDatas) < 0) { // 존재하지 않는 제품 선택시 -1값이므로
					continue; // 다시 선택요구
				}
				char answerResult;
				while (true) {
					System.out.println("정말로 제품을 삭제하시겠습니까? Y / N");
					answerResult = sc.next().charAt(0);
					if (answerResult == ('Y')) { // 정말로 삭제할지 더 물어봄 (정확한 삭제를 위한 방어코드)
						int getItemNum = hasItemNo(select, itemDatas);
						if (getItemNum > 0) {
							itemDatas.remove(getItemNum - 1);
							System.out.println("아이템 삭제완료");
							searchAllItem(itemDatas); // 삭제 이후 아이템 조회 하기
							break;
						}
					} else if (answerResult == 'N') { // 잘못 삭제를 할시 재선택을 하기 위함
						break;
					} else {
						System.out.println("정확한 문자를 입력 해주세요"); // Y / N 이외의 입력시 다시 재입력 요구
						continue;
					}
				}
				if (answerResult == 'N') { // 제품
					continue;
				}
				break;
			}
		}
	}

	// 폐점 TODO 천지성
	// @param 없음
	// @return 없음
	public static void doomsday() {
		LocalDateTime now = LocalDateTime.now(); // 현재 날짜와 시간 정보를 가져오기 위해 LocalDateTime.now() 메서드 사용

		// 날짜와 시간 정보를 원하는 형식으로 출력하기 위해 DateTimeFormatter 클래스를 생성합니다.
		// "yyyy년 MM월 dd일 HH시 mm분 ss초"는 출력 형식을 지정한 문자열입니다.
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초"); // 패턴 지정

		String formatedNow = now.format(formatter); // LocalDateTime 클래스의 내장함수 format()사용해서 지정한 패턴을 넣어줌
		System.err.println("\n" + formatedNow + " 이후 폐점하게 되었습니다."); // yyyy년 MM월 dd일 HH시 mm분 ss초 형식의 날짜 데이터 출력
		System.out.println("그동안 사랑해주셔서 감사합니다.");
	}

	// 폐점 TODO 천지성
	// @param 제품 데이터 리스트(itemDatas)
	// @return 없음
	public static String ourStore(ArrayList<Item> itemDatas, String pw) {
		final int YES = 'Y';
		final int NO = 'N';
		while (true) {
			char doubleCheck = 0;
			// 폐점을 하기 위해 관리자 권한 패스워드를 확인하는 메서드 호출
			if (adminAccess(pw)) { // @param pw 관리자 권한 패스워드, @return boolean 패스워드 일치 여부
				System.out.println("정말로 폐점 하시겠습니까? Y / N");
				doubleCheck = sc.next().charAt(0);
				if (doubleCheck == YES) {
					System.out.print("페기중");
					for (int i = 0; i < 7; i++) {
						try {
							// 폐점 진행 중 시각적으로 표현하기 위해 일정 시간 간격으로 점 찍기
							Thread.sleep(itemDatas.size() * 100);
							System.out.print(".");
						} catch (Exception e) {
							errMsg();
						}
					}
					// 제품 데이터 리스트 비우기
					itemDatas.removeAll(itemDatas); // @param itemDatas 제품 데이터 리스트, @return void
					// 폐점 메서드 호출
					doomsday(); // @return void
					return null;
				} else if (doubleCheck == NO) {
					return pw; // 폐점 취소 시 패스워드 반환
				}
			}
		}
	}

	// 관리자 컨트롤러
	// 관리자 기능을 선택하는 화면을 출력하고 사용자의 선택에 따라 각 기능을 실행하는 메서드
	// @param PK 현재 제품의 고유 키 값
	// @param itemDatas 제품 데이터를 저장한 ArrayList
	// @param pw 현재 관리자의 비밀번호
	// @return 관리자 기능 수행 후 변경된 비밀번호 또는 폐점 여부에 따라 반환된 값
	public static String adminController(int PK, ArrayList<Item> itemDatas, String pw) {
		final int GO_BACK = 0; // 뒤로가기
		final int SEARCH_ALL_ITEM = 1; // 모든 제품 조회
		final int ADD_ITEM = 2; // 제품 추가
		final int ADD_STOCK = 3; // 재고 추가
		final int ITEM_DELETE = 4; // 제품 삭제
		final int PASSWORD_CHANGE = 5; // 패스워드 변경
		final int CLOSE_STORE = 6; // 폐점
		int select;

		while (true) {
			adminPage(); // 관리자 페이지 메뉴 출력
			select = inputExceptionCheck("기능선택"); // 사용자로부터 기능 선택 받음
			if (select == GO_BACK) { // 뒤로가기 선택
				break; // 반복문 종료
			}
			if (select == SEARCH_ALL_ITEM) { // 모든 제품 조회 선택
				searchAllItem(itemDatas); // 모든 제품 조회 메서드 호출
			} else if (select == ADD_ITEM) { // 제품 추가 선택
				addItem(PK++, itemDatas); // 제품 추가 메서드 호출
			} else if (select == ADD_STOCK) { // 재고 추가 선택
				addStock(itemDatas); // 재고 추가 메서드 호출
			} else if (select == ITEM_DELETE) { // 제품 삭제 선택
				itemDelete(itemDatas); // 제품 삭제 메서드 호출
			} else if (select == PASSWORD_CHANGE) { // 비밀번호 변경 선택
				return pwSetting(pw); // 비밀번호 설정 메서드 호출하여 변경된 비밀번호 반환
			} else if (select == CLOSE_STORE) { // 폐점 선택
				return ourStore(itemDatas, pw); // 폐점 처리 메서드 호출하여 반환된 값 반환
			} else if (select >= 7 || select < 0) { // 잘못된 입력 선택
				System.out.println("잘못된 번호입니다. 다시 확인해주세요");
			}
		}
		return pw; // 폐점시 null값으로 반환
	}

	// 입력 예외처리
	// 주어진 메시지를 출력하고, 사용자로부터 정수를 입력받는 메서드
	// 입력 값이 음수인 경우나 정수 이외의 문자열이 입력된 경우에 대한 예외처리를 수행함
	// @param msg 출력할 메시지 문자열
	// @return 입력받은 정수값
	public static int inputExceptionCheck(String msg) {
		int select;
		while (true) {
			try {
				select = getNum(msg); // 사용자로부터 정수 입력 받음
				if (select < 0) { // 입력값이 음수인 경우
					System.out.println("음수 입력은 사용하지 못합니다. 다시 입력해주세요");
					continue; // 다시 입력 받기 위해 반복문 계속
				}
			} catch (InputMismatchException e) { // 정수 이외의 문자열이 입력된 경우
				sc.nextLine(); // 입력 버퍼 비우기
				System.out.println("정수 이외의 번호는 잘못된 입력입니다. 다시 확인해주세요");
				continue; // 다시 입력 받기 위해 반복문 계속
			}
			return select; // 정상적인 입력 값인 경우 입력값 반환
		}
	}

	// 판매 모드
	// 주어진 제품 데이터 리스트를 이용하여 판매 모드를 실행하는 메서드
	// @param itemDatas 제품 데이터를 저장한 ArrayList
	// @return 없음
	public static void sellMode(ArrayList<Item> itemDatas) { // TODO 구본승 시작
		final int GO_BACK = 0; // 뒤로가기
		final int BUY = 1; // 바로 구매
		final int SAVE_CART = 2; // 장바구니 담기

		if (!searchAllItem(itemDatas)) { // 제품을 구매하려는데 제품이 아무것도 없으면 뒤로가기
			return;
		}

		while (true) {
			int select;
			System.out.println("0. 뒤로가기");
			select = inputExceptionCheck("구매할 제품 번호를 입력해주세요"); // 입력받기

			// 뒤로가기 선택 시 메소드 종료
			if (select == GO_BACK) {
				break;
			}

			// 제품 번호가 양수일 때(0보다 큰 정수) 즉 제품이 있다!!!
			if (select > 0) {
				// 제품 번호를 통해 해당 제품이 있는지 확인하고 해당 제품의 PK값 얻음
				int getItemNum = hasItemNo(select, itemDatas); // getItemNum: 제품의 PK값을 가짐

				// 제품이 존재하면서, 재고가 있을 경우에만 구매 가능 (제품이 있으면 무조건 PK값은 1이상)
				if (getItemNum <= 0) { // 음수, 0이므로 제품이 없다!!!
					continue;
				}

				// 제품이 존재하고 해당 제품의 재고가 0보다 크다면 구매 가능한 상태 => 구매, 장바구니 담기 가능
				if (itemDatas.get(getItemNum - 1).getNum() > 0 && itemDatas.get(getItemNum - 1).getStock() > 0) {
					System.out.println(" ===== 쇼핑중 =====");
					System.out.println("1. 바로 구매하기");
					System.out.println("2. 장바구니 담기");
					System.out.println("0. 뒤로가기");
					// 구매 방식 선택
					int decisionSelect = inputExceptionCheck("결정해주세요");
					if (decisionSelect == BUY) {
						System.out.println("구매 완료");
						itemDatas.get(getItemNum - 1).sell(); // 선택한 제품의 (선택번호 - 1)인덱스 제품의 재고 -1 해줌
						searchAllItem(itemDatas); // 결과 : 선택한 제품의 (선택번호 -1) 인덱스 제품의 재고-1한 값 포함, 모든 제품 조회
						break; // 메소드 종료
					} else if (decisionSelect == SAVE_CART) { //
						// 장바구니 담기 선택 시
						Item itemData = itemDatas.get(select - 1); // 해당하는 제품 객체
						System.out.println("장바구니 담기");
						int firstStock = itemData.getStock(); // 처음 재고
						itemData.sell(); // 제품 1개 판매
						int resultStock = firstStock - itemData.getStock(); // 처음 재고 - 제품 1개판매이후 재고
						int i;
						boolean flag = false;
						// 장바구니에 이미 담긴 제품인지 확인
						for (i = 0; i < basketDatas.size(); i++) {
							if (basketDatas.get(i).getNum() == getItemNum) {
								flag = true;
								break;
							}
						}

						// 장바구니에 담긴 제품이 아니라면 새로운 아이템으로 추가하고 재고 설정
						if (!flag) { // 장바구니에 선택한 제품이 없으면 제품데이터 추가
							basketDatas.add(new Item(itemData.getNum(), itemData.getName(), itemData.getPrice()));
							basketDatas.get(basketDatas.size() - 1).setStock(resultStock); // 장바구니에 맨마지막에 담은 제품의 재고
						} else {// 장바구니에 이미 담긴 제품이 있으면 중복으로 담으면서 재고 증가시킴
							resultStock++; // 해당하는 재품의 재고에 + 1
							basketDatas.get(i).setStock(resultStock); // 장바구니 리스트에 해당 제품 재고값 변경
						}
						// 장바구니 정보 조회
						System.out.println("===========================");
						for (i = 0; i < basketDatas.size(); i++) {
							System.out.println(basketDatas.get(i));
						}
					} else if (decisionSelect == GO_BACK) {
						// 뒤로가기 선택 시 다른 제품 구매하러 갈수있음
						break;
					}
					// 제품이 존재하나 해당 제품의 재고가 0일 때
				} else if (itemDatas.get(getItemNum - 1).getNum() > 0 // 제품번호가 1이상일때 => 제품존재함
						&& itemDatas.get(getItemNum - 1).getStock() <= 0) { // 하지만 재고는 0이하이므로 => 구매는 불가
					System.out.println("해당 제품은 재고 소진으로 인해 구매하실 수 없습니다. 다른 제품 번호를 입력해주세요");
					continue;
					// 제품이 존재하지 않을 때
				} else if (itemDatas.get(getItemNum - 1).getNum() != select) { // 제품번호가 없으면 존재하지않는 제품임
					System.out.println("해당하는 제품이 존재하지 않습니다. 다른 제품을 선택해주세요");
					continue;
				}
			}
		}
	}

	// 손님 컨트롤러
	// 제품 PK, 제품 데이터 리스트, 장바구니 데이터 리스트를 이용하여 손님 컨트롤러를 실행하는 메서드
	// @param PK 제품의 현재 고유 키 값
	// @param itemDatas 제품 데이터를 저장한 ArrayList
	// @param basketDatas 장바구니 데이터를 저장한 ArrayList
	// @return 없음
	public static void customerController(int PK, ArrayList<Item> itemDatas, ArrayList<Item> basketDatas) {
		final int GO_BACK = 0; // 뒤로가기
		final int BUY = 1; // 물건 사기
		final int SHOW_BASKET = 2; // 장바구니 확인하기
		int select;

		while (true) {
			customerPage(); // 손님모드 페이지 출력
			select = inputExceptionCheck("기능선택"); // 사용자로부터 기능 선택 받음

			if (select == GO_BACK) { // 뒤로가기 선택 시 메소드 종료
				return;
			}

			if (select == BUY) { // 구매 하기 선택 시 판매 모드 실행
				sellMode(itemDatas);
			} else if (select == SHOW_BASKET) { // 장바구니 확인 선택 시
				System.out.println("===== 장바구니 =====");
				if (searchAllItem(basketDatas)) { // 장바구니에 제품이 있는지 확인
					System.out.println("1. 전체 구매하기");
					System.out.println("0. 뒤로가기");
					select = inputExceptionCheck("번호를 입력해주세요");

					if (select == GO_BACK) { // 뒤로가기 선택 시 메소드 종료
						return;
					} else if (select == BUY) { // 전체 구매하기 선택 시
						basketDatas.clear(); // 장바구니 비우기
					}
				}
			}
		}
	}

	// 메인 컨트롤러
	// 제품 데이터 리스트를 이용하여 전체 시스템의 메인 컨트롤러를 실행하는 메서드
	// @param itemDatas 제품 데이터를 저장한 ArrayList
	// @return 없음
	public static void mainController(ArrayList<Item> itemDatas) {
		int PK = 1;
		final int ADMIN_MODE = 1;
		final int CUSTOM_MODE = 2;
		int select;
		String pw = null;

		while (true) {
			selectModePage(); // 관리자, 유저모드 선택 페이지 출력
			select = inputExceptionCheck("모드 선택"); // 사용자로부터 모드 선택 받음

			if (select == 0) {
				System.out.println("안녕히 가세요 다음에 또 찾아주세요~~~");
				break; // 0 입력 시 프로그램 종료
			}

			if (select == ADMIN_MODE) { // 관리자모드 접속
				if (pw == null) {
					pw = pwSetting(pw); // 초기 비밀번호 설정
				}
				System.out.println(pw); // 비밀번호 확인용 로그
				if (adminAccess(pw)) { // 비밀번호 확인 후 관리자 접근 허용되면 관리자 모드 실행
					pw = adminController(PK, itemDatas, pw); // 관리자 컨트롤러 실행
				}
			} else if (select == CUSTOM_MODE) { // 유저(손님) 모드
				customerController(PK, itemDatas, basketDatas); // 손님 컨트롤러 실행
			} else if (select >= 3) { // 예외처리
				System.out.println("번호를 잘못입력했습니다. 다시 확인해 주세요.");
			}
		}
	}

	public static void main(String[] args) {
		itemDatas.add(new Item(1, "감자칩", 2000));
		itemDatas.add(new Item(2, "아이스크림", 1500));
		itemDatas.add(new Item(3, "초코바", 2000));
		itemDatas.add(new Item(4, "커피", 2000));
		itemDatas.add(new Item(5, "젤리", 1000));
		itemDatas.add(new Item(6, "콜라", 1000));
		itemDatas.add(new Item(7, "핫식스", 1500));
		mainController(itemDatas); // 메인 컨트롤 실행
	}
}
