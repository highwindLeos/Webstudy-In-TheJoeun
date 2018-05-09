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
		setJob(new JobLec()); // interface 로 구현된 클래스를 객체로 생성해서 그형의 변수의 값으로 넣는다.
		setPay(new GetSalary());
	}

	@Override
	public void print() {
		System.out.println("[ID] : " + getId() + "\t [이름] : " + getName() + "\t [과목] : " + course);
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

}
