package class04;

// 자료형에 대하여...
// Q. 학생 3명의 중간고사 점수 저장하고 싶어요...
// Q. 물건 5개의 상품명을 저장하고 싶어요...
// Q. 수학문제 x,y 변수를 선언하고 싶어요...
// Q. 학생 1명의 이름, 나이, 점수를 저장하고 싶어요...
//		-> 배열, 원시타입을 사용할 수 없음!
// 		A. "학생"이라는 자료형이 필요한 순간

// Class 선언 방법
class Student{// "학생"이라는 자료형 정의 완료
	
	// "학생"이라는 자료형은
	// 이름, 나이, 점수를 가지고 있음
	// 멤버변수
	String name;
	int age;
	int score;
	
	void printInfo() {
		
		System.out.println(name); // scope가 틀리지 않았기 때문에 사용가능
		
		System.out.println(age);
		
		System.out.println(score);
		
	}
	
}

public class Test01 {

	public static void main(String[] args) {
		
//		int[] stuDatas = new int[3];
//		
//		String[] proNameDatas = new String[3]; 
//		
//		double x,y;
//		
//		Student stu; //"학생"이라는 자료형이 필요함
//		
//		학생[]  stuDatas = new 학생[3]; // "학생배열"
//		
//		// 학생 ===>> "클래스"라고 부르는 개념
		
		// ㅎ학생이라는 자료형인 변수를 생성해보자
		
		int i = 10;
		double d = 3.14;
		int[] datas = new int[3];
		datas[0] = 0;
		Student student = new Student();
		student.name = "고라니";
		student.age = 10;
		student.score = 100;
		student.printInfo();
		

	}

}
