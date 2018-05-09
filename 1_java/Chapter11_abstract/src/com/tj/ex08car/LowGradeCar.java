package com.tj.ex08car;

//LowGradeCar : 빨강 일반 
public class LowGradeCar extends Car {
	private int tex;

	public LowGradeCar(String color, String tire, int displacement, String handle) {
		super(color, tire, displacement, handle); // 부모의 생성자를 이용해서 멤버변수를 초기화
		tex = 50000;
	}

	@Override
	public String getSpec() {
		String resulte = "**********************";
		resulte += "\n색상 : " + getColor();
		resulte += "\n타이어 : " + getTire();
		resulte += "\n배기량 : " + getDisplacement();
		resulte += "\n핸들 : " + getHandle();
		if (getDisplacement() > 1000) {
			tex += getDisplacement() * 100;
		}
		resulte += "\n세금 : " + tex;
		resulte += "\n**********************";
		
		return resulte;
	}

}
