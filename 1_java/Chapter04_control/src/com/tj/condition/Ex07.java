package com.tj.condition;

import java.util.Scanner;

public class Ex07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("���� ���� ���� �����ϼ��� : ���� (0) , ���� (1), �� = (2)");
		int human = sc.nextInt();

		if (human == 0) {
			System.out.println("����");
		} else if (human == 1) {
			System.out.println("����");
		} else if (human == 2) {
			System.out.println("��");
		} else {
			System.out.println("0 ~ 2 ������ ������ �Է����ּ���.");
		}
		sc.close();
	}
}
