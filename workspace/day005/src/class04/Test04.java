package class04;

import java.util.Random;
import java.util.Scanner;

public class Test04 {

	public static void funcA() {
		// 정수를 3개 랜덤으로 생성합니다.
		Random rand=new Random();
		int[] datas=new int[3];
		for(int i=0;i<datas.length;i++) {
			datas[i]=rand.nextInt(6)+1;
			// 랜덤 범위는 1~6
		}
		// 3개의 랜덤 정수를 모두 Console에 출력해주세요.
		for(int data:datas) {
			System.out.print(data+" ");
		}
		System.out.println();
		// 그리고 가장 큰 랜덤 정수를 Console에 출력해주세요.
		int maxIndex=0;
		for(int i=1;i<datas.length;i++) {
			if(datas[i]>datas[maxIndex]) {
				maxIndex=i;
			}
		}
		System.out.println("최대값은 "+datas[maxIndex]);
	}
	public static int funcB() {
		// 사용자에게 정수 2개를 입력받습니다. ▶ Scanner, Console에서 입력
		Scanner sc=new Scanner(System.in);
		int[] datas=new int[2];
		for(int i=0;i<datas.length;i++) {
			System.out.print((i+1)+"번 정수 입력 >> ");
			int num=sc.nextInt();
			datas[i]=num;
		}
		// 입력받은 2개의 정수 합을 main()함수로 반환해주세요.
		int total=0;
		for(int data:datas) {
			total+=data;
		}
		return total;
	}
	public static int funcC(int a,int b) {
		// 두개의 정수중 더 작은 값을 Console에 출력해주세요.
		int min=a<b? a:b;
		System.out.println("min= "+min);
		// 이후 main()함수로 더 작은 값을 반환해주세요. ▶ output
		return min;
	}
	public static void main(String[] args) {
		
		funcA();
		
		System.out.println(funcB());
		int num=funcB();
		System.out.println("num= "+num);
		
		Scanner sc=new Scanner(System.in);
		System.out.print("첫번째 정수 입력 >> ");
		int a=sc.nextInt();
		System.out.print("두번째 정수 입력 >> ");
		int b=sc.nextInt();
		System.out.println(funcC(a,b));
		num=funcC(a,b);
		System.out.println("num= "+num);
		
	}

}
