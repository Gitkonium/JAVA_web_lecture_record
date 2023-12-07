package class02;

import java.util.ArrayList;
import java.util.Random;

/*
10부터 30까지 정수중에서 랜덤으로 정수 1개를 생성해주세요.
1부터 해당 정수까지의 모든 홀수들을 배열리스트에 저장해주세요.
그리고 배열리스트에 저장된 모든 요소들을 출력해주세요.
이후, 배열리스트의 모든 요소들의 총합을 출력해주세요.
평균도 출력해주세요. (단, 0.00 의 형태로 출력해주세요.)
 */
public class Test02 {

	public static void main(String[] args) {
	
		int randNum=new Random().nextInt(21)+10;
		System.out.println("랜덤수 : "+randNum);
		
		ArrayList<Integer> datas=new ArrayList<Integer>();
		
		for(int i=1;i<=randNum;i++) {
			if(i%2==1) {
				datas.add(i);
			}
		}
		
		System.out.println(datas);
		
		int total=0;
		for(int data:datas) {
			total+=data;
		}
		/*
		for(int i=0;i<datas.size();i++) {
			total+=datas.get(i);
		}
		*/
		System.out.println("총합 : "+total);
		
		double avg=total*1.0/datas.size();
		System.out.println("평균 : "+avg);
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
