package view;

import java.util.ArrayList;

import model.ProductDTO;

public class UserVIEW extends VIEW {

	public void printMenu(int cnt) {
		System.out.println("2. 가격검색출력");
		if(cnt>0) {
			System.out.println("4. 장바구니에 저장된 상품 구매");
		}
	}

	public void printTotalPrice(ArrayList<ProductDTO> cart) {
		int total=0;
		for(ProductDTO data:cart) {
			total+=data.getPrice()*data.getCnt();
		}
		System.out.println("총 구매 금액은 "+total+"원입니다.");
	}

}
