package com.tj.ex4;

// 직육면제의 가로 세로 높이 부피나 직사각형의 가로 세로 넓이를 속성으로 갖는 클래스.
// 부피나 넑이를 구하는 메소드 calVolum() 도 구현한다.
public class BoxOrRect {
	private int width;
	private int height;
	private int depth;
//	private int volum; // 부피나 넓이를 갖음.

	public BoxOrRect() {
	} // 기본 생성자 메소드.

	public BoxOrRect(int width, int height, int depth) {
		this.width = width;
		this.height = height;
		this.depth = depth;
		// volum = width * height * depth; // 부피
	}

	public BoxOrRect(int width, int height) {
		this.width = width;
		this.height = height;
		// volum = width * height; // 면적
	}
	// 여기까지 생성자 메소드.

	public int calVolum() {
		if (depth == 0) { // 깊이 값이 없다면.
			return width * height;
		} else {
			return width * height * depth;
		}

	} // 부피를 구하는 함수

	// getter setter 메소드 생성.
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

}
