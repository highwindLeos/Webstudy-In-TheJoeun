package com.tj.ex02date;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Ex05SimpleDateFormat {
	public static void main(String[] args) {
		Calendar today = Calendar.getInstance(); //  singleton class 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 ★a★ - hh:mm");
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
		String resulte = sdf.format(today.getTime()); // getTime() : Calendar > Date 형으로 바꾸어줌.
		System.out.println(resulte); 
	}
}
