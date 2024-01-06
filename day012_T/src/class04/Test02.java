package class04;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {



		int num;
		try {
			int a=10,b=0;
			System.out.println(a/b);

			System.out.println("-----");

			int[] datas=new int[3];
			System.out.println(datas[2]);

			System.out.println("-----");

			Scanner sc=new Scanner(System.in);
			System.out.print("정수입력 >> ");
			num=sc.nextInt();
			System.out.println("num= "+num);
		}catch(ArithmeticException e) {
			System.out.println("0으로는 나눌수없습니다!");
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("인덱스 범위초과로 출력 불가능합니다!");
		}catch(InputMismatchException e) {
			System.out.println("num을 100으로 초기화합니다...");
			num=100;
			System.out.println("num= "+num);
		}











	}

}
