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
		return null;
	}
	// 만약, null이 반환되면 ID가 중복되지않음!
	// null이 아닌것이 반환되면 회원이 있는것이므로 회원가입 불가능...
	
	public boolean insert(MemberDTO memberDTO) {
		return false;
	}
	public boolean update(MemberDTO memberDTO) {
		return false;
	}
	public boolean delete(MemberDTO memberDTO) {
		return false;
	}
}
