package com.tj.ex11person;

public class Person {
	
	private String id;
	private String name;
	//������
	public Person() {
		
	}
	public Person(String id, String name) {
		this.id = id;
		this.name = name;
	}
	// ����� �Լ�
	public void print() {
		System.out.println("ID :"+id+" �̸� : "+name);
	}
	
	// get set
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
