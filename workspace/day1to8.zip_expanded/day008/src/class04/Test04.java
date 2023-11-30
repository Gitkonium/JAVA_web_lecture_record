package class04;

//문제2
//Circle 원 클래스가 있습니다.
//new Circle(10); // 원 : 반지름 10 넓이 314.0
//new Circle("도넛"); // 도넛 : 반지름 1 넓이 3.14
//new Circle("피자",12); // 피자 : 반지름 12 넓이 452.16
//   HINT 모든 원들은 원주율(PI)이라는 3.14 값을 갖고있어용
//
//원객체명.printInfo();
//   원는(은) 넓이가 314.0입니다.
//   피자는(은) 넓이가 452.16입니다.

class Circle {

	// 종류
	String type;

	// 반지름
	int radius;

	Circle(int radius) {

		this("원",radius);
		
	}

	Circle(String type) {

		this(type,1);

	}

	Circle(String type, int radius) {

		this.type = type;

		this.radius = radius;

	}

	void printInfo() {

		System.out.println(this.type + "는(은) 넓이가 " + (this.radius*this.radius*3.14));

	}

}

public class Test04 {

	public static void main(String[] args) {

		Circle c1 = new Circle(10);
		Circle c2 = new Circle("도넛");
		Circle c3 = new Circle("피자", 12);

		c1.printInfo();
		c2.printInfo();
		c3.printInfo();

	}

}
