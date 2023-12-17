package ctrl;

import model.MemberDAO;
import model.ProductDAO;
import model.ProductDTO;
import view.AdminVIEW;
import view.CommonVIEW;
import view.LoginVIEW;
import view.LogoutVIEW;
import view.UserVIEW;

public class CTRL {
	private MemberDAO mDAO;
	private ProductDAO pDAO;
	private AdminVIEW adminVIEW;
	private UserVIEW userVIEW;
	private CommonVIEW commonVIEW;
	private LoginVIEW loginVIEW;
	private LogoutVIEW logoutVIEW;
	public CTRL() {
		mDAO=new MemberDAO();
		pDAO=new ProductDAO();
		adminVIEW=new AdminVIEW();
		userVIEW=new UserVIEW();
		commonVIEW=new CommonVIEW();
		loginVIEW=new LoginVIEW();
		logoutVIEW=new LogoutVIEW();
	}
	public void start() {
		while(true) {
			int action=commonVIEW.inputAction();
			
			// ※ 모든 action 수행은 자격이 있다고 가정하고 하겠습니다.
			// ※ 즉, 별도의 인증 작업을 생략하겠습니다.
			
			if(action==0) {
				break;
			}
			else if(action==1) {
				// 모델아, 전체목록주라!
				// 받은것들 뷰에서 출력
				
				commonVIEW.printDatas(pDAO.selectAll(new ProductDTO()));
			}
			else if(action==2) {
				
				// ※ 최저 → 최고 가격 순서로 입력을 잘 했다고 가정하고 하겠습니다.
				
				// 최저가격입력
				// 최고가격입력
				// 모델아, 가격검색목록주라!
				// 받은것들 뷰에서 출력		
				
				/*
				int 최저가격=commonVIEW.inputPrice();
				int 최고가격=commonVIEW.inputPrice();
				commonVIEW.printDatas(pDAO.selectAll(new ProductDTO()));
				
				int 최저가격=commonVIEW.inputPrice();
				int 최고가격=commonVIEW.inputPrice();
				ProductDTO pDTO=new ProductDTO();
				pDTO.setPrice(최저가격);
				pDTO.setPrice(최고가격);
				commonVIEW.printDatas(pDAO.selectAll(pDTO));
				*/
				
				int minPrice=commonVIEW.inputPrice();
				int maxPrice=commonVIEW.inputPrice();
				ProductDTO pDTO=new ProductDTO();
				pDTO.setMinPrice(minPrice);
				pDTO.setMaxPrice(maxPrice);
				commonVIEW.printDatas(pDAO.selectAll(pDTO));
			}
			else if(action==3) {

			}
			else if(action==4) {

			}
			else if(action==5) {

			}
			else if(action==6) {

			}
			else if(action==7) {

			}
			else if(action==8) {

			}
			else if(action==9) {

			}
			else if(action==10) {

			}
		}
	}
}
