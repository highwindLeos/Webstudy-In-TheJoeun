package com.tj.ex08constract;

public class Person {
	private String name;
	private String character;
	
	public Person() {
		System.out.println("인자 없는 부모 생성자 호출되었습니다.");
	} // 이 클래스를 상속한다면 기본 생성자가 있어야 한다. Person p = new Person();
	
	public Person(String name, String character) {
		this.name = name;
		this.character = character;
	}
	
	public void intro() {
		System.out.println(name + "은 " + character);
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
