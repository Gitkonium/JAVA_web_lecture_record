package ctrl;

import java.util.ArrayList;

import model.ProductDAO2;
import model.ProductDTO;
import view.View2;

public class Ctrl2 {

	private ProductDAO2 productDAO; // MODEL
	private View2 view;
	private int PK;
	public Ctrl2() {
		this.productDAO=new ProductDAO2();
		this.view=new View2();
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
		}		
	}

}
