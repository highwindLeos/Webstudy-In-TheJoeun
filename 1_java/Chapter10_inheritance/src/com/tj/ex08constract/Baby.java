package com.tj.ex08constract;

public class Baby extends Person {
	
	public Baby(String name, String character) {
		super(name, character); // 부모 생성자를 호출한다. 해당 코드는 항상 최상단에 명령해야함.
		super.intro(); //
		System.out.println("test");
//		setName(name);
//		setCharacter(character);
	}

	public void cry() {
		System.out.println("우어어어");
	}

	@Override
	public void intro() {
		System.out.println(getName() + "는 아기라서 말 못해");
		System.out.println("성격은 " + getCharacter());
	}

}
