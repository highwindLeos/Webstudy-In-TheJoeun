package com.tj.ex05tostring;

//데이터 : 코드(gCode), 이름(gName), 재고수량(stock), 가격(price)
// new Goods("a001","새우깡",10,1200);
// sell("a001","0703","2") // 구매기능 : 상품코드 , 회원연락처, 구매수량
public class Goods {

	private String gCord;
	private String gName;
	private int stock;
	private int price;

	public Goods(String gCord, String gName, int stock, int price) {
		this.gCord = gCord;
		this.gName = gName;
		this.stock = stock;
		this.price = price;
	} // 상품을 생성할때 모든 데이터를 초기화 (4개)

	@Override
	public String toString() { // 새우깡(a01) 1200원 재고 1개 같은 형식으로 반환
		String resulte;
		resulte = gName + "(" + gCord + ")" + price + "원 재고" + stock + "개";

		return resulte;
	}

}
