package com.tj.ex03Shape;

public class Circle extends Shape {
	private int r;

	public Circle() {
	}

	public Circle(int r) {
		this.r = r;
	} // 1���� ���� ������

	// �޼ҵ� ����
	@Override
	public void computerArea() {
		System.out.println("���� ���̴� : " + (3.14 * r * r));
	}

	@Override
	public void draw() {
		System.out.println("���� �׷���");
	}

}
