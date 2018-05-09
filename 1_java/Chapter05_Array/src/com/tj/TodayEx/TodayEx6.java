package com.tj.TodayEx;

public class TodayEx6 {

	private static void line(char ch, int no) {

		for (int i = 0; i < no; i++) {
			System.out.print(ch);
		}
		System.out.println();
	}// line() �Ű������� 2��

	private static void line2() {
		System.out.println("���������������������������������������������������");
	}// line2()

	public static void main(String[] args) {
		String[] title = { "�̸�", "����", "����", "����", "����", "���" };
		String[] name = { "���켺", "���ϴ�", "Ȳ����", "������", "������" };
		int[][] score = { { 90, 90, 90 }, { 90, 95, 79 }, { 99, 98, 97 }, { 97, 93, 95 }, { 77, 63, 97 } };
		int sum = 0;
		double avg;
		int[] total = new int[3]; // ������ 0���� �ʱ�ȭ��.

		line('=', 50);
		System.out.println("\t��\t��\tǥ\t");
		line('=', 50);

		for (String t : title) {
			System.out.print(t + "\t"); // ���� ���� ���
		}

		System.out.println();
		line2();

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
		
		line2();
		System.out.print("�Ѱ�\t");
		for (int i = 0; i < total.length; i++) {
			System.out.print(total[i] + "\t");
			sum += total[i];
		} // for �Ѱ�
		avg = (double) sum / total.length;
		System.out.printf("%d\t%.1f\n", sum, avg);
		line2();
	}// main
}// class
