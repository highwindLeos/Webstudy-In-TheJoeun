package com.tj.ex07static;

public class Child {

	private MomPouch momPouch;
	String sun;

	public Child(String sun) {
		momPouch = new MomPouch();
		this.sun = sun;
	}

	public void takeMoney(int money) {
		if (momPouch.money >= money) {
			// 그 객체.
			System.out.println(sun + "이 " + money + "원 받음");
			momPouch.money = momPouch.money - money;
		} else {
			System.out.println(sun + "이 돈을 못 받음");
		}
	}

}
