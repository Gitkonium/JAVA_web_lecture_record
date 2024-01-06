package teamProject2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Movie {

	// 영화PK
	private int PK;

	// 영화 이름
	private String name;

	// 영화 가격
	private int price;

	// 남은수량
	private int cnt;

	// 영화 생성자 초기화
	Movie(int PK, String name, int price) {

		this.PK = PK;

		this.name = name;

		this.price = price;

		this.cnt = 30;

	}

	public int getPK() {

		return PK;

	}

	public void setPK(int pK) {

		PK = pK;

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

	// 예약 메서드
	public void reservation(int ticketNum) {

		// 티켓 잔량 감소
		this.cnt = cnt - ticketNum;

	}

}

public class TeamProject {

	public static void main(String[] args) {

		ArrayList<Movie> datas = new ArrayList<Movie>();

		int PK = 1001;

		datas.add(new Movie(PK++, "봄", 10000));
		datas.add(new Movie(PK++, "여름", 15000));
		datas.add(new Movie(PK++, "가을", 20000));

		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.println("===영화 티켓 자판기===");
			System.out.println("1. 상영중인 영화목록");
			System.out.println("2. 예매하기");
			System.out.println("3. 담아둔 티켓 전체구매");
			System.out.println("0. 프로그램 종료");

			int action = sc.nextInt();

			if (action == 0) {

				break;

			} else if (action == 1) {

			} else if (action == 2) { // 2. 예매하기

				while (true) {

					System.out.println("=============================");

					// 배열리스트의 사이즈 만큼 반복
					for (int i = 0; i < datas.size(); i++) {

						// 영화 목록 출력
						System.out.println(datas.get(i).getPK() + " " + datas.get(i).getName() + " (티켓 잔량 : "
								+ datas.get(i).getCnt() + ")");

					}

					System.out.println("=============================");
					System.out.println("1. 영화 예매하기");
					System.out.println("2. 장바구니에 담기");
					System.out.print("입력 >>");
					// 콘솔에서 정수값 입력 받기
					int input = sc.nextInt();

					// 입력 받은 값이 1이면
					if (input == 1) {

						// 영화 번호 변수
						int movieNum = 0;

						// 티켓 장수 변수
						int ticketNum = 0;

						// 영화 번호의 입력 범위 확인용 변수
						boolean movieNumFlag = false;

						// 티켓 수량의 입력 범위 확인용 변수
						boolean ticketNumFlag = false;

						while (true) {

							// 영화 번호 입력받기
							System.out.print("예매할 영화의 번호를 입력해주세요. >>");
							movieNum = sc.nextInt();

							// 존재하는 영화 번호인지 확인하는 플래그
							movieNumFlag = false;

							// 영화 번호 존재확인
							for (Movie m : datas) {

								// 데이터의 번호가 입력한 번호와 같다면
								if (m.getPK() == movieNum) {

									// 플래그를 true로 변경
									movieNumFlag = true;

									// 반복문 종료
									break;

								}

							}

							// 영화 번호가 존재한다면
							if (movieNumFlag == true) {

								// while문 탈출
								break;

							} else { // 존재한다면
								
								// 안내 메세지 출력
								System.out.println("옳바른 영화 번호를 입력해주세요.");

							}

						}

						while (true) {

							// 티켓 장수 입력 받기
							System.out.print("예매할 티켓의 장수를 입력해주세요. >>");
							ticketNum = sc.nextInt();

							// 배열 만큼 반복
							for (int i = 0; i < datas.size(); i++) {

								// i번째 데이터의 PK 값이 영화 번호 입력 값과 같으면
								if (datas.get(i).getPK() == movieNum) {

									// 티켓 잔량이 입력 값보다 적다면
									if (datas.get(i).getCnt() < ticketNum) {

										// 안내 메세지 출력
										System.out.println("티켓의 잔량을 초과하였습니다.");

										// for문 탈출
										break;

									}

									// 티켓 잔량이 1장 이상이라면
									if (datas.get(i).getCnt() > 0) {

										// 티켓 잔량을 감소 시키는 메서드 호출
										datas.get(i).reservation(ticketNum);

										// 티켓 허용 범위 플래그를 true로 변경
										ticketNumFlag = true;

										// 예매 완료 메세지 출력
										System.out.println(
										datas.get(i).getName() + "의 티켓이 " + ticketNum + "장 예매완료 되었습니다.");

										// for문 탈출
										break;

									}

								}

							}

							// 입력 값이 허용범위 였다면
							if (ticketNumFlag == true) {

								// while문 탈출
								break;

							}

						}

					} else if (input == 2) {

					} else {

						System.out.println("옳바른 메뉴 번호를 입력해주세요.");

					}

				}

			} else if (action == 4885) {

				while (true) {

					System.out.println("===관리자 모드===");

					System.out.println("1. 영화추가하기");

					System.out.println("2. 영화 정보 수정");

					System.out.println("3. 상영중인 영화 내리기");

					System.out.println("4. 예매 현황 확인하기");

					System.out.println("5. 매출 확인하기");

					System.out.println("0. 관리자 모드 종료");

					action = sc.nextInt();

					if (action == 0) {

						break;

					} else if (action == 1) {

						int minPrice = 10000;

						int maxPrice = 15000;

						int price = 0;

						while (true) {

							System.out.print("영화의 제목을 입력하세요 >> ");

							String title = sc.next();

							try {

								System.out.print("가격을 입력하세요(10,000원 ~ 15,000원 사이) >> ");

								price = sc.nextInt();

							} catch (InputMismatchException e) {

								System.out.println("정수만 입력 가능합니다.");

								System.out.println("다시 입력해주세요");

								sc.nextLine();

								continue;

							}

							if (minPrice <= price && price <= maxPrice) {

								datas.add(new Movie(PK++, title, price));

								System.out.println("영화가 추가되었습니다.");

								break;

							}

							System.out.println("입력값이 범위를 벗어났습니다. \n 다시 입력해주세요");
						}

					}

				}

			}

		}

	}

}