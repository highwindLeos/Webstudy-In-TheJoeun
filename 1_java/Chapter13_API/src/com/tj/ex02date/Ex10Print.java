package com.tj.ex02date;
/* 
 * 뉴욕 : 2018 / 04 / 09 (월) 오전 04:08
 * 홍콩 : 2018 / 04 / 09 (월) 오후 04:08
 * 파리 : 2018 / 04 / 09 (월) 오전 10:08
 * 서울 : 2018 / 04 / 09 (월) 오후 05:08
 */

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Ex10Print {
	public static void main(String[] args) {
		GregorianCalendar gc = new GregorianCalendar();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy / MM / dd (E) a hh:mm");
		String[] city = { "뉴욕", "홍콩", "파리", "서울" };
		String[] timeZoneId = { "America/New_York", "Asia/Hong_Kong", "Europe/Paris", "Asia/Seoul" };
		
		for (int i = 0; i < timeZoneId.length; i++) {
			sdf.setTimeZone(TimeZone.getTimeZone(timeZoneId[i]));
			System.out.println(city[i] + " : " + sdf.format(gc.getTime()));
		}
	}
}
