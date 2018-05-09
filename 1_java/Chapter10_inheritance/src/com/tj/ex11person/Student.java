package com.tj.ex11person;

public class Student extends Person {
	
	private String ban;
	
	public Student() {
		
	}
	
	public Student(String id, String name, String ban) {
		super(id,name); // 부모 생성자.
		setBan(ban);
	}
	
	// 사용자 함수 (오버라이딩)
	@Override
	public void print() {
		System.out.println("ID : "+ super.getId() + " (이름) : "+ super.getName() + " (반) : "+ ban );
	}
	
	// get set

	public String getBan() {
		return ban;
	}

	public void setBan(String ban) {
		this.ban = ban;
	}
	
	
	

}
