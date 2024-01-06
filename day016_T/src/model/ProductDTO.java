package model;

public class ProductDTO {

	private int num; // PK
	private String name;
	private int price;
	private int cnt;
	
	private String searchConditon; // JAVA 로직에서만 사용하는 변수
	private int addCnt;
	
	// 웹 개발에서는,
	// 기본 생성자를 사용하는 것을 원칙으로 한다!!!!!
	//  : new할때 생성자의 인자로 넣는 값중에서,
	//    어떤 값이 정말 유효한 값인지 파악하는 시간을 줄이기위함!

	public int getAddCnt() {
		return addCnt;
	}
	public void setAddCnt(int addCnt) {
		this.addCnt = addCnt;
	}
	public String getSearchConditon() {
		return searchConditon;
	}
	public void setSearchConditon(String searchConditon) {
		this.searchConditon = searchConditon;
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
		if(this.cnt<=0) {
			return this.num+"번 상품 품절";
		}
		return "ProductDTO [num=" + num + ", name=" + name + ", price=" + price + ", cnt=" + cnt + "]";
	}
	
}
