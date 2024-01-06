package project;

import java.util.Random;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//boolean [] numCk =new boolean[10];
		Random rand = new Random();
		int[] datas = new int[5];
		for (int i = 0; i < datas.length; i++) {

			datas[i]  = rand.nextInt(5) + 1;
		//탐색 알고리즘
		//다시
			
		}

		for (int data : datas) {//출력
			System.out.print(data + " ");
		}
		System.out.println();
	}

}
