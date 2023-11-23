package class03;

public class Test01 {

	public static void main(String[] args) {
				
		
		// 배열을 사용할수있는 3가지 조건
		// 1. 관련된 데이터
		// 2. 같은 타입의 데이터들인가?
		// 3. 데이터의 개수를 정확히 알고있어야한다!
		int[] proArr=new int[4];
		System.out.println(proArr);
		proArr[0]=500;
		proArr[1]=700;
		proArr[2]=1200;
		proArr[3]=950;
		
		// 하드코딩 xxx
		for(int i=0;i<proArr.length;i++) {
			System.out.println((i+1)+"번 상품의 가격은 "+proArr[i]+"원입니다.");
		}

		int total=0;
		// 특정배열의 value만 궁금할때
		// forEach문(향상된 for문)
		for(int price:proArr) {
			total+=price;
			System.out.println("현재 price: "+price);
		}
		/*
		for(자료형  임의의 변수명:배열명) {
			
		}
		*/
		System.out.println("1~4번 상품의 총 합 가격은 "+total+"원입니다.");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
