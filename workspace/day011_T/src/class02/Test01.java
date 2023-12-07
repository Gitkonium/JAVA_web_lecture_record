package class02;

import java.util.ArrayList;

public class Test01 {

	public static void main(String[] args) {

		ArrayList<Integer> datas=new ArrayList<Integer>();
		datas.add(10);
		System.out.println(datas);
		datas.add(0, 11);
		datas.add(0, 12);
		datas.add(1, 13);
		System.out.println(datas);
		boolean ans=datas.contains(10);
		System.out.println(ans);
		ans=datas.contains(100);
		System.out.println(ans);
		System.out.println(datas.get(0));
		datas.remove(0);
		System.out.println(datas);
		System.out.println(datas.size()); // .length
		System.out.println(datas.isEmpty());
		datas.clear();
		System.out.println(datas);
		System.out.println(datas.isEmpty());
		
	}

}
