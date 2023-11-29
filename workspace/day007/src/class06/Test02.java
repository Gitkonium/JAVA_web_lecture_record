package class06;

class Book{
	String title;
	int price;
	Book(String t){
		title=t;
		price=0;
		System.out.println("생성자 2 호출됨");
	}
	Book(String t,int p){
		title=t;
		price=p;
		System.out.println("생성자 1 호출됨");
	}
	void printInfo() {
		System.out.println(title+"는(은) "+price+"원입니다.");
	}
}
public class Test02 {

	public static void main(String[] args) {
		

		Book b1=new Book("어린왕자",10000);
		Book b2=new Book("해리포터 외전");
		Book b3=new Book("IT 지식",12000);
		b1.printInfo();
		b2.printInfo();
		b3.printInfo();
		
		
	}

}