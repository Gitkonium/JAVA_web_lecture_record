package view;

import java.util.Scanner;

// VIEW 추상클래스는 객체를 생성하려는 목표 xxx
// VIEW류의 클래스들을 정의하려는 목표 O
// § 메서드를 강제로 정의(오버라이딩 강제)하고싶다면, "인터페이스"
// § sc라는 '멤버변수'를 가져야한다는것을 정의하고싶었기에 "추상클래스"
public abstract class VIEW {
	protected Scanner sc; // 나와 내 자식까지 사용가능한 접근제어자 범위
	public VIEW() {
		sc=new Scanner(System.in);
	}
}
