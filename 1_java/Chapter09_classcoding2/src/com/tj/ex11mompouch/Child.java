package com.tj.ex11mompouch;

public class Child {
	private String sun;

	// ������. ������ �ʱ�ȭ �� �ַ� ����.
	public Child(String sun) {
		this.sun = sun;
	}
	// ����� �Լ�.
	public void takeMoney(int money) {
		if (MomPouch.MONEY >= money) { // �ڽ��� ����� �䱸�ϴ� ���� ���������� ������ ���ų� �۾ƾ� ���.
			System.out.println(sun + "�� " + money + "�� �޾Ҿ��.");
			// Mompouch.MONEY = Mompouch.MONEY - money;
			MomPouch.MONEY -= money;
		} else {
			System.out.println(sun + "�� �� �� �޾Ҿ��. ���� ������ ���� ����.");
		}
	}

}
