package com.tj.condition;

import java.util.Scanner;

public class SwitchEx02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("���� �Է��ϼ���");
		int num = sc.nextInt();
		
		//��� ���� ���ǹ��̴�.
		System.out.println(num % 2 == 0 ? "¦����" : "Ȧ����"); // ���׿����ڷ� �ٷ� ���

		if (num % 2 == 0) { // if ��
			System.out.println("¦����");
		} else {
			System.out.println("Ȧ����");
		}

		switch (num % 2) { // switch �� 
		case 0:
			System.out.println("¦����");
			break;
		case 1: case -1:
			System.out.println("Ȧ����");
			break;
		}

		sc.close(); // ��ĳ�� ����

	}

}
