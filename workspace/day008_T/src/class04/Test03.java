package class04;

class ColorPoint {
	String color;
	int x;
	int y;
	ColorPoint(){
		this("검정",0,0);
	}
	ColorPoint(int x,int y){
		this("검정",x,y);
	}
	ColorPoint(String color){
		this(color,0,0);
	}
	ColorPoint(String color,int x,int y){
		this.color=color;
		this.x=x;
		this.y=y;
	}
	void printInfo() {
		System.out.println(this.color+"색 점은 ("+this.x+","+this.y+")에 있습니다.");
	}
	void changeColor(String color) {
		this.color=color;
	}
	void move(int x,int y) {
		this.x+=x;
		this.y+=y;
	}
}

public class Test03 {

	public static void main(String[] args) {
		ColorPoint cp=new ColorPoint("파랑",-10,-20);
		
		cp.changeColor("빨강");
		cp.move(1,2);
		
		
		
		
		
		
		
		
		
		
		
		cp.printInfo();
	}

}
