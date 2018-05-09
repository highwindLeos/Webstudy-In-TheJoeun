package com.tj.ex06Shape;

import com.tj.ex00piclass.PiClass;

public class Circle extends Shape {
	private int r;

	public Circle() {
	}

	public Circle(int r) {
		this.r = r;
	} // 1���� ���� ������

	// �޼ҵ� ����
	@Override
	public double computerArea() {
		// System.out.println("���� ���̴� : " + (3.14 * r * r));
		return PiClass.PI * r * r;
	}

	@Override
	public void draw() {
		System.out.println("���� �׷���");
	}

}
