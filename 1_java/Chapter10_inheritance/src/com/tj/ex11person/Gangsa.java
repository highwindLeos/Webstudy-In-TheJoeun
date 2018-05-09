package com.tj.ex11person;

public class Gangsa extends Person {
	
	private String subject;
	
	public Gangsa() {
		
	}
	
	public Gangsa(String id, String name, String subject) {
		super(id,name); // �θ� ������.
		setSubject(subject);
	}
	
	// ����� �Լ� (�������̵�)
	@Override
	public void print() {
		System.out.println("ID : "+ super.getId() + " (�̸�) : "+ super.getName() + " (����) : "+ subject );
	}

	// get set
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	


	
	

}
