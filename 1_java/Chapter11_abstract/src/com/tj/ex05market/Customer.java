package com.tj.ex05market;

public class Customer {
	private String name; // 이름
	private String phoneNum;// 회원연락처
	private int buyingPoint;// 구매총액
	private int point; // 포인트

	// 생성자 : Customer c = new Customer("홍길동","010-0000-0000");
	// public Customer () {}

	public Customer(String name, String phoneNum) {
		this.name = name;
		this.phoneNum = phoneNum;
		buyingPoint = 0; // 구매 누적액
		point = 1000; // 회원가입시 기본 포인트.
	}

	// method 
	
	public void phoneChange(String phoneNum) {
		System.out.print(name + "님 연락처가 " + this.phoneNum);
		System.out.println("에서 " + phoneNum + "로 변경되었습니다.");
		this.phoneNum = phoneNum;
	}// phoneChange();

	public void buy(int price) {
		double pointpercent = 0.05;

		if (price <= 0) { // 가격이 0보다 작거나 같다면 (음수나 가격이 없을경우 true)
			System.out.println("구매 금액이 유효하지 않습니다.");
			return;
		} else {
			buyingPoint += price;
			point += (int)price * pointpercent;
			System.out.println(name + "님 구매에 감사드립니다. * ");
			System.out.println("구매액 : " + price);
			System.out.println("누적 될 포인트 : " + price * pointpercent);
			System.out.println("총 포인트 : " + point);
			System.out.println(name + "님 또 오세요. * ");
			System.out.println();
		} // if

	}// buy()
	
	public String outString() {
		String resulte = "";
		resulte += "이름 : " + name;
		resulte += "\n연락처 : " + phoneNum;
		resulte += "\n누적구매금액 : " + buyingPoint;
		resulte += "\n포인트 : " + point;
		// 출력한 문자를 계속 더해서 문자열에 더해 놓는다.
		return resulte;
	}

	// getter setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public int getBuyingPoint() {
		return buyingPoint;
	}

	public void setBuyingPoint(int buyingPoint) {
		this.buyingPoint = buyingPoint;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

}
