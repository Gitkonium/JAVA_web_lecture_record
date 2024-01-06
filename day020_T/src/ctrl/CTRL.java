package ctrl;

import java.util.ArrayList;

import model.BoardDAO;
import model.BoardDTO;
import model.Crawling;
import model.MemberDAO;
import model.MemberDTO;
import view.VIEW;

public class CTRL {

	private MemberDAO mDAO;
	private BoardDAO bDAO;
	private VIEW view;
	private MemberDTO loginINFO;

	public CTRL() {
		mDAO=new MemberDAO();
		bDAO=new BoardDAO();
		view=new VIEW();
		loginINFO=null;
	}

	public void start() {
		
		ArrayList<BoardDTO> samples=Crawling.sample();
		for(BoardDTO data:samples) {
			data.setContent("크롤링");
			data.setWriter("admin");
			bDAO.insert(data);
		}
		
		while(true) {
			view.loginlogout(loginINFO);
			view.printMenu();
			int action=view.inputAction();
			if(action==0) {
				break;
			}
			else if(action==1) {
				if(loginINFO != null) {
					view.printFalse();
					continue;
				}
				MemberDTO mDTO=view.login();
				mDTO=mDAO.selectOne(mDTO);
				if(mDTO==null) {
					view.printFalse();
					continue;
				}
				loginINFO=mDTO;
				view.printTrue();
			}
			else if(action==2) {
				if(loginINFO == null) {
					view.printFalse();
					continue;
				}
				loginINFO=null;
				view.printTrue();
			}
			else if(action==3) {
				if(loginINFO==null) {
					view.printFalse();
					continue;
				}
				BoardDTO bDTO=view.boardInsert();
				bDTO.setWriter(loginINFO.getMid());
				if(!bDAO.insert(bDTO)) {
					view.printFalse();
					continue;
				}
				view.printTrue();
			}
			else if(action==4) {
				ArrayList<BoardDTO> datas=bDAO.selectAll(null);
				view.printDatas(datas);
			}
			else if(action==5) {
				int bid=view.inputBid();
				BoardDTO bDTO=new BoardDTO();
				bDTO.setBid(bid);
				bDTO=bDAO.selectOne(bDTO);
				view.printData(bDTO);
				action=view.loginMenu(bDTO, loginINFO);
				if(action==1) {
					bDTO=view.boardInsert();
					bDTO.setBid(bid);
					// bDTO.setWriter(loginINFO.getMid());
					//  코드가 없어도 되는 이유
					//   1. 이미 bDTO에 writer 정보가 있음
					//   2. update()에서 writer 정보를 필요로하지않음
					if(!bDAO.update(bDTO)) {
						view.printFalse();
						continue;
					}
					view.printTrue();
				}
				else if(action==2) {
					if(!bDAO.delete(bDTO)) {
						view.printFalse();
						continue;
					}
					view.printTrue();
				}
			}
		}
	}

}









