package class01;

abstract class Animal{
	String type;
	String name;
	Animal(String type){
		this(type,type);
	}
	Animal(String type,String name){
		this.type=type;
		this.name=name;
	}
	abstract void hello();
	// 추상메서드를 가진 클래스는 반드시 추상메서드 !
}
class Dog extends Animal {
	Dog(){
		this("강아지");
	}
	Dog(String name){
		super("강아지",name);
	}
	@Override
	void hello() {
		System.out.println("멍멍!");
	}
}

public class Test03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
