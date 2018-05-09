package com.tj.ex11person;

public class Gangsa extends Person {
	
	private String subject;
	
	public Gangsa() {
		
	}
	
	public Gangsa(String id, String name, String subject) {
		super(id,name); // 부모 생성자.
		setSubject(subject);
	}
	
	// 사용자 함수 (오버라이딩)
	@Override
	public void print() {
		System.out.println("ID : "+ super.getId() + " (이름) : "+ super.getName() + " (과목) : "+ subject );
	}

	// get set
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	


	
	

}
