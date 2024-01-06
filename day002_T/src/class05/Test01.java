package class05;

public class Test01 {

	public static void main(String[] args) {
		
		int a=3,b=1;
		for(int i=b;i<=a;i++) {
			System.out.print(i+" ");
		}
		
		System.out.println();

		for(int i=a; i>=b ;i--) {
			System.out.print(i+" ");
		}
		
		System.out.println();
		
		for(int i=1;i<=10;i++) {
			if(i%2==1) {
				System.out.print(i+" ");
			}
		}	
		
		System.out.println();
		
		
		int i=3;
		while(true) {
			// 종료조건
			
			
			i+=2;
			
			
			if(i>1000) {
				break;
			}
			System.out.print(i+ " ");
			
			
		}
	
		
		
	}

}
