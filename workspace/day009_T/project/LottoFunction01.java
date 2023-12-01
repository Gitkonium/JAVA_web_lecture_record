package project;

import java.util.Random;
import java.util.Scanner;

public class LottoFunction01 {

	static int MAX = 10;

	public static int menu(Scanner sc) {// 초기 메뉴
		System.out.println("0. 시스템 종료");
		System.out.println("1. 복권 구매");
		System.out.println("2. 팀 검색");
		System.out.println("3. 추첨 번호");
		System.out.print(">>> ");
		int action = sc.nextInt();
		return action;

	}

	public static int buy(Scanner sc) {// 복권 구매
		while (true) {
			System.out.println("복권을 구매 하시겠습니까?");
			System.out.println("1. 예");
			System.out.println("2. 아니오");
			System.out.print(">>> ");
			int num = sc.nextInt();
			if (num < 1 || num > 2) {// 유효성 검사
				System.out.println("1 또는 2의 값을 입력하세요");
				continue;
			} else if (num == 2) {
				System.out.println("메뉴로 돌아갑니다");
				return 0;
			}
			break;
		}
		int sel = 0;
		while (true) {
			System.out.println("0. 구매하지 않기");
			System.out.println("1. 직접 입력");
			System.out.println("2. 랜덤 뽑기");
			System.out.print("번호 입력 >>> ");
			sel = sc.nextInt();
			if (sel < 0 || sel > 2) {// 유효성 검사
				System.out.println("0~2 사이의 값을 입력하세요");
				continue;
			}
			break;
		}
		return sel;
	}

	public static int team(int length, Scanner sc) {// 팀번호 입력 및 유효성 검사
		int teamNum = -1;
		while (true) {
			System.out.print("복권을 구매 할 팀의 번호(1~" + length + ")를 입력하세요 : ");
			teamNum = sc.nextInt();
			if (teamNum < 0 || teamNum > length) {
				System.out.println("팀의 번호(1~" + length + ")를 입력해야합니다");
				System.out.println("다시 입력해주세요");
				continue;
			}
			break;
		}

		return teamNum;
	}

	public static void userInput(int[][] userNums, int index, Scanner sc) {// 사용자가 복권 번호 입력

		System.out.println("1~" + MAX + "중 숫자 6개를 골라주세요");
		for (int i = 0; i < userNums[index].length; i++) {
			Boolean numCk = true;
			while (true) {
				System.out.print((index + 1) + "팀" + (i + 1) + "번째 숫자>>> ");
				userNums[index][i] = sc.nextInt();// 사용자 입력
				// 깊이 줄이기
				if (1 <= userNums[index][i] && userNums[index][i] <= MAX) {// 1~10사이 유효성 검사
					break;
				}
				System.out.println("1~" + MAX + "사이의 숫자를 입력해주세요");

			}
			for (int j = 0; j < i; j++) {
				if (userNums[index][i] == userNums[index][j]) {
					System.out.println("사용자가 적으신 " + userNums[index][i] + "는(은) 이미 사용하셨습니다");
					numCk = false;
					i--;
				}
			}

			if (numCk) {
				System.out.println();
				System.out.println("현재 저장된 숫자");
				for (int j = 0; j < userNums[index].length; j++) {// 지금까지 받은 숫자 출력
					if (i < j) {// 아직 받지 않았다면 "__"
						System.out.print(" __ ");
					} else
						System.out.print(" " + userNums[index][j] + " ");// 받은 숫자 출력
				}
				System.out.println();
				System.out.println();

			}
		}

	}

	public static void randInput(int[][] userNums, int teamNum) {// 랜덤으로 복권 번호 입력
		Random rand = new Random();
		for (int i = 0; i < userNums[teamNum].length; i++) {
			userNums[teamNum][i] = rand.nextInt(MAX) + 1;// n번 팀의 6개 중복 없이 랜덤 뽑기
			for (int j = 0; j < i; j++) {
				if (userNums[teamNum][i] == userNums[teamNum][j]) {
					i--;
				}
			}
		}
	}

