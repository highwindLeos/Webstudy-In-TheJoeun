package com.tj.ex07;

public class Person {
	private String name;
	private String character;
	
	public void intro() {
		System.out.println(name + "Àº " + character);
	}
	// getter setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}
	
	
}
