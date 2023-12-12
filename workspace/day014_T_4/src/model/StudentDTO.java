package model;

public class StudentDTO {
	private int num; // PK
	private String name;
	private int score;
	
	private String searchCondition; // 검색조건을 확인하기위한 용도
	// "학생 데이터"와는 무관하기때문에,
	// 생성자에서 초기화 xxx
	
	public StudentDTO(int num,String name,int score) {
		this.num=num;
		this.name=name;
		this.score=score;
	}
	
	public String getSearchCondition() {
		return searchCondition;
	}
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "StudentDTO [num=" + num + ", name=" + name + ", score=" + score + ", searchCondition=" + searchCondition
				+ "]";
	}
}
