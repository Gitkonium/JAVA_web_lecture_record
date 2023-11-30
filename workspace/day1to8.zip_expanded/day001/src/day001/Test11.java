package day001;

public class Test11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//문제풀이
		//"한글코딩" : 의사코딩, 스도우 코딩,.....
		//그냥 코딩을 작성하는데에는 반드시 한계가 존재함
		//"협업" << 다른 사람이 모르면 의미가 없음
		
		//1번
		//1:num을 정의해 주세요(1~100의 양의 정수)
		//2:num이 짝수일까?
		//	짝수라면 짝수입니다. 출력
		//	★ 선택사항, 만약 ~라면, ~일때, 특정 조건을 만족한다면... => 조건문
		//3:홀수라면 홀수일까?
		//	홀수면 홀수입니다. 출력
				
		int num = 50;
		
		if(num%2 == 0) 
		{
			
			System.out.println("짝수");
			
		}
		else
		{
			
			System.out.println("홀수");
			
		}
		
		// + boolean flag = num % 2 == 0 ? true : false
		// 플래그 변수 : 주로 T,F  확인지표가 되는 
				
		//2번
		//h=5 시(1~12)
		//m=30 분(0~59)
		//5시 30분의 1시간 20분전 시간은 4시 10분입니다.라고 출력해주세요.
		//만약 h=1,m=10이었다면
		//1시 10분의 1시간 20분전 시간은 11시 50분입니다. 라고 출력됩니다.
			
		int h = 5; 
		int m = 30;
		
		if(h == 1 && m == 10) 
		{
			
			System.out.println("1시 10분의 1시간 20분전 시간은 11시 50분입니다.");
			
		}
		else 
		{
			
			System.out.println("5시 30분의 1시간 20분전 시간은 4시 10분입니다.");
			
		}
		

	}

}
