package com.tj.ex02date;

import java.util.Calendar;

public class Ex01Calender {
	public static void main(String[] args) {
		// ���� �ý������� ���� �ð��� ������ ��¥�� �ð��� ����ϴ� ����
		Calendar calendar = Calendar.getInstance(); // �̱��� ���� class �̱⶧���� (��ü�� �ϳ��� �����ǵ��� ��)
		System.out.println(calendar);
		// 2018�� 4�� 9�� ������ ���� 3�� 8��
		int year = calendar.get(Calendar.YEAR); // �� ���� ����
		int month = calendar.get(Calendar.MONTH) + 1; // ���� ���� (���� 1�� ���ؾ� ���ǽð�)
		int day = calendar.get(Calendar.DAY_OF_MONTH); // ���� ���� (�̴��� ���° ��)
		int week = calendar.get(Calendar.DAY_OF_WEEK); // �� ������ ���� 1 �Ͽ��� 2 ������ ... 7 �����
		int amapm = calendar.get(Calendar.AM_PM); // ���� ���� 0 = am 1 = pm
		int hour12 = calendar.get(Calendar.HOUR); // 12�� ����
		int hour24 = calendar.get(Calendar.HOUR_OF_DAY); // 24�� ����
		int minite = calendar.get(Calendar.MINUTE); // ��
		int second = calendar.get(Calendar.SECOND); // ��
		int millisec = calendar.get(Calendar.MILLISECOND); // �и���

		System.out.printf("%d �� %d �� %d �� ", year, month, day);

		switch (week) {
		case 1:
			System.out.println("�Ͽ���");
			break;
		case 2:
			System.out.println("������");
			break;
		case 3:
			System.out.println("ȭ����");
			break;
		case 4:
			System.out.println("������");
			break;
		case 5:
			System.out.println("�����");
			break;
		case 6:
			System.out.println("�ݿ���");
			break;
		case 7:
			System.out.println("�����");
			break;
		}

		System.out.print((amapm == 0) ? "���� " : "���� ");
		System.out.printf("%d�� %d�� %d�� %d \n", hour12, minite, second, millisec); // 12�ð� ��

		System.out.printf("24ǥ�� : %d�� %d�� %d�� %d \n", hour24, minite, second, millisec); // 24�ð� ��

	}
}
