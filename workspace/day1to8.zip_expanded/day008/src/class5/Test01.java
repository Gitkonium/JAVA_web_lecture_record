package class5;

import java.util.Random;
import java.util.Scanner;

//[ 문 제 ]
//포켓몬 클래스가 있습니다.
//이름과 레벨(int)과 경험치(int)가 있습니다.
//시스템 설명) 경험치가 100이 되면 경험치 0으로 변경되고
//   레벨이 1오릅니다.
// ex) 경험치가 10 ---+100-->> 110 -> 10
//            레벨++
//   경험치 100당 레벨 1
//포켓몬을 만들때에는,,,
//포켓몬 피카츄1=new 포켓몬("피카츄");
//   => 피카츄 Lv.5 [0/100]
//포켓몬 피카츄2=new 포켓몬("피카츄",10);
//   => 피카츄 Lv.10 [0/100]
//피카츄1.printInfo();
//   => 피카츄 Lv.5 [0/100] 입니다.
//------------------------------------------------------------------
//피카츄1.game();
//   50%의 확률로 게임을 성공할수있습니다.
//   게임 실패시 아무일도없습니다... 출력
//   게임 성공시 경험치를 획득! 출력
//      경험치는 50~500까지 랜덤하게 얻을수있습니다.
//      경험치 획득으로 인해 레벨이 올라간다면
//         피카츄, 레벨업 ! 을 출력해주세요.

class Pokemon {

	// 이름 변수
	String name;

	// 정수인 레벨 변수
	int level;

	// 정수인 경험치 변수
	int exp;

	// 랜덤 함수를 호출
	static Random r = new Random();

	// 매개변수를 2개 받는 생성자
	Pokemon(String name, int level) {

		// 이름 저장
		this.name = name;

		// 레벨 저장
		this.level = level;

	}

	// 매개변수를 1개 받는 생성자
	Pokemon(String name) {

		// 매개변수를 2개 받는 생성자 활용
		this(name, 5);

	}

	// 정보를 출력하는 메서드
	void printInfo() {

		System.out.println(this.name + " Lv." + this.level + " [" + this.exp + "/100]");

	}

	// 레벨업 메소드
	void levelUp() {

		// 랜덤 함수는 0과1을 뱉는다.
		// 50% 확률
		int result = r.nextInt(2);

		// 만약 결과가 0이면 경험치를 얻지 못한다.
		if (result == 0) {

			// 문구 출력
			System.out.println("아무일도없습니다...");

		} else { // 0이 아니라면 경험치를 얻는다.

			// 경험치 추가
			// 50 ~ 500
			result = r.nextInt(451) + 50;

			// 문구 출력
			System.out.println(result + " 경험치 획득!");

			// 레벨업 횟수
			int levelUpCount = result / 100;

			// 레벨 업 후 남는 경험치량
			int leftExp = result - (levelUpCount * 100);

			for (int i = 0; i < levelUpCount; i++) {

				// 업한 레벨을 저장
				this.level += 1;

			}

			// 남는 경험치량 저장
			this.exp = leftExp;

			System.out.println(this.name + "의 레벨이 올랐습니다.");

			this.printInfo();

		}

	}

	// 경험치를 얻는 메서드
	void game() {

		this.levelUp();

	}

}

public class Test01 {

	public static void main(String[] args) {

		// Pokemon 데이터 타입을 받는 배열 선언
		Pokemon[] pokemon = new Pokemon[3];

		pokemon[0] = new Pokemon("달막화", 1);
		
		pokemon[1] = new Pokemon("셀러", 1);
		
		pokemon[2] = new Pokemon("잉어킹", 1);

		for (Pokemon p : pokemon) {

			p.game();

		}

	}

}
