package com.tj.ex1;

// Ŭ������ ����� ����.
// ��Ű���� - Ŭ���� �� - ������ - ������ - �޼ҵ� - getter setter �Լ� 
public class Squre {
	private int side;

	public Squre() {
		System.out.println("�Ű����� ���� ������ ȣ��");
	}

	public Squre(int side) {
		this.side = side; // ���� ������ �Լ��� ��Ȱ�� ���� �ʱ�ȭ.
		System.out.println("�Ű����� �ִ� ������ ȣ��");
	}
	
	public int area() {
		return side * side;
	}

	// getter setter �Լ�
	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
	}

}
