package com.tj.ex08toy;

public class Mazinger implements IMoveArmLeg, IMisslie {
	
	public Mazinger() {
		System.out.println("��¡�� ����");
		canMissile();
		canMoveArmLeg();
		System.out.println("-----------------------------");
	}

	@Override
	public void canMissile() {
		System.out.println("�̻��� �߻�!!");
	}

	@Override
	public void canMoveArmLeg() {
		System.out.println("�ȴٸ��� �����ϼ� �־��");
	}

}
