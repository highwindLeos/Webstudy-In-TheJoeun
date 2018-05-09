package com.tj.ex04job;

public class Actor implements FireFighter, PoliceMan, Chef {
	private String name;

	public Actor() {
	}

	public Actor(String name) {
		this.name = name;
	}

	@Override
	public void canCatchCriminal() {
		System.out.println(name + "��(��) ������ ����ϴ�.");
	}

	@Override
	public void canSerach() {
		System.out.println(name + "��(��) ������ ã���ϴ�.");
	}

	@Override
	public void outFire() {
		System.out.println(name + "��(��) ���� ���ϴ�.");
	}

	@Override
	public void saveMan() {
		System.out.println(name + "��(��) ����� ���մϴ�.");
	}

	@Override
	public void makePizza() {
		System.out.println(name + "��(��) ���ڸ� ���� �� �ֽ��ϴ�.");

	}

	@Override
	public void makeSpaghetti() {
		System.out.println(name + "��(��) ���İ�Ƽ�� ���� �� �ֽ��ϴ�.");
	}

}
