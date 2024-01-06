package class04;

public class Test01 {

	// input X output O
	// JAVA에서는 output 모든 타입이 가능하지만,
	//  단 1개만 반환할수있음!
	public static int funcA() {
		System.out.println("funcA()는 5를 반환하는 함수입니다.");
		return 5; // 즉시 해당 함수 종료
	}
	
	public static void main(String[] args) {
		
		System.out.println( funcA() );
		// Run → 13번 → 15번에는 수행해야하는 함수가 2개임
		// → funcA() → println()
		// → 8번..11번 → 15번 → 20번
		
		int num=funcA();
		System.out.println("funcA()의 output이 저장된 num의 값은 "+num);
		
	}

}
