package com.tj.ex07;

public class Baby extends Person {

	public void cry() {
		System.out.println("우어어어");
	}

	@Override
	public void intro() {
		System.out.println(getName() + "는 아기라서 말 못해");
		System.out.println("성격은 " + getCharacter());
	}

}
