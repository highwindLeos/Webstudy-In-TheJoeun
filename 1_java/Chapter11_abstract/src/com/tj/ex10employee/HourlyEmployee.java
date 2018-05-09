package com.tj.ex10employee;

public class HourlyEmployee extends Employee {
	private int hoursWorked; // 일한시간
	private int moneyPerHour; // 시급
	// new HourlyEmployee("홍길동", 100, 8000);
	public HourlyEmployee() {}
	
	public HourlyEmployee(String name, int hoursWorked, int moneyPerHour) {
		super(name);
		this.hoursWorked = hoursWorked;
		this.moneyPerHour = moneyPerHour;
	}

	@Override
	public int computerPay() {
		return hoursWorked * moneyPerHour; // 월급을 계산해서 반환.
	}	

}
