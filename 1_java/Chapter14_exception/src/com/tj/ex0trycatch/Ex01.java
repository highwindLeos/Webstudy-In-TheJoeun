package com.tj.ex0trycatch;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i= 0, j = 0;
		
		System.out.println("��Ģ������ �Ұ̴ϴ�.");

		System.out.println("ù��° ��?");
		try {
			i = sc.nextInt();
		} catch (Exception e) {
			System.out.println("�� ���� �Է��ϼ���.");
		}
		sc.nextLine(); // ���� ����
		System.out.println("�ι�° ��?");
		try {
			j = sc.nextInt();
		} catch (Exception e) {
			System.out.println("�� ���� �Է��ϼ���.");
		}
		
		System.out.println("i * j = " + (i * j));
		try {
			System.out.println("i / j = " + (i / j));
			
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("��� ����ʴϴ�.");
		}
		System.out.println("i + j = " + (i + j));
		System.out.println("i - j = " + (i - j));

		System.out.println("�̻��Դϴ�.");
		sc.close();
	}
}
