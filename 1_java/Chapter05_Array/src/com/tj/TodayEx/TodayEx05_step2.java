package com.tj.TodayEx;
// 2�ܰ� : �迭�� �̿��Ͽ� �л��� (���� ö�� �浿 ���� ����)�� Ű�� �Է¹޾� 

// �ִܽŰ� ����� ���

import java.util.Scanner;

public class TodayEx05_step2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] name = { "����", "ö��", "�浿", "����", "����" };
		int[] height = new int[name.length]; // Ű �迭�� �ε��� ���̴� �л��� ���� ����.

		int max = 0; // �ִ밪 ���� , �ַ� ���� ���� �ʱ�ȭ
		int maxIndex = 0;
		int min = 999; // �ּҰ� ����, ū ���� �ʱ�ȭ
		int minIndex = 0; 

		for (int i = 0; i < name.length; i++) {

			System.out.println(name[i] + "�� Ű��?");
			height[i] = sc.nextInt();

		}
		// 5���� Ű�� height �迭 �濡 ����
		for (int i = 0; i < name.length; i++) {
			if (max < height[i]) {
				max = height[i];
				maxIndex = i; // name �� �ε����� ����
			} // end if
			if (min > height[i]) {
				min = height[i];
				minIndex = i; // name �� �ε����� ����
			} // end if
		} // end for
		System.out.println("����� : " + max + "(" + name[maxIndex] + ") �Դϴ�.");
		System.out.println("�ִܽ� : " + min + "(" + name[minIndex] + ") �Դϴ�.");
		
		sc.close();
	}
}
