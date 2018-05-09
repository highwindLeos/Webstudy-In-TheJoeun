package com.tj.ex10employee;

public abstract class Employee {
	private String name;

	public Employee() {	} // 기본 생성자

	public Employee(String name) {
		this.name = name;
	}

	public abstract int computerPay(); // 추상 메소드
	
	public final int computeIncentive() { // 절대 override 금지
		int temp = computerPay();
		if (temp > 2000000) {
			return (int)(temp * 0.02); // 2%
		} 
		return 0;
	}
	
	public String outString() {
		String resulte = "~ ~ ~ 월 급 명 세 서 ~ ~ ~";
		resulte += "\n 성 함 : " + name;
		resulte += "\n 급 여 : " + computerPay() + "원";
		
		int tempIncentive =  computeIncentive();
		if (tempIncentive > 0 ) {
			resulte += "\n 상 여 : " + computeIncentive() + "원";
		}
		
		resulte += "\n ~ 수 고 하 셨 습 니 다. ~";
		
		return resulte;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
