package com.tj.ex08toy;

public class PoohToy implements IMoveArmLeg {
	
	public PoohToy() {
		System.out.println("������ ����");
		canMoveArmLeg();
		System.out.println("-----------------------------");
	}

	@Override
	public void canMoveArmLeg() {
		System.out.println("�ȴٸ��� ������ �� �־��");
	}

}
