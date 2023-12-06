package class06;

class SamsungTV implements TVimpl{

	@Override
	public void turnOn() {
		System.out.println("삼성TV 전원 ON");
	}

	@Override
	public void turnOff() {
		System.out.println("삼성TV 전원 OFF");
	}

	@Override
	public void soundUp() {
		System.out.println("삼성TV 소리 ++");
	}

	@Override
	public void soundDown() {
		System.out.println("삼성TV 소리 --");
	}
	
}
class LgTV implements TVimpl{

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void soundUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void soundDown() {
		// TODO Auto-generated method stub
		
	}
	
}

public class Test01 {

	public static void main(String[] args) {
		
		SamsungTV tv=new SamsungTV();
		tv.turnOn();
		tv.soundUp();
		tv.soundDown();
		tv.turnOff();
		
	}

}
