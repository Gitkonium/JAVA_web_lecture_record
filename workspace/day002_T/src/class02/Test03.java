package class02;

public class Test03 {

	public static void main(String[] args) {
		int i=0;
		// while >> 여러번,무한하게,계속,특정조건을 만족하는동안에,...
		// while은 일부러 무한루프문을 만들어서 사용할때에 가장많이 활용됨
		while(true) { // 무한루프문 => 반드시 "종료조건"과 함께 사용해야함!!!!!
			System.out.println("계속1");
			i++;
			
			if(i<3) {
				System.out.println("계속2");
				break; // 자신과 가장가까운 반복문의 바깥으로 즉시 이동하는 제어문
				// break 뒤는 데드코드 사용 불가능!
			}
			
			System.out.println("계속3");
		}
		
		
	}

}
