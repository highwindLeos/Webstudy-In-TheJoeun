package com.tj.ex06init;

public class Test1 {
	private int i = 1; // �ڵ忡 ���� �ʱ�ȭ �ϴ� �� (��Ȥ ���Եȴ�.)

	{
		i = 1; // �ʱ�ȭ ���� ���� �ʱ�ȭ.
	}

	public Test1() {
		i = 1; // ���� ���� ���� ���� �ʱⰪ ������.
	}

	public Test1(int i) {
		this.i = i;
	} // ������ �Լ��� �Ű������� ���� �Է¹޾Ƽ� �ʱ�ȭ.

}
