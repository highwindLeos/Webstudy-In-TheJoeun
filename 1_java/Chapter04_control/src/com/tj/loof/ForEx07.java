package com.tj.loof;

public class ForEx07 {

	public static void main(String[] args) {
		int total = 0; // ���� ����.
		for (int i = 1; i <= 10; i+=2) { // 1~10 ���� Ȧ�� ��.
			total += i; 
		} // end for
		System.out.println("1~ 10 ������ Ȧ���� ���� : " + total);
	}
}
