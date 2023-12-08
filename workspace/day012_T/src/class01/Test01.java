package class01;

import java.util.ArrayList;
import java.util.Scanner;

// 자판기 프로그램

// LP, ERD, UF
// 기능 명세 / CRUD / 사용자? 관리자?
// 어떤 데이터를 사용해야하는지?
// Console 화면에 어떻게 출력되어야하는지? 사용자 편의성을 충분히 고려해야함!

// 음료 항목을 추가 [관]
//  : 배열리스트에 음료객체를 추가 >> 배열리스트가 main() 소속이라서 메서드화 X
// 음료 목록 출력
// 구매하기 => R,U
// 음료 재고를 추가 [관]
//  : 음료객체의 재고속성의 값을 변경 >> 객체의 속성 값 변경이라서 메서드화 O
// 음료 항목을 삭제 [관]
//  : 배열리스트에 음료객체를 삭제

// "거스름돈" ☆
// "장바구니" ★★★

class Drink {
	private int num; // PK : 시스템에서 부여하는 값
	private String name;
	private int price;
	private int cnt;
	public Drink(int num,String name,int price){
		this.num=num;
		this.name=name;
		this.price=price;
		this.cnt=5;
	}

	public void sell() {
		this.cnt--;
		System.out.println(this.name+" 판매완료!");
	}
	public void addCnt(int cnt) {
		this.cnt+=cnt;
		// this.cnt=this.cnt+cnt;
		System.out.println(this.name+" 재고추가완료!");
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
		String msg="[" + num + "] " + name + " " + price + "원";
		if(this.cnt<=0) {
			msg+=" [재고없음]";
		}
		else {
			msg+=" [재고 "+this.cnt+"]";
		}
		return msg;
	}
}

public class Test01 {

	public static int func(ArrayList<Drink> datas,int num) {
		// 존재하는 번호인지 ???
		boolean flag=false;
		int i=-1;
		for(i=0;i<datas.size();i++) {
			if(datas.get(i).getNum()==num) {
				flag=true;
				System.out.println("[로그] 기능수행가능");
				break;
			}
		}
		if(!flag) {
			System.out.println("없는번호입니다...");
		}		
		return i;
	}

	public static void main(String[] args) {

		// "자판기"
		//  : "프로그램"의 데이터 !
		ArrayList<Drink> datas=new ArrayList<Drink>();

		int PK=1001;
		datas.add(new Drink(PK++,"콜라",1200));
		datas.add(new Drink(PK++,"사이다",1100));

		Scanner sc=new Scanner(System.in);

		while(true) {
			System.out.println("=== 자 판 기 ===");
			System.out.println("1. 목록출력");
			System.out.println("2. 구매");
			System.out.println("0. 종료");
			System.out.print("입력 >> ");
			int action=sc.nextInt();
			if(action==0) {
				break;
			}
			else if(action==777) {
				while(true) {
					System.out.println("=== 관 리 자 모 드 ===");
					System.out.println("1. 음료추가");
					System.out.println("2. 재고추가");
					System.out.println("3. 음료삭제");
					System.out.println("0. 종료");
					System.out.print("입력 >> ");
					action=sc.nextInt();
					if(action==0) {
						break;
					}
					else if(action==1) {
						System.out.print("추가할 음료 이름 입력 >> ");
						String name=sc.next();
						System.out.print("추가할 음료의 가격 입력 >> ");
						int price=sc.nextInt();

						datas.add(new Drink(PK++,name,price));
					}
					else if(action==2) {
						System.out.println("=== 목 록 ===");
						for(Drink data:datas) {
							System.out.println(data);
						}
						System.out.print("입력 >> ");
						int num=sc.nextInt();

						int i=func(datas,num);

						System.out.print("추가할 재고수량 입력 >> ");
						int cnt=sc.nextInt();

						datas.get(i).addCnt(cnt);
					}
					else if(action==3) {
						System.out.print("삭제할 음료의 번호 입력 >> ");
						int num=sc.nextInt();

						int i=func(datas,num);

						datas.remove(i);
					}
				}
			}
			else if(action==1) {
				System.out.println("=== 목 록 ===");
				for(Drink data:datas) {
					System.out.println(data);
				}
			}
			else if(action==2) { // 구매
				System.out.println("=== 목 록 ===");
				for(Drink data:datas) {
					System.out.println(data);
				}
				System.out.print("입력 >> ");
				int num=sc.nextInt();

				// 1. 존재하는 번호인지
				// 2. 재고가 있는지
				boolean flag=false;
				int i;
				for(i=0;i<datas.size();i++) {
					if(datas.get(i).getNum()==num) {
						if(datas.get(i).getCnt()>0) {
							flag=true;
							System.out.println("[로그] 구매가능");
							break;
						}
						System.out.println("[로그] 재고없음");
						break;
					}
				}
				if(!flag) {
					System.out.println("없는 번호이거나 재고가 없습니다...");
					continue;
				}
				datas.get(i).sell();
			}
		}











	}

}
