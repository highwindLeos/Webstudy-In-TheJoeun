package com.tj.op;

public class Ex06 {

	public static void main(String[] args) {
		System.out.println("== ����(3��)������ ( ���� ? true ��� : false ���) ==");
		int h = 100;
		
		String resulte = ((h % 2) == 0) ? "h�� ¦��" : "h�� Ȧ��";
		System.out.println(resulte);
		
		h = 101;
		System.out.println((h%2 == 0) ? "h�� ¦�� ": "h�� Ȧ��");
		
	}

}
