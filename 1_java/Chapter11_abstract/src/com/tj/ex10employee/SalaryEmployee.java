package com.tj.ex10employee;

public class SalaryEmployee extends Employee {
	
	private int annalSalary;
	// new SalaryEmployee("È«±æµ¿", 2400000);
	
	public SalaryEmployee() {
	}
	
	public SalaryEmployee(String name, int annalSalary) {
		super(name); //setName(name);
		this.annalSalary = annalSalary;
	}

	@Override
	public int computerPay() { // ¿ù±Þ = ¿¬ºÀ / 14
		return annalSalary / 14;
	}

}
