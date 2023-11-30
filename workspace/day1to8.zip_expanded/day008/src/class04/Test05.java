package class04;

class Circle2 {
	String name;
	int radius;
	// 불변하는 변수 == 상수
	// 모든 원이라면 전부다 3.14를 가짐
	// 공유자원이라 부름
	// 객체와 무관하게 3.14를 유지
	static final double PI = 3.14;
	double area;

	Circle2(int radius) {
		this("원", radius);
	}

	Circle2(String name) {
		this(name, 1);
	}

	Circle2(String name, int radius) {
		this.name = name;
		this.radius = radius;
		this.area = this.radius * this.radius * Circle2.PI;
	}

	void printInfo() {
		System.out.println(this.name + "는(은) 넓이가 " + this.area + "입니다.");
	}
}

public class Test05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
