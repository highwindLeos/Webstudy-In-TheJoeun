package com.tj.condition;

import java.util.Scanner;

public class SwitchEx01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name = "Leo";

		System.out.println("������ �Է����ּ���.");
		int score = sc.nextInt();
		int temp = (score == 100) ? (score - 1) : score; // �ӽ� �������� 100���϶��� ó���Ѵ�.
		temp = (temp > -10 && temp < 0) ? (temp - 10) : temp; // ������ 0�̻� 10���� �϶��� -10 �ؼ� ����� ����.

		switch (temp / 10) { // ���� �Է��� ������ ���ڳ� ���ڿ��� �����ϴ�.
		case 9:
			System.out.println("A���� �Դϴ�. ���߾��");
			break;
		case 8:
			System.out.println("B���� �Դϴ�. �� �߱���");
			break;
		case 7:
			System.out.println("C���� �Դϴ�. �״���...");
			break;
		case 6:
			System.out.println("D���� �Դϴ�. ������ ��");
			break;
		case 5:
		case 4:
		case 3:
		case 2:
		case 1:
		case 0:
			System.out.println("F���� �Դϴ�. ���߾��");
			break;
		default:
			System.out.println("��ȿ�� ������ �ƴմϴ�.");
		}
		// switch ������ �ٲ� if ����
		/*
		 * if (score >= 90 && score <= 100) { System.out.println("A���� \t ���߾��"); } else
		 * if (score >= 80 && score <= 90) { System.out.println("B���� \t �߱��߳�?"); } else
		 * if (score >= 70 && score <= 80) { System.out.println("C���� \t �״���?"); } else
		 * if (score >= 60 && score <= 70) { System.out.println("D���� \t ���� ������?!"); }
		 * else if (score >= 0 && score <= 60) { System.out.println("F���� \t ���� ������!?");
		 * } else { System.out.println("��ȿ�� ������ �ƴմϴ�."); }
		 */
		sc.close(); // ��ĳ�� ����

	}

}
