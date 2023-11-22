package class01;

public class Test01 {

	public static void main(String[] args) {

		// [문제]
		// 10,7,2가 저장된 변수가 3개 있습니다.
		// 세 변수 a,b,c의 총합을 출력해주세요.
		// "10,7,2의 총합은 19입니다."
		// 그리고
		// 세 변수의 평균값을 출력해주세요.
		// "10,7,2의 평균은 6.333333입니다."
		// 만약, 평균값이 5이상이라면
		// 평균이 높습니다!
		// 만약 평균값이 5미만이라면
		// 평균이 낮습니다...
		// 라고 출력해주세요!~~

		int a=10,b=7,c=2; // 변수 a,b,c를 선언/정의 해라.
		// '총합'을 선언,정의 => total
		// total은 0에서부터 차곡차곡 a,b,c를 더한것
		int total=0;
		total+=a;
		total+=b;
		total+=c; // 총합을 구하는 로직
		System.out.println(a+","+b+","+c+"의 총합은 "+total+"입니다."); // 총합 출력하기
		
		// avg 정의,선언
		// 자료형 변수명 = 값;
		int cnt=3;
		double avg = total*1.0/cnt; // float ? 상관없음
		// ★ 문제 원인 파악 및 해결 ★
		// 6.0이 나오는 이유? => 연산자 우선순위 때문임!!!!!
		// 이 문제를 해결하는 방법?
		// total값을 가장 먼저 double로 변환(형변환,캐스팅)
		// *1.0 하기
		System.out.println(a+","+b+","+c+"의 평균은 "+avg+"입니다."); // 평균 출력하기
		
		if(avg >= 5) { // 만약 ~라면, 조건을 만족한다면의 뉘앙스 ==> 조건문(if문)
			System.out.println("평균이 높습니다!");
		}
		else { // else if(avg<5)
			System.out.println("평균이 낮습니다...");
		}
		// else if 사용가능한 조건
		// [1] 두 사건이 동시에 일어날수있는가? x
		// [2] 두 조건문이 서로 관련되어있는가? o

	}

}
