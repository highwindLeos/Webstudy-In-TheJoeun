package com.tj.ex02date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex04SimpleDateFormat {
	public static void main(String[] args) {
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일(E) a hh시 mm분 ss초");
		// yyyy년 MM월 dd일(E) a hh시 mm분 ss초
		
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
		String resulte = sdf.format(today); // 생성한 포멧으로 출력하는 값으로 반환.
		System.out.println(resulte); 
	}
}
