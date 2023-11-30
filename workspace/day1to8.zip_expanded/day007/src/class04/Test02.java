package class04;

// 클래스는 같은 패키지에 여러개 선언 xxx
class Point {
	int x;
	int y;

	void printInfo() {
		System.out.println("(" + x + "," + y + ")에 있는 점입니다.");
	}
}

public class Test02 {

	public static void main(String[] args) {

		Point p1 = new Point();
		p1.x = 0;
		p1.y = 0;
		p1.printInfo();

		Point p2 = new Point();
		p2.x = 2;
		p2.y = 3;
		p2.printInfo();

	}

}