package class06;

public class Test01 
{

	// 1번 함수
	// 정수 3개 인자로 받아와서,-> 인풋
	// 3개를 각각 +1씩 하고
	// 3개 정수의 총합을 Console에 출력하는 함수-> output
	
	public static void funcA(int a, int b, int c) 
	{
		
		a++;
		b+=1;
		c=c+1;
		
		int total = a+b+c;
		
		System.out.println(total);
		
	}
	
	// 2번 함수	
	// 정수배열 1개를 인자로 받아와서 -> 인풋
	// 배열의 모든 요소를 각각 +1 하고
	// 배열의 모든 요소의 총합을 Console에 출력하는 함수 -> output
	public static void funcB(int[] datas) {
		
		for(int i=0;i<datas.length;i++) 
		{
			
			datas[i]++;
			
		}
		
		int total =0;
		
		for(int data : datas) 
		{
			
			total += data;
			
		}
		
		System.out.println(total);
		
	}
	
	
	
	public static void main(String[] args) 
	{
		
		int a=10,b=20,c=30;
		
		// 값에 의한 호출(call by value)
		// 변수 a,b,c에 대한 정보가 전달 xxxx
		funcA(a,b,c);
		
		System.out.println("main()의 현재 a,b,c,값을 출력");
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		
		int[] numArr = new int[5];
		
		for(int i=0;i<numArr.length;i++) 
		{
			
			numArr[i] = 10;
			
		}
		// 참조에 의한 호출
		// 힙 메모리의 주소 값 전달
		// 실제 메모리에 접근가능함
		funcB(numArr);
		for(int num : numArr) {
		
			System.out.print(num+" ");
			
		}

	}

}
