package com.tj.Example;

import java.util.Scanner;

// ���� ���� 2 : �Է��� ���� ¦������ Ȧ�� ���� ���.
public class Q2 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("���� �Է��ϼ��� : ");
		
		int i = scanner.nextInt(); // ������ �Է¹޴´�.

		String resulte = ((i % 2) == 0) ? "�Է��Ͻ� ���� ¦���Դϴ�." 
										: "�Է��Ͻ� ���� Ȧ���Դϴ�.";
		scanner.close();

		System.out.println(resulte);
		
	}

}
