package model;

import java.util.ArrayList;

public class ProductDAO {

	private ArrayList<ProductDTO> datas; // DB

	public ProductDAO() {
		datas=new ArrayList<ProductDTO>();

		// 샘플 데이터 추가
		ProductDTO sample01=new ProductDTO();
		sample01.setNum(1001);
		sample01.setName("콜라");
		sample01.setPrice(1200);
		sample01.setCnt(3);
		datas.add(sample01);
		ProductDTO sample02=new ProductDTO();
		sample02.setNum(1002);
		sample02.setName("사이다");
		sample02.setPrice(1100);
		sample02.setCnt(0);
		datas.add(sample02);
	}

	public ArrayList<ProductDTO> selectAll(ProductDTO productDTO){
		return datas;
	}
	public ProductDTO selectOne(ProductDTO productDTO){
		boolean flag=false;
		int i;
		for(i=0;i<this.datas.size();i++) {
			// this.datas.get(i).getNum()
			// 내꺼.DB.요소 == 상품
			// 상품.pk()
			if(this.datas.get(i).getNum() == productDTO.getNum()) {
				flag=true;
				break;
			}
		}
		if(!flag) {
			return null;
		}
		return this.datas.get(i);
	}

	public boolean insert(ProductDTO productDTO) {
		try {
			ProductDTO data=new ProductDTO();
			data.setNum(productDTO.getNum());
			data.setName(productDTO.getName());
			data.setPrice(productDTO.getPrice());
			data.setCnt(productDTO.getCnt());
			this.datas.add(data);
		}catch(Exception e) {
			System.out.println("[로그] 알수없는 이슈발생!");
			return false;
		}
		return true;
	}
	public boolean update(ProductDTO productDTO) {
		boolean flag=false;
		int i;
		for(i=0;i<this.datas.size();i++) {
			if(this.datas.get(i).getNum() == productDTO.getNum()) {
				flag=true;
				break;
			}
		}
		if(!flag) {
			return false;
		}
		
		if(productDTO.getSearchConditon().equals("구매")) {
			this.datas.get(i).setCnt(this.datas.get(i).getCnt()-1);
		}
		else if(productDTO.getSearchConditon().equals("재고변경")) {
			this.datas.get(i).setCnt(productDTO.getCnt());
		}
		
		return true;
	}
	public boolean delete(ProductDTO productDTO) {
		boolean flag=false;
		int i;
		for(i=0;i<this.datas.size();i++) {
			if(this.datas.get(i).getNum() == productDTO.getNum()) {
				flag=true;
				break;
			}
		}
		if(!flag) {
			return false;
		}
		this.datas.remove(i);
		return true;
	}

}
