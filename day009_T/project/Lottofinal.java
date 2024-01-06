package project;

import java.util.Scanner;

public class Lottofinal {

	public static int[][] selfNum(int n) {
		Scanner sc = new Scanner(System.in);
		int[][] teamNum = new int[6][6];
		System.out.println("1~10까지의 숫자 중 6개를 중복되지 않게 입력해주세요.");
		System.out.println();
		for (int i = 0; i < teamNum[n - 1].length; i++) {
			Boolean numCk = true;
			System.out.print((i + 1) + "번째 번호 >> ");
			teamNum[n - 1][i] = sc.nextInt();// 사용자가 입력
			for (int j = 0; j < i; j++) {
				if (teamNum[n][i] == teamNum[n][j]) { // 같은 숫자가 있는지 처음부터 하나씩 비교해보기
					System.out.println("입력하신 번호 " + teamNum[n][i] + "는 이미 사용하셨습니다.");
					System.out.println();
					System.out.println("==============================");
					System.out.println();
					numCk = false;
					i--;
				}
			}

			if (numCk) {
				System.out.println("현재까지 저장된 숫자");
				for (int k = 0; k < teamNum[n].length; k++) {
					if (i < k) {
						System.out.println("__");
					} else {
						System.out.println(" " + teamNum[n][k] + " ");
						System.out.println("행운을 빕니다! :D");
					}
					System.out.println();
					System.out.println("==============================");
					System.out.println();
				}
			}
		}
		return teamNum;
	}

	public static void self(int n, int[][] arr) {
		
		System.out.println();
		System.out.print(n + "팀의 로또 번호는 [ ");
			for (int i = 0; i < arr[n - 1].length; i++) {
				System.out.print(arr[n-1][i]);
			}
			System.out.println("] 입니다.");
			System.out.println("행운을 빕니다! :D");
			System.out.println();
			System.out.println("==============================");
		}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[][] teamNum = new int[6][6];

		while (true) {

			System.out.println("===== 코리아 복권 =====");
			System.out.println();
			System.out.println("1. 복권구매");
			System.out.println("2. 팀 검색");
			System.out.println("3. 결과 확인");
			System.out.println("4. 시스템 종료");
			System.out.println();
			System.out.print("원하는 메뉴를 선택하세요 > ");
			int action1 = sc.nextInt();
			System.out.println();
			System.out.println("==============================");
			System.out.println();

			// 시스템 종료
			if (action1 == 4) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}

