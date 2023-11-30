package class05;

//문제 1 (해당 문제는 Scanner를 사용하지않습니다.)
//사람 클래스가 있습니다.
//사람은 반드시 이름(문자열)이 있습니다.
//나이를 별도로 알려주지않는 경우 자동으로 20살 설정됩니다.
//사람 객체를 2명 생성해주세요.
//사람객체명.hello(); 하면
//   "ㅇㅇ은 ㅇ살입니다."라고 출력됩니다.

class Person1{
	
	String name;
	
	int age;
	
	Person1(String n, int a){
		
		name = n;
		
		age = a;
		
	}
	
	void hello(){
		
		System.out.println(name + "은 " + age + "살 입니다.");
		
	}
	
}

public class Test04 {

	public static void main(String[] args) {
		
		String n = "아무개";
		
		int a = 20;
		
		Person1 p1 = new Person1(n,a);
		p1.age = 50;
		p1.hello();
		
		Person1 p2 = new Person1(n,a);
		p2.name = "강상기";
		p2.hello();
		
	}

}
