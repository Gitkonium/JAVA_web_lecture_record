package ctrl;

import java.util.ArrayList;

import model.ProductDAO3;
import model.ProductDTO;
import view.View3;

public class Ctrl3 {

	private ProductDAO3 productDAO; // MODEL
	private View3 view;
	private int PK;
	public Ctrl3() {
		this.productDAO=new ProductDAO3();
		this.view=new View3();
		this.PK=1003;
	}

	public void start() {
		while(true) {
			view.printMenu();
			int action=view.inputInteger();
			if(action==0) {
				break;
			}
			else if(action==1234) {
				while(true) {
					view.printAdminMenu();
					action=view.inputInteger();
					if(action==0) {
						break;
					}
					else if(action==1) {
						String name=view.inputName();
						int price=view.inputPrice();
						int cnt=view.inputCnt();
						
						ProductDTO productDTO=new ProductDTO();
						productDTO.setNum(PK++);
						productDTO.setName(name);
						productDTO.setPrice(price);
						productDTO.setCnt(cnt);
						
						productDAO.insert(productDTO);
					}
					else if(action==2) {
						int num=view.inputNum();
						
						ProductDTO productDTO=new ProductDTO();
						productDTO.setNum(num);
						productDTO=productDAO.selectOne(productDTO);
						if(productDTO==null) {
							view.printNoData();
							continue;
						}
					
						int cnt=view.inputCnt();
						productDTO.setCnt(cnt);
						productDTO.setSearchConditon("재고변경");
						boolean flag=productDAO.update(productDTO);
						if(flag){
							view.printDeleteData01(); // update 성공 !
						}
						else {
							view.printDeleteData02(); // update 실패 ...
						}
					}
					else if(action==3) {
						int num=view.inputNum();
						
						ProductDTO productDTO=new ProductDTO();
						productDTO.setNum(num);
						
						productDTO=productDAO.selectOne(productDTO);
						if(productDTO == null) {
							view.printNoData();
							continue;
						}
						
						boolean flag=productDAO.delete(productDTO);
						if(flag) {
							view.printDeleteData01();
						}
						else {
							view.printDeleteData02();
						}
					}
					else if(action==4) {
						int num=view.inputNum();
						
						ProductDTO productDTO=new ProductDTO();
						productDTO.setNum(num);
						productDTO=productDAO.selectOne(productDTO);
						if(productDTO==null) {
							view.printNoData();
							continue;
						}
						
						int addCnt=view.inputCnt();
						productDTO.setAddCnt(addCnt);
						productDTO.setSearchConditon("재고추가");
						boolean flag=productDAO.update(productDTO);
						if(flag) {
							view.printDeleteData01();
						}
						else {
							view.printDeleteData02();
						}
					}
					else if(action==5) {
						int num=view.inputNum();
						
						ProductDTO productDTO=new ProductDTO();
						productDTO.setNum(num);
						productDTO=productDAO.selectOne(productDTO);
						if(productDTO==null) {
							view.printNoData();
							continue;
						}
						
						int price=view.inputPrice();
						productDTO.setPrice(price);
						productDTO.setSearchConditon("가격변경");
						productDAO.update(productDTO);
					}
				}
			}
			else if(action==1) {
				ProductDTO productDTO=new ProductDTO();
				ArrayList<ProductDTO> datas=productDAO.selectAll(productDTO);
				view.printDatas(datas);
			}
			else if(action==2) {
				int num=view.inputInteger();
				ProductDTO productDTO=new ProductDTO();
				productDTO.setNum(num);
				ProductDTO data=productDAO.selectOne(productDTO);
				view.printData(data);
				if(data!=null && data.getCnt()>0) { // 구매성공이라면
					data.setSearchConditon("구매");
					productDAO.update(data);
				}
			}
			else if(action==3) {
				String name=view.inputName();
				
				ProductDTO productDTO=new ProductDTO();
				productDTO.setName(name);
				productDTO.setSearchConditon("이름검색");
				ArrayList<ProductDTO> datas=productDAO.selectAll(productDTO);
				
				view.printDatas(datas);
			}
		}		
	}

}
