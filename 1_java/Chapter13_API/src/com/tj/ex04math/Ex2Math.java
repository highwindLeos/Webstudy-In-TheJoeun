package com.tj.ex04math;

public class Ex2Math {
	public static void main(String[] args) {
		
		//ceil : �Ǽ� ��ȯ - �ø�
		//floor : �Ǽ� ��ȯ - ����
		//round : ���� ��ȯ - �ݿø�
		
		System.out.println("�Ҽ������� �ݿø�, �ø�, ����");
		System.out.println("9.12 �ø� : " + Math.ceil(9.12)); // 10.0 �Ǽ� ��ȯ
		System.out.println("9.69 ���� : " + Math.floor(9.69)); // 9.0 �Ǽ� ��ȯ
		System.out.println("9.69 �ݿø� : " + Math.round(9.69)); // 10 ���� ��ȯ
		System.out.println("9.49 �ݿø� : " + Math.round(9.49)); // 9 ���� ��ȯ
		
		System.out.println("�Ҽ��� ���ڸ����� �ݿø�, �ø�, ����"); // 10�� ������ �ڸ����� �����.
		System.out.println("9.12 �ø� : " + Math.ceil(9.12*10)/10); // 9.2 �Ǽ� ��ȯ : 10�� ���ϰ� 10.0���� ������.
		System.out.println("9.69 ���� : " + Math.floor(9.69*10)/10); // 9.6 �Ǽ� ��ȯ
		System.out.println("9.69 �ݿø� : " + Math.round(9.69*10)/10.0); // 9.7 ���� ��ȯ
		System.out.println("9.69 �ݿø� : " + Math.round(9.69*10)/10.0); // 9.7 ���� ��ȯ
		
		System.out.println("���� �ڸ����� �ݿø�, �ø�, ����");// �Ʒ��� ������ ���������� ���ϸ� ����ȯ.
		System.out.println("11 �ø� : " + (int)Math.ceil(11/10.0)*10); // 20.0 �Ǽ� ��ȯ :  10.0���� ������ 10���� ������.
		System.out.println("19 ���� : " + (int)Math.floor(19/10.0)*10); // 20.0 �Ǽ� ��ȯ :  10.0���� ������ 10���� ������.
		System.out.println("19 �ݿø� : " + Math.round(19/10.0)*10); // 20 ���� ��ȯ :  10.0���� ������ 10���� ������.

	}
}
