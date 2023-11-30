package class04;

//자료구조 : 데이터 관리를 용이하게 해보자!
//         다양한 자료형을 공부함
//         메모리 관리가 용이 >> 배열
//알고리즘 : 문제를 좋게 해결하는 과정을 생각해보자!
//         자료형과 관련된 로직을 공부함
//         효율성,속도 빨라짐
// [배열과 관련된 알고리즘(로직)]
// 1. 최대값(최소값) 찾기 알고리즘
// 2. 탐색(검색) 알고리즘 : search / 일반검색, 최적화된 검색
// 3. 정렬 알고리즘 : 빠른 탐색(검색)을 위한 전제조건
// 4. 중복제거 알고리즘 : 랜덤값으로 배열을 저장하면 중복이 될 수 있음 >> 중복 값이 안나오도록 코딩
public class Test01 
{

	public static void main(String[] args) 
	{
		
		// 1. 최대값 찾기 알고리즘
		// 5개의 서로 다른 정수 데이터를 저장한 배열이 존재합니다.
		// 가장 큰 값을 가진 index의 위치와 
		// 그 값(가장 큰 값)을 출력해주세요.

		//배열 선언
		int[] datas = new int[5];
		
		//데이터 넣기
		datas[0]=2;
		datas[1]=3;
		datas[2]=1;
		datas[3]=5;
		datas[4]=4;
				
		//하나씩 출력
		for(int data : datas) 
		{
			
			System.out.println(data);
			
		}

		//현재 가장 큰 값이라고 예상되는 값
//		int max = datas[0];
		
		//현재 가장 큰값이 들어있다고 생각되는 인덱스
		int maxIndex=0;
		
		//비교를 [1] index부터 [4]까지
		//비교를 2번째 데이터부터 5번째 데이터까지
		//for문!
		for(int i=1;i<datas.length;i++)
		{
			
			if(datas[i] > datas[maxIndex]) 
			{
				
				datas[maxIndex] = datas[i];
						
			    maxIndex=i;
				
			}
			
			System.out.println("최대값은 " + datas[maxIndex] + "이고, ");
			
			System.out.println("위치는 [" + maxIndex + "]이고, ");
			
		}
		
		
	}

}
