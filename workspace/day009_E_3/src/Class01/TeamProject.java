package Class01;

import java.util.Random;
import java.util.Scanner;

//클래스 : 음식점
class Restaurant {

	// 변수 : 상호명
	String shopName;

	// 변수 : 시그니처 메뉴
	String cignatureMenu;

	// 변수 : 가격
	int price;

	// 생성자 정의
	Restaurant(String shopName, String cignatureMenu, int price) {

		// 상호명 강제 초기화
		this.shopName = shopName;

		// 시그니처 메뉴 강제 초기화
		this.cignatureMenu = cignatureMenu;

		// 가격 강제 초기화
		this.price = price;

	}

	// 메소드 : 음식을 제공한다.
	void provideFood() {

		System.out.println(shopName + "의 시그니처 메뉴는 " + cignatureMenu + "입니다.");

	}

}

//클래스 : 빵집 -> 음식점 상속
class Bakery extends Restaurant {

	int star;

	static Random rand = new Random();

	// 생성자 정의
	Bakery(String shopName, String cignatureMenu, int price) {

		super(shopName, cignatureMenu, price);

		this.star = rand.nextInt(5) + 1;

	}

	// 메소드 : 깜짝할인
	void event() {

		if (star <= 3) {

			System.out.println("이 가게의 별점은 " + star + "점 입니다.");

			System.out.println("별점이 3점 이하이기 때문에 할인 이벤트 대상 가게 입니다.");

			// 가격 10% 할인
			this.price *= 0.9;

			System.out.println("10% 할인되어 가격은 " + this.price + "입니다.");

		} else {

			System.out.println("이 가게의 별점은 " + star + "점 입니다.");

			System.out.println("별점이 4점 이상으로 할인 이벤트 대상 가게가 아닙니다.");

			System.out.println("가격은 " + this.price + "입니다.");

		}

	}

}

//클래스 : 커피 -> 음식점 상속
class Cafe extends Restaurant {

	// 생성자 정의
	Cafe(String shopName, String cignatureMenu, int price) {

		super(shopName, cignatureMenu, price);

	}

	@Override
	void provideFood() {

		System.out.println(shopName + "의 시그니처 메뉴는 " + cignatureMenu + "입니다.");

		System.out.println("가격은 " + this.price + "입니다.");

	}

}

public class TeamProject {

	public static void main(String[] args) {

		// 스캐너 함수 호출
		Scanner sc = new Scanner(System.in);

		// Restaurant클래스로 배열 선언
		Restaurant[] restaurant = new Restaurant[5];

		// 음식점 추가 카운트
		int restaurantIndex = 0;

		while (true) {

			// 기능 종류 출력
			System.out.println("=============================");
			System.out.println("0. 프로그램 종료");
			System.out.println("1. 음식점 추가");
			System.out.println("2. 음식점 목록 출력");
			System.out.println("3. 가게 정보 수정");
			System.out.println("=============================");
			System.out.print("메뉴를 선택해 주세요. >>");

			// 메뉴 선택 입력 값 저장
			int action = sc.nextInt();

			if (action == 0) {

				System.out.print("프로그램을 종료합니다.");

				break;

			} else if (action == 1) { // 1. 음식점 추가

				while (true) {

					System.out.println("추가할 음식점의 종류를 골라주세요.");
					System.out.println("1. 빵집");
					System.out.println("2. 카페");
					System.out.print(">>");
					int choice = sc.nextInt();

					if (choice == 1) {

						System.out.print("상호를 입력해 주세요. >>");
						String shopName = sc.next();

						System.out.print("시그니처 메뉴를 입력해 주세요. >>");
						String cignatureMenu = sc.next();

						System.out.print("가격을 입력해 주세요. >>");
						int price = sc.nextInt();

						restaurant[restaurantIndex++] = new Bakery(shopName, cignatureMenu, price);

						break;

					} else if (choice == 2) {

						System.out.print("상호를 입력해 주세요. >>");
						String shopName = sc.next();

						System.out.print("시그니처 메뉴를 입력해 주세요. >>");
						String cignatureMenu = sc.next();

						System.out.print("가격을 입력해 주세요. >>");
						int price = sc.nextInt();

						restaurant[restaurantIndex++] = new Cafe(shopName, cignatureMenu, price);

						break;

					} else {

						System.out.println("다시 입력해주세요...");

						continue;

					}

				}

			} else if (action == 2) { // 2. 음식점 목록 출력

				for (int i = 0; i < restaurantIndex; i++) {

					if (restaurant[i] instanceof Bakery) {

						Bakery bakery = (Bakery) restaurant[i];

						bakery.provideFood();

						bakery.event();

						System.out.println("");

					} else {

						Cafe cafe = (Cafe) restaurant[i];

						cafe.provideFood();

						System.out.println("");

					}

				}

			} else if (action == 3) { // 3. 가게 정보 수정

				while (true) {

					for (int i = 0; i < restaurantIndex; i++) {
						
						System.out.println((i+1) + ". " + restaurant[i].shopName);
						
					}
					
					System.out.print("변경할 가게를 선택해 주세요. >>");
					// 가게 선택 값 저장
					int choice = sc.nextInt();
					
					if(choice>restaurantIndex) {
						
						System.out.println("다시 입력해주세요...");
						
						continue;
							
					}else {
						
						System.out.print("변경할 가게 이름을 입력해주세요. >>");
						String shopName = sc.next();
						String oldShopName = restaurant[choice-1].shopName;
						restaurant[choice-1].shopName = shopName;
						
						System.out.print("변경할 시그니처 메뉴 이름을 입력해주세요. >>");
						String cignatureMenu = sc.next();
						String oldCignatureMenu = restaurant[choice-1].cignatureMenu;
						restaurant[choice-1].cignatureMenu = cignatureMenu;
						
						System.out.print("변경할 가격을 입력해주세요. >>");
						int price = sc.nextInt();
						int oldPrice = restaurant[choice-1].price;
						restaurant[choice-1].price = price;
						
						System.out.println(oldShopName + "이(가) " + shopName + "으로 변경되었습니다.");
						System.out.println(oldCignatureMenu + "이(가) " + cignatureMenu + "으로 변경되었습니다.");
						System.out.println(oldPrice + "이(가) " + price + "으로 변경되었습니다.");
						
						System.out.println("");
						
						break;
						
					} 
				
				}

			} else {
				
				System.out.println("다시 입력해주세요...");
				
				continue;
				
			}

		}

	}

}
