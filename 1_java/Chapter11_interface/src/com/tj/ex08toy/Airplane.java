package com.tj.ex08toy;

public class Airplane implements ILight, IMisslie {

	public Airplane() {
		System.out.println("����� ����");
		canMissile();
		canLight();
		System.out.println("-----------------------------");
	}
	
	@Override
	public void canMissile() {
		System.out.println("�̻��� �߻�!!");
	}

	@Override
	public void canLight() {
		System.out.println("�Һ��� �� �� �־��.");
	}

}
