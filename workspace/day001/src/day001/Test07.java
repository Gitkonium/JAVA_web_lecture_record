package day001;

public class Test07 {
	public static void main(String[] args) {
		
		int a=10;
		int b=11;
		int c=11;
		
		// 비교 연산자
		// 질문 -> 컴퓨터가 답을 줌
		System.out.println(a>b);
		System.out.println(b<c);
		System.out.println(b>=c);
		System.out.println(a<=c);
		System.out.println(b==c);
		System.out.println(b!=c); // NOT 부정
		
		// AND OR NOT
		System.out.println("a가 b보다 크고, a가 c보다 작니?");
		// ~이고, ~이면서, ~하면서, 동시에, 그리고, ...
		System.out.println((a>c) && (a<c));
		System.out.println("a가 b보다 크거나, a가 c보다 작니?");
		// ~이거나, 혹은, 또는, ...
		System.out.println((a>b) || (a<c));
		System.out.println(!(a>b));
		
		
	}
}
