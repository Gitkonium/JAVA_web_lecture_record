package ctrl;

import java.util.ArrayList;

import model.MemberDAO;
import model.MemberDTO;
import model.ProductDAO4;
import model.ProductDTO;
import view.MemberView;
import view.View4;

public class Ctrl4 {

	private ProductDAO4 productDAO; // MODEL
	private MemberDAO memberDAO;
	private View4 view;
	private MemberView memberView;
	private int PK;
	private MemberDTO user; // 현재 로그인한 사람의 정보
	 // 로그인 세션,쿠키,로컬 스토리지 정보
	public Ctrl4() {
		this.productDAO=new ProductDAO4();
		this.memberDAO=new MemberDAO();
		this.view=new View4();
		this.memberView=new MemberView();
		this.PK=1003;
		this.user=null; // 아무도 로그인하지않은 상태
	}

	public void start() {
		while(true) {
			if(user == null) { // 로그아웃 상태
				view.printMenu();
			}
			else {
				view.printLoginMenu();
				if(user.getMid().equals("admin")) {
					view.adminInfo();
				}
			}
			
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
			else if(action==4) {
				if(user != null) {
					continue;
				}
				// 로그아웃 상태일때만 수행할 예정
				// 로그인 상태야? 그럼 못해. 되돌아가!
				// 유효성 검사 ☆
				
				MemberDTO memberDTO=new MemberDTO();
				String mid;
				while(true) {
					mid=memberView.inputMemberID();
					
					memberDTO.setMid(mid);
					memberDTO.setSearchCondition("ID중복검사");
					memberDTO=memberDAO.selectOne(memberDTO);
					if(memberDTO == null) {
						break;
					}
					
					memberView.signUpFalse();
				}
				memberDTO=new MemberDTO();
				memberDTO.setMid(mid);
				String mpw=memberView.inputMemberPW();
				memberDTO.setMpw(mpw);
				String name=memberView.inputMemberName();
				memberDTO.setName(name);
				memberDAO.insert(memberDTO);
				
				memberView.signUpTrue();
			}
			else if(action==5) {
				if(user != null) {
					continue;
				}
				// 로그아웃 상태일때만 수행할 예정
				// 로그인 상태야? 그럼 못해. 되돌아가!
				// 유효성 검사 ☆
				
				String mid=memberView.inputMemberID();
				String mpw=memberView.inputMemberPW();
				MemberDTO memberDTO=new MemberDTO();
				memberDTO.setMid(mid);
				memberDTO.setMpw(mpw);
				memberDTO.setSearchCondition("로그인");
				memberDTO=memberDAO.selectOne(memberDTO);
				if(memberDTO == null) {
					memberView.loginFalse();
					continue;
				}
				user=memberDTO;
				memberView.loginTrue();
			}
			else if(action==6) {
				user=null;
				memberView.logout();
			}
			else if(action==7) {
				if(user == null) {
					continue;
				}
				
				String mpw=memberView.inputMemberPW(); // 현재 비번
				
				// 현재 로그인한 정보의 비번과 같은지 확인해야함!
				MemberDTO memberDTO=new MemberDTO();
				memberDTO.setMid(user.getMid()); // 현재 로그인한 정보
				memberDTO.setMpw(mpw); // 입력한 정보
				memberDTO.setSearchCondition("로그인");
				memberDTO=memberDAO.selectOne(memberDTO);
				if(memberDTO==null) {
					memberView.printFalse();
					continue;
				}
				
				mpw=memberView.inputMemberPW(); // 바꿀 비번
				memberDTO=new MemberDTO();
				memberDTO.setMid(user.getMid()); // 현재 로그인한 사람을
				memberDTO.setMpw(mpw); // 바꿀 비번으로 설정해줘!~~
				memberDAO.update(memberDTO);
				
				user=null;
				memberView.logout();
			}
			else if(action==8) {
				if(user == null) {
					continue;
				}
				
				MemberDTO memberDTO=new MemberDTO();
				memberDTO.setMid(user.getMid());
				memberDAO.delete(memberDTO);
				user=null; // 로그아웃도 시켜주어야함!
				memberView.printTrue();
			}
		}		
	}

}
