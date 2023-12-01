package class02;

import java.util.Random;
import java.util.Scanner;

class Pokemon {
	String name;
	int lv;
	int exp; // 경험치 100당 레벨++
	Pokemon(String name){
		this(name,5);
	}
	Pokemon(String name,int lv){
		this.name=name;
		this.lv=lv;
		this.exp=0;
	}
	void printInfo() {
		System.out.println(this.name+" Lv."+this.lv+" ["+this.exp+"/100]");
	}
	void game() {
		Random rand=new Random();
		int flag=rand.nextInt(2);
		if(flag>0) {
			int exp=rand.nextInt(451)+50; // 50~500
			System.out.println(exp+"만큼 경험치 획득!");

			this.exp+=exp;
			/*
			int tmp=this.exp/=100;
			this.lv+=tmp;
			this.exp%=100;
			for(int i=0;i<tmp;i++) {
				System.out.println(this.name+", 레벨업!");
			}			
			 */
			while(this.exp>=100) {
				this.levelUp();
				// 메서드 호출에는 "주어"가 필요!
			}
		}
		else {
			System.out.println("아무일도없습니다...");
		}
	}
	void levelUp() {
		this.exp-=100;
		this.lv++;
		System.out.println(this.name+", 레벨업!");
	}
}

public class Test01 {

	// 사용자에게 프로그램 상황을 출력하는 함수
	//    참고) 로또 프로그램 출력문구 함수화
	public static int getActionNum(Scanner sc) {
		final int START=1; // final : 값 변경을 막게끔 '강제'하는 키워드
		final int END=2;
		
		int action;
		while(true) {
			System.out.println("1. 포켓몬 고르기");
			System.out.println("2. 종료하기");
			System.out.print("입력 >> ");
			action=sc.nextInt();
			if(START<=action && action<=END) {
				break;
			}
			System.out.println("잘못누르셨습니다...");
		}
		return action;
	}

	public static void main(String[] args) {
		/*
		Pokemon p1=new Pokemon("피카츄");
		Pokemon p2=new Pokemon("꼬부기",10);

		p1.game();
		p1.game();
		p1.printInfo();
		 */
		/*
		int[] datas=new int[3];
		datas[0]=10; // datas[0]

		int num=20;
		datas[1]=num; // num,datas[1]
		 */
		Pokemon[] datas=new Pokemon[3];
		datas[0]=new Pokemon("파이리"); // datas[0]

		Pokemon p=new Pokemon("고라파덕");
		datas[1]=p; // p,datas[1]

		datas[2]=new Pokemon("이상해씨");



		Scanner sc=new Scanner(System.in);
		while(true) {
			int action=getActionNum(sc);
			if(action==2) {
				break;
			}
			else if(action==1) {
				for(int i=0;i<datas.length;i++) {
					System.out.println((i+1)+". "+datas[i].name);
				}
				while(true) {
					System.out.print("선택 >> ");
					action=sc.nextInt();
					if(1<=action && action<=datas.length) {
						break;
					}
					System.out.println("제대로 입력하세요...");
				}
				datas[action-1].game();
				datas[action-1].printInfo();
			}
		}


























	}

}
