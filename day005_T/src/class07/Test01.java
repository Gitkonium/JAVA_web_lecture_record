package class07;

public class Test01 {

	// 1번 함수
	// 정수 3개를 인자로 받아와서, ▶ input
	// 3개를 각각 +1씩 하고
	// 3개 정수의 총합을 Console에 출력하는 함수 ▶ output
	public static void printTotal(int a,int b,int c) {
		a++;
		b+=1;
		c=c+1;
		int total=a+b+c;
		System.out.println("funcA() 총합= "+total);
	}
	
	// 2번 함수
	// 정수배열 1개를 인자로 받아와서, ▶ input
	// 배열의 모든 요소를 각각 +1씩 하고
	// 배열의 모든 요소의 총합을 Console에 출력하는 함수 ▶ output
	public static void printTotal(int[] datas) {
		for(int i=0;i<datas.length;i++) {
			datas[i]++;
		}
		int total=0;
		for(int data:datas) {
			total+=data;
		}
		System.out.println("funcB() 총합= "+total);
	}
	
	public static void main(String[] args) {
		
		int a=10,b=20,c=30;
		printTotal(a,b,c); // 값에 의한 호출(call by value)
		// 변수 a,b,c에 대한 정보가 전달 xxx
		System.out.println("main()의 현재 a,b,c값을 출력");
		System.out.println("a= "+a);
		System.out.println("b= "+b);
		System.out.println("c= "+c);
		
		int[] numArr=new int[5];
		for(int i=0;i<numArr.length;i++) {
			numArr[i]=10;
		}
		// [ 10 10 10 10 10 ]
		printTotal(numArr); // 참조에 의한 호출(call by reference)
		// heap(힙) 메모리 영역의 주소값이 전달 O
		// 실제 메모리에 접근가능함!!!!!
		System.out.println("main()의 현재 numArr 상태를 출력");
		for(int num:numArr) {
			System.out.print(num+" ");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