			// 복권 구매
			else if (action1 == 1) {
				while (true) {
					// 복권을 구매 할 팀의 번호(n)를 입력하세요 (사용자 입력)
					System.out.print("복권을 구매 할 팀의 번호를 입력해주세요 > ");
					int n = sc.nextInt(); // 팀 번호 선언(사용자 입력)
					System.out.println();
					System.out.println("==============================");
					System.out.println();
					System.out.println(n + "번 팀의 복권을 구매합니다.");
					System.out.println("복권을 구매하시겠습니까?");
					System.out.println();
					System.out.println("1. 예");
					System.out.println("2. 아니오");
					System.out.println();
					System.out.print("원하는 메뉴를 선택하세요 > ");
					int action2 = sc.nextInt();
					System.out.println();
					System.out.println("==============================");
					System.out.println();
					if (action2 == 1) {
						while (true) {
							System.out.println("복권을 구매할 방법을 선택하세요");
							System.out.println();
							System.out.println("1. 직접 입력");
							System.out.println("2. 랜덤 뽑기");
							System.out.println();
							System.out.print("원하는 메뉴를 선택하세요 > ");
							int action3 = sc.nextInt();
							System.out.println();
							System.out.println("==============================");
							System.out.println();
							// 1번 선택 시,
							if (action3 == 1) {

								// 1~10의 숫자중 5가지를 사용자가 입력하고, n번 팀의 배열에 저장하고, n번 팀의 행운의 번호는 [ ]입니다. 출력 (단, 중복없이)
								// 숫자 출력 후, 행운을 빕니다! :D
								// 초기메뉴로 복귀
								// 함수 처리

								System.out.println("1~10까지의 숫자 중 6개를 중복되지 않게 입력해주세요.");
								System.out.println();
								for (int i = 0; i < teamNum[n - 1].length; i++) {
									Boolean numCk = true;
									System.out.print((i + 1) + "번째 번호 >> ");
									teamNum[n - 1][i] = sc.nextInt();// 사용자가 입력
									for (int j = 0; j < i; j++) {
										if (teamNum[n][i] == teamNum[n][j]) { // 같은 숫자가 있는지 처음부터 하나씩 비교해보기
											System.out.println("입력하신 번호 " + teamNum[n][i] + "는 이미 사용하셨습니다.");
											System.out.println();
											System.out.println("==============================");
											System.out.println();
											numCk = false;
											i--;
										}
									}

									if (numCk) {
										System.out.println("현재까지 저장된 숫자");
										for (int k = 0; k < teamNum[n - 1].length; k++) {
											if (i < k) {
												System.out.print(" __ ");
											} else {
												System.out.println(" " + teamNum[n - 1][k] + " ");
											}
										}
										System.out.println();
										System.out.println("==============================");
										System.out.println();
									}
								}
								selfNum(n);

								System.out.println("1~10까지의 숫자 중 6개를 중복되지 않게 입력해주세요.");
								System.out.println();
								for (int i = 0; i < teamNum[n - 1].length; i++) {
									Boolean numCk = true;
									System.out.println();
									System.out.print((i + 1) + "번째 숫자 >> ");
									teamNum[n - 1][i] = sc.nextInt();
									for (int k = 0; k < i; k++) {
										if (teamNum[n - 1][i] == teamNum[n - 1][k]) {
											System.out.println();
											System.out.println("사용자가 적으신 " + teamNum[n - 1][i] + "는(은) 이미 사용하셨습니다");
											numCk = false;
											i--;
										}
									}
									if (numCk) {
										System.out.println();
										System.out.println("현재 저장된 숫자");
										System.out.println();
										for (int j = 0; j < teamNum[n - 1].length; j++) {// 지금까지 받은 숫자 출력
											if (i < j) {// 아직 받지 않았다면 "__"
												System.out.print(" __ ");
											}
											else
												System.out.print(" " + teamNum[n - 1][j] + " ");// 받은 숫자 출력
										}
										System.out.println();
									}
								}
								self(n,teamNum);

								break;
							}
							// 2번 선택 시,
							else if (action3 == 2) {
								// 1~10의 숫자중 5가지를 랜덤으로 n번 팀의 배열에 저장하고 , n번 팀의 행운의 번호는 [ ]입니다. 출력(단, 중복없이)
								// 숫자 출력 후, 행운을 빕니다! :D
								// 초기메뉴로 복귀
								// 함수 처리
								break;
							} else {
								System.out.println("잘못 된 입력입니다. 입력하신 번호를 확인해주세요.");
								System.out.println();
								System.out.println("==============================");
								System.out.println();
								continue;
							}
						}
						break;
					}
					// 2번 선택 시,
					else if (action2 == 2) {
						// 초기 메뉴로 복귀
						break;
					} else {
						System.out.println("잘못 된 입력입니다. 입력하신 번호를 확인해주세요.");
						System.out.println();
						System.out.println("==============================");
						System.out.println();
						continue;
					}
				}
			}

			// 팀 검색
			else if (action1 == 2) {
				// 원하는 팀의 번호를 입력하세요 (사용자 입력)
				while (true) {
					System.out.print("검색하고 싶은 팀의 번호를 입력하세요. 첫 화면으로 돌아가고싶다면 0을 입력하세요 > ");
					int n = sc.nextInt();
					// 번호 입력 했을 때,
					// n팀의 복권 번호는 [ ]입니다.
					// 초기메뉴로 복귀
					// R 입력했을 때,
					// 초기메뉴로 복귀
				}
			}

			// 결과 확인
			else if (action1 == 3) {
				// 1~10의 숫자중 5가지를 랜덤으로 배열에 저장하고
				// 이번 주 행운의 번호는 [ ]입니다. 축하합니다.
				// 프로그램 종료
			}

			// 유효성 검사
			else {
				System.out.println();
				System.out.println("잘못 된 입력입니다. 입력하신 번호를 확인해주세요.");
				System.out.println();
			}

		}

	}
}
// 강사님 947826