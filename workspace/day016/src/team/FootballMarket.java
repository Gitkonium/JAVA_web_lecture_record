package team;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class FootballPlayer { // 축구선수 클래스
	private int pk; // PK, 객체 고유 id로 사용
	private String name; // 선수 이름
	private String position; // 선수 포지션
	private int totalPower; // 선수 능력치
	private int price; // 가격
	private int ea; // 수량

	FootballPlayer(int pk, String name, String position, int totalPower, int price, int ea) {
		this.pk = pk;
		this.name = name;
		this.position = position; // FW, MF, DF, GK
		this.totalPower = totalPower;
		this.price = price;
		this.ea = ea;
	}

	public int getPk() {
		return pk;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getTotalPower() {
		return totalPower;
	}

	public void setTotalPower(int totalPower) {
		this.totalPower = totalPower;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getEa() {
		return ea;
	}

	public void setEa(int ea) {
		this.ea = ea;
	}

	@Override // 유저한테 PK 안보이도록 설정
	public String toString() {
		String ret = "[" + position + " "+ name + " 능력치 : " + totalPower + ", " + price+"$";
		if (this.ea == 0) {
			return ret + ", 재고없음]";
		} else {
			return ret + ", 수량=" + ea + "]";
		}
	}

	public void sell(int cnt) {
		this.ea -= cnt;
	}

	public static Comparator<FootballPlayer> byPrice = new Comparator<FootballPlayer>() {
		@Override
		public int compare(FootballPlayer p1, FootballPlayer p2) {
			return p2.price - p1.price;
		}
	};

	public static Comparator<FootballPlayer> byTotalPower = new Comparator<FootballPlayer>() {
		@Override
		public int compare(FootballPlayer p1, FootballPlayer p2) {
			return p2.totalPower - p1.totalPower;
		}
	};

	public static Comparator<FootballPlayer> byPk = new Comparator<FootballPlayer>() {
		@Override
		public int compare(FootballPlayer p1, FootballPlayer p2) {
			return p2.pk - p1.pk;
		}
	};

	public static Comparator<FootballPlayer> byName = new Comparator<FootballPlayer>() {
		@Override
		public int compare(FootballPlayer p1, FootballPlayer p2) {
			return p2.name.compareTo(p1.name);
		}
	};
}

public class FootballMarket {

	public static int PK = 1001; // 객체가 만들어질떄마다 ++
	public final static int MANAGERMODE = 231121;
	public static Scanner sc = new Scanner(System.in);
	public static ArrayList<FootballPlayer> datas = new ArrayList<FootballPlayer>();

	/*
	 * Utils
	 */

	// 문자열 입력받기
	public static String inputString(String msg) {
		System.out.print(msg);
		return sc.next();
	}




	// 포지션 입력받기 및 유효성 검사
	public static String getPosition(String msg) {
		System.out.print(msg);
		System.out.print("(FW / MF / DF / GK) >> ");
		while (true) {
			String position = sc.next();
			if (position.equals("FW") || position.equals("MF") || position.equals("DF") || position.equals("GK")) {
				return position;
			}
			System.out.println("포지션은 FW, MF, DF, GK 중에만 입력하실 수 있습니다.");
			System.out.print("다시 입력해주세요 >> ");
		}
	}

	// Y or N 입력받기 및 유효성 검사
	public static String getAnswer(String msg) {
		System.out.print(msg);
		while (true) {
			String answer = sc.next();
			if (answer.equals("Y") || answer.equals("N")) {
				return answer;
			}
			System.out.println("Y 또는 N 만 입력 가능합니다.");
			System.out.print("다시 입력해주세요 >> ");
		}
	}



	/*
	 * Football Player Buy
	 */

	public static void buy(ArrayList<FootballPlayer> players) {
		int eaCnt = 0;
		for (int i = 0; i < players.size(); i++) {
			eaCnt += players.get(i).getEa();
		}
		if (eaCnt <= 0) {
			System.out.println("등록된 모든 선수의 재고가 없습니다.");
			return;
		}
		while (true) {

			int choiceNum = inputNum("구매할 선수 번호 입력 ", 1, players.size());
			if (players.get(choiceNum - 1).getEa() <= 0) {
				System.out.println("해당선수 재고가 없습니다.");
				continue;
			}

			int cnt = inputNum("구입할 수량 입력 ", 1, players.get(choiceNum - 1).getEa());
			System.out.println(cnt + "개를 구입하시겠습니까 ?");

			String answer = getAnswer("Y or N >> ");
			if (answer.equals("Y")) {
				System.out.println(players.get(choiceNum - 1).getName() + " " + cnt + "개 구입완료!");
				players.get(choiceNum - 1).sell(cnt);
			} else {
				System.out.println("구입 취소");
			}
			break;
		}
	}

	/*
	 * Manager Mode
	 */


	// 선수 모두 출력 ( 정보 변경이나 삭제에서 목록을 띄우기 위함)
	public static void printAllFootballPlayer() {

		for (int i = 0; i < datas.size(); i++) {
			System.out.println("[PK-" + datas.get(i).getPk() + "] " + datas.get(i));
		}
	}

	// 관리자 모드 실행
	public static void execManagerMode() {
		System.out.println("관리자 모드입니다");
		printManagermode();
	}

	// 관리자 메인 메뉴
	public static void printManagermode() {
		while (true) {
			System.out.println("1. 선수 추가");
			System.out.println("2. 선수 정보 변경");
			System.out.println("3. 선수 삭제");
			System.out.println("0. 관리자 모드 종료");
			if (chooseManagermenu() == 0) {
				break;
			}
		}
	}

	// 관리자 메인 메뉴 번호 선택
	public static int chooseManagermenu() {
		int action = inputNum("번호를 입력해주세요", 0, 3);
		if (action == 1) { // 선수 추가
			addFootballPlayer();
		} else if (action == 2) { // 선수정보 변경
			updateFootballPlayer();
		} else if (action == 3) { // 선수 삭제
			deleteFootballPlayer();
		} else if (action == 0) { // 사용자화면으로 이동
			System.out.println("관리자모드를 종료합니다...");
		}
		return action;
	}


	// 가격 변경
	public static void UpdatePrice(int i) {
		while (true) {
			int price = inputNum("새로운 가격을 입력해주세요", 1000, 10000);
			if (price != datas.get(i).getPrice()) {
				datas.get(i).setPrice(price);
				System.out.println(datas.get(i).getName() + "선수 " + datas.get(i).getPrice() + "원 변경완료!");
				break;
			} else {
				System.out.println("같은 가격은 입력하실 수 없습니다.");
			}
		}
	}

	// 능력치 변경
	public static void UpdateTotalPower(int i) {
		while (true) {
			int power = inputNum("새로운 능력치를 입력해주세요", 40, 100);
			if (power != datas.get(i).getTotalPower()) {
				datas.get(i).setTotalPower(power);
				System.out.println(datas.get(i).getName() + "선수 능력치 " + datas.get(i).getTotalPower() + " 변경완료!");
				break;
			} else {
				System.out.println("같은 능력치는 입력하실 수 없습니다.");
			}

		}
	}

	// 수량 변경
	public static void UpdateEa(int i) {
		while (true) {
			int ea = inputNum("새로운 수량을 입력해주세요", 1, 10);
			if (ea != datas.get(i).getEa()) {
				datas.get(i).setEa(ea);
				System.out.println(datas.get(i).getName() + "선수 재고 " + datas.get(i).getEa() + "개 변경완료!");
				break;
			} else {
				System.out.println("같은 수량으로는 입력하실 수 없습니다.");
			}
		}

	}


	
	// PK 유효성 검사
	public static int inputIndex() {
		int i = 0;
		while (true) {
			try {
				int firstPK = datas.get(0).getPk(); // datas리스트는 원본데이터로 순서를 섞지않고 PK는 항상 증가하는 방식으로 추가됩니다.
				int lastPK = datas.get(datas.size() - 1).getPk();
				int changePlayer = inputNum("선수의 PK를 입력해주세요 ", firstPK, lastPK);// 수정, 현진 =>
				for (i = 0; i < datas.size(); i++) { // datas리스트의 0번째 인덱스 PK값 부터
					if (datas.get(i).getPk() == changePlayer) { // datas리스트의 마지막 인덱스 PK값은
						System.out.println("선택된 선수 : [" + datas.get(i).getName() + "]");
						return i; // datas리스트의 size()-1을 해주어야
									// 리스트의 마지막 인덱스 PK값이 됩니다.
					}
				}
				System.out.println("유효하지 않은 PK입니다.");
			} catch (Exception e) {
				System.out.println("정수를 입력해주세요");
				sc.nextLine();
			}
		}
	}
	
	// 선수 정보 변경
	public static void updateFootballPlayer() {
		if (!checkListEmpty()) {
			printAllFootballPlayer();
			int i = inputIndex();
			System.out.println("1. 가격 변경");
			System.out.println("2. 능력치 변경");
			System.out.println("3. 수량 변경");
			int select = inputNum("어떤정보를 변경하시겠습니까?", 1, 3);
			if (select == 1) {
				UpdatePrice(i);
			} else if (select == 2) {
				UpdateTotalPower(i);
			} else if (select == 3) {
				UpdateEa(i);
			}
		}
	}

	// 배열리스트가 비어있는지 검사
	public static boolean checkListEmpty() {
		if (datas.size() <= 0) {
			System.out.println("등록된 선수가 없습니다...");
			return true;
		}
		return false;
	}
	
	// 선수 삭제
	public static void deleteFootballPlayer() {
		if (!checkListEmpty()) {
			printAllFootballPlayer();
			int i = inputIndex();
			String name = datas.get(i).getName();
			datas.remove(i);
			System.out.println(name + " 선수삭제 성공!");
		}
	}

	// 선수 추가
	public static void addFootballPlayer() {
		System.out.println("선수를 추가합니다.");
		String name = inputString("이름을 입력해주세요 >> ");
		String position = getPosition("포지션을 입력해주세요");
		int totalPower = inputNum("능력치를 입력해주세요", 40, 100);
		int price = inputNum("가격을 입력해주세요", 1000, 10000);
		int ea = inputNum("수량을 입력해주세요", 1, 10);
		datas.add(new FootballPlayer(PK++, name, position, totalPower, price, ea));
		System.out.println(name + " 선수 " + ea + "개 등록 성공!");
	}

	/*
	 * Functions
	 */

	// 가격별 출력
	public static void printByPrice() {
		if (!checkListEmpty()) {
			ArrayList<FootballPlayer> tmpDatas = new ArrayList<FootballPlayer>(datas);
			tmpDatas.sort(FootballPlayer.byPrice);
			for (int i = 0; i < tmpDatas.size(); i++) {
				System.out.println((i + 1) + ". " + tmpDatas.get(i));
			}
			buy(tmpDatas);
		}
	}

	// 능력치별 출력
	public static void printByTotalPower() {
		if (!checkListEmpty()) {
			ArrayList<FootballPlayer> tmpDatas = new ArrayList<FootballPlayer>(datas);
			tmpDatas.sort(FootballPlayer.byTotalPower);
			for (int i = 0; i < tmpDatas.size(); i++) {
				System.out.println((i + 1) + ". " + tmpDatas.get(i));
			}
			buy(tmpDatas);
		}
	}

	public static void printByMainPosition(ArrayList<FootballPlayer> players, String position) { // 포지션 입력 // 배열 넣기
		// 배열 하나 만든다 tmpDatas
		ArrayList<FootballPlayer> tmpDatas = new ArrayList<FootballPlayer>();
		int i = 0;
		for (FootballPlayer player : players) {
			if (player.getPosition().equals(position)) { // 포지션을 선택한다
				tmpDatas.add(player); // 선택된 포지션을 배열 안으로 넣는다
				System.out.println((i + 1) + ". " + player); // 선택된 포지션 출력
				i++;
			}
		}
		buy(tmpDatas);
	}

	public static void printByMainPositionPage() {
		System.out.println("포지션을 선택해주세요"); // 포지션 번호로 선택
		System.out.println("1. FW");
		System.out.println("2. MF");
		System.out.println("3. DF");
		System.out.println("4. GK");
		System.out.println("0. 종료");
	}

	// 포지션별 출력
	public static void printByPosition() { // 선수 포지션별로 출력하기
		while (true) {
			printByMainPositionPage(); // 포지션 선택창
			int action = inputNum("번호를 입력해주세요", 0, 4); // 포지션 번호로 선택
			if (action == 0) {
				System.out.println("포지션 선택을 나갑니다."); // 포지션 선택 종료
				break;
			} else {
				String selectedPosition = ""; // 선택된 포지션을 저장할 변수
				// 선택된 포지션 설정
				if (action == 1) {
					selectedPosition = "FW"; // 모듈화를 통해 간단하게 표현 FW 선택
				} else if (action == 2) {
					selectedPosition = "MF"; // MF 선택
				} else if (action == 3) {
					selectedPosition = "DF";
				} else if (action == 4) {
					selectedPosition = "GK";
				}
				System.out.println(selectedPosition + " 포지션 선수 목록"); // 선택된 포지션 출력
				printByMainPosition(datas, selectedPosition); // 선수 출력
			}
		}
	}

	public static void searchByName() {
		if (!checkListEmpty()) {
			String name = inputString("선수 이름을 입력해주세요 >> ");
			boolean found = false;
			for (FootballPlayer data : datas) {
				if (data.getName().contains(name)) { // "호날두".contains("호");
					System.out.println(data);
					found = true;
				}
			}
			if (!found) {
				System.out.println("해당 이름을 가진 선수가 없습니다.");
			}
		}
	}
	
	// 번호 입력받기 및 범위 유효성 검사 (수정, 현진 => 오버로딩 삭제 => 결합도 ↓, 응집도 ↑ => 좋은 코드)
	public static int inputNum(String msg, int min, int max) {
		System.out.print(msg);	 // min 최소값, max최대값을 사용자에게 출력하기 위해 사용된 변수
		String rangeStr;
		if (min == max) {
			rangeStr = "( " + min + " )";
		} else {
			rangeStr = "(" + min + " ~ " + max + ")";
		}
		System.out.print(rangeStr + " >> ");
		while (true) {
			try {
				int chooseNum = sc.nextInt();
				if (chooseNum >= min && chooseNum <= max) {
					return chooseNum;
				} 
				else if (chooseNum == MANAGERMODE) {
					return chooseNum;
				} 
				else {
					System.out.print(rangeStr + " 입력 가능합니다. >>");
				}
			} catch (Exception e) {
				System.out.print("'정수'만 입력가능합니다. >>");
				sc.nextLine();
			}
		}
	}

	/*
	 * Main Page
	 */

	public static void printMainPage() {
		System.out.println("=====================");
		System.out.println("⚽ Football 이적 시장 ⚽");
		System.out.println("=====================");
		System.out.println("1. 가격별 출력");
		System.out.println("2. 능력치별 출력");
		System.out.println("3. 포지션별 출력");
		System.out.println("4. 검색 기능");
		System.out.println("0. 프로그램 종료");
		System.out.println("======================");
	}

	public static int controller() {
		int select = inputNum("번호를 입력해주세요 ", 0, 4);
		if (select == 0) {
			System.out.println("프로그램을 종료합니다..");
		} else if (select == 1) {
			// 가격별 출력
			printByPrice();
		} else if (select == 2) {
			// 능력치별 출력
			printByTotalPower();
		} else if (select == 3) {
			// 포지션별 출력
			printByPosition();
		} else if (select == 4) {
			// 검색 기능
			searchByName();
		} else if (select == MANAGERMODE) { //231121
			// 관리자 모드
			execManagerMode();
		} else if (select < 0 || select > 4) {
			// validation 처리
			System.out.println("유효하지 않은 입력입니다\n다시 입력해주세요\n");
		}
		return select;
	}

	public static void run() {
		while (true) {
			printMainPage();
			int select = controller();
			if (select == 0) {
				break;
			}
		}
	}

	public static void main(String[] args) {

		datas.add(new FootballPlayer(PK++, "호날두", "FW", 87, 8700, 5));
		datas.add(new FootballPlayer(PK++, "메시", "FW", 86, 8600, 4));
		datas.add(new FootballPlayer(PK++, "손흥민", "FW", 83, 8300, 7));
		datas.add(new FootballPlayer(PK++, "김덕배", "MF", 85, 8500, 2));
		datas.add(new FootballPlayer(PK++, "박지성", "MF", 81, 8100, 3));
		datas.add(new FootballPlayer(PK++, "이강인", "MF", 77, 7700, 7));
		datas.add(new FootballPlayer(PK++, "에브라", "DF", 83, 8300, 6));
		datas.add(new FootballPlayer(PK++, "김민재", "DF", 79, 7900, 4));
		datas.add(new FootballPlayer(PK++, "말디니", "DF", 84, 8400, 3));
		datas.add(new FootballPlayer(PK++, "알베스", "DF", 83, 8300, 3));
		datas.add(new FootballPlayer(PK++, "이운재", "GK", 83, 8300, 3));

		run();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

		
		
		
		
		
		
		
		
		
	
	}
}
