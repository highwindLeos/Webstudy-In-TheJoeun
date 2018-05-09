package strategy.academy.modulelization;

import strategy.academy.inter.IJob;
import strategy.academy.inter.IPay;

public abstract class Person {
	private String id;
	private String name;
	// interface 로 만들은 변수형
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
		System.out.println("ID : "+ id + "\t 이름 : "+name);
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
	// 인터페이스의 구현대로 변수 형을 설정하고 getter setter 를 만든다.
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
