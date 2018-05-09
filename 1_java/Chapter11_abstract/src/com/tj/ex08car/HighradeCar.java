package com.tj.ex08car;

//LowGradeCar : ���� ��� 
public class HighradeCar extends Car {
	private int tex;

	public HighradeCar(String color, String tire, int displacement, String handle) {
		super(color, tire, displacement, handle); // �θ��� �����ڸ� �̿��ؼ� ��������� �ʱ�ȭ
		tex = 150000;
	}

	@Override
	public String getSpec() {
		String resulte = "**********************";
		resulte += "\n���� : " + getColor();
		resulte += "\nŸ�̾� : " + getTire();
		resulte += "\n��ⷮ : " + getDisplacement();
		resulte += "\n�ڵ� : " + getHandle();
		if (getDisplacement() > 2200) {
			tex += getDisplacement() * 50;
		}
		resulte += "\n���� : " + tex;
		resulte += "\n**********************";
		
		return resulte;
	}

}
