package com.tj.ex11person;

public class Person {
	
	private String id;
	private String name;
	//생성자
	public Person() {
		
	}
	public Person(String id, String name) {
		this.id = id;
		this.name = name;
	}
	// 사용자 함수
	public void print() {
		System.out.println("ID :"+id+" 이름 : "+name);
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
