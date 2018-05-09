package com.tj.ex03overloading;

public class OverloadingTest {
	private int i1;
	private int i2;

	public OverloadingTest() { // overloading
		System.out.println("�Ű� ���� ���� ������");
	}

	public OverloadingTest(int i) {
		System.out.println("int �Ű� ���� �ϳ� �ִ� ������");
		i1 = i2 + i;
	}

	public OverloadingTest(String i) {
		System.out.println("String �Ű� ���� �ϳ� �ִ� ������");
		i1 = i2 + Integer.parseInt(i); // ���ڿ��� ������ �ٲپ� �ش�.
	}

	public OverloadingTest(int i1, int i2) {
		this.i1 = i1;
		this.i2 = i2;
	}

	// �Ϲ� �޼ҵ�
	public int calculate() { // �����ε�.
		return i1 + i2;
	}

	public int calculate(char c) {
		int resulte;
		
		switch (c) {
		case '+':
			resulte = i1 + i2;	break;
		case '-':
			resulte = i1 - i2;	break;
		case '*':
			resulte = i1 * i2;	break;		
		case '/':
			resulte = i1 / i2;	break;
		case '%':
			resulte = i1 % i2;	break;
		default:
			System.out.println("��ȿ���� ���� ������ �Դϴ�.");
			resulte = 0;

		}
		return resulte;
	}
	// getter setter
	public int getI1() {
		return i1;
	}

	public void setI1(int i1) {
		this.i1 = i1;
	}

	public int getI2() {
		return i2;
	}

	public void setI2(int i2) {
		this.i2 = i2;
	}

}
