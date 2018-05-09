package com.tj.ex02date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Ex09Print {
	
	public void printDate(Date today, String city, String timeId) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy / MM / dd (E) a hh:mm");
		sdf.setTimeZone(TimeZone.getTimeZone(timeId)); // �Ű������� ���� ������ �ð��� ����.
		System.out.println(city +" : "+ sdf.format(today));
	}
	
}
