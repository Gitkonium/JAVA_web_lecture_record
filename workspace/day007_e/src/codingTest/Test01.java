package codingTest;

import java.util.Random;

// https://school.programmers.co.kr/learn/courses/30/lessons/181930

// 주사위 게임 2

// 문제 설명
// 1부터 6까지 숫자가 적힌 주사위가 세 개 있습니다. 세 주사위를 굴렸을 때 나온 숫자를 각각 a, b, c라고 했을 때 얻는 점수는 다음과 같습니다.
// 세 숫자가 모두 다르다면 a + b + c 점을 얻습니다.
// 세 숫자 중 어느 두 숫자는 같고 나머지 다른 숫자는 다르다면 (a + b + c) × (a2 + b2 + c2 )점을 얻습니다.
// 세 숫자가 모두 같다면 (a + b + c) × (a2 + b2 + c2 ) × (a3 + b3 + c3 )점을 얻습니다.
// 세 정수 a, b, c가 매개변수로 주어질 때, 얻는 점수를 return 하는 solution 함수를 작성해 주세요.

// 제한사항
// a, b, c는 1이상 6이하의 정수입니다.

public class Test01 {

	public static void main(String[] args) {

		Random r = new Random();

		int a = r.nextInt(6) + 1;
		
		System.out.println(a);

		int b = r.nextInt(6) + 1;
		
		System.out.println(b);

		int c = r.nextInt(6) + 1;
		
		System.out.println(c);

		System.out.println(dice(a, b, c));

	}

	public static double dice(int a, int b, int c) {
		
		double result =0;
		
		if (a != b && a != c && b != c) {
			
			result = a + b + c;

		}
		else if((a == b && a != c) || (a == c && a != b) || (b == c && b != a)) {
			
			result = (a + b + c) * (a * a + b * b + c * c);
			
		}
		else if(a == b && b ==c) {
			
			result = (a + b + c) * (a * a + b * b + c * c) * (a * a * a + b * b * b + c * c * c);
			
		}
		
		return result;
	}

}
