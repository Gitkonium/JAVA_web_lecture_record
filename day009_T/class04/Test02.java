package class04;

class Pokemon {
	String type;
	int lv;
	int exp;
	String name;
	Pokemon(String type) { // 객체를 만들 마음 x / type 멤버변수 값을 강제하기 위함
		this.type=type;
		this.lv=5;
		this.exp=0;
		this.name="포켓몬";
	}
	void attack() {
		System.out.println(" [ 로 그 ]");
		System.out.println("포켓몬 클래스의 attack()");
		System.out.println("아직 구현 x");
	}
	void hello() {
		System.out.println(" [ 로 그 ]");
		System.out.println("포켓몬 클래스의 hello()");
		System.out.println("아직 구현 x");
	}
}
class Elec extends Pokemon {
	Elec(){
		super("전기타입");
	}
	@Override // @ 어노테이션 : 코드 가독성 향상, 메모리 성능 향상, 설정 사항
	void attack() {
		System.out.println("백만볼트!!~~~");
	}
}
class Water extends Pokemon {
	Water(){
		super("물타입");
	}
	@Override
	void attack() {
		System.out.println("물대포-----");
	}	
}
class Pikachu extends Elec {
	Pikachu(){
		this("피카츄");
	}
	Pikachu(String name){
		this.name=name;
	}
	@Override
	void hello() {
		System.out.println("피카피카 (*^▽^*)");
	}
}
class Squirtle extends Water {
	Squirtle(){
		this("꼬부기");
	}
	Squirtle(String name){
		this.name=name;
	}
	@Override
	void hello() {
		System.out.println("꼬북꼬북 💧💧💧");
	}
}

public class Test02 {

	public static void main(String[] args) {
		
		Pikachu pika=new Pikachu();
		Squirtle sq=new Squirtle();
		pika.attack();
		pika.hello();
		sq.attack();
		sq.hello();
		// 가장 최근에 정의된(오버라이딩된) 메서드가 자동호출됨
		//  == 다형성이 실현되었다.
		
		/*
		// 클래스는 자료형이다!
		Pikachu[] datas=new Pikachu[6];
		// 피카츄만 6마리
		
		Pokemon[] datas=new Pokemon[6];
		// 여러종류의 포켓몬 6마리
		datas[0]=new Pikachu();
		
		double[] datas=new double[6];
		datas[0]=10;
		*/
		
		
		
		
		
		
		
		
		
	}

}
