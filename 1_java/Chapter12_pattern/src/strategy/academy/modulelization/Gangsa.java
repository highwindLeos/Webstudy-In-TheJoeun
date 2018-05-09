package strategy.academy.modulelization;

import strategy.academy.inter.GetSalary;
import strategy.academy.inter.GetStudentPay;
import strategy.academy.inter.JobLec;

public class Gangsa extends Person {
	private String course;

	public Gangsa(String id, String name, String course) {
		setId(id);
		setName(name);
		this.course = course;
		setJob(new JobLec()); // interface �� ������ Ŭ������ ��ü�� �����ؼ� ������ ������ ������ �ִ´�.
		setPay(new GetSalary());
	}

	@Override
	public void print() {
		System.out.println("[ID] : " + getId() + "\t [�̸�] : " + getName() + "\t [����] : " + course);
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

}
