package com.tj.TodayEx;
// 3�ܰ� : �Է��� �޾Ƽ� ���� ���� ������ ����϶�. 

import java.util.Scanner;

public class TodayEx05_step3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] name = { "����", "ö��", "�浿", "����", "����" };
		int[] height = new int[name.length]; // Ű �迭�� �ε��� ���̴� �л��� ���� ����.

		for (int i = 0; i < name.length; i++) {

			System.out.println(name[i] + "�� Ű��?");
			height[i] = sc.nextInt();

		}

		for (int i = 0; i < name.length; i++) {
			System.out.print(height[i] + "(" + name[i] + ") ");
		}

		for (int i = 0; i < name.length; i++) { // �����ϱ�.
			for (int j = i + 1; j < name.length; j++) { // �ι�° �迭.
				if (height[i] > height[j]) {
					// Ű�� �������ش�.
					int tempH = height[i];
					height[i] = height[j];
					height[j] = tempH;
					// �̸��� �������ش�.
					String tempN = name[i];
					name[i] = name[j];
					name[j] = tempN;
				} // if end
			} // for - j
		} // for - i
		System.out.println();
		for (int i = 0; i < name.length; i++) {
			System.out.print(height[i] + "(" + name[i] + ") ");
		}
		sc.close();
	}
}
