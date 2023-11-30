package day001;

public class Test05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num1 = 12;
		int num2 = 32;
		int num3 = ++num2 / num1--;
		
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		
		/**디버깅표 풀이
		 * num1     num2     num2/num1     num3
		 * =====================================
		 *  12       32
		 *           33 
		 *   11        
		 *                      3
		 * 									3					
		 **/
		
		/**디버깅표 정답
		 * num1     num2     num2/num1     num3
		 * =====================================
		 *  12       32
		 *           33 		2			2
		 *  11        					
		 **/
		
	}

}
