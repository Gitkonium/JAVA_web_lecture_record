package test;

public class GalaxyPhone implements Phone {
	@Override
	public void powerOn() {
		System.out.println("갤럭시 전원 ON");
	}
	@Override
	public void powerOff() {
		System.out.println("갤럭시 전원 OFF");
	}
	@Override
	public void call() {
		System.out.println("갤럭시 전화통화연결");
	}
}
