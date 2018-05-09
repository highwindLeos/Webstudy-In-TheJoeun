package com.tj.ex08car;

//LowGradeCar : 빨강 고급 
public class HighradeCar extends Car {
	private int tex;

	public HighradeCar(String color, String tire, int displacement, String handle) {
		super(color, tire, displacement, handle); // 부모의 생성자를 이용해서 멤버변수를 초기화
		tex = 150000;
	}

	@Override
	public String getSpec() {
		String resulte = "**********************";
		resulte += "\n색상 : " + getColor();
		resulte += "\n타이어 : " + getTire();
		resulte += "\n배기량 : " + getDisplacement();
		resulte += "\n핸들 : " + getHandle();
		if (getDisplacement() > 2200) {
			tex += getDisplacement() * 50;
		}
		resulte += "\n세금 : " + tex;
		resulte += "\n**********************";
		
		return resulte;
	}

}
