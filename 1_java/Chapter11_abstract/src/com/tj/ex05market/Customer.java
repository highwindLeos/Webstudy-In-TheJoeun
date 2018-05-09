package com.tj.ex05market;

public class Customer {
	private String name; // �̸�
	private String phoneNum;// ȸ������ó
	private int buyingPoint;// �����Ѿ�
	private int point; // ����Ʈ

	// ������ : Customer c = new Customer("ȫ�浿","010-0000-0000");
	// public Customer () {}

	public Customer(String name, String phoneNum) {
		this.name = name;
		this.phoneNum = phoneNum;
		buyingPoint = 0; // ���� ������
		point = 1000; // ȸ�����Խ� �⺻ ����Ʈ.
	}

	// method 
	
	public void phoneChange(String phoneNum) {
		System.out.print(name + "�� ����ó�� " + this.phoneNum);
		System.out.println("���� " + phoneNum + "�� ����Ǿ����ϴ�.");
		this.phoneNum = phoneNum;
	}// phoneChange();

	public void buy(int price) {
		double pointpercent = 0.05;

		if (price <= 0) { // ������ 0���� �۰ų� ���ٸ� (������ ������ ������� true)
			System.out.println("���� �ݾ��� ��ȿ���� �ʽ��ϴ�.");
			return;
		} else {
			buyingPoint += price;
			point += (int)price * pointpercent;
			System.out.println(name + "�� ���ſ� ����帳�ϴ�. * ");
			System.out.println("���ž� : " + price);
			System.out.println("���� �� ����Ʈ : " + price * pointpercent);
			System.out.println("�� ����Ʈ : " + point);
			System.out.println(name + "�� �� ������. * ");
			System.out.println();
		} // if

	}// buy()
	
	public String outString() {
		String resulte = "";
		resulte += "�̸� : " + name;
		resulte += "\n����ó : " + phoneNum;
		resulte += "\n�������űݾ� : " + buyingPoint;
		resulte += "\n����Ʈ : " + point;
		// ����� ���ڸ� ��� ���ؼ� ���ڿ��� ���� ���´�.
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
