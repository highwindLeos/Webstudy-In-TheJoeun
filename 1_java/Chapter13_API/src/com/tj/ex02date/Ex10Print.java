package com.tj.ex02date;
/* 
 * ���� : 2018 / 04 / 09 (��) ���� 04:08
 * ȫ�� : 2018 / 04 / 09 (��) ���� 04:08
 * �ĸ� : 2018 / 04 / 09 (��) ���� 10:08
 * ���� : 2018 / 04 / 09 (��) ���� 05:08
 */

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Ex10Print {
	public static void main(String[] args) {
		GregorianCalendar gc = new GregorianCalendar();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy / MM / dd (E) a hh:mm");
		String[] city = { "����", "ȫ��", "�ĸ�", "����" };
		String[] timeZoneId = { "America/New_York", "Asia/Hong_Kong", "Europe/Paris", "Asia/Seoul" };
		
		for (int i = 0; i < timeZoneId.length; i++) {
			sdf.setTimeZone(TimeZone.getTimeZone(timeZoneId[i]));
			System.out.println(city[i] + " : " + sdf.format(gc.getTime()));
		}
	}
}
