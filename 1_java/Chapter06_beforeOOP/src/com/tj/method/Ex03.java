package com.tj.method;

public class Ex03 {

	public static void main(String[] args) {
		//
		ArtisMetic sansu = new ArtisMetic(); // Ŭ������ �ν��Ͻ��� ����. (�ν��Ͻ��� Ŭ���� ������ �Լ��� ��� ������ �ִ�.)

		int sum = sansu.sum(1, 10);
		
		System.out.println("������ ����� " + sum);
		System.out.println("������ sum�� " + sansu.evenOdd(sum));
		System.out.println("-5�� ���밪�� " + sansu.abs(-5));
	}

}
