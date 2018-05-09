package com.tj.ex11person;

public class Staff extends Person {
	
	private String department;
	
	public Staff() {
		
	}
	
	public Staff(String id, String name, String department) {
		super(id,name); // �θ� ������.
		setDepartment(department);
	}
	
	// ����� �Լ� (�������̵�)
	@Override
	public void print() {
		System.out.println("ID : "+ super.getId() + " (�̸�) : "+ super.getName() + " (�Ҽ�) : "+ department );
	}
	
	// get set
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	



	
	
	

}
