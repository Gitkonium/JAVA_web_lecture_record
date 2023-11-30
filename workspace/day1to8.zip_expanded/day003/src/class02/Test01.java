package class02;

//배열
//메모리
public class Test01 
{

	public static void main(String[] args) 
	{
		
		int stu1=80;
		int stu2=15;
		int stu3=50;
		
		System.out.print(stu1);
		
		//초기화 되지 않은 변수는 출력이 불가능하다.
		//초기화란 값을 설정한다는 뜻
		System.out.print(stu3);
		
		//여러개의 변수를 깔끔하게 정리해서 저장할 수 있도록 하는 자료형이다.
		//보다 더 많은 공간을 활용할 수 있다.
		//데이터에 접근할 때 보다 빠르게 접근 가능하다.
		
		//new 연산자 ★
		//개발자 전용 메모리 공간()에 데이터를 생성해주세요
 		int[] stuArr = new int[5];
 		
 		stuArr[0]=80;
 		stuArr[1]=15;
 		stuArr[2]=50;
 		stuArr[3]=50;
 		stuArr[4]=50;
 		
 		//배열의 길이만큼
 		//요소의 갯수만큼
 		//length만큼
 		//size만큼
 		for(int i=0;i<stuArr.length;i++) 
 		{
 			
 			System.out.print((i+1)+"번 학생의 점수는" + stuArr[i] + "점입니다.");
 			
 		}
 		
 		//하드 코딩은 하면 안 좋은것
 		
	}

}
