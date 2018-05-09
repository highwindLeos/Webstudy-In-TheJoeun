package com.tj.ex06Shape;

public class Triangle extends Shape {
	private int w;
	private int h;

	public Triangle() {
	}

	public Triangle(int w, int h) {
		this.w = w;
		this.h = h;
	} // 2개의 인자 생성자

	// 메소드 구현
	@Override
	public double computerArea() {
		// System.out.println("삼각형의 넓이는 : " + (w * h / 2));
		return w * h * 0.5;
	}

	@Override
	public void draw() {
		System.out.println("삼각형을 그려요");
	}

}
