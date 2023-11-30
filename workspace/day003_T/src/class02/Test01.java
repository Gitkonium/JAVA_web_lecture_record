package class02;

// 배열
// 메모리

public class Test01 {

	public static void main(String[] args) {

		int stu1=80;
		int stu2=15;
		int stu3=50;
		System.out.println(stu1);
		System.out.println(stu3);
		// 초기화가(값 설정이) 되지않은 변수는
		//  출력 xxx


		// 배열이란?
		// 여러개의 변수를 깔끔하게 정리해서
		// 한 공간에 저장할수있도록하는 "자료형"
		//  1. 보다 더 많은 공간을 활용할수있음
		//  2. 데이터를 접근할때 보다 빠르게 접근가능

		int[] stuArr = new int[5];
		// new 연산자 ★
		// 개발자 전용 메모리 공간(Heap 메모리)에
		// 데이터를 생성해주세요!~~

		System.out.println(stuArr);

		stuArr[0]=80;
		stuArr[1]=15;
		stuArr[2]=50;
		stuArr[3]=50;
		stuArr[4]=50;
		// 인덱스(index)
		// 1번 인덱스에는 2번 학생의 정보가 있다.


// 배열의 길이만큼
// 배열의 요소 개수 만큼
// 배열의 크기만큼
// 배열의 length만큼
// 배열의 size만큼
		for(int i=0;i<stuArr.length;i++) {
			System.out.println((i+1)+"번 학생의 점수는 "+stuArr[i]+"점입니다.");
		}
		// ctrl C,V
		
		// 5,3 등의 상수를 직접 작성하는 것 == 하드코딩
		// 안좋은겁니다...!!













	}

}
