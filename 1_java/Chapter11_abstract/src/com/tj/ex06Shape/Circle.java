package com.tj.ex06Shape;

import com.tj.ex00piclass.PiClass;

public class Circle extends Shape {
	private int r;

	public Circle() {
	}

	public Circle(int r) {
		this.r = r;
	} // 1개의 인자 생성자

	// 메소드 구현
	@Override
	public double computerArea() {
		// System.out.println("원의 넓이는 : " + (3.14 * r * r));
		return PiClass.PI * r * r;
	}

	@Override
	public void draw() {
		System.out.println("원을 그려요");
	}

}
