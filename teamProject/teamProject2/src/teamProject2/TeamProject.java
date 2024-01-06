package teamProject2; //ver 2.0 

import java.util.ArrayList;
import java.util.Scanner;

class Ticket {
	
	// PK
	private int num;
	
	// 영화 이름
	private String name; 
	
	// 영화 가격
	private int price; 
	
	// 남은수량
	private int cnt;

	Ticket(int num, String name, int price) {
		
		this.num = num;
		
		this.name = name;
		
		this.price = price;
		
		// 우선 고정값으로 넣었습니다 :) , 13~16번 라인 사이 다 수정가능
		this.cnt = 30; 
		
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

	@Override
	public String toString() {
		
		String msg = "[" + num + "] " + name + " " + price + "원 남은티켓 수량= " + cnt + " ";
		
		if (this.cnt <= 0) {
			
			msg += "[재고 없음] ";
			
		} else {
			
			msg += "[재고 " + this.cnt + "]";
			
		}
		
		return msg;

	}

}

public class TeamProject {
	
	public static void main(String[] args) {
		
		ArrayList<Ticket> datas = new ArrayList<Ticket>();

		int PK = 1001;
		datas.add(new Ticket(PK++, "서울의 봄", 13000));
		datas.add(new Ticket(PK++, "서울의 여름", 13000));
		
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
				
			} else if(action == 2) {
				
				System.out.println("예매할 영화를 선택해주세요.");
				
				for(int i=0;i<datas.size();i++) {
					
					System.out.println((i+1)+"."+datas.get(i).getName());
					
				}
				
				System.out.print("입력 >>");
				
				int n = sc.nextInt();
				
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
						
					} else if (action == 2) {
						
						System.out.println("정보를 변경할 티켓의 번호를 입력 >> ");
						
						int num = sc.nextInt();
						
						String name;
						
						while (true) {
							
							System.out.println("새로 변경할 영화 이름 입력");
							
							name = sc.next();
							
							System.out.println("변경할 영화 이름이 [" + name + "]이 맞습니까?");
							
							System.out.println("맞다면 1을 입력해주세요 ");
							
							System.out.println("상위 메뉴로 돌아가려면 0을 입력해주세요");
							
							if (action == 1) {
								
								break;
								
							}

							else if (action == 0) {

								continue;

							}
							
						}

					}

				}
				
			} else if (action == 1) { // 상영중인 영화목록
				
				System.out.println("===절찬 상영중===");
				
				for (Ticket data : datas) {
					
					System.out.println(data);
					
				}
				
			} else if (action == 2) {
				
				System.out.println("===절찬 상영중===");
				
				for (Ticket data : datas) {
					
					System.out.println(data);
					
				}
				
				System.out.println("구매할 티켓 번호 입력 >> ");
				
				int num = sc.nextInt();
				
			}
			
		}

	}
	
}