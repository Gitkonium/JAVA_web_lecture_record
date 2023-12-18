package model;

import java.util.ArrayList;

public class MemberDAO {
	
	private ArrayList<MemberDTO> mdatas; // 유저 데이터가 들어가는 배열리스트

	public MemberDAO() { // 생성자
		
		mdatas = new ArrayList<MemberDTO>();

		MemberDTO sample01 = new MemberDTO(); // 유저샘플1 
		sample01.setMid("admin");
		sample01.setMpw("1234");
		sample01.setName("관리자");
		sample01.setGrade("ADMIN"); 
		
		mdatas.add(sample01);

		MemberDTO sample02 = new MemberDTO(); // 유저샘플2
		sample02.setMid("teemo");
		sample02.setMpw("1234");
		sample02.setName("작은티모");
		sample02.setGrade("USER");
		
		mdatas.add(sample02);
	}
	
	//==========================================================================================

	// ※ 사용하지않는 DAO의 CRUD(비즈니스 메서드,핵심 관심,핵심 로직)는
	// private으로 은닉했습니다.

	private ArrayList<MemberDTO> selectAll(MemberDTO mDTO) { // 모든 데이터를 가져오는 로직

		// 유저데이터의 경우 전체 출력할 필요가 없기에 기능이 부재
		
		return null; // null을 반환

	}
	
	//==========================================================================================

	public MemberDTO selectOne(MemberDTO mDTO) { // 단일 데이터를 가져오는 로직

		if (mDTO.getSearchCondition().equals("로그인")) { // 검색상태가 "로그인"일 경우

			boolean flag = false; // 검색 실패 성공 플래그

			int i; // 인덱스 번호 저장 변수 i

			for (i = 0; i < mdatas.size(); i++) { // 유저데이터의 갯수만큼 반복

				if (mdatas.get(i).getMid().equals(mDTO.getMid())) { // 입력 아이디가 유저데이터와 일치한다면

					System.out.println("[로그] ID 일치"); // 일치 메세지 출력

					if (mdatas.get(i).getMpw().equals(mDTO.getMpw())) { // 입력 비밀번호가 유저데이터와 일치한다면
						
						System.out.println("[로그] PW 일치"); // 일치 메세지 출력

						flag = true; // 아이디와 비밀번호가 일치하기에 플래그를 true로 변경

						break; // for문 탈출 

					} 

				} 

			}

			if (!flag) { // 플래그가 false라면

				return null; // null을 반환

			}

			return mdatas.get(i); // 일치하는 유저 데이터 반환

		} else { // ID중복검사
			
			boolean flag = false; // 중복되는지 어떤지 확인하는 플래그
			
			int i; // 인덱스 번호 저장 변수 i
			
			for (i = 0; i < mdatas.size(); i++) { // 유저 데이터 수만큼 반복
				
				if (mdatas.get(i).getMid().equals(mDTO.getMid())) { // 입력한 아이디가 유저데이터 중에 존재한다면
					
					System.out.println("[로그] ID 일치"); // 일치 메세지 출력
					
					flag = true; // 플래그랠 true로 변경
					
					break; // for문 탈출
					
				}
				
			}
			
			if (!flag) { // 플래그가 false라면
				
				return null; // null을 반환
				
			}
			
			return mdatas.get(i); // 일치하는 데이터를 반환
			
		}
		
	}
	
	//==========================================================================================

	public boolean insert(MemberDTO mDTO) { // 유저 데이터 추가 로직
		
		try { 
			
			MemberDTO data = new MemberDTO(); // 새로운 객체생성
			data.setMid(mDTO.getMid()); // 인자로 받은 아이디를 객체에 저장
			data.setMpw(mDTO.getMpw()); // 인자로 받은 비밀번호를 객체에 저장
			data.setName(mDTO.getName()); // 인자로 받은 이름을 객체에 저장
			data.setGrade(mDTO.getGrade()); // 인자로 받은 등급을 객체에 저장
		
			mdatas.add(data); // 객체를 배열리스트에 저장
			
		} catch (Exception e) {
			
			System.out.println("[로그] memberDAO.insert()에서 예외발생!");
			
			return false; // 어떤 문제로 데이터 추가에 실패 했을 경우 false를 반환
			
		}
		
		return true; // 추가에 성공 했을 경우 ture를 반환
	}

	//==========================================================================================
	
	public boolean update(MemberDTO mDTO) { // 유저 데이터에 변경 점이 있을 때 사용하는 로직
		
		boolean flag = false; // 변경 실패 성공을 확인하기 위한 플래그
		
		int i; // 인덱스 번호 저장 변수 i
		
		for (i = 0; i < mdatas.size(); i++) { // 유저 데이터 수만큼 반복
			
			if (mdatas.get(i).getMid().equals(mDTO.getMid())) { // 입력한 아이디가 유저데이터 중에 존재한다면
				
				flag = true; // 플래그를 true로 변경
				
				break; // for문 탈출
				
			}
			
		}
		
		if (!flag) { // 플래그가 flase라면
			
			return false; // false를 반환
			
		}
		
		mdatas.get(i).setMpw(mDTO.getMpw()); // 기존 비밀번호를 인자의 비밀번호로 교체
		
		return true; // true를 리턴
		
	}
	
	//==========================================================================================

	public boolean delete(MemberDTO mDTO) { // 유저데이터를 삭제할 때 사용하는 로직
		
		boolean flag = false; // 삭제 실패 성공을 확인하기 위한 플래그
		
		int i; // 인덱스 번호 저장 변수 i
		
		for (i = 0; i < mdatas.size(); i++) { // 유저 데이터 수 만큼 반복
			
			if (mdatas.get(i).getMid().equals(mDTO.getMid())) { // 입력한 아이디가 유저데이터 중에 존재한다면
				
				flag = true; // 플래그를 true로 변경
				
				break; // for문 탈출
				
			}
			
		}
		
		if (!flag) { // 플래그가 flase라면
			
			return false; // false를 반환
			
		}
		
		mdatas.remove(i); // 지정 유저 데이터를 삭제
		
		return true; // true를 반환
		
	}
	
}
