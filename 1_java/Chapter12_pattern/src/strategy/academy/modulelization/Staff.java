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
		setJob(new JobMng()); // interface �� ������ Ŭ������ ��ü�� �����ؼ� ������ ������ ������ �ִ´�.
		setPay(new GetSalary());
	}
	
	@Override
	public void print() {
		System.out.println("[ID] : " + getId() + "\t [�̸�] : " + getName() + "\t [�μ�] : " + department);
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}


	
}
