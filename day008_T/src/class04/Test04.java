package class04;

class Circle {
	String name;
	int radius;
	static final double PI=3.14; // 불변하는 변수 == 상수
			// 모---든 원이라면 전부다 3.14 값을 가짐
			// 공유자원
			// 객체와 무관하게
	double area;
	Circle(int radius){
		this("원",radius);
	}
	Circle(String name){
		this(name,1);
	}
	Circle(String name,int radius){
		this.name=name;
		this.radius=radius;
		this.area=this.radius*this.radius*Circle.PI;
										// 객체소속.멤버변수 xxx
										// 클래스소속.변수 O
	}
	void printInfo() {
		System.out.println(this.name+"는(은) 넓이가 "+this.area+"입니다.");
	}
	void changeRadius(int radius) {
		this.radius=radius;
		this.area=this.radius*this.radius*Circle.PI;
	}
}

public class Test04 {

	public static void main(String[] args) {

		Circle c=new Circle("거울");
		c.changeRadius(10);
		c.printInfo();
		
		
		
		
		
		
		
		
	}

}
