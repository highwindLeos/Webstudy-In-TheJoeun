package strategy.academy.modulelization;

import strategy.academy.inter.GetSalary;
import strategy.academy.inter.JobMng;

public class Staff extends Person {
	private String department;
	
	public Staff() {}

	public Staff(String id, String name,String department) {
		setId(id);
		setName(name);
		this.department = department;
		setJob(new JobMng()); // interface 로 구현된 클래스를 객체로 생성해서 그형의 변수의 값으로 넣는다.
		setPay(new GetSalary());
	}
	
	@Override
	public void print() {
		System.out.println("[ID] : " + getId() + "\t [이름] : " + getName() + "\t [부서] : " + department);
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}


	
}
