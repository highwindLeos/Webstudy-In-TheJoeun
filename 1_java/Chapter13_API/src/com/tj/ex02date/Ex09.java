package com.tj.ex02date;

import java.util.Date;

/*
 * 뉴욕 2016/02/22 (월) 오전 08:40
 * 홍콩 2016/02/22 (월) 오후 09:40
 * 파리 2016/02/22 (월) 오후 02:40
 * 서울 2016/02/22 (월) 오후 09:40
*/
public class Ex09 {
	public static void main(String[] args) {
		Date today = new Date();
		Ex09Print printObj = new Ex09Print();
		printObj.printDate(today, "뉴욕", "America/New_York");
		printObj.printDate(today, "홍콩", "Asia/Hong_Kong");
		printObj.printDate(today, "파리", "Europe/Paris");
		printObj.printDate(today, "서울", "Asia/Seoul");
	}
}
