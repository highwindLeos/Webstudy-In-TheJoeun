package com.tj.TodayEx;

public class TodayEx8 {

	private static void line(char ch, int no) {

		for (int i = 0; i < no; i++) {
			System.out.print(ch);
		}
		System.out.println();
	}// line() �Ű������� 2��

	private static void line2(int no) {
		for (int i = 0; i < no; i++) {
			System.out.print("��");
		}
		System.out.println();
	}// line2()

	public static void main(String[] args) {
		String[] title = { "��ǰ��", "1��", "2��", "3��", "4��", "�հ�", "���" };
		String[] name = { "�����", "�׷���", "û�ұ�" };
		int[][] score = { { 250, 170, 300, 780 }, { 170, 120, 150, 220 }, { 450, 230, 400, 250 } };
		int sum = 0;
		double avg;
		int[] total = new int[4]; // ������ 0���� �ʱ�ȭ��.

		line('=', 60);
		System.out.println("\t��\t��\t��\tȲ");
		line('=', 60);

		for (String t : title) {
			System.out.print(t + "\t"); // ���� ���� ���
		}

		System.out.println();
		line2(60);

		for (int i = 0; i < name.length; i++) { // �̸� �迭�� ����.
			System.out.print(name[i] + "\t");
			for (int j = 0; j < score[i].length; j++) { // ���� �迭�� ����.
				// i�� j �� ������ ����ϰ� sum�� total[j] �� ����
				System.out.print(score[i][j] + "\t"); // ���� �迭�� ���
				sum += score[i][j]; // �հ�
				total[j] += score[i][j]; // ����
			} // for-j
			avg = (double) sum / score[i].length;
			System.out.printf("%d \t %.1f\n", sum, avg);
			sum = 0;
		} // for-i

		line2(60);
		System.out.print("�Ѱ�\t");
		for (int i = 0; i < total.length; i++) {
			System.out.print(total[i] + "\t");
			sum += total[i];
		} // for �Ѱ�
		avg = (double) sum / total.length; // �հ踦 ���� �ε��� ���� ��ŭ ������.
		System.out.printf("%d\t%.1f\n", sum, avg);
		line2(60);
	}// main
}// class
