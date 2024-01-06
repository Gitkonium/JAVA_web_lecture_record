package class04;

class LgTV implements TVimpl {
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

class SamsungTV{
	boolean power;
	int sound;
	void turnOnOff() {
		if(this.power) {
			this.power=false;
		}
		else {
			this.power=true;
		}
	}
	void volumeUp(int sound) {
		this.sound+=sound;
	}
	void volumeDown(int sound) {
		this.sound-=sound;
	}
}

public class Test01 {

	public static void main(String[] args) {
		
		SamsungTV tv=new SamsungTV();
		tv.turnOnOff();
		tv.volumeUp(10);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
