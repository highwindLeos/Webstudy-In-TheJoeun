package com.tj.ex6supermarket;

public class Goods {
	private String gCode;
	private String gName;
	private int stock;
	private int price;
	
	public Goods() {}

	public Goods(String gCode, String gName, int stock, int price) {
		this.gCode = gCode;
		this.gName = gName;
		this.stock = stock;
		this.price = price;
	}

	public int stockCheck(int su) throws Exception {
		if(stock - su < 0) {
			throw new Exception("예외 메세지 : 재고량이 부족합니다. 관리자님 확인 요망.");
		}
		
		return stock - su; //재고수량 - 살수량(su) = 바뀔 재고량 반환.
	}
	
	@Override
	public String toString() {
		return "[상품코드] " + gCode + " [상품명] " + gName + " [재고수량] " + stock + " [구매가]" + price;
	}

	// setter getter
	public String getgCode() {
		return gCode;
	}


	public void setgCode(String gCode) {
		this.gCode = gCode;
	}


	public String getgName() {
		return gName;
	}


	public void setgName(String gName) {
		this.gName = gName;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
