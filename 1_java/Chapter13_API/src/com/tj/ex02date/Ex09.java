package com.tj.ex02date;

import java.util.Date;

/*
 * ���� 2016/02/22 (��) ���� 08:40
 * ȫ�� 2016/02/22 (��) ���� 09:40
 * �ĸ� 2016/02/22 (��) ���� 02:40
 * ���� 2016/02/22 (��) ���� 09:40
*/
public class Ex09 {
	public static void main(String[] args) {
		Date today = new Date();
		Ex09Print printObj = new Ex09Print();
		printObj.printDate(today, "����", "America/New_York");
		printObj.printDate(today, "ȫ��", "Asia/Hong_Kong");
		printObj.printDate(today, "�ĸ�", "Europe/Paris");
		printObj.printDate(today, "����", "Asia/Seoul");
	}
}
