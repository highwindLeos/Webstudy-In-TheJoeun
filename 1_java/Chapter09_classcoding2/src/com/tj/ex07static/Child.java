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
			// �� ��ü.
			System.out.println(sun + "�� " + money + "�� ����");
			momPouch.money = momPouch.money - money;
		} else {
			System.out.println(sun + "�� ���� �� ����");
		}
	}

}
