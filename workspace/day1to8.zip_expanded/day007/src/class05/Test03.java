package class05;

class Student{
	
	String name;
	int score;
	// JAVA가 기본 생성자를 기본 제공해줌
	// 생성자 함수는 메모리를 반환하기 때문에 반환타입을 지정하지 않는다.
	Student() {
		
	}
	
	void printInfo() {
		
		System.out.println(name + "학생은 " + score + "점 입니다." );
		
	}
	
}

public class Test03 {

	public static void main(String[] args) {
		
		Student stu1 = new Student();
		
		stu1.printInfo();
		

	}

}
