package day001;

public class Test04 {

	public static void main(String[] args) {
		// 연산자
		// 산술연산자
		int a=10; // 대입 연산자
		int b=3;
		System.out.println(a+b);
		System.out.println(a-b);
		System.out.println(a*b);
		System.out.println(a/b); // 몫 연산자, INT 연산자
		System.out.println(a%b); // 나머지 연산자, MOD 연산자
		
		a++; // 증감 연산자
		++a; // 전위 증감 연산자
		b--; // 후위 증감 연산자
		--b;
		System.out.println(a);
		System.out.println(b);
		
		
		
		// 컴퓨터는 절대로 2가지 이상의 일을 동시에 못함
		// 다만 여러일을 빠르게 처리하는것뿐
		int c=a+b;
		// 연산자 충돌시 "우선순위"를 따짐(기사에 나옴)
		// 대입연산자는 우선순위가 낮음
		System.out.println("c= "+c);
		
		
		
		
	}

}
