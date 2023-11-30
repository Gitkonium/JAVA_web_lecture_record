package class04;

class Point {
	
	int x;
	
	int y;
	
	Point(){
		
		this.x = 0;
		
		this.y = 0;
		
	}
	
	Point(int x){
		
		this(x,x);
		
	}
	
	// 인자가 가장 많은 생성자부터 작성
	Point(int x, int y){
		
		// 멤버면수 x = 매개변수 x;
		this.x = x;
		
		// 멤버면수 x = 매개변수 y;
		this.y = y;
		
		//  모든 멤버 변수 앞에는 반드시  this를 붙일것 ! 
		
	}
	
	void pritInfo() {
		
		System.out.println("점(" + this.x + "," + this.y + ") 입니다.");
		
	}
	
	
}

public class Test01 {

	public static void main(String[] args) {
		
		// 생성자 오버로딩
		
		// (0,0)
		Point point01 = new Point();
		
		// (10,10)
		Point point02 = new Point(10);
		
		// (1,2)
		Point point03 = new Point(1,2);
		
		point01.pritInfo();
		point02.pritInfo();
		point03.pritInfo();
		

	}

}
