package class01;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//[문제]
		//10,7,2가 저장된 변수가 3개 있습니다.
		//세 변수 a,b,c의 총합을 출력해주세요.
		//"10,7,2의 총합은 19입니다."
		//그리고
		//세 변수의 평균값을 출력해주세요.
		//"10,7,2의 평균은 6.333333입니다."
		//만약, 평균이 5이상이라면
		//평균이 높습니다!
		//만약 평균값이 5미만이라면
		//평균이 낮습니다...
		//라고 출력해주세요!~~
		
		
		/**한글코딩
		 * 1:a에 10을 대입
		 * 2:b에 7을 대입
		 * 3:c에 2를 대입
		 * 4:a,b,c를 총합 도출
		 * 5:결과값 출력
		 * 6:a,b,c에 평균값 도출
		 * 7:5이상?
		 * 		평균이높습니다. 출력
		 * 8:5이하?
		 * 		평균이 낮습니다... 출력
		 **/
		
		//변수 정의 및 초기화
		int a = 10, b = 7, c = 2;
		
		//총합 도출
		int sum = a+b+c;
		
		/**중간값을 알기 위한 작성법
		 *int total = 0 
		 *total += a; 
		 *total += b;
		 *total += c;
		 **/
		
		//결과 값 출력
		System.out.println("10,7,2의 총합은"+ sum + "입니다.");
		
		//평균 도출
		//캐스팅을 하지 않았을 때 6.0이 나오는 이유는 sum이 정수로 인식되기 때문
		//해결 : sum을 double로 캐스팅
		double avg = sum*1.0 / 3;
		
		//결과 값 출력
		System.out.println(avg);
		
		//[1]두 사건이 동시성이 있는가
		//[2]두 시건이 관련성이 있는가 -> else if
		//평균이 5보다 클 경우
		if(avg > 5)
		{
			
			System.out.println("평균이 높습니다!");
			
		}
		//평균이 5보다 작을 경우
		else if(avg < 5) 
		{
			
			System.out.println("평균이 낮습니다...");
			
		}
		
	}

}
