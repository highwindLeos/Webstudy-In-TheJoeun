package com.tj.ex07child;

public class LunchMain {

	public static void main(String[] args) {

		Child1 ch1 = new Child1(MenuPrice.RICE, MenuPrice.BULGOGI, MenuPrice.SOUP, 
				MenuPrice.BANANA, MenuPrice.MILK, MenuPrice.ALMONDE);

		System.out.println(ch1.getType() + ch1.calculatePrice() + "원");

		Child2 ch2 = new Child2(MenuPrice.RICE, MenuPrice.BULGOGI, MenuPrice.SOUP,
				MenuPrice.BANANA, MenuPrice.MILK, MenuPrice.ALMONDE);

		System.out.println(ch2.getType() + ch2.calculatePrice() + "원");
		//Child1 ,Child2 타입은 부모 타입인 LunchMenu 타입도 가능. 
		LunchMenu[] chilren = { ch1, ch2 };

		for (LunchMenu ch : chilren) {
			System.out.println(ch.getType() + ch.calculatePrice() + "원");
		}
	}

}
