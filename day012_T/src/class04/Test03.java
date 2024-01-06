package class04;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.print("정수입력 >> ");
			int num;
			try {
				num=sc.nextInt();
			}catch(InputMismatchException e) {
				sc.nextLine(); // 버퍼 공간에 있는 잘못 입력된 값을 제거하는 역할
				System.out.println("정수를 입력해주세요!");
				continue;
			}
			if(1<=num && num<=10) {
				System.out.println(num+"을(를) 입력했습니다! :D");
				break;
			}
			System.out.println("1~10사이로 입력해주세요!");
		}



		System.out.println("================================");

		ArrayList<Integer> datas=new ArrayList<Integer>();
		datas.add(10);
		datas.add(1);
		datas.add(2);
		datas.add(0);
		datas.add(-2);
		System.out.println(datas);

		System.out.print("정수입력 >> ");
		int num;
		int result;
		try {
			num=sc.nextInt();
			
			result=100/datas.get(num-1);
			
			
			
		}catch(IndexOutOfBoundsException e) {
			System.out.println("해당 인덱스 요소는 없습니다...");
			return;
		}catch(ArithmeticException e) {
			System.out.println("0으로는 나눌수없습니다.");
			return;
		}catch(InputMismatchException e) {
			System.out.println("정수를 입력하셔야합니다...");
			return;
		}
		
		System.out.println(100+"/"+datas.get(num-1)+"="+result);






	}
}
