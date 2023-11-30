package day001;

public class Test04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//연산자
		//산술연산자(+,-,*,/)
		//대입연산자(=)
		int a = 10;
		int b = 3;
		System.out.println(a+b);
		System.out.println(a-b);
		System.out.println(a*b);
		System.out.println(a/b); //몫 연산자, int연산자
		System.out.println(a%b); //나머지 연산자, MOD연산자
		
		a++;//후위 증
		++a;//전위 증
		b--;//후위 감
		--b;//전위 감
		
		//컴퓨터는 절대로 2가지 이상의 일을 동시에 못 함
		//다만 여러일을 빠르게 처리하는 것 일 뿐
		int c = a+b;
		//연산자 충돌시 "우선순위"를 따짐(기사에 나옴)
		//대입연산자는 우선순위가 낮음
		System.out.println("c= "+c);
	}

}