	public static void InputPrint(int[][] userNums) {// 현재 저장됨 팀 정보
		System.out.println("=====저장된팀======");
		for (int j = 0; j < userNums.length; j++) {
			if (userNums[j][0] > 0) {
				System.out.print((j + 1) + "팀 : ");
				for (int k = 0; k < userNums[j].length; k++) {
					System.out.print(" " + userNums[j][k] + " ");
				}
				System.out.println();
			}
		}
		System.out.println();
		System.out.println("좋은 결과 있길 바랍니다~~! :D");
	}

	public static void teamPrint(int[][] userNums, Scanner sc) {// 특정 팀 정보 확인
		int teamNum = -1;
		while (true) {
			System.out.print("확인 하고 싶은 팀의 번호(1~" + userNums.length + ")를 입력하세요 : ");
			teamNum = sc.nextInt();
			if (teamNum < 0 || teamNum > 6) {
				System.out.println("팀의 번호(1~" + userNums.length + ")를 입력해야합니다");
				System.out.println("다시 입력해주세요");
				continue;
			}
			break;
		}
		System.out.print(teamNum + "팀 :");
		for (int i = 0; i < userNums[teamNum - 1].length; i++) {
			System.out.print(userNums[teamNum - 1][i] + " ");
		}
		System.out.println();
	}

	public static int randPlay(int[] datas, int bonusNum) {// 복권 번호 추첨

		Random rand = new Random();

		boolean[] numCk = new boolean[MAX];// 1~10까지 뽑기때문에 진위형 배열 0~9까지 만든다 def=false
		for (int i = 0; i <= datas.length; i++) {// 랜덤 숫자를 datas길이 만큼 뽑는다
			int ranNum = rand.nextInt(MAX) + 1;
			if (i < datas.length) {// 배열 갯수만큼만 뽑기

				// 방금 뽑은 숫자를 numCk(진위형 배열)index로 넣어 false가 나오면 중복x true가 나오면 중복o이 된다
				if (!numCk[ranNum - 1]) {// false를 Not 연산자를 이용해 true로 바꾸어 if문 실행한다
					datas[i] = ranNum;// 뽑은 랜덤 값 저장
					numCk[ranNum - 1] = true;// numCk 해당 index로 들어가 false를 true로 변환
				} else {// 중복시 i 감소하여 다시 뽑기
					i--;
				}
			} else {
				if (!numCk[ranNum - 1]) {// false를 Not 연산자를 이용해 true로 바꾸어 if문 실행한다
					bonusNum = ranNum;// 뽑은 랜덤 값 저장
					numCk[ranNum - 1] = true;// numCk 해당 index로 들어가 false를 true로 변환
				} else {// 중복시 i 감소하여 다시 뽑기
					i--;
				}

			}
		}
		return bonusNum;
	}

	public static void rank(int[][] userNums, int[] datas, int bonusNum) {// 팀별 순위
		int[] teamNumCk = new int[userNums.length];
		boolean bonusCk = false;
		System.out.println("결과 확인");
	
		for (int j = 0; j < userNums.length; j++) {
			for (int i = 0; i < userNums[j].length; i++) {
				if (userNums[j][i] > 0) {
					for (int k = 0; k < datas.length; k++) {
						if (userNums[j][i] == datas[k]) {
							teamNumCk[j] += 1;
							System.out.println("teamNumCk[j] : "+teamNumCk[j]);
						}
					}
					if (userNums[j][i] == bonusNum) {
						bonusCk = true;
						System.out.println("bonusCk : "+bonusCk);
					}
				} else {
					teamNumCk[j] = -1;
				}
			}
			if (bonusCk == true && teamNumCk[j] >= datas.length - 1) {
				teamNumCk[j] *= 10;
			}
		}
		for (int i = 0; i < teamNumCk.length; i++) {
			if (teamNumCk[i] > datas.length * 10) {
				System.out.print((i + 1) + "팀 " + teamNumCk[i] + "개 보너스 1개 맞춤 / ");
			} else if (teamNumCk[i] > 0) {
				System.out.print((i + 1) + "팀 " + teamNumCk[i] + "개 맞춤 / ");
			} else {
				System.out.print((i + 1) + "팀 : ");
			}
			if (teamNumCk[i] == userNums.length) {
				System.out.println("1등");
			} else if (teamNumCk[i] >= datas.length * 10) {
				System.out.println("2등");
			} else if (teamNumCk[i] == 5) {
				System.out.println("3등");
			} else if (teamNumCk[i] == 4) {
				System.out.println("4등");
			} else if (teamNumCk[i] == 3) {
				System.out.println("5등");
			} else if (teamNumCk[i] == -1) {
				System.out.println("미입력");
			} else
				System.out.println("꽝");

		}

	}

