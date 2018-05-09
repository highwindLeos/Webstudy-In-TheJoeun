package strategy.academy.modulelization;

import strategy.academy.inter.IJob;
import strategy.academy.inter.IPay;

public abstract class Person {
	private String id;
	private String name;
	// interface �� ������ ������
	private IJob job; 
	private IPay pay;

	public Person() { }

	public Person(String id, String name) {
		 this.id = id;
		 this.name = name;
	 }
	
	public void job(){
		job.job();
	}
	
	public void pay() {
		pay.pay();
	}
	
	public void print() {
		System.out.println("ID : "+ id + "\t �̸� : "+name);
	}

	// getter setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	// �������̽��� ������� ���� ���� �����ϰ� getter setter �� �����.
	public IJob getJob() { 
		return job;
	}

	public void setJob(IJob job) {
		this.job = job;
	}

	public IPay getPay() {
		return pay;
	}

	public void setPay(IPay pay) {
		this.pay = pay;
	}
	
}
