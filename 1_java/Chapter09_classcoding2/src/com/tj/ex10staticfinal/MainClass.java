package com.tj.ex10staticfinal;

import com.tj.staticfinal.PiClass;

public class MainClass {

	public static void main(String[] args) {
		double area = 2 * 2 * PiClass.PI;
		System.out.println("�������� 2�� ���� ���̴� " + area);
		// PiClass.PI = 3.14; final ������ �� ���� �Ұ�.
	}

}
