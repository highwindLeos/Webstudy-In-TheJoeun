package com.tj.TodayEx;
// 1�ܰ� : �迭�� �̿��Ͽ� �л��� (���� ö�� �浿 ���� ����)�� Ű�� �Է¹޾� ��� ���

import java.util.Scanner;

public class TodayEx05_step1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] name = { "����", "ö��", "�浿", "����", "����" };
		int[] height = new int[name.length]; // Ű �迭�� �ε��� ���̴� �л��� ���� ����.

		int total = 0; // �հ� ����
		double avg; // ��� ����

		for (int i = 0; i < name.length; i++) {

			System.out.println(name[i] + "�� Ű��?");
			height[i] = sc.nextInt();

			total += height[i]; // �Է¹��� Ű�� ����
		}

		avg = (double) total / (name.length); // ����� ���.

		for (int i = 0; i < name.length; i++) {
			System.out.println(name[i] + " �� Ű :" + height[i] + " �Դϴ�.");
		}
		System.out.printf("���Ű�� %.1f ", avg);
		
		sc.close();
	}

}
