package class02;

import java.util.Scanner;

class Person {
	String name;
	int age;
	Person(String n){
		name=n;
		age=20;
	}
	Person(String n,int a){
		name=n;
		age=a;
	}
	void hello() {
		System.out.println(name+"는(은) "+age+"살입니다.");
	}
	int inputAge() {
		Scanner sc=new Scanner(System.in);
		int age;
		while(true){
			System.out.print("나이입력 >> ");
			age=sc.nextInt();
			if(1<=age && age<=100) {
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
		Scanner sc=new Scanner(System.in);
		
		String name;
		while(true) {
			System.out.print("이름입력 >> ");
			name=sc.next();
			
			System.out.print("정말 이 이름으로 하시겠습니까? ");
			String ans=sc.next();
			///System.out.println("   로그 1");
			///System.out.println("ans==\"네\"의 결과 : "+(ans=="네"));
			///System.out.println("ans.equals(\"네\")의 결과 : "+ans.equals("네"));
			if(ans.equals("네")) {
				///System.out.println("   로그 2");
				break;
			}
			System.out.println("다시 입력해주세요...");
		}
		return name;
	}

	public static void main(String[] args) {
	
		/*
		Person p1=new Person(inputName());

		Person p2=new Person(inputName(),13);

		p1.hello();

		p2.age=p2.inputAge();
		p2.hello();
		*/

		
		/*
		Person[] datas=new Person[5];
		datas[0]=사람객체;
		*/
		
		Person[] datas=new Person[3];
				
		Person person=new Person("0번인덱스");
		datas[0]=person;
		// 1) 사람객체를 미리 생성한 다음 저장
		
		datas[1]=new Person("1번인덱스");
		// 2) 저장할때에 사람객체를 생성 ◁
		
		
		for(int i=2;i<datas.length;i++) {
			String name=inputName();
			datas[i]=new Person(name);
		}
		
		System.out.println();
		
		for(Person data:datas) {
			data.hello();
			// System.out.println(data);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		






	}

}