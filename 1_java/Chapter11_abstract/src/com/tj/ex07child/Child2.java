package com.tj.ex07child;

public class Child2 extends LunchMenu {
	private String type;

	public Child2(int rice, int bulgogi, int soup, int banana, int milk, int almonde) {
		// new Child1(300,1000,200,200,500,100)
		super(rice, bulgogi, soup, banana, milk, almonde);
		type = "Child 2형 식대 계산 ";
	}

	@Override
	public int calculatePrice() {
		int resulte = getRice() + getBulgogi() + getSoup() + getMilk() + getAlmonde();
		return resulte;
	}

	@Override
	public String getType() {
		return type;
	}

}
