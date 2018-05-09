package com.tj.ex08toy;

public class PoohToy implements IMoveArmLeg {
	
	public PoohToy() {
		System.out.println("곰돌이 만듦");
		canMoveArmLeg();
		System.out.println("-----------------------------");
	}

	@Override
	public void canMoveArmLeg() {
		System.out.println("팔다리를 움직일 수 있어요");
	}

}
