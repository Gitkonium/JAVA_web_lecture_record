package model;

public class ProductDTO {
	private int pid;
	private String name;
	private int price;
	private int cnt;

	private int minPrice; // JAVA 로직에서만 사용할 멤버변수
	private int maxPrice;
	private String searchCondition;
	private int addCnt;

	public int getAddCnt() {
		
		return addCnt;
		
	}
	
	public void setAddCnt(int addCnt) {
		
		this.addCnt = addCnt;
		
	}
	
	public String getSearchCondition() {
		
		return searchCondition;
		
	}
	
	public void setSearchCondition(String searchCondition) {
		
		this.searchCondition = searchCondition;
		
	}
	
	public int getMinPrice() {
		
		return minPrice;
		
	}
	
	public void setMinPrice(int minPrice) {
		
		this.minPrice = minPrice;
		
	}
	
	public int getMaxPrice() {
		
		return maxPrice;
		
	}
	
	public void setMaxPrice(int maxPrice) {
		
		this.maxPrice = maxPrice;
		
	}

	public int getPid() {
		
		return pid;
		
	}
	
	public void setPid(int pid) {
		
		this.pid = pid;
		
	}
	
	public String getName() {
		
		return name;
		
	}
	
	public void setName(String name) {
		
		this.name = name;
		
	}
	
	public int getPrice() {
		
		return price;
		
	}
	
	public void setPrice(int price) {
		
		this.price = price;
		
	}
	
	public int getCnt() {
		
		return cnt;
		
	}
	
	public void setCnt(int cnt) {
		
		this.cnt = cnt;
		
	}
	
	@Override
	public String toString() {
		
		return "ProductDTO [pid=" + pid + ", name=" + name + ", price=" + price + ", cnt=" + cnt + "]";
		
	}
	
}