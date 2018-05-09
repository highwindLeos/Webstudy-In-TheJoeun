package com.tj.ex11person;

public class Staff extends Person {
	
	private String department;
	
	public Staff() {
		
	}
	
	public Staff(String id, String name, String department) {
		super(id,name); // 부모 생성자.
		setDepartment(department);
	}
	
	// 사용자 함수 (오버라이딩)
	@Override
	public void print() {
		System.out.println("ID : "+ super.getId() + " (이름) : "+ super.getName() + " (소속) : "+ department );
	}
	
	// get set
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	



	
	
	

}
