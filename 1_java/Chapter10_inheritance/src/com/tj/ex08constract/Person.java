package com.tj.ex08constract;

public class Person {
	private String name;
	private String character;
	
	public Person() {
		System.out.println("���� ���� �θ� ������ ȣ��Ǿ����ϴ�.");
	} // �� Ŭ������ ����Ѵٸ� �⺻ �����ڰ� �־�� �Ѵ�. Person p = new Person();
	
	public Person(String name, String character) {
		this.name = name;
		this.character = character;
	}
	
	public void intro() {
		System.out.println(name + "�� " + character);
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
