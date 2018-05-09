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
		System.out.println(name + "은(는) 범인을 잡습니다.");
	}

	@Override
	public void canSerach() {
		System.out.println(name + "은(는) 범인을 찾습니다.");
	}

	@Override
	public void outFire() {
		System.out.println(name + "은(는) 불을 끕니다.");
	}

	@Override
	public void saveMan() {
		System.out.println(name + "은(는) 사람을 구합니다.");
	}

	@Override
	public void makePizza() {
		System.out.println(name + "은(는) 피자를 만들 수 있습니다.");

	}

	@Override
	public void makeSpaghetti() {
		System.out.println(name + "은(는) 스파게티를 만들 수 있습니다.");
	}

}
