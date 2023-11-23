package class04;

import java.util.Random;

/*
랜덤 정수를 5개 저장할수있는
배열이 있습니당
1~6까지 랜덤하게 저장해주세용


1) 2가 몇번 나왔는지
2) 총합이 몇인지
3) 평균이 몇인지 >> x.x 소수점까지
출력해주세요!~~

 */
public class Test05 {

	public static void main(String[] args) {

		Random rand=new Random();
		int[] datas=new int[5];
		for(int i=0;i<datas.length;i++) {
			datas[i]=rand.nextInt(6)+1;
		}
		System.out.print("[ ");
		for(int data:datas) {
			System.out.print(data+" ");
		}
		System.out.println("]");

		int cnt=0;
		for(int data:datas) {
			if(data==2) {
				cnt++;
			}
		}
		System.out.println("2는 총 "+cnt+"번 나왔습니다.");

		int total=0;
		for(int data:datas) {
			total+=data;
		}
		System.out.println("총합은 "+total+"입니다.");

		double avg=total*1.0/datas.length;
		System.out.println("평균은 "+avg+"입니다.");










	}

}
