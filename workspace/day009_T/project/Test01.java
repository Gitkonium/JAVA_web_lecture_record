package project;

import java.util.Random;

public class Test01 {
	
	public static boolean seqSearch(int i, int[] datas) {
		for (int j = 0; j < i; j++) {//순차탐색
			if (datas[i] == datas[j]) {
				return true;
			}
		}
		return false;
	}	
	
	
	public static boolean binSearch(int i, int[] datas) {
		int mid;// 중간 index 값
		int low = 0;// 배열 첫번째 index
		int high = i - 1;// 지금까지 뽑은 배열 index
		// 이진 탐색
		while (low <= high) {
			mid = (low + high) / 2;

			if (datas[i] == datas[mid]) {
				break;
			} else if (datas[i] < datas[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		if(low>high) {
			sort(i, datas);
			return false;
		}
		return true;
	}

	public static void sort(int i, int[] datas) {// 버블 정렬

		for (int j = 0; j < i; j++) {// 0~ 현재까지 뽑은 i 만큼 정렬을 시킨다
			for (int k = 0; k < i - j; k++) {
				if (datas[k] > datas[k + 1]) {
					int tmp = datas[k];
					datas[k] = datas[k + 1];
					datas[k + 1] = tmp;
				}
			}
		}
	}

	public static boolean boolSearch(int i, int[] datas, boolean[] numCk) {
		if(numCk[datas[i]-1]) {
			//중복시 다시 뽑기
			return true;
		}
		else {			//numCk 해당 index로 들어가 false를 true로 변환
			numCk[datas[i]-1]=true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean [] numCk =new boolean[5]; // 1~5 0~4 10~14
		Random rand = new Random();
		int[] datas = new int[5];
		for (int i = 0; i < datas.length; i++) {

			datas[i]  = rand.nextInt(5) + 1;

			//순차 탐색으로 중복 탐색(확인)
			//if (seqSearch(i, datas))// 다시 뽑기위해 i 감소
				
			
			
			//이진 탐색으로 중복 탐색(확인)
			//if (binSearch(i, datas)) // 다시 뽑기위해 i 감소
			
			
			//boolean 배열 인덱스 숫자로 중복 탐색(확인)
			if (boolSearch(i, datas,numCk))// 다시 뽑기위해 i 감소
			
			 i--;
		}

		for (int data : datas) {
			System.out.print(data + " ");
		}
		System.out.println();
	}

}
