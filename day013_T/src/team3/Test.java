package team3;

import java.util.Random;
import java.util.Scanner;



/*
 * 3팀  팀 프로젝트

설계 작업 day 1 ~ 2일차
자동차 프로그램 설계

목적

자동차 프로그램 : 데일리카와 펀카의 정보를 저장하고 데일리카의 연비와 차량 정기 점검일을 확인 및 펀카의 속도와 마모된 타이어를 확인하는 프로그램



자동차 클래스 설계

자동차 클래스
   멤버 변수
   String 브랜드 brand
   int 가격 price

   생성자
   car(브랜드, 가격) 생성

   메서드
   출력(printInfo) : "차 브랜드 : ㅇㅇ, 차 가격 : ㅇㅇ원"

   ▶ 1. 데일리카(자식 클래스)

         멤버 변수 
         int 연비 mileage
         int 점검 inspection

         생성자 
               DailyCar(브랜드, 가격) : 연비와 점검은 랜덤으로 추가
               DailyCar(브랜드, 가격, 연비, 점검)

         @메서드
              printInfo() : "차 브랜드 : ㅇㅇ, 차 가격 : ㅇㅇ원, 연비 : ㅇㅇ"

      메서드
         - milecheck() : 연비 체크; 차의 연비를 받아와서 연비가 18보다 높은지 낮은지 체크
            if(this.mileage < 18)
                      T ---> "차 길들이기 실패" 출력
                       F ---> "차 길들이기 성공" 출력

         - test() : 차량 점검; 차량 점검일이 6개월이 지났는지 체크
            if(this.inspection > 6)
                      T ---> "점검 후 this.inpection 개월이 지났습니다."
               "차량 점검을 받아야 됩니다."
                       F ---> "문제 없습니다."

   ▶ 2. 펀카(자식 클래스)

         멤버 변수 
         int 속도 speed
         int 타이어 개수 tire

         생성자 
               FunCar(브랜드, 가격) : 속도와 타이어 개수는 랜덤으로 추가
               FunCar(브랜드, 가격, 스피드, 타이어)

         @메서드
              printInfo() : "차 브랜드 : ㅇㅇ, 차 가격 : ㅇㅇ원, 속도 : ㅇㅇ"

      메서드
         - speedUpDown() : 속도 체크; 차의 속도를 받아와서 120초과하면 과속으로 주행속도 줄이기
            while(this.speed > 120)
                      T ---> "과속주의 현재속도 : this.speed 속도를 120km까지 줄이세요" 출력
               Random으로 속도 다시 받아오기

         - wear() : 타이어 점검; 불량 타이어가 3개 이상이면 교체
            if(this.tire >= 3)
                      T ---> "현재 타이어 this.tire개가 마모되었습니다."
               "타이어를 교체 해주시기 바랍니다."
            else ---> "문제 없습니다."



한글 코딩 


자동차 프로그램 편성표

while 사용 종료조건 : 0을 입력할때까지 반복한다.
if (0){
0. 차량 프로그램 종료
   프로그램을 종료합니다.
}
else if(1){
1. 전체 차량정보 출력 
   저장된 차량의 정보를 전부 출력합니다.
}
else if(2){
2. 차량 정보 추가 입력 
   데일리카와 펀카의 정보를 입력합니다.
}
else if(3) {
3. 데일리카 연비 변경
   데일리카의 연비를 변경합니다. 
   (연비가 18 미만인 차량들 한정)
}
else if(4) {
4. 펀카 주행 과속 감지
   펀카의 주행속도를 확인하여 과속인지 아닌지 확인하고 속도를 변경합니다.
   (과속 기준 120km 이상) 
}
else if(5) {
5. 현재차량 가격 변경
   차량들의 현재 가격을 입력한 가격으로 변경합니다.
}
else if(6) {
6. 데일리카의 차량 정기 점검
   데일리카의 정기 점검일을 확인합니다. 
   (6개월 초과시 안내문 출력)   
}
else if(7) {
7. 펀카 타이어 점검
   펀카의 마모된 타이어가 있는지 확입니다. 
   (마모된 타이어 3개 이상시 안내문 출력)
}
 */




