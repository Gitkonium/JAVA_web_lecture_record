package class04;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {

		int a=10,b=1;
		System.out.println(a/b);

		System.out.println("-----");

		int[] datas=new int[3];
		System.out.println(datas[2]);

		System.out.println("-----");

		Scanner sc=new Scanner(System.in);
		System.out.print("정수입력 >> ");
		int num;
		try {

			num=sc.nextInt();
			System.out.println("로그 01");

		} catch(Exception e) {
			
			num=100;
			// 정수값이 아닌값이 입력되면,
			// 100으로 값 저장
			System.out.println("로그 02");
			
		}
		System.out.println(num);












	}

}
