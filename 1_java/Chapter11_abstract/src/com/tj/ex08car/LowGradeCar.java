package com.tj.ex08car;

//LowGradeCar : ���� �Ϲ� 
public class LowGradeCar extends Car {
	private int tex;

	public LowGradeCar(String color, String tire, int displacement, String handle) {
		super(color, tire, displacement, handle); // �θ��� �����ڸ� �̿��ؼ� ��������� �ʱ�ȭ
		tex = 50000;
	}

	@Override
	public String getSpec() {
		String resulte = "**********************";
		resulte += "\n���� : " + getColor();
		resulte += "\nŸ�̾� : " + getTire();
		resulte += "\n��ⷮ : " + getDisplacement();
		resulte += "\n�ڵ� : " + getHandle();
		if (getDisplacement() > 1000) {
			tex += getDisplacement() * 100;
		}
		resulte += "\n���� : " + tex;
		resulte += "\n**********************";
		
		return resulte;
	}

}
