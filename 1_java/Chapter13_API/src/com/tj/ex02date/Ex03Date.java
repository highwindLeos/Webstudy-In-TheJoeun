package com.tj.ex02date;

import java.util.Date;

public class Ex03Date {
	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now.toString()); // Mon Apr 09 15:48:54 KST 2018
		// 2018년 4월 ~
		int year = now.getYear()+1900; // 1900 년을더해야 한다.
		int month = now.getMonth()+1; // 1월을 더해야한다.
		int day = now.getDay(); // 
		System.out.printf("%d년 %d월 %d일 \n",year ,month ,day);
		
		//simple date format : 출력포멧이랑 타임존 변경을 위해 사용.
		
	}
}
