package class04;

import java.util.Random;

public class Test02 {

	public static void funcB(int a, int b) {
		// 둘의 합을 Console에 출력	
		int result=a+b;
		System.out.println(a+" + "+b+" = "+result);
	}
	
	public static double funcC() {
		// 랜덤정수 3개(랜덤 범위 1~10)를 생성하고
		Random rand=new Random();
		int[] datas=new int[3];
		for(int i=0;i<datas.length;i++) {
			datas[i]=rand.nextInt(10)+1;
		}
		// 생성된 3개의 정수 평균값(xx.xxxxxx의 형태)을
		int total=0;
		for(int data:datas) {
			total+=data;
		}
		System.out.println("total= "+total);
		double avg=total*1.0/datas.length;
		System.out.println("avg= "+avg);
		// 반환
		return avg;
	}
	
	public static void funcD(int a,int b) {
		// 둘중 더 큰 정수를 Console에 출력하는 함수입니다. ▶ output
		// 단, 둘의 크기가 동일하면 그냥 그 값을 출력합니다.
		int max = a>b? a:b;
		System.out.println(max);
	}
	
	public static void main(String[] args) {
		
		funcB(10,20);
		funcB(11,3);
		funcB(-1,0);
		
		System.out.println(funcC());
		double avg=funcC();
		System.out.println(avg);
		
		funcD(1,2);
		funcD(2,1);
		funcD(1,1);
		
	}

}
