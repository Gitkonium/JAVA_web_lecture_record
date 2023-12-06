package class01;
abstract class Pokemon{
	String name;
	String type;
	int lv;
	Pokemon(String name,String type,int lv){
		this.name=name;
		this.type=type;
		this.lv=lv;
	}
	void printInfo() {
		System.out.println(this.type+"타입의 "+this.name+"는(은) Lv."+this.lv);
	}
	abstract void attack();
	abstract void hello();
}
abstract class Elec extends Pokemon{
	
	Elec(String name,int lv){
		super(name,"전기",lv);
	}

	@Override
	void attack() {
		System.out.println("백만볼트!");
	}
	

}
class Pika extends Elec{

	Pika(){
		this(5);
	}
	Pika(int lv){
		super("피카츄",lv);
	}
	@Override
	void hello() {
		System.out.println("피카피카");
	}

}
public class Test04 {

	public static void main(String[] args) {

		
		

		Pika p1=new Pika(); // 피카츄 Lv.5
		Pika p2=new Pika(11); // 피카츄 Lv.11
		p1.attack(); // 백만볼트!!!
		p1.hello(); // 피카피카



	}

}
/*
abstract class 포켓몬
	① 멤버변수(속성) 유추
	String name;
	(String type;)
	int lv;
	② 생성자 유추
	포켓몬()
		this(5);
	포켓몬(String name,String type,int lv)
		③ 생성자는 멤버변수 초기화하는 역할 !
		this.name=name; // "포켓몬"에서 결정 xxx
		this.type=type;
		this.lv=lv;
	abstract void attack();
	abstract void hello();
class 전기 extends 포켓몬
	전기(String name){
		this(name,5);
	}
	전기(String name,int lv){
		super(name,"전기",lv);
	}
	void attack(){
		syso("백만볼트");
	}
	abstract void hello();
class 피카츄 extends 전기
	피카츄(){
		this(5);
	}
	피카츄(int lv){
		super("피카츄",lv);
	}
	void hello(){
		syso("피카피카");
	}
class 라이츄 extends 전기
 */