package com.tj.loof;

import java.util.Scanner;

// ¦���� �Է¹޾� ���.(��, Ȧ���� �Է½� �ٽ� �Է¹���)
public class DoWhileEx01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num;
		do {
			System.out.println("���ϴ� ¦���� �Է����ּ���.");
			num = sc.nextInt();
		} while ((num % 2) == 1 ||(num%2) == -1); // �Էµ� ���� Ȧ�� �̸� true?

		System.out.println("�Է��� ¦���� " + num + " �Դϴ�.");
		sc.close();

	}// main
}
