package ctrl;

import model.ProductDAO;
import model.ProductDTO;
import view.VIEW;

public class CTRL {

	private ProductDAO pDAO;
	private VIEW view;

	public CTRL() {
		pDAO=new ProductDAO();
		view=new VIEW();
	}

	public void start() {
		while(true) {
			view.printMenu();
			int action=view.inputAction();
			if(action==0) {
				break;
			}
			else if(action==1) {
				String name=view.inputName();
				int price=view.inputPrice();
				int cnt=view.inputCnt();
				ProductDTO pDTO=new ProductDTO();
				pDTO.setName(name);
				pDTO.setPrice(price);
				pDTO.setCnt(cnt);
				boolean flag=pDAO.insert(pDTO);
				if(!flag) {
					view.printFalse();
					continue;
				}
				view.printTrue();
			}
			else if(action==2) {
				ProductDTO pDTO=new ProductDTO();
				pDTO.setSearchCondition("전체");
				view.printDatas(pDAO.selectAll(pDTO));
			}
			else if(action==3) {
				int pid=view.inputPid();
				ProductDTO pDTO=new ProductDTO();
				pDTO.setPid(pid);
				view.printData(pDAO.selectOne(pDTO));
			}
			else if(action==4) {
				int pid=view.inputPid();
				ProductDTO pDTO=new ProductDTO();
				pDTO.setPid(pid);
				pDTO=pDAO.selectOne(pDTO);
				if(pDTO==null || pDTO.getCnt()<=0) {
					view.printInfo(pDTO);
					continue;
				}
				
				boolean flag=pDAO.update(pDTO);
				if(!flag) {
					view.printFalse();
					continue;
				}
				view.printTrue();
			}
			else if(action==5) {
				int pid=view.inputPid();
				ProductDTO pDTO=new ProductDTO();
				pDTO.setPid(pid);
				boolean flag=pDAO.delete(pDTO);
				if(!flag) {
					view.printFalse();
					continue;
				}
				view.printTrue();
			}
			else if(action==6) {
				String name=view.inputName();
				ProductDTO pDTO=new ProductDTO();
				pDTO.setName(name);
				pDTO.setSearchCondition("이름");
				view.printDatas(pDAO.selectAll(pDTO));
			}
		}
	}

}
