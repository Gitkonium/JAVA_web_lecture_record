package class03;

import java.util.Random;
import java.util.Scanner;

// int[] 학생점수데이터
// 최대 3명까지 저장가능

// 1. 추가
// 2. 목록출력
// 3. 검색
// 4. 변경
// 5. 삭제
// 0. 종료

// 유효성검사
// 사용자가 잘못 된 사용법으로 입력할 수 있기때문에

// 기능 추가(or 변경)
//	1등 출력 기능
//	목록 출력을 50점 이상 학생만 출력 가능하도록 변경
public class Test01 {

	// 샘플데이터 추가하는 함수
	public static void sample(int[] stuArr, int index) {

		Random r = new Random();

		stuArr[index] = r.nextInt(101);

		System.out.println();

		System.out.println((index + 1) + "번 학생의 점수는" + stuArr[index] + "점입니다.");

		System.out.println("추가 완료");

		System.out.println();

	}

	// 학생을 추가하는 함수
	public static void insertStu(int[] stuArr, int index, Scanner sc) {

		// 문구 출력
		System.out.println(" === 추가 === ");

		// 줄 바꿈
		System.out.println();

		int stuNum = 0;

		// 탈출할 때 까지 반복
		while (true) {

			// 입력 문구 출력
			System.out.println("추가할 학생 번호 입력>>");

			// 입력 값을 넣는 변수
			stuNum = sc.nextInt();

			// 등록가능 한 학생 수의 범위를 넘을 경우
			if (stuNum - 1 > index) {

				System.out.println("등록가능 한 학생 수의 범위를 넘었습니다.");

				System.out.println("다시 입력해주세요.");

				continue;

				// 이미 등록된 학생이면
			} else if (stuArr[stuNum - 1] != -2) {

				System.out.println("이미 등록된 학생입니다.");

				System.out.println("다시 입력해주세요.");

				continue;

			} else {

				break;

			}

		}

		// 탈출할 때 까지 반복
		while (true) {

			// 줄 바꿈
			System.out.println();

			// 입력 문구 출력
			System.out.println("점수를 입력>>");

			// 입력 값을 넣는 변수
			int stuScore = sc.nextInt();

			// 허용 범위의 점수가 아닐 경우
			if (stuScore < 0 || stuScore > 100) {

				System.out.println("등록가능 점수 범위를 넘었습니다.");

				System.out.println("다시 입력해주세요.");

				continue;

			} else {

				// 줄 바꿈
				System.out.println();

				// 정보 저장
				stuArr[stuNum - 1] = stuScore;

				// 등록된 정보 출력
				System.out.println(stuNum + "번 학생의" + stuScore + "점 입니다.");

				// 반복문 탈출
				break;

			}

		}

	}

	// 목록을 출력하는 함수
	public static void printStuArr(int[] stuArr, int index) {

		System.out.println(" === 목록 출력 === ");

		System.out.println();

		for (int i = 0; i < index; i++) {

			if (stuArr[i] == -1) {

				continue;

			}

			if (stuArr[i] >= 50) {

				System.out.println((i + 1) + "번 학생은  " + stuArr[i] + "점 입니다.");

			}

		}

	}

	// 학생을 검색하는 기능
	public static void searchStu(int[] stuArr, int index, Scanner sc) {

		System.out.println(" === 검색 === ");

		System.out.println();

		// 입력 값을 넣는 변수
		int stuNum = 0;

		while (true) {

			// 줄 바꿈
			System.out.println();

			// 입력 문구 출력
			System.out.print("검색할 학생 번호 입력>>");

			// 입력한 값을 변수에 넣기
			stuNum = sc.nextInt();

			// 입력 값이 0보다 작거나 존재하는 인덱스 값을 넘으면
			if (stuNum < 1 || index < stuNum || stuArr[stuNum - 1] == -1) {

				// 문구 출력
				System.out.println("해당 번호를 가진 학생은 존재하지 않습니다.");

				// 문구 출력
				System.out.println("확인 후 다시 이용해주세요...");

			}
			// 입력 값이 허용범위 안이면
			else {

				// 문구 출력
				System.out.println(stuNum + "번 학생은" + stuArr[stuNum - 1] + "점 입니다.");

				// 문구 출력
				System.out.println();

				break;

			}

		}

	}