// Car 클래스(부모 클래스) 
class Car {
	// 멤버 변수
	String brand; // 브랜드
	int price; // 가격

	// 생성자
	// 브랜드와 가격을 받아오는 생성자
	Car(String brand, int price) {
		this.brand = brand;
		this.price = price;
	}

	// 메소드
	// 출력
	void printInfo() {
		System.out.println(this.brand + "차 가격 : " + this.price + "원");
	}
}

// 데일리카 클래스 (자식 클래스)
class DailyCar extends Car {
	// 멤버 변수
	int mileage; // 연비
	int inspection; // 차량 점검 개 월수

	// 생성자
	// 브랜드와 가격을 받아오고 연비(랜덤값 0~34까지 생성), 차량 점검 개월수(랜덤값 1~12까지 생성) 받아오기
	DailyCar(String brand, int price) {
		this(brand, price, new Random().nextInt(35), new Random().nextInt(12) + 1);
	}

	DailyCar(String brand, int price, int mileage, int inspection) {
		super(brand, price);
		this.mileage = mileage;
		this.inspection = inspection;
	}

	@Override
	void printInfo() {
		System.out.println("데일리카 " + this.brand + "차 가격 : " + this.price + "원 연비 : " + this.mileage);
	}

	// 연비 검사
	void milcheck() {
		if (this.mileage < 18) {
			System.out.println("차 길들이기 실패");
			this.mileage = new Random().nextInt(35);
		} else {
			System.out.println("차 길들이기 성공");
		}
	}

	// 차량 점검 체크
	void test() {
		// 6개월 초과시 안내문 출력
		if (this.inspection > 6) {
			System.out.println(this.brand + "차의 점검일로부터 " + this.inspection + "개월이 지났습니다.");
			System.out.println("차량 점검을 받아야 됩니다.");
		} else {
			System.out.println("문제없습니다.");
		}
	}

}

// 펀카 클래스(자식 클래스)
class FunCar extends Car {
	// 멤버 변수
	int speed; // 속도
	int tire; // 타이어

	// 브랜드와 가격, 차량의 속도(랜덤값 0~200까지), 타이어 마모 갯수(랜덤값 0~4개)
	FunCar(String brand, int price) {
		this(brand, price, new Random().nextInt(201), new Random().nextInt(5));
	}

	FunCar(String brand, int price, int speed, int tire) {
		super(brand, price);
		this.speed = speed;
		this.tire = tire;
	}

	@Override
	void printInfo() {
		System.out.println("펀카 " + this.brand + "차 가격 : " + this.price + "원 속도 : " + this.speed);
	}

	// 속도 120km 넘어가면 경고 문구 출력 및 속도 값 랜덤으로 변경
	void speedUpDown() {
		while (true) {
			// 주행 속도가 120 이하면 반복 바로 종료
			if (this.speed <= 120) {
				break;
			}
			// 과속중이면 과속 주의 안내 출력
			System.out.println("과속주의 현재속도 :" + this.speed + "km 속도를 120km까지 줄이시오");
			this.speed = new Random().nextInt(201);
		}
		// 속도가 0이면 정지 안내
		if (this.speed == 0) {
			System.out.println("정지하셨습니다.");
		} else {
			System.out.println("현재 속도 : " + this.speed + "km 안전운전 중입니다.");
		}
	}

	// 타이어 마모 체크
	void wear() {
		if (this.tire >= 3) {
			System.out.println(this.brand + "차의 현재 타이어 " + this.tire + "개가 마모되었습니다.");
			System.out.println("타이어를 교체 해주시기 바랍니다.");
		} else {
			System.out.println("문제없습니다.");
		}
	}
}

public class Test {

	// 등록된 차량이 없으면 사용되는 메소드
	public static boolean indexChk(int index) {
		if (index <= 0) {
			System.out.println("등록된 차량이 없습니다.");
			return false;
		}
		return true;
	}

