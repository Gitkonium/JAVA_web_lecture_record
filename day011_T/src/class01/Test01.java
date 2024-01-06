package class01;

import java.util.Random;

class SamsungTV implements TVimpl{

	String userName;
	int channel;
	static Random rand=new Random();
	// 반복문 횟수 -> 메서드 호출 횟수 -> 객체 생성 횟수 -> 1번
	// "싱글톤 패턴" 유지 ★
	
	SamsungTV(String userName){
		this.userName=userName;
		this.channel=1;
	}

	@Override
	public void channelUp() {
		this.channel++;
		if(this.channel>TVimpl.CMAX) {
			this.channel=TVimpl.CMIN;
		}
	}

	@Override
	public void channelDown() {
		this.channel--;
		if(this.channel<TVimpl.CMIN) {
			this.channel=TVimpl.CMAX;
		}
	}

	public void channelRandom() {
		int randNum;
		while(true) {
			randNum=SamsungTV.rand.nextInt(TVimpl.CMAX-TVimpl.CMIN+1)+TVimpl.CMIN; // ※ 가능하다면 new는 적게 사용하는것이 좋다!
			if(this.channel!=randNum) {
				break;
			}
		}
		this.channel=randNum;
	}

	@Override
	public void printInfo() {
		System.out.println(this.userName+"님의 현재 시청 채널은 "+this.channel+"입니다.");
	}

}
class SamsungMiniTV extends SamsungTV{
	
	int battery;
	final static int BM=10;
	// 상수를 목적으로 사용하는 변수는 전부 대문자
	
	SamsungMiniTV(String userName){
		super(userName);
		this.battery=SamsungTV.rand.nextInt(21)+50; // 50~70
	}

	@Override
	public void channelRandom() {
		if(this.battery<SamsungMiniTV.BM) { // ※ 하드코딩
			System.out.println(" 로그 : 배터리 부족으로 채널 랜덤 변경 불가능");
			return;
		}
		super.channelRandom();
		this.battery-=SamsungMiniTV.BM;
	}

}
class LgTV implements TVimpl{

	boolean power;
	int channel;
	
	LgTV(){
		this.power=false;
		this.channel=1;
	}

	@Override
	public void channelUp() {
		if(this.power) {
			// 기능
		}
		else {
			System.out.println(" 로그 : 전원 OFF 상태");
		}
	}

	@Override
	public void channelDown() {
		// ※ 기능을 먼저 작성하고, 안될때의 코드를 위에 배치
		if(!this.power) {
			System.out.println(" 로그 : 전원 OFF 상태");
			return;
		}
		// 기능
	}

	@Override
	public void printInfo() {
		// TODO Auto-generated method stub

	}

}

public class Test01 {

	public static void main(String[] args) {

		SamsungTV tv1=new SamsungTV("홍길동"); // 처음 채널 위치는 1로 고정
		SamsungMiniTV tv2=new SamsungMiniTV("홍길동"); // 처음 채널 위치는 1로 고정. 처음 배터리는 50~70 랜덤 설정됨
		LgTV tv3=new LgTV(); // 처음 채널 위치는 1로 고정. 처음 전원은 OFF 상태

	}

}
