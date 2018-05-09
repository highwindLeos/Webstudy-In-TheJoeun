package com.tj.ex02date;

import java.util.Calendar;

public class Ex01Calender {
	public static void main(String[] args) {
		// 현제 시스템으로 부터 시간을 가져와 날짜와 시간을 출력하는 예제
		Calendar calendar = Calendar.getInstance(); // 싱글톤 패턴 class 이기때문에 (객체는 하나만 생성되도록 함)
		System.out.println(calendar);
		// 2018년 4월 9일 월요일 오후 3시 8분
		int year = calendar.get(Calendar.YEAR); // 년 도를 대입
		int month = calendar.get(Calendar.MONTH) + 1; // 월을 대입 (월은 1을 더해야 현실시간)
		int day = calendar.get(Calendar.DAY_OF_MONTH); // 일을 대입 (이달의 몇번째 날)
		int week = calendar.get(Calendar.DAY_OF_WEEK); // 주 요일을 대입 1 일요일 2 월요일 ... 7 토요일
		int amapm = calendar.get(Calendar.AM_PM); // 오전 오후 0 = am 1 = pm
		int hour12 = calendar.get(Calendar.HOUR); // 12시 기준
		int hour24 = calendar.get(Calendar.HOUR_OF_DAY); // 24시 기준
		int minite = calendar.get(Calendar.MINUTE); // 분
		int second = calendar.get(Calendar.SECOND); // 초
		int millisec = calendar.get(Calendar.MILLISECOND); // 밀리초

		System.out.printf("%d 년 %d 월 %d 일 ", year, month, day);

		switch (week) {
		case 1:
			System.out.println("일요일");
			break;
		case 2:
			System.out.println("월요일");
			break;
		case 3:
			System.out.println("화요일");
			break;
		case 4:
			System.out.println("수요일");
			break;
		case 5:
			System.out.println("목요일");
			break;
		case 6:
			System.out.println("금요일");
			break;
		case 7:
			System.out.println("토요일");
			break;
		}

		System.out.print((amapm == 0) ? "오전 " : "오후 ");
		System.out.printf("%d시 %d분 %d초 %d \n", hour12, minite, second, millisec); // 12시간 형

		System.out.printf("24표기 : %d시 %d분 %d초 %d \n", hour24, minite, second, millisec); // 24시간 형

	}
}
