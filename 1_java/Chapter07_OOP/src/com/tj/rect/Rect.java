package com.tj.rect;

public class Rect {
	private int width; // data
	private int height;
	
	// ������ �Լ� : ��ü�� �����ɶ� �ѹ� ȣ��. �����ڰ� ���ٸ� JVM �� �������ش�.
	// ������ �Լ��� ���� Ÿ���� ���� Ŭ���� ��� �Լ����� ����.
	public Rect() { System.out.println("�Ű� ���� ���� ������ ȣ��");}
	
	public Rect(int width, int height) {
		this.width = width;
		this.height = height;
		System.out.println("�Ű� ���� �ִ� ������ ȣ��.");
	} // �������� overloading �Լ�. (�Լ����� ������ �Ű� ������ �ٸ� �Լ�.)
	
	public int area() { // method
		int resulte = width * height;

		return resulte;
	}

	// set : �Ű� ���� ���� �޾Ƽ� ������ ������ �������ִ� �Լ�
	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeigth(int height) {
		this.height = height;
	}
	// get : Ŭ���� ����� ������ �������ִ� �Լ�.
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
}
