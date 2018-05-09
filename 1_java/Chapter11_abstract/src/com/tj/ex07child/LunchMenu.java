package com.tj.ex07child;

public abstract class LunchMenu {
	private int rice; // �� ����
	private int bulgogi;// �Ұ�� ����
	private int soup; // �� ����

	private int banana; // �ٳ��� ����
	private int milk; // ���� ����
	private int almonde; // �Ƹ�� ����

	public LunchMenu() {}

	public LunchMenu(int rice, int bulgogi, int soup, int banana, int milk, int almonde) {
		this.rice = rice;
		this.bulgogi = bulgogi;
		this.soup = soup;
		this.banana = banana;
		this.milk = milk;
		this.almonde = almonde;
	}// 6���� ���� ���ڷ� �޴� ������ �޼ҵ�. (��簪�� ��ü������ �޾Ƽ� �ʱ�ȭ)

	// �߻� Ŭ����
	public abstract int calculatePrice(); // ���ĺ� ��� �޼ҵ�
	public abstract String getType();

	// setter getter
	public int getRice() {
		return rice;
	}

	public void setRice(int rice) {
		this.rice = rice;
	}

	public int getBulgogi() {
		return bulgogi;
	}

	public void setBulgogi(int bulgogi) {
		this.bulgogi = bulgogi;
	}

	public int getSoup() {
		return soup;
	}

	public void setSoup(int soup) {
		this.soup = soup;
	}

	public int getBanana() {
		return banana;
	}

	public void setBanana(int banana) {
		this.banana = banana;
	}

	public int getMilk() {
		return milk;
	}

	public void setMilk(int milk) {
		this.milk = milk;
	}

	public int getAlmonde() {
		return almonde;
	}

	public void setAlmonde(int almonde) {
		this.almonde = almonde;
	} 

}
