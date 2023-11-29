package class06;

class Student{
	String name;
	int score;
	/*
	// 엥? 생성자 없는데요?
	// JAVA가 기본 생성자(디폴트 생성자)를 기본 제공해줌
	Student() {
		System.out.println("Student 클래스의 기본 생성자");
		// 짜잔
		// JAVA가 기본제공해주던 애를 제가 직접 여러분들께 보여줬어용 ㅎㅎ
		
		name="무명"; // 멤버변수 초기화를 강제
		score=0;
	}
	*/
	Student(String n){ // 생성자 오버로딩
		name=n;
		score=0;
		System.out.println("하나 더 만든 생성자");
	}
	Student(String n,int s){
		name=n;
		score=s;
		System.out.println("생성자로 멤버변수 초기화 강제");
	}
	void printInfo() {
		System.out.println(name+" 학생은 "+score+"점입니다.");
	}
}
public class Test01 {

	public static void main(String[] args) {
		
		Student stu1=new Student("티모",13);
		stu1.printInfo();
		// 현재는 멤버변수 초기화를 강제하지않음
		// Student() 인자가 없는 생성자 기본 생성자
		
		Student stu2=new Student("가렌");
		stu2.printInfo();
		
		
		
		
	}

}
