package com.tj.ex08toy;

public class Mazinger implements IMoveArmLeg, IMisslie {
	
	public Mazinger() {
		System.out.println("마징가 만듦");
		canMissile();
		canMoveArmLeg();
		System.out.println("-----------------------------");
	}

	@Override
	public void canMissile() {
		System.out.println("미사일 발사!!");
	}

	@Override
	public void canMoveArmLeg() {
		System.out.println("팔다리를 움직일수 있어요");
	}

}
