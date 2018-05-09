package com.tj.ex10employee;

public abstract class Employee {
	private String name;

	public Employee() {	} // �⺻ ������

	public Employee(String name) {
		this.name = name;
	}

	public abstract int computerPay(); // �߻� �޼ҵ�
	
	public final int computeIncentive() { // ���� override ����
		int temp = computerPay();
		if (temp > 2000000) {
			return (int)(temp * 0.02); // 2%
		} 
		return 0;
	}
	
	public String outString() {
		String resulte = "~ ~ ~ �� �� �� �� �� ~ ~ ~";
		resulte += "\n �� �� : " + name;
		resulte += "\n �� �� : " + computerPay() + "��";
		
		int tempIncentive =  computeIncentive();
		if (tempIncentive > 0 ) {
			resulte += "\n �� �� : " + computeIncentive() + "��";
		}
		
		resulte += "\n ~ �� �� �� �� �� �� ��. ~";
		
		return resulte;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
