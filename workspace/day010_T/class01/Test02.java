package class01;

abstract class Shape{ // [추상]
	String name;
	double area;
	Shape(String name){ // name 속성 강제
		this.name=name;
		this.area=0.0;
	}
	abstract void printInfo(); // 추상메서드
	// ▶ 얘 좀 오버라이딩 해줄래?
	// ▶ 오버라이딩을 "강제"
	// ▶ 호출될일이 없으므로 {}메서드바디가 없음
	/*
	void printInfo() {
		System.out.println(this.name+"은(는) 넓이가 "+this.area+"입니다.");
	}
	12번 라인은 호출 불가능 !
	Shape 타입의 객체가 .printInfo(); 해야하는데,
	Shape 타입의 객체를 객체화 할 수 없기 때문 !!!
	*/
}
class Circle extends Shape{
	int radius;
	final static double PI=3.14; // 공유자원 : 모든 객체에게 공통적으로 적용
	Circle(){
		this("원");
	}
	Circle(String name){
		this(name,1);
	}
	Circle(String name,int radius){
		super(name);
		this.radius=radius;
		this.area=this.radius*this.radius*Circle.PI;
	}
	@Override
	void printInfo() {
		System.out.println("반지름 "+this.radius);
	}
}
class Rect extends Shape{
	int x;
	int y;
	Rect(){
		this("사각형");
	}
	Rect(String name){
		this(name,1,1);
	}
	Rect(String name,int x,int y){
		super(name);
		this.x=x;
		this.y=y;
		this.area=this.x*this.y;
	}
	@Override
	void printInfo() {
		System.out.println("가로 "+this.x+"  세로 "+this.y);
	}
}

public class Test02 {

	public static void main(String[] args) {
		
		/*
		Shape s=new Shape("모양");
		추상 클래스로는 객체화 불가능 !!!!!
		*/
		
		Shape[] datas=new Shape[3];
		datas[0]=new Circle();
		datas[1]=new Rect();
		
		Circle c=new Circle("도넛");
		datas[2]=c;
		
		for(Shape data:datas) {
			data.printInfo();
			// 동적바인딩
			//  : 가장 마지막에 재정의한 메서드가 자동으로 호출되는 현상
			// 다형성 실현
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
