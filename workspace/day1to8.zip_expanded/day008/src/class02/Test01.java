package class02;

import java.util.Scanner;

class Person {

	String name;
	int age;

	Person(String n) {
		
		name = n;
		
		age = 20;
		
	}

	Person(String n, int a) {
		
		name = n;
		
		age = a;
		
	}

	void hello() {
		
		System.out.println(name + "는(은) " + age + "살입니다.");
		
	}

	int inputAge() {
		
		Scanner sc = new Scanner(System.in);
		
		int age;
		
		while (true) {
			
			System.out.print("나이입력 >> ");
			
			age = sc.nextInt();
			
			if (1 <= age && age <= 100) {
				
				break;
				
			}
			
			System.out.println("1~100살까지만 입력가능합니다!");
			
			System.out.println("확인후 다시 입력해주세요...");
			
		}
		
		return age;
		
	}
	
}

public class Test01 {

	public static String inputName() {
		
		Scanner sc = new Scanner(System.in);

		String name;
		
		while (true) {
			
			System.out.print("이름입력 >> ");
			
			name = sc.next();
			
			System.out.print("정말 이 이름으로 하시겠습니까? ");
			
			String ans = sc.next();
			
			if (ans.equals("네")) {
				
				break;
				
			}
			
			System.out.println("다시 입력해주세요...");
			
		}
		
		return name;
		
	}
 
	public static void main(String[] args) {
	
		Person[] datas = new Person[3];

		Person person = new Person("0번인덱스");
		
		datas[0] = person;
		
		datas[1] = new Person("1번인덱스");

		for (int i = 2; i < datas.length; i++) {
			
			String name = inputName();
			
			datas[i] = new Person(name);
			
		}

		System.out.println();

		for (Person data : datas) {
			
			data.hello();
			
		}

	}

}
