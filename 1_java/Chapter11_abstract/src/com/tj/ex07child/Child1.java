package com.tj.ex07child;

public class Child1 extends LunchMenu {
	private String type;

	public Child1(int rice, int bulgogi, int soup, int banana, int milk, int almonde) {
		// new Child1(1000,500,200,200,600,100)
		super(rice, bulgogi, soup, banana, milk, almonde);
		type = "Child 1형 식대 계산 ";
	}

	@Override
	public int calculatePrice() { // rice + bulgogi + soup + banana
		int resulte = getRice() + getBulgogi() + getSoup() + getBanana();
		return resulte;
	}

	@Override
	public String getType() {
		return type;
	}

}
