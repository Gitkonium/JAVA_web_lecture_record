package class04;

//문제 1
//ColorPoint 색깔점 클래스가 있습니다.
//new ColorPoint(); // 검정(0,0)
//new ColorPoint(1,2); // 검정(1,2)
//new ColorPoint("분홍"); // 분홍(0,0)
//new ColorPoint("빨강",3,5); // 빨강(3,5)

//색깔점객체명.printInfo();
//   검정색 점은 (0,0)에 있습니다.

class ColorPoint{
	
	String colorS;
	
	int colorI1;
	
	int colorI2;
	
	ColorPoint(){
		
		this(0,0);
		
	}
	
	ColorPoint(String colorS){
		
		this(colorS, 0,0);
		
	}
	
	ColorPoint(int colorI1, int colorI2){
		
		this("검정", colorI1, colorI2);
		
	}
	
	ColorPoint(String colorS, int colorI1, int colorI2){
		
		this.colorS = colorS;
		
		this.colorI1 =colorI1;
		
		this.colorI2 =colorI2;
		
	}
	
	void printInfo() {
		
		System.out.println(this.colorS + "점은" + "(" + this.colorI1 + "," + this.colorI2 + ")에 있습니다.");
		
	}

}

public class Test03 {

	public static void main(String[] args) {
		
		ColorPoint c1 = new ColorPoint();
		
		ColorPoint c2 = new ColorPoint(1,2);
		
		ColorPoint c3 = new ColorPoint("분홍");
		
		ColorPoint c4 = new ColorPoint("빨강",3,5);
		
		c1.printInfo();
		
		c2.printInfo();
		
		c3.printInfo();
		
		c4.printInfo();
		
		ColorPoint c5 = new ColorPoint("빨강",3,5);
		
		

	}

}
