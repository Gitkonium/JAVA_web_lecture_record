package model;

import java.util.ArrayList;

public class ProductDAO {
	private ArrayList<ProductDTO> pdatas;
	public ProductDAO() {
		pdatas=new ArrayList<ProductDTO>();
	}
	public ArrayList<ProductDTO> selectAll(ProductDTO pDTO) {
		// 상품목록전체출력
		// 가격검색출력
		return null;
	}
	public ProductDTO selectOne(ProductDTO pDTO) {
		// 상품선택
		return null;
	}
	private boolean insert(ProductDTO pDTO) {
		return false;
	}
	public boolean update(ProductDTO pDTO) {
		// 구매
		// 재고추가
		return false;
	}
	private boolean delete(ProductDTO pDTO) {
		return false;
	}
}
