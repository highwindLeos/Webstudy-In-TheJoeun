package com.tj.ex0trycatch;

public class EX03 {

	public static void main(String[] args) {
		int[] iArr = { 0, 1, 2 };
		System.out.println("===========================================");
		try {
			System.out.println(iArr[3]);
		} catch (ArrayIndexOutOfBoundsException e) {
			// e.printStackTrace(); // ���� �޼����� �ڼ��ϰ� �����ش�.
			System.out.println(e.getMessage() + "�ε����� ��");
		} finally {
			System.out.println("finally ���� ���ܰ� ���� �ȳ��� �׻� ��������.");
		}
		System.out.println("===========================================");
	}
}
