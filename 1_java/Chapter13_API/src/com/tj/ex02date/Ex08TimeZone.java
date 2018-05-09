package com.tj.ex02date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class Ex08TimeZone {
	public static void main(String[] args) {
		Calendar today = Calendar.getInstance(); // �̱��� ��ü
		// ���� �ѱ��� yy �� MM�� dd�� a hh�� mm���Դϴ�.
		// ���� ������ yy �� MM�� dd�� a hh�� mm���Դϴ�.

		SimpleDateFormat dateformat = new SimpleDateFormat(" yy�� MM�� dd�� a hh�� mm���Դϴ�.");

		System.out.println("�ѱ� : " + dateformat.format(today.getTime()));
		dateformat.setTimeZone(TimeZone.getTimeZone("America/New_York")); // �ð� ������ ����ð���� ����.
		System.out.println("���� : " + dateformat.format(today.getTime()));
		dateformat.setTimeZone(TimeZone.getTimeZone("Asia/Hong_Kong")); // �ð� ������ ȫ��ð���� ����.
		System.out.println("ȫ�� : " + dateformat.format(today.getTime()));
	}

}
