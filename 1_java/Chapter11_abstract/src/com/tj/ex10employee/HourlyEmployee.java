package com.tj.ex10employee;

public class HourlyEmployee extends Employee {
	private int hoursWorked; // ���ѽð�
	private int moneyPerHour; // �ñ�
	// new HourlyEmployee("ȫ�浿", 100, 8000);
	public HourlyEmployee() {}
	
	public HourlyEmployee(String name, int hoursWorked, int moneyPerHour) {
		super(name);
		this.hoursWorked = hoursWorked;
		this.moneyPerHour = moneyPerHour;
	}

	@Override
	public int computerPay() {
		return hoursWorked * moneyPerHour; // ������ ����ؼ� ��ȯ.
	}	

}
