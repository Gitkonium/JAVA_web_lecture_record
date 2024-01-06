package class03;

// 점과 색깔점
class Point {
	int x;
	int y;
	Point(){
		this(0,0);
		System.out.println("로그1");
	}
	Point(int x,int y){
		this.x=x;
		this.y=y;
		System.out.println("로그2");
	}
	void move(int x) {
		this.x+=x;
		this.y+=x;
	}
	void printInfo() {
		System.out.println("점 ("+this.x+","+this.y+")입니다.");
	}
}
class ColorPoint extends Point {
	String color;
	ColorPoint(String color){
		this(color,0,0);
		System.out.println("로그3");
	}
	ColorPoint(int x,int y){
		this("검정",x,y);
		System.out.println("로그4");
	}
	ColorPoint(String color,int x,int y){
		/*
		모든 자식 클래스의 생성자 가장 첫 줄에는
		부모 클래스의 기본 생성자가 자동 호출됩니다!!!
		
		생성자의 역할이 멤버변수 초기화인데,
		부모 클래스가 갖고있었던 멤버변수를 초기화하는 역할을
		부모 클래스의 생성자로 갖고있으니...호출할수밖에없다!
	    */
		super(); // 부모() == 부모 생성자 함수
		this.color=color;
		this.x=x;
		this.y=y;
		System.out.println("로그5");
	}
}
public class Test02 {

	public static void main(String[] args) {

		ColorPoint cp=new ColorPoint("분홍",1,2);
		cp.printInfo();
		cp.move(10);
		cp.printInfo();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
