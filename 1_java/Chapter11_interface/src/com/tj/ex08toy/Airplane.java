package com.tj.ex08toy;

public class Airplane implements ILight, IMisslie {

	public Airplane() {
		System.out.println("비행기 만듦");
		canMissile();
		canLight();
		System.out.println("-----------------------------");
	}
	
	@Override
	public void canMissile() {
		System.out.println("미사일 발사!!");
	}

	@Override
	public void canLight() {
		System.out.println("불빛을 껼 수 있어요.");
	}

}