	// 학생 정보를 변경하는 함수
	public static void modifyStu(int[] stuArr, Scanner sc) {

		System.out.println(" === 변경 === ");

		// 줄 바꿈
		System.out.println();

		// 입력 문구 출력
		System.out.print("변경할 학생 번호 입력>>");

		// 입력한 값을 변수에 넣기
		int stuNum = sc.nextInt();

		// 줄 바꿈
		System.out.println();

		// 입력 문구 출력
		System.out.print("변경할 점수 입력>>");

		// 입력한 값을 변수에 넣기
		int stuScore = sc.nextInt();

		stuArr[stuNum - 1] = stuScore;

		System.out.println(stuNum + "번 학생의 점수는" + stuScore + "점 입니다.");

	}

	// 학생 정보를 삭제하는 함수
	public static void deleteStu(int[] stuArr, Scanner sc) {

		System.out.println(" === 삭제 === ");

		// 줄 바꿈
		System.out.println();

		// 입력 문구 출력
		System.out.print("삭제할 학생 번호 입력>>");

		// 입력한 값을 변수에 넣기
		int stuNum = sc.nextInt();

		stuArr[stuNum - 1] = -1;

		System.out.println(stuNum + "번 학생이 삭제되었습니다.");

	}

	// 1위인 학생만을 출력하는 함수
	public static void firstPrizeStu(int[] stuArr, int index, Scanner sc) {

		System.out.println(" === 1등 출력 === ");

		// 0번 인덱스를 가장 큰 값이라고 가정
		int maxIndex = 0;

		// 1번부터 마지막 인덱스까지 반복
		for (int i = 1; i < index; i++) {

			// i번 값이 가정 값 보다 크다면
			if (stuArr[i] > stuArr[maxIndex]) {

				// i번 인덱스를 저장
				maxIndex = i;

			}

		}

		System.out.println();

		System.out.println((maxIndex + 1) + "번 학생이 " + stuArr[maxIndex] + "으로 1등입니다.");

		System.out.println();

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 학생 명부 배열 선언
		int[] stuArr = new int[3];

		// 학생 명수
		int index = 0;

		// 선 함수 수행
		// 후 연산자 처리 ++
		// sample(stuArr, index++);

		while (true) {

			System.out.println(" === 학생부 프로그램 === ");

			System.out.println(" 1. 추가 ");

			System.out.println(" 2. 목록 출력 ");

			System.out.println(" 3. 검색 ");

			System.out.println(" 4. 변경 ");

			System.out.println(" 5. 삭제 ");

			System.out.println(" 6. 1등 출력 ");

			System.out.println(" 0. 종료 ");

			System.out.println(" =================== ");

			System.out.println("입력 >> ");

			int action = sc.nextInt();

			System.out.println();

			// 종료
			if (action == 0) {

				System.out.println();

				System.out.println("프로그램을 종료합니다.");

				System.out.println();

				break;

			} else if (action == 1) { // 학생 추가

				insertStu(stuArr, index++, sc);

			} else if (action == 2) { // 학생 목록 출력

				printStuArr(stuArr, index);

			} else if (action == 3) { // 학생 검색

				searchStu(stuArr, index, sc);

			} else if (action == 4) { // 학생 정보 변경

				modifyStu(stuArr, sc);

			} else if (action == 5) { // 학생 정보 삭제

				deleteStu(stuArr, sc);
				
				index --;

			} else if (action == 6) { // 1등 학생 출력

				firstPrizeStu(stuArr, index, sc);

			} else {

				System.out.println("존재하지 않는 기능입니다.");
				System.out.println("다시 입력해주세요.");
				System.out.println();

				continue;

			}

		}

	}

}
