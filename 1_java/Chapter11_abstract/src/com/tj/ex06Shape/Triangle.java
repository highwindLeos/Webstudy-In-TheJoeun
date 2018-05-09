package com.tj.ex06Shape;

public class Triangle extends Shape {
	private int w;
	private int h;

	public Triangle() {
	}

	public Triangle(int w, int h) {
		this.w = w;
		this.h = h;
	} // 2���� ���� ������

	// �޼ҵ� ����
	@Override
	public double computerArea() {
		// System.out.println("�ﰢ���� ���̴� : " + (w * h / 2));
		return w * h * 0.5;
	}

	@Override
	public void draw() {
		System.out.println("�ﰢ���� �׷���");
	}

}
