package class03;

public class Test01 {

	//  input O output X
	// int타입의 인자가 1개있는 함수다~~
	// JAVA의 모든 타입이 전부 인자로 사용가능함
	// 인자 개수 여러개 가능함
	public static void plus(int num) {
						// 인자로 호출했을때에 사용한 "값"을 받음
						// main()함수에게 있던 num의 값이다 라는 사실을 모름!
						// main()함수에게서 100이라는 "값"을 받았다~~만 앎!
						// 값에 의한 호출(call by value)
		num+=10;
		System.out.println("최종 num= "+num);
	}
	
	public static void funcA(int a,int b) {
		int tmp=10;
		tmp=a;
		a=b;
		b=tmp;
		System.out.println("funcA()");
		System.out.println("a= "+a);
		System.out.println("b= "+b);
		System.out.println("tmp= "+tmp);
	}
	
	public static void main(String[] args) {
		
		plus(2);
		plus(-5);
		plus(0);
		
		// 개발도구(이클립스)를 활용해서 서로 다른 변수임을 확인
		// 이름이 우연히 같을뿐, 서로 다른 변수!
		// {} 블록 영역(scope)이 서로 다름!!!
		int num=100;
		plus(num);
		System.out.println("메인함수의 num= "+num);
		
		
		int a=1,b=2,tmp=3;
		funcA(a,b);
		System.out.println("main()");
		System.out.println("a= "+a);
		System.out.println("b= "+b);
		System.out.println("tmp= "+tmp);
		
		
		
		
		
		
		
		
		
	}

}
