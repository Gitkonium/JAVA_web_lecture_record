package model;

import java.util.ArrayList;

public class ProductDAO4 {

	private ArrayList<ProductDTO> datas; // DB

	public ProductDAO4() {
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
		if(productDTO.getSearchConditon()==null) {
			// 전체출력
			return this.datas;
		}
		else if(productDTO.getSearchConditon().equals("이름검색")) {
			ArrayList<ProductDTO> datas=new ArrayList<ProductDTO>();
			
			for(int i=0;i<this.datas.size();i++) {
				if(this.datas.get(i).getName().contains(productDTO.getName())) {
					datas.add(this.datas.get(i));
				}
			}
			
			return datas;
		}
		return null;
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
		if(productDTO.getSearchConditon().equals("구매")) {
			productDTO.setCnt(productDTO.getCnt()-1);
		}
		else if(productDTO.getSearchConditon().equals("가격변경")) {
			productDTO.setPrice(productDTO.getPrice());
		}
		else if(productDTO.getSearchConditon().equals("재고변경")) {
			productDTO.setCnt(productDTO.getCnt());
		}
		else if(productDTO.getSearchConditon().equals("재고추가")) {
			// "재고"라는 속성의 값을 "변경"하는 것이므로 "U"에 해당함!
			productDTO.setCnt(productDTO.getCnt()+productDTO.getAddCnt());
			// "추가할 값"이라는 속성은,
			// 제품의 속성이 아님!
			// "U" 기능을 수행할때 필요한 속성일뿐임!
			// "searchCondition"같은 속성이라는뜻!
		}
		else {
			return false;
		}		
		return true;
	}
	public boolean delete(ProductDTO productDTO) {
		try {
			int i;
			for(i=0;i<this.datas.size();i++) {
				if(this.datas.get(i).getNum() == productDTO.getNum()) {
					break;
				}
			}
			this.datas.remove(i);
		}catch(Exception e) {
			return false;
		}
		return true;
	}

}
