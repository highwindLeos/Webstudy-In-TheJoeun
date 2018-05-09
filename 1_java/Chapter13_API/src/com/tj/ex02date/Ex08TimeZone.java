package com.tj.ex02date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class Ex08TimeZone {
	public static void main(String[] args) {
		Calendar today = Calendar.getInstance(); // 싱글톤 객체
		// 현제 한국은 yy 년 MM월 dd일 a hh시 mm분입니다.
		// 현제 뉴욕은 yy 년 MM월 dd일 a hh시 mm분입니다.

		SimpleDateFormat dateformat = new SimpleDateFormat(" yy년 MM월 dd일 a hh시 mm분입니다.");

		System.out.println("한국 : " + dateformat.format(today.getTime()));
		dateformat.setTimeZone(TimeZone.getTimeZone("America/New_York")); // 시간 설정을 뉴욕시간대로 변경.
		System.out.println("뉴욕 : " + dateformat.format(today.getTime()));
		dateformat.setTimeZone(TimeZone.getTimeZone("Asia/Hong_Kong")); // 시간 설정을 홍콩시간대로 변경.
		System.out.println("홍콩 : " + dateformat.format(today.getTime()));
	}

}
