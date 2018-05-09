package com.tj.ex02date;

import java.util.GregorianCalendar;

public class Ex02GregorianCalender {
	public static void main(String[] args) {
		// ���� �ý������� ���� �ð��� ������ ��¥�� �ð��� ����ϴ� ����
		GregorianCalendar gc = new GregorianCalendar();
		System.out.println(gc);
		// 2018�� 4�� 9�� ������ ���� 3�� 8��
		int year = gc.get(GregorianCalendar.YEAR); // �� ���� ����
		int month = gc.get(GregorianCalendar.MONTH) + 1; // ���� ���� (���� 1�� ���ؾ� ���ǽð�)
		int day = gc.get(GregorianCalendar.DAY_OF_MONTH); // ���� ���� (�̴��� ���° ��)
		int week = gc.get(GregorianCalendar.DAY_OF_WEEK); // �� ������ ���� 1 �Ͽ��� 2 ������ ... 7 �����
		int amapm = gc.get(GregorianCalendar.AM_PM); // ���� ���� 0 = am 1 = pm
		int hour12 = gc.get(GregorianCalendar.HOUR); // 12�� ����
		int hour24 = gc.get(GregorianCalendar.HOUR_OF_DAY); // 24�� ����
		int minite = gc.get(GregorianCalendar.MINUTE); // ��
		int second = gc.get(GregorianCalendar.SECOND); // ��
		int millisec = gc.get(GregorianCalendar.MILLISECOND); // �и���

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
