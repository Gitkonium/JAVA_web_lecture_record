package class01;

public class Test05 {

	public static void main(String[] args) {
		
		for(int a=0;a<5;a++) {
			for(int i=0;i<=a-1;i++) {
				System.out.print(" ");
			}
			for(int i=0;i<5-a;i++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}

}
