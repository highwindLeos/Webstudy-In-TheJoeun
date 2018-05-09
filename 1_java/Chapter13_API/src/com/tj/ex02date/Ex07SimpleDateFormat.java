package com.tj.ex02date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex07SimpleDateFormat {
	public static void main(String[] args) { 
		//GregorianCalendar 로 생성해 출력 :GregorianCalendar 와 Calender 는 생성만 다르고 사용법은 똑같다.
		Date today = new Date();  
		SimpleDateFormat sdf1, sdf2, sdf3, sdf4;
		sdf1 = new SimpleDateFormat("yyyy년 MM월 dd일 ★a★ - hh:mm");
		sdf2 = new SimpleDateFormat("a hh:mm:ss");
		sdf3 = new SimpleDateFormat("S");
		sdf4 = new SimpleDateFormat("오늘은 올해의 D번째 날입니다.");
		
		System.out.println(sdf4.format(today));
		System.out.println(sdf3.format(today));
		System.out.println(sdf2.format(today));
		System.out.println(sdf1.format(today));

		// yyyy년 MM월 dd일 ★a★ - hh:mm
		
		/* 
		 * y년 M월 d일 
		 * D 월구분없는일(1~365) 
		 * E 요일 
		 * (E) -> 월
		 * a 오전/오후 
		 * W 월의 몇번째 주 
		 * w 년의 몇번째주
		 * H 시(0~23)
		 * h 시(1~12)
		 * m 분 
		 * s 초
		 * S 밀리세컨드(1/1000)
		 */
		
	}
}
