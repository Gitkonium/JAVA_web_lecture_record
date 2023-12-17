package model;

import java.util.ArrayList;

public class MemberDAO {
	private ArrayList<MemberDTO> datas;
	public MemberDAO() {
		datas=new ArrayList<MemberDTO>();

		MemberDTO admin=new MemberDTO();
		admin.setMid("admin");
		admin.setMpw("1234");
		admin.setName("관리자");
		datas.add(admin);
	}

	public ArrayList<MemberDTO> selectAll(MemberDTO memberDTO){
		return datas;
	}
	public MemberDTO selectOne(MemberDTO memberDTO){
		if(memberDTO.getSearchCondition().equals("ID중복검사")) {
			boolean flag=false;
			int i;
			for(i=0;i<this.datas.size();i++) {
				if(this.datas.get(i).getMid().equals(memberDTO.getMid())) {
					flag=true;
					break;
				}
			}
			if(!flag) {
				return null;
			}
			MemberDTO data=new MemberDTO();
			data.setMid(this.datas.get(i).getMid());
			data.setMpw(this.datas.get(i).getMpw());
			data.setName(this.datas.get(i).getName());
			return data; // data를 new하는 이유? 원본이 변경되는것을 막기위함!
		}
		else if(memberDTO.getSearchCondition().equals("로그인")) {
			boolean flag=false;
			int i;
			for(i=0;i<this.datas.size();i++) {
				if(this.datas.get(i).getMid().equals(memberDTO.getMid()) && this.datas.get(i).getMpw().equals(memberDTO.getMpw())) {
					flag=true;
					break;
				}
			}
			if(!flag) {
				return null;
			}
			MemberDTO data=new MemberDTO();
			data.setMid(this.datas.get(i).getMid());
			data.setMpw(this.datas.get(i).getMpw());
			data.setName(this.datas.get(i).getName());
			return data;
		}
		return null;
	}
	// 만약, null이 반환되면 ID가 중복되지않음!
	// null이 아닌것이 반환되면 회원이 있는것이므로 회원가입 불가능...

	public boolean insert(MemberDTO memberDTO) {
		try {
			MemberDTO data=new MemberDTO();
			data.setMid(memberDTO.getMid());
			data.setMpw(memberDTO.getMpw());
			data.setName(memberDTO.getName());
			this.datas.add(data);
		}catch(Exception e) {
			System.out.println("[로그] 알수없는 이슈발생!");
			return false;
		}
		return true;
	}
	public boolean update(MemberDTO memberDTO) {
		boolean flag=false;
		int i;
		for(i=0;i<this.datas.size();i++) {
			if(this.datas.get(i).getMid().equals(memberDTO.getMid())) {
				flag=true;
				break;
			}
		}
		if(!flag) {
			return false;
		}
		this.datas.get(i).setMpw(memberDTO.getMpw());
		return true;
	}
	public boolean delete(MemberDTO memberDTO) {
		boolean flag=false;
		int i;
		for(i=0;i<this.datas.size();i++) {
			if(this.datas.get(i).getMid().equals(memberDTO.getMid())) {
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
