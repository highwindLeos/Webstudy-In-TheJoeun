package com.tj.ex03Shape;

public class Reacangle extends Shape {

	private int x;
	private int y;

	public Reacangle() {
	}

	public Reacangle(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void computerArea() {
		System.out.println("사각형의 넓이는 : " + (x * y));
	}

	@Override
	public void draw() {
		System.out.println("사각형을 그려요");
	}

}
