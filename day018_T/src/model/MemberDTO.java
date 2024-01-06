package model;

public class MemberDTO {
	
	private String mid; // PK
	private String mpw;
	private String name;
	private String grade;
	
	private String searchCondition;
	
	public String getSearchCondition() {
		
		return searchCondition;
		
	}
	
	public void setSearchCondition(String searchCondition) {
		
		this.searchCondition = searchCondition;
		
	}
	
	public String getMid() {
		
		return mid;
		
	}
	
	public void setMid(String mid) {
		
		this.mid = mid;
		
	}
	
	public String getMpw() {
		
		return mpw;
		
	}
	
	public void setMpw(String mpw) {
		
		this.mpw = mpw;
		
	}
	
	public String getName() {
		
		return name;
		
	}
	
	public void setName(String name) {
		
		this.name = name;
		
	}
	
	public String getGrade() {
		
		return grade;
		
	}
	
	public void setGrade(String grade) {
		
		this.grade = grade;
		
	}
	
	@Override
	public String toString() {
		
		return "MemberDTO [mid=" + mid + ", mpw=" + mpw + ", name=" + name + ", grade=" + grade + "]";
		
	}
	
}