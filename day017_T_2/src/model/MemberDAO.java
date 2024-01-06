package model;

import java.util.ArrayList;

public class MemberDAO {
	private ArrayList<MemberDTO> mdatas;
	public MemberDAO() {
		mdatas=new ArrayList<MemberDTO>();
	}
	
	// ※ 사용하지않는 DAO의 CRUD(비즈니스 메서드,핵심 관심,핵심 로직)는
	//    private으로 은닉했습니다.
	
	private ArrayList<MemberDTO> selectAll(MemberDTO mDTO) {
		return null;
	}
	public MemberDTO selectOne(MemberDTO mDTO) {
		// 로그인
		// ID 중복 검사
		return null;
	}
	public boolean insert(MemberDTO mDTO) {
		// 회원가입
		return false;
	}
	public boolean update(MemberDTO mDTO) {
		// 비밀번호변경
		return false;
	}
	public boolean delete(MemberDTO mDTO) {
		// 회원탈퇴
		return false;
	}
}
