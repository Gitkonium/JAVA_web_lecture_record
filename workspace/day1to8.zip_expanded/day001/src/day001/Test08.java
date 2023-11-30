package day001;

public class Test08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 삼항(조건) 연산자
		
		// 조건식? T:F
		int result = 100 > 500 ? 3 : -3;
		System.out.println(result);
		
		int a = 10, b = 20;
		int c = b++ + ++a;
		int d = c-- * 2;
		int e = b / d < 5 ? 10:11;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		
		/**디버깅표 정답
		 * a     b     a + b     c     c*2     d     b/d<5     e
		 *========================================================================== 
		 * 10    20
		 * 11           31       
		 * 						 31
		 *       21                                                    
		 * 								62
		 * 										62
		 * 						 30
		 * 											  0<5
		 * 													   10
		 **/
		
	}

}
