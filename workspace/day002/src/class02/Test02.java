package class02;

public class Test02 {

	public static void main(String[] args) {
		
		int i=1;
		// 무한루프,무한반복문
		// ※ 반복문은 조건식을 어떻게 작성하느냐에 따라, "무한"실행될수도있에 유의!!!!!
		
		while(i<5) {
			i++;
			i*=-1;
			System.out.println("i= "+i);
		}
		System.out.println("최종 i= "+i);
		// ★ 앞으로실습할때.... ^^..... 주의해야한다!!!!
		// 디버깅표를 그려봤으면 괜찮았을텐데.... ★★★★★
		
	}

}
