package class04;

// 자료구조 : 데이터 관리를 용이하게 해보자!
//          다양한 자료형을 공부함
//          메모리 관리 용이 >> 배열
// 알고리즘 : 문제를 좋게 해결하는 과정을 생각해보자!
//          자료형과 관련된 로직을 공부함
//          효율성,속도가 빨라짐.성능이 좋아짐
// [배열과 관련된 알고리즘(로직)]
// 1. 최대값(최소값) 찾기 알고리즘
// 2. 탐색(검색) 알고리즘 : search / 일반 검색,최적화된 검색
//  탐색 알고리즘을 사용하려면
//  특히 최적화된 검색을 하려면
//   => 정렬을 반드시 선행해야만합니다!!!!!
// 3. 정렬 알고리즘 : 빠른 탐색(검색)을 위한 전제조건
// 4. 중복제거 알고리즘 : 랜덤값으로 배열을 저장한다면 중복이될수있음! >> 중복값이 안나오도록 코딩해주세요!
public class Test01 {

	public static void main(String[] args) {

		// 1. 최대값 찾기 알고리즘
		// 5개의 서로다른 정수 데이터를 저장한 배열이 존재합니다.
		// 가장 큰 값을 가진 index의 위치와
		// 그 값(가장 큰 값)을 출력해주세요!~~
		
		int[] datas=new int[5];
		datas[0]=2;
		datas[1]=3;
		datas[2]=1;
		datas[3]=5;
		datas[4]=4;
		
		System.out.print("[ ");
		for(int data:datas) {
			System.out.print(data+" ");
		}
		System.out.println("]");
		
		/////int max=datas[0];
		// max 현재 예상중인 가장 큰 값
		int maxIndex=0;
		// maxIndex max가 저장된 index 위치
		
		// O (권장) 비교를 [1] index부터 [4] index까지
		// 비교를 2번째 데이터부터 5번째 데이터까지
		// for문 !
		for(int i=1;i<datas.length;i++) {
			if(datas[i] > datas[maxIndex]) { // max==datas[maxIndex]
				datas[maxIndex]=datas[i];
				maxIndex=i;
			}
		}
		
		System.out.println("최대값은 "+datas[maxIndex]+"이고,");
		System.out.println("위치는 ["+maxIndex+"] 입니다.");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
