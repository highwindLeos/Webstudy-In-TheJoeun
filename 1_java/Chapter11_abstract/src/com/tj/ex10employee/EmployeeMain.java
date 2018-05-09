package com.tj.ex10employee;

public class EmployeeMain {

	public static void main(String[] args) {
		Employee kim = new SalaryEmployee("��浿", 28000000);
		Employee hong = new SalaryEmployee("ȫ�浿", 30000000);
		Employee kang = new SalaryEmployee("������", 70000000);
		
		HourlyEmployee yi = new HourlyEmployee("�̸�ȭ", 120, 8000);
		HourlyEmployee yu = new HourlyEmployee("������", 100, 12000);

		Employee[] employees = {kim, hong, kang, yi, yu};
		
		for (Employee etemp : employees) {
			System.out.println(etemp.outString());
		}
	}

}
