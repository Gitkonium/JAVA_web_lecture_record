package ctrl;

import java.util.ArrayList;

import model.ProductDAO;
import model.ProductDTO;
import view.View;

public class Ctrl {

	private ProductDAO productDAO; // MODEL
	private View view;
	public Ctrl() {
		this.productDAO=new ProductDAO();
		this.view=new View();
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
						
					}
					else if(action==2) {

					}
					else if(action==3) {

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
