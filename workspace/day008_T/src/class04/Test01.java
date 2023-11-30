package class04;

class Point {
	int x;
	int y;
	Point(){
		this(0,0); // 생성자보다 먼저 수행되는 코드는 존재할수없음 !
		System.out.println("   로그 1");
	}
	Point(int x){
		this(x,x); // this() == 생성자
		System.out.println("   로그 2");
	}
	Point(int x,int y){ // 인자가 가장 많은 생성자부터 작성
		this.x=x; // 멤버변수 x=매개변수 x;
		this.y=y;
		// 모든 멤버변수앞에는 반드시 this를 붙일것 ! ★
		System.out.println("   로그 3");
	}
	void printInfo() {
		System.out.println("점 ("+this.x+","+this.y+")입니다.");
	}
	void move(int x) {
		this.x+=x;
		this.y+=x;
	}
}

public class Test01 {

	public static void main(String[] args) {

		Point point01=new Point(); // (0,0)
		System.out.println("   로그 4");
		Point point02=new Point(10); // (10,10)
		System.out.println("   로그 5");
		Point point03=new Point(1,2); // (1,2)
		System.out.println("   로그 6");

		
		point01.move(10);
		// (0,0) -> (10,10)		
		
		point01.printInfo();
		point02.printInfo();
		point03.printInfo();

	}

}
