package class02;

public class Test02 {

	public static void main(String[] args) {

		// 크기가 5인 배열선언
		int[] arr = new int[5];

		// 배열에 데이터 넣기
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 4;
		arr[4] = 5;

		// 찾고자 하는 값
		int key = 2;

		// 찾고자 하는 값의 인덱스 번호
		int keyIndex = -1;

		// 배열의 시작 인덱스
		int start = 0;

		// 배열의 마지막 인덱스
		int end = arr.length - 1;
		
		// 탈출 할 때 까지 도는 반복문
		while (start <= end) {
			
			// 중앙 인덱스를 설정
			int mid = (start + end) / 2;

			// 중앙 인덱스 값이 찾고자 하는 값이라면
			if (arr[mid] == key) {

				// 중앙 값 인덱스 저장
				keyIndex = mid;

				// 반복문 탈출
				break;

			}
			// 중앙 인덱스 값이 찾고자 하는 값보다 크다면
			else if (arr[mid] > key) {

				// 찾는 값이 왼쪽에 있다는 뜻이므로
				// 최대 인덱스를 중앙 인덱스의 왼쪽(-1) 인덱스로 잡는데
				end = mid - 1;

			}
			// 중앙 인덱스 값이 찾고자 하는 값보다 작다면
			else if (arr[mid] < key) {
				
				// 찾는 값이 오른쪽에 있다는 뜻이므로
				// 최대 인덱스를 중앙 인덱스의 오른쪽(+1) 인덱스로 잡는데
				start = mid + 1;

			}

		}
		
		if(keyIndex == -1) {
			
			System.out.println("찾는 값이 없습니다.");
			
		}
		else {
			
			System.out.println(arr[keyIndex]);	
			
		}

	}

}
