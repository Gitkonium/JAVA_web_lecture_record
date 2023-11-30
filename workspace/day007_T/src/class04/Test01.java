package class04;

// 자료형에 대하여 ...
// Q. 학생 3명의 중간고사 점수 저장하고싶어요...
// Q. 상품 5개의 상품명을 저장하고싶어요...
// Q. 수학문제 x,y 변수를 선언하고싶어요...
// Q. 학생 1명의 이름,나이,점수를 저장하고싶어요...
//     → 배열,원시타입을 사용할수없음!
// A. "학생"이라는 자료형이 필요한 순간이다!

// Class 선언(정의)하는 방법
class Student{ // "학생"이라는 자료형 정의(선언) 완료
	// "학생"이라는 자료형은
	//    이름,나이,점수를 가지고있음
	String name;
	int age;
	int score;
	void printInfo() {
		System.out.println("printInfo()에서 출력중입니다.");
		System.out.println(name); // scope가 틀리지않았기때문에 사용가능
		System.out.println(age);
		System.out.println(score);
	}
}

public class Test01 {

	public static void main(String[] args) {
		
		/*
		int[] stuDatas=new int[3];
		String[] proNameDatas=new String[5];
		double x,y;
		Student stu; // "학생"이라는 자료형이 필요함
		Student[] stuDatas=new Student[3]; // "학생배열"
		// 학생 ===>> "클래스(Class)"라고 부르는 개념
		*/
		
		// "학생"이라는 자료형인 변수를 생성해보자!
		int i=10;
		double d=3.14;
		int[] datas=new int[3];
		datas[0]=0;
		Student student=new Student();
		student.name="홍길동";
		// 멤버변수접근 연산자
		// 멤버접근 연산자
		student.age=20;
		student.score=100;
		
		System.out.println(student);
		System.out.println(student.name);
		System.out.println(student.age);
		System.out.println(student.score);
		student.printInfo();
		
		Student teemo=new Student();
		teemo.name="티모";
		teemo.age=16;
		teemo.score=71;
		teemo.printInfo();
		
		
		
		
		
		
	}

}
