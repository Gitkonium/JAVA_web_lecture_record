package model;

import java.util.ArrayList;

public class ProductDAO {

	private ArrayList<ProductDTO> pdatas;

	public ProductDAO() {

		pdatas = new ArrayList<ProductDTO>();

		ProductDTO sample01 = new ProductDTO();
		sample01.setPid(1001);
		sample01.setName("콜라");
		sample01.setPrice(1100);
		sample01.setCnt(10);
		pdatas.add(sample01);

		ProductDTO sample02 = new ProductDTO();
		sample02.setPid(1002);
		sample02.setName("사이다");
		sample02.setPrice(1200);
		sample02.setCnt(1);
		pdatas.add(sample02);

		ProductDTO sample03 = new ProductDTO();
		sample03.setPid(1003);
		sample03.setName("보리차");
		sample03.setPrice(2200);
		sample03.setCnt(0);
		pdatas.add(sample03);

	}

	public ArrayList<ProductDTO> selectAll(ProductDTO pDTO) {

		if (pDTO.getSearchCondition() == null) { // 상품전체목록

			return pdatas;

		} else { // 가격검색
			
			ArrayList<ProductDTO> datas = new ArrayList<ProductDTO>();
			
			for (int i = 0; i < pdatas.size(); i++) {
				
				if (pDTO.getMinPrice() <= pdatas.get(i).getPrice() && pdatas.get(i).getPrice() <= pDTO.getMaxPrice()) {
					
					ProductDTO data = new ProductDTO();
					data.setPid(pdatas.get(i).getPid());
					data.setName(pdatas.get(i).getName());
					data.setPrice(pdatas.get(i).getPrice());
					data.setCnt(pdatas.get(i).getCnt());
					
					datas.add(data);
					
				}
				
			}
			
			return datas;
			
		}
		
	}

	public ProductDTO selectOne(ProductDTO pDTO) {
		
		boolean flag = false;
		int i;
		
		for (i = 0; i < pdatas.size(); i++) {
			
			if (pDTO.getPid() == pdatas.get(i).getPid()) {
				
				flag = true;
				
				break;
				
			}
			
		}
		
		if (!flag) {
			
			return null;
			
		}
		
		return pdatas.get(i);
		
	}

	private boolean insert(ProductDTO pDTO) {
		
		return false;
		
	}

	public boolean update(ProductDTO pDTO) {
		
		if (pDTO.getSearchCondition().equals("구매")) {
			
			boolean flag = false;
			int i;
			
			for (i = 0; i < pdatas.size(); i++) {
				
				if (pDTO.getPid() == pdatas.get(i).getPid()) {
					
					flag = true;
					
					break;
					
				}
				
			}
			
			if (!flag) {
				
				return false;
				
			}
			
			/// pdatas.get(i).setCnt(pdatas.get(i).getCnt()-1); // 1개 구매
			pdatas.get(i).setCnt(pdatas.get(i).getCnt() - pDTO.getCnt()); // N개 구매
			
			return true;
			
		} else { // 재고추가
			
			boolean flag = false;
			int i;
			
			for (i = 0; i < pdatas.size(); i++) {
				
				if (pDTO.getPid() == pdatas.get(i).getPid()) {
					
					flag = true;
					
					break;
					
				}
				
			}
			
			if (!flag) {
				
				return false;
				
			}
			
			pdatas.get(i).setCnt(pdatas.get(i).getCnt() + pDTO.getAddCnt());
			
			return true;
			
		}
		
	}

	private boolean delete(ProductDTO pDTO) {
		
		return false;
		
	}
	
}