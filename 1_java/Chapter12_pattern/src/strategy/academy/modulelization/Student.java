package strategy.academy.modulelization;

import strategy.academy.inter.GetStudentPay;
import strategy.academy.inter.JobStudy;

public class Student extends Person {
	private String ban;
	
	public Student(String id, String name,String ban) {
		setId(id);
		setName(name);
		this.ban = ban;
		setJob(new JobStudy());
		setPay(new GetStudentPay());
	}

	@Override
	public void print() {
		System.out.println("[ID] : " + getId() + "\t [¿Ã∏ß] : " + getName() + "\t [π›] : " + ban);
	}

	public String getBan() {
		return ban;
	}

	public void setBan(String ban) {
		this.ban = ban;
	}
	
	
}
