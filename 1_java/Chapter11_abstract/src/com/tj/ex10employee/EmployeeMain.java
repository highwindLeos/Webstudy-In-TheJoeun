package com.tj.ex10employee;

public class EmployeeMain {

	public static void main(String[] args) {
		Employee kim = new SalaryEmployee("김길동", 28000000);
		Employee hong = new SalaryEmployee("홍길동", 30000000);
		Employee kang = new SalaryEmployee("강동원", 70000000);
		
		HourlyEmployee yi = new HourlyEmployee("이만화", 120, 8000);
		HourlyEmployee yu = new HourlyEmployee("유도리", 100, 12000);

		Employee[] employees = {kim, hong, kang, yi, yu};
		
		for (Employee etemp : employees) {
			System.out.println(etemp.outString());
		}
	}

}
