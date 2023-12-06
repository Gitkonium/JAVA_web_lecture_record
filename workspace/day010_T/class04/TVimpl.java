package class04;

public interface TVimpl {
	void turnOn(); // 메서드 바디 x
	void turnOff(); // 추상메서드
	abstract void soundUp(); // 메서드 오버라이딩 강제
	public abstract void soundDown();
}