	public static void main(String[] args) {

		// 차 배열 선언
		Car[] cardatas = new Car[3];
		// 차 요소
		int index = 0;

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("======편성표======");
			System.out.println("0. 차량 프로그램 종료 ");
			System.out.println("1. 전체 차량정보 출력 ");
			System.out.println("2. 차량 정보 추가 입력 ");
			System.out.println("3. 데일리카 연비 변경 ");
			System.out.println("4. 펀카 주행 과속 감지 ");
			System.out.println("5. 현재차량 가격 변경 ");
			System.out.println("6. 데일리카 차량 정기 점검 ");
			System.out.println("7. 펀카 타이어 점검 ");
			System.out.println("--------------------");
			int action = sc.nextInt();
			if (action == 0) {
				System.out.println("프로그램 종료");
				break;
			} else if (action == 1) {
				// 데이터가 없을경우 호출하는 함수
				if (!indexChk(index)) {
					// 반복문에서 빠져나가기 위해 조건문 if문과 continue 사용
					continue;
				}
				for (int i = 0; i < index; i++) {
					cardatas[i].printInfo();
				}
			} else if (action == 2) {
				// 배열에 등록할 수 있는 범위를 넘어갔을때 사용하는 유효성 검사
				if (index >= cardatas.length) {
					System.out.println("등록할 수 있는 정보의 용량이 가득 찼습니다.");
					continue;
				}
				// 번호를 입력할때까지 반복할 수 있도록 반복문 while문 사용
				while (true) {
					System.out.println("1. 데일리카 구매");
					System.out.println("2. 펀카 구매 ");
					System.out.print("번호 입력 :");
					action = sc.nextInt();
					// 종료조건 입력한 값이 1과 2 중 하나를 입력했을때 반복 종료
					if (1 <= action && action <= 2) {
						break;
					}
					System.out.println("다시 입력해주세요.");

				}
				if (action == 1) {
					// 등록할 차량의 데이터를 제대로 입력할때까지 반복 while 문 사용
					while (true) {
						System.out.println("차량입력 :");
						String brand = sc.next();
						System.out.println("가격입력 :");
						int price = sc.nextInt();
						// 종료조건 가격이 0원 이상일때 반복 종료
						if (!(price <= 0)) {
							cardatas[index++] = new DailyCar(brand, price);
							break;
						}
						System.out.println("정보를 다시 입력해주세요");
					}
				} else if (action == 2) {
					// 등록할 차량의 데이터를 제대로 입력할때까지 반복 while 문 사용
					while (true) {
						System.out.println("차량입력 :");
						String brand = sc.next();
						System.out.println("가격입력 :");
						int price = sc.nextInt();
						// 종료조건 가격이 0원 이상일때 반복 종료
						if (price >= 0) {
							cardatas[index++] = new FunCar(brand, price);
							break;
						}
						System.out.println("정보를 다시 입력해주세요");
					}
				}
			} else if (action == 3) {
				// 데이터가 없을때 유효성 메서드 호출
				if (!indexChk(index)) {
					// 반복문에서 빠져나가기 위해 조건문 if문과 continue 사용
					continue;
				}
				// 배열 안에 해당 클래스의 데이터가 있는지 확인용 변수
				boolean flag = false;
				// 배열에 데일리카 클래스의 정보가 있을경우 milcheck 메서드 호출
				for (int i = 0; i < index; i++) {
					if (cardatas[i] instanceof DailyCar) {
						cardatas[i].printInfo();
						DailyCar dailyCar = (DailyCar) cardatas[i];
						dailyCar.milcheck();
						flag = true;
					}
				}
				// 해당 클래스의 데이터가 없을 경우 출력
				if (!flag) {
					System.out.println("데일리카가 없습니다.");
				}
			} else if (action == 4) {
				// 데이터가 없을때 유효성 메서드 호출
				if (!indexChk(index)) {
					// 반복문에서 빠져나가기 위해 조건문 if문과 continue 사용
					continue;
				}
				// 배열 안에 해당 클래스의 데이터가 있는지 확인용 변수
				boolean flag = true;
				// 배열에 펀카 클래스의 정보가 있을경우 speedUpDown 메서드 호출
				for (int i = 0; i < index; i++) {
					// instanceof : 좌측객체가 우측 클래스의 타입과 같으면true
					if (cardatas[i] instanceof FunCar) {
						cardatas[i].printInfo();
						FunCar funcar = (FunCar) cardatas[i];
						funcar.speedUpDown();
						flag = false;
					}
				}
				// 해당 클래스의 데이터가 없을 경우 출력
				if (flag) {
					System.out.println("펀카가 없습니다.");
				}

			} else if (action == 5) {

				// 데이터가 없을때 유효성 메서드 호출
				if (!indexChk(index)) {
					// 반복문에서 빠져나가기 위해 조건문 if문과 continue 사용
					continue;
				}
				System.out.println();
				System.out.println("차량 가격변경");
				System.out.println();
				// 변경전 모든 차량들 확인
				for (int i = 0; i < index; i++) {
					System.out.print((i + 1) + ". ");
					cardatas[i].printInfo();
				}
				// 변경할 번호가 잘 입력될 수 있도록 반복문 while 사용
				while (true) {
					System.out.println("변경하고싶은 차량의 번호를 입력해주세요.");
					System.out.println("입력 >> ");
					action = sc.nextInt();
					// 입력한 번호가 배열에 존재한 값인지 확인하기 위해 조건문 if 사용
					if (0 < action && action <= index) {
						// 변경할 가격이 음수인지 확인하기 위해 반복문 while 사용
						while (true) {
							System.out.print(cardatas[action - 1].brand + "차의 변경하실 가격을 입력해주세요 >> ");
							int newPrice = sc.nextInt();
							// 종료조건 가격이 0 이상일 경우 종료
							if (newPrice >= 0) {
								cardatas[action - 1].price = newPrice;
								System.out.println("변경되었습니다.");
								break;
							}
						}
						break;
					}
					System.out.println("입력하신 번호의 차량이 존재하지 않습니다.");

				}

			} else if (action == 6) {
				// 데이터가 없을때 유효성 메서드 호출
				if (!indexChk(index)) {
					// 반복문에서 빠져나가기 위해 조건문 if문과 continue 사용
					continue;
				}

				// 배열 안에 해당 클래스의 데이터가 있는지 확인용 변수
				boolean flag = true;
				// 배열에 데일리카 클래스의 정보가 있을경우 test 메서드 호출
				for (int i = 0; i < index; i++) {
					if (cardatas[i] instanceof DailyCar) {
						DailyCar dailyCar = (DailyCar) cardatas[i];
						dailyCar.test();
						flag = false;
					}
				}
				// 해당 클래스의 데이터가 없을 경우 출력
				if (flag) {
					System.out.println("데일리카가 없습니다.");
				}
			} else if (action == 7) {
				// 데이터가 없을때 유효성 메서드 호출
				if (!indexChk(index)) {
					// 반복문에서 빠져나가기 위해 조건문 if문과 continue 사용
					continue;
				}
				// 배열 안에 해당 클래스의 데이터가 있는지 확인용 변수
				boolean flag = true; //
				// 배열에 펀카 클래스의 정보가 있을경우 speedUpDown 메서드 호출
				for (int i = 0; i < index; i++) {
					// instanceof : 좌측객체가 우측 클래스의 타입과 같으면true
					if (cardatas[i] instanceof FunCar) {
						FunCar funcar = (FunCar) cardatas[i];
						funcar.wear();
						flag = false;
					}

				}
				// 해당 클래스의 데이터가 없을 경우 출력
				if (flag) {
					System.out.println("펀카가 없습니다.");
				}
			} else {
				System.out.println("잘못된 번호입니다.");
				System.out.println("재입력 해주시기 바랍니다.");
			}
		}

	}
}