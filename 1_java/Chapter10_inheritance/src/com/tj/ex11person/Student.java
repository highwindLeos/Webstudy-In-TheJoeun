package com.tj.ex11person;

public class Student extends Person {
	
	private String ban;
	
	public Student() {
		
	}
	
	public Student(String id, String name, String ban) {
		super(id,name); // �θ� ������.
		setBan(ban);
	}
	
	// ����� �Լ� (�������̵�)
	@Override
	public void print() {
		System.out.println("ID : "+ super.getId() + " (�̸�) : "+ super.getName() + " (��) : "+ ban );
	}
	
	// get set

	public String getBan() {
		return ban;
	}

	public void setBan(String ban) {
		this.ban = ban;
	}
	
	
	

}
