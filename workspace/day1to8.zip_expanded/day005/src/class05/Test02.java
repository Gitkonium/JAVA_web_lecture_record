package class05;

import java.util.Random;
import java.util.Scanner;

public class Test02 
{
	
//	문제1) funcA() 함수가 있습니다.
//	정수를 3개 랜덤으로 생성합니다.
//	랜덤 범위는 1~6
//	3개의 랜덤 정수를 모두 Console에 출력해주세요.
//	그리고 가장 큰 랜덤 정수를 Console에 출력해주세요.

	// 리턴 값이 없는 funcA라는 이름의 함수
	public static void funcA() 
	{
		
		// 랜덤 함수 호출
		Random r = new Random();
		
		// 배열을 선언
		int[] datas = new int[3];
		
		// 배열에 랜덤함수 넣기
		for(int i=0;i<3;i++) 
		{
			
			datas[i] = r.nextInt(6) + 1;
			
		}
		
		// 랜덤 함수를 콘솔에 출력
		for(int data : datas) 
		{
			
			System.out.println(data);
			
		}
		
		// 가장 큰 랜덤 함수 출력
		// 0번 인덱스를 가장 큰 값이라고 가정
		int maxIndex=0;

		// 1번부터 마지막 인덱스까지 반복  
		for(int i=1;i<datas.length;i++)
		{

			//i번 값이 가정 값 보다 크다면  
			if(datas[i] > datas[maxIndex])  	
			{

				//i번 인덱스를 저장
				maxIndex=i;

			}

		}
		
		//출력
		System.out.println("최대값은 " + datas[maxIndex] + "이다.");  
		
	}
	
//	문제2) funcB() 함수가 있습니다.
//	사용자에게 정수 2개를 입력받습니다.
//	입력받은 2개의 정수 합을 main()함수로 반환해주세요.
	
//  output이 없으면 main() 입장에서 호출만 가능하고
//  output이 있으면 main() 입장에서 출력 저장 모두 가능하다.
	
	public static int funcB() 
	{
		
		Scanner sc = new Scanner(System.in);
		
		int[] datas = new int[2];
		
		for(int i=0;i<datas.length;i++) 
		{
			
			System.out.println("입력>>");
			datas[i] = sc.nextInt();
		}
		
		int total = 0;
		
		for(int data : datas) 
		{
			
			total += data;
			
		}
		
		return total;

	}
	

//	문제3) funcC() 함수가 있습니다.
//	main()함수에서 사용자에게 입력받은 2개의 정수들을
//	매개변수로 받아와서
//	두개의 정수중 더 작은 값을 Console에 출력해주세요.
//	이후 main()함수로 더 작은 값을 반환해주세요.
	
	public static int funcC(int a, int b) 
	{
		
		int smaller = a > b ? b : a;
		
		System.out.println(smaller);
		
		return smaller;
		
	}
	

	public static void main(String[] args) 
	{
		
		
		funcA();
		
		System.out.println(funcB());
		
		funcC(100,2000);
		
	}

}
