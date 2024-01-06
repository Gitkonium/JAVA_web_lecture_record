package class04;

class Point {
	int x;
	int y;
	Point(){
		this(0,0);
	}
	Point(int x){
		this(x,x);
	}
	Point(int x,int y){
		this.x=x;
		this.y=y;
	}
	void move(int x) {
		this.x+=x;
		this.y+=x;
	}
	void printInfo() {
		System.out.println("점이 ("+this.x+","+this.y+")에 있습니다.");
	}
}
class ColorPoint extends Point {
	String color;
	ColorPoint(){
		this(0,0);
	}
	ColorPoint(String color){
		this(color,0,0);
	}
	ColorPoint(int x,int y){
		this("검정",x,y);
	}
	ColorPoint(String color,int x,int y){
		super(x,y);
		this.color=color;
	}
	void printInfo() {
		System.out.println(this.color+"색 점이 ("+this.x+","+this.y+")에 있습니다.");
	} // 메서드 재정의 : 기존에 부모가 사용하던 메서드는 더이상 사용 x
}

public class Test01 {

	public static void main(String[] args) {

		ColorPoint cp1=new ColorPoint(); // 검정 0,0
		ColorPoint cp2=new ColorPoint("분홍"); // 분홍 0,0
		ColorPoint cp3=new ColorPoint("노랑",1,1); // 노랑 1,1
		
		cp1.printInfo();
		cp2.printInfo();
		
		cp2.move(1);
		cp2.printInfo();
		cp3.printInfo();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		






	}

}
