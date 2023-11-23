package class01;

public class Test06 {
	
	public static void main(String[] args) {
		
		for(int a=0;a<5;a++) {
			for(int i=0;i<5;i++) {
				if(i<a) {
					System.out.print(" ");
				}
				else {
					System.out.print("*");
				}
			}
			System.out.println();
		}

	}

}
