package class05;

// 책이라는 자료형이 필요해
// == 책 클래스 정의
class Book{
	
	String title;
	
	String writer;
	
	int price;
	
	void printInfo() {
		
		System.out.println("제목 : " + title);
		System.out.println("작가 : " + writer);
		System.out.println("가격 : " + price);
		
	}
	
}


public class Test02 {

	public static void main(String[] args) {
		
		Book book1 = new Book();
		Book book2 = new Book();
		book2.title = "어린왕자";
		book2.writer = "생텍쥐페리";
		book2.price = 20000;
		
		book1.printInfo();
		book2.printInfo();
		
		// 원시타입인 변수들은 초기화하지 않으면 값이 없음 => 에러가 발생
		// 힙 메모리의 특징
		//		0,null로 자동 초기화
		
		
	}

}
