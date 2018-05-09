package com.tj.ex07child;

public class LunchMain {

	public static void main(String[] args) {

		Child1 ch1 = new Child1(MenuPrice.RICE, MenuPrice.BULGOGI, MenuPrice.SOUP, 
				MenuPrice.BANANA, MenuPrice.MILK, MenuPrice.ALMONDE);

		System.out.println(ch1.getType() + ch1.calculatePrice() + "��");

		Child2 ch2 = new Child2(MenuPrice.RICE, MenuPrice.BULGOGI, MenuPrice.SOUP,
				MenuPrice.BANANA, MenuPrice.MILK, MenuPrice.ALMONDE);

		System.out.println(ch2.getType() + ch2.calculatePrice() + "��");
		//Child1 ,Child2 Ÿ���� �θ� Ÿ���� LunchMenu Ÿ�Ե� ����. 
		LunchMenu[] chilren = { ch1, ch2 };

		for (LunchMenu ch : chilren) {
			System.out.println(ch.getType() + ch.calculatePrice() + "��");
		}
	}

}
