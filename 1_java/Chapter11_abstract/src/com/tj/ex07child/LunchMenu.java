package com.tj.ex07child;

public abstract class LunchMenu {
	private int rice; // 밥 가격
	private int bulgogi;// 불고기 가격
	private int soup; // 국 가격

	private int banana; // 바나나 가격
	private int milk; // 우유 가격
	private int almonde; // 아몬드 가격

	public LunchMenu() {}

	public LunchMenu(int rice, int bulgogi, int soup, int banana, int milk, int almonde) {
		this.rice = rice;
		this.bulgogi = bulgogi;
		this.soup = soup;
		this.banana = banana;
		this.milk = milk;
		this.almonde = almonde;
	}// 6개의 값을 인자로 받는 생성자 메소드. (모든값을 객체생성때 받아서 초기화)

	// 추상 클래스
	public abstract int calculatePrice(); // 간식비 계산 메소드
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
