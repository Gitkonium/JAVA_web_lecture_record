package team;

public class Item {
	private int num;
	private String name;
	private int price;
	private int stock;

	public Item(int PK, String name, int price) {
		this.num = PK;
		this.name = name;
		this.price = price;
		this.stock += 5;
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

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public void sell() {
		this.stock -= 1;
	}

	@Override
	public String toString() {
//		return "제품No : " + num + "\n제품이름 : " + name + "\n가격 : " + price + "원" + "\n재고수량 : " + stock + "\n";
		if (this.getStock() <= 0) {
			return "▶ 제품No : " + num + "\n▶ 제품이름 : " + name + "\n▶ 가격 : " + price + "원" + "\n▶ 재고수량 : " + "재고없음\n";
		} else {
			return "▶ 제품No : " + num + "\n▶ 제품이름 : " + name + "\n▶ 가격 : " + price + "원" + "\n▶ 재고수량 : " + stock + "\n";
		}
	}

	// sell 구매하기

	//

}
