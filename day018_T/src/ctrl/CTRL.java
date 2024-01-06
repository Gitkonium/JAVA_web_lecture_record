package ctrl;

import java.util.ArrayList;

import model.MemberDAO;
import model.MemberDTO;
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

	private MemberDTO loginINFO; // 로그인한 사용자의 데이터를 저장할 공간

	private ArrayList<ProductDTO> cart; // 장바구니 데이터를 저장할 공간

	public CTRL() {

		mDAO = new MemberDAO();

		pDAO = new ProductDAO();

		adminVIEW = new AdminVIEW();

		userVIEW = new UserVIEW();

		commonVIEW = new CommonVIEW();

		loginVIEW = new LoginVIEW();

		logoutVIEW = new LogoutVIEW();

		loginINFO = null;

		cart = null;

	}

	// 모듈화
	public void loginAction() {

		String mid = logoutVIEW.inputMid();

		String mpw = logoutVIEW.inputMpw();

		MemberDTO mDTO = new MemberDTO();
		mDTO.setMid(mid);
		mDTO.setMpw(mpw);

		mDTO.setSearchCondition("로그인");

		loginINFO = mDAO.selectOne(mDTO);

		if (loginINFO == null) {

			commonVIEW.printFalse();

			return;

		}

		commonVIEW.printTrue();

	}

	public void start() {

		while (true) {

			commonVIEW.printMenu();

			if (loginINFO == null) {

				logoutVIEW.printMenu();

			} else if (loginINFO.getGrade().equals("ADMIN")) {

				adminVIEW.printMenu();

				loginVIEW.hello(loginINFO);

			} else {
				
				if (cart != null) {
					
					userVIEW.printMenu(cart.size());
					
				} else {
					
					userVIEW.printMenu(0);
					
				}
				
				loginVIEW.printMenu();
				
				loginVIEW.hello(loginINFO);
				
			}
			
			int action = commonVIEW.inputAction();

			// ※ 모든 action 수행은 자격이 있다고 가정하고 하겠습니다.
			// ※ 즉, 별도의 인증 작업을 생략하겠습니다.

			if (action == 0) {
				
				break;
				
			} else if (action == 1) {
				
				// MODEL아, 전체목록주라! == SELECTALL
				// 받은것들 뷰에서 출력

				commonVIEW.printDatas(pDAO.selectAll(new ProductDTO()));
				
			} else if (action == 2) {

				// ※ 최저 → 최고 가격 순서로 입력을 잘 했다고 가정하고 하겠습니다.

				// 최저가격입력
				// 최고가격입력
				// MODEL아, 가격검색목록주라! == SEELCTALL
				// 받은것들 뷰에서 출력

				/*
				 * int 최저가격=commonVIEW.inputPrice(); int 최고가격=commonVIEW.inputPrice();
				 * commonVIEW.printDatas(pDAO.selectAll(new ProductDTO()));
				 * 
				 * int 최저가격=commonVIEW.inputPrice(); int 최고가격=commonVIEW.inputPrice();
				 * ProductDTO pDTO=new ProductDTO(); pDTO.setPrice(최저가격); pDTO.setPrice(최고가격);
				 * commonVIEW.printDatas(pDAO.selectAll(pDTO));
				 */

				int minPrice = commonVIEW.inputPrice();
				int maxPrice = commonVIEW.inputPrice();
				
				ProductDTO pDTO = new ProductDTO();
				
				pDTO.setMinPrice(minPrice); // searchCondition의 역할
				pDTO.setMaxPrice(maxPrice); // JAVA 로직에서만 활용되는 DTO의 멤버변수
				pDTO.setSearchCondition("가격검색");
				
				commonVIEW.printDatas(pDAO.selectAll(pDTO));
			} else if (action == 3) {
				
				if (loginINFO == null) {
					
					commonVIEW.printInfo();

					loginAction();

					continue;
					
				}

				int pid = commonVIEW.inputPid();
				
				ProductDTO pDTO = new ProductDTO();
				pDTO.setPid(pid);
				
				pDTO = pDAO.selectOne(pDTO);
				
				if (pDTO == null) {
					
					commonVIEW.printNoData();
					
					continue;
					
				}

				commonVIEW.printData(pDTO);
				int cnt = commonVIEW.inputCnt();

				boolean flag = false;
				int i = 0;
				if (cart != null) {
					for (i = 0; i < cart.size(); i++) {
						if (pDTO.getPid() == cart.get(i).getPid()) {
							flag = true;
							break;
						}
					}
				}

				// 원래는 그냥 지금 구매하려는 재고가 기존 재고보다 크면 안된다.
				// 현재는 지금 구매하려는 재고가 기존 재고-장바구니 재고보다 크면 안된다.
				if (!flag) {
					
					if (pDTO.getCnt() < cnt) {
						
						commonVIEW.printFalse();
						
						continue;
						
					}
					
					if (cart == null) {
						
						cart = new ArrayList<ProductDTO>();
						
					}
					
					ProductDTO data = new ProductDTO();
					
					data.setPid(pDTO.getPid());
					data.setName(pDTO.getName());
					data.setCnt(cnt);
					data.setPrice(pDTO.getPrice());
					
					cart.add(data);
					
					commonVIEW.printTrue();
					
				} else { // 장바구니에 있던 상품이라면
					
					if (pDTO.getCnt() - cart.get(i).getCnt() < cnt) {
						
						commonVIEW.printFalse();
						
						continue;
						
					}
					
					cart.get(i).setCnt(cart.get(i).getCnt() + cnt);
					
					commonVIEW.printTrue();
					
				}
				
			} else if (action == 4) {
				
				userVIEW.printTotalPrice(cart);
				
				for (int i = 0; i < cart.size(); i++) {
					
					cart.get(i).setSearchCondition("구매");
					
					if (!pDAO.update(cart.get(i))) {
						
						commonVIEW.printFalse();
						
						continue;
						
					}
					
					commonVIEW.printTrue();
					
				}
				
				cart = null; // cart.clear();
				
			} else if (action == 5) {
				
				// 재고추가
				
			} else if (action == 6) {
				
				String mid;
				
				while (true) {
					
					mid = logoutVIEW.inputMid();
					
					MemberDTO mDTO = new MemberDTO();
					mDTO.setMid(mid);
					mDTO.setSearchCondition("ID중복검사");
					
					if (mDAO.selectOne(mDTO) == null) { // 중복이 아니라면
						
						break;
						
					}
					
					logoutVIEW.printInfo();
					
				}
				
				String mpw = logoutVIEW.inputMpw();
				String name = logoutVIEW.inputName();

				MemberDTO mDTO = new MemberDTO();
				mDTO.setMid(mid);
				mDTO.setMpw(mpw);
				mDTO.setName(name);
				mDTO.setGrade("USER");
				
				if (!mDAO.insert(mDTO)) {
					
					commonVIEW.printFalse();
					
					continue;
					
				}
				
				commonVIEW.printTrue();
				
			} else if (action == 7) {
				
				loginAction();
				
			} else if (action == 8) {
				
				loginINFO = null;
				
				cart = null; // cart.clear();
				
				commonVIEW.printTrue();
				
			} else if (action == 9) {
				
				// 비밀번호를 확인한후에 비번변경을 진행
				String mpw = logoutVIEW.inputMpw();
				
				MemberDTO mDTO = new MemberDTO();
				mDTO.setMid(loginINFO.getMid());
				mDTO.setMpw(mpw);
				mDTO.setSearchCondition("로그인");
				mDTO = mDAO.selectOne(mDTO);
				
				if (mDTO == null) {
					
					commonVIEW.printFalse();
					
					continue;
					
				}

				// 변경할 비번입력
				mpw = logoutVIEW.inputMpw();
				mDTO.setMid(loginINFO.getMid());
				mDTO.setMpw(mpw);
				
				if (!mDAO.update(mDTO)) {
					
					commonVIEW.printFalse();
					
					continue;
					
				}
				
				loginINFO = null;
				
				cart = null;
				
				commonVIEW.printTrue();
				
			} else if (action == 10) {
				
				if (!mDAO.delete(loginINFO)) {
					
					commonVIEW.printFalse();
					
					continue;
					
				}
				
				loginINFO = null;
				
				cart = null;
				
				commonVIEW.printTrue();
				
			}
			
		}
		
	}
	
}