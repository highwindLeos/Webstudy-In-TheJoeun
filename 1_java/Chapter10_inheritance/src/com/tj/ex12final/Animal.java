package com.tj.ex12final;

public class Animal {
	protected int speed;
	
	public void running() {
		speed += 5;
		System.out.println("�ٰ� �־��. ���� �ӵ� : " + speed);
	}
	
	public final void stop() { // final�޼ҵ�� override �Ұ�
		speed = 0;
		System.out.println("����!");
	}
	
}
