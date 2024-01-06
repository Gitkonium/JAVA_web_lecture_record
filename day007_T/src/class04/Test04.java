package class04;

// "책"이라는 자료형이 필요해
//  == "책" 클래스 정의
class Book{
	String title;
	String writer;
	int price;
	void printInfo() {
		System.out.println("제목: "+title);
		System.out.println("작가: "+writer);
		System.out.println("가격: "+price);
	}
}
public class Test04 {

	public static void main(String[] args) {

		Book book1=new Book();
		Book book2=new Book();
		book2.title="어린왕자";
		book2.writer="생텍쥐페리";
		book2.price=10000;
		
		book1.printInfo();
		book2.printInfo();
		
		// heap 메모리 영역의 특징
		//  ▶ 0, null로 자동 초기화
		int[] datas=new int[3];
		System.out.println(datas[0]);
		for(int data:datas) {
			System.out.print(data+" ");
		}
		System.out.println();
		
		// 원시타입인 변수들은 초기화하지않으면 값이 無 → 에러발생!
		/*
		int num1;
		int num2=10;
		
		String str1;
		String str2="hello";
		
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(str1);
		System.out.println(str2);
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
