package com.tj.ex12final;

public class Dog extends Animal {
	
	@Override
	public void running() { // stop �� final �� ������ �������̵���.
		speed += 10;
		System.out.println("�ٸ鼭 ������ �����. ���� �ӵ� : "+speed);
	}
	
	
}
