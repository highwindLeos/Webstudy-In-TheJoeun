package com.tj.ex4;

// ���������� ���� ���� ���� ���ǳ� ���簢���� ���� ���� ���̸� �Ӽ����� ���� Ŭ����.
// ���ǳ� ���̸� ���ϴ� �޼ҵ� calVolum() �� �����Ѵ�.
public class BoxOrRect {
	private int width;
	private int height;
	private int depth;
//	private int volum; // ���ǳ� ���̸� ����.

	public BoxOrRect() {
	} // �⺻ ������ �޼ҵ�.

	public BoxOrRect(int width, int height, int depth) {
		this.width = width;
		this.height = height;
		this.depth = depth;
		// volum = width * height * depth; // ����
	}

	public BoxOrRect(int width, int height) {
		this.width = width;
		this.height = height;
		// volum = width * height; // ����
	}
	// ������� ������ �޼ҵ�.

	public int calVolum() {
		if (depth == 0) { // ���� ���� ���ٸ�.
			return width * height;
		} else {
			return width * height * depth;
		}

	} // ���Ǹ� ���ϴ� �Լ�

	// getter setter �޼ҵ� ����.
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