	public static void randPrint(int[] datas, int bonusNum) {// 추첨 번호 출력
		System.out.print("당첨 번호 : ");
		for (int data : datas) {// forEach문
			System.out.print(data + " ");
		}
		System.out.println("+ 보너스 번호 : " + bonusNum);
		System.out.println();

	}

	public static void clear(int[][] userNums, int[] datas) {// 추첨이 끝나고 초기화
		for (int j = 0; j < userNums.length; j++) {
			for (int i = 0; i < userNums[j].length; i++) {
				userNums[j][i] = 0;
			}
		}
		for (int i = 0; i < userNums.length; i++) {
			datas[i] = 0;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // 사용자 입력을 이용하기 위한 선언
		int[][] userNums = new int[6][6]; // 팀별로 입력한 숫자들을 저장하기 위한 공간
		int[] datas = new int[6]; // 당첨 번호를 저장하기 위한 공간
		int bonusNum = 0; // 보너스 번호를 초기화

		while (true) {
			int number = menu(sc);
			if (number == 0) {
				System.out.println("종료합니다.");
				break;
			} else if (number == 1) {
				int teamNum = team(userNums.length, sc);
				int sel = buy(sc);
				System.out.println();
				if (sel == 1) {// 뽑기 방법 1 (직접입력)
					userInput(userNums, teamNum - 1, sc);
					InputPrint(userNums);
				} else if (sel == 2) {// 뽑기 방법 2 (랜덤뽑기)
					randInput(userNums, teamNum - 1);
					InputPrint(userNums);
				}

			} else if (number == 2) {// 팀 번호 출력
				teamPrint(userNums, sc);
			} else if (number == 3) {// 당첨 번호 뽑기
				bonusNum = randPlay(datas, 0);
				randPrint(datas, bonusNum);
				rank(userNums, datas, bonusNum);
				clear(userNums, datas);
				bonusNum = 0;
			} else {// 유효성 검사
				System.out.println("유효하지 않은 값입니다 다시 확인해주세요");
			}
		}
	}

}

//1팀:
//2팀:1 2 3 4 5 7
//3팀:1 3 4 5 6 9
//4팀:
//5팀:
//6팀(강사님):9 4 7 8 2 6

//	public static int randPlay(int[] datas) {// 복권 번호 추첨
//	Random rand = new Random();
//	int bonusNum = -1;
//		for (int i = 0; i <= datas.length; i++) {//배열 n + 1
//			if (i < datas.length) {//배열 갯수만큼만 뽑기 
//				datas[i] = rand.nextInt(MAX) + 1;      
//				for (int j = 0; j < i; j++) {
//					if (datas[i] == datas[j]) {
//						i--;
//					}
//				}
//			} else {
//				bonusNum = rand.nextInt(10) + 1;
//				for (int j = 0; j < i; j++) {
//
//					if (bonusNum == datas[j]) {
//						i--;
//					}
//				}
//			}
//		}
//	}
