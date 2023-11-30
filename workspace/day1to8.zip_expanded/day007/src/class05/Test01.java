package class05;

//문제) 포켓몬 클래스가 있습니다.
//포켓몬 객체를 2개 만들어주세요.
//포켓몬은 레벨(정수),경험치(정수),이름(문자열)을 갖고있습니다.
//포켓몬.hello();하면
//   이름 Lv.ㅁ [ㅁㅁ/100]
//   이렇게 출력해주세요~~

// 포켓몬 객체
class Pokemon {

	String name;

	int level;

	int exp;

	void hello() {

		System.out.println(name + " Lv." + level + " [" + exp + "/100]");

	}

}

// 강아지 객체
class Dog {

	String name;

	String kind;

	void dogInfo() {

		System.out.println(name + "의 견종은 " + kind + "입니다.");

	}

}

public class Test01 {

	public static void main(String[] args) {

		// 포켓몬 객체1 호출
		Pokemon poke1 = new Pokemon();
		poke1.name = "야도란";
		poke1.level = 30;
		poke1.exp = 80;
		poke1.hello();

		// 포켓몬 객체2 호출
		Pokemon poke2 = new Pokemon();
		poke2.name = "불비달마";
		poke2.level = 60;
		poke2.exp = 70;
		poke2.hello();
		
		// 강아지 객체1 호출
		Dog dog1 = new Dog();
		dog1.name = "노노";
		dog1.kind = "골든리트리버";
		dog1.dogInfo();
		
		// 강아지 객체2 호출
		Dog dog2 = new Dog();
		dog2.name = "누누";
		dog2.kind = "보더콜리";
		dog2.dogInfo();

	}

}
