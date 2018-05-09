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
			throw new Exception("���� �޼��� : ����� �����մϴ�. �����ڴ� Ȯ�� ���.");
		}
		
		return stock - su; //������ - �����(su) = �ٲ� ��� ��ȯ.
	}
	
	@Override
	public String toString() {
		return "[��ǰ�ڵ�] " + gCode + " [��ǰ��] " + gName + " [������] " + stock + " [���Ű�]" + price;
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
