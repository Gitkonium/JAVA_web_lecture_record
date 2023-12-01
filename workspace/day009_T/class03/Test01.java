package class03;

class A {
	int data01;
	int data02;
	int data03;
	void funcA() {
		System.out.println("메서드01");
	}
	void funcB() {
		System.out.println("메서드02");
	}
}
class B extends A {
	// 데이터 01~05 총 5개의 속성
	// 메서드 01~03 총 3개의 기능
	int data04;
	int data05;
	void funcC() {
		System.out.println("메서드03");
	}
}

public class Test01 {

	public static void main(String[] args) {
		
		A aaa=new A();
		B bbb=new B();
		
		aaa.funcB();
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		bbb.funcB();
		bbb.funcC();


		



















	}

}
