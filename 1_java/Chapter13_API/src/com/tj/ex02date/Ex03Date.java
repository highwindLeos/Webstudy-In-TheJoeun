package com.tj.ex02date;

import java.util.Date;

public class Ex03Date {
	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now.toString()); // Mon Apr 09 15:48:54 KST 2018
		// 2018�� 4�� ~
		int year = now.getYear()+1900; // 1900 �������ؾ� �Ѵ�.
		int month = now.getMonth()+1; // 1���� ���ؾ��Ѵ�.
		int day = now.getDay(); // 
		System.out.printf("%d�� %d�� %d�� \n",year ,month ,day);
		
		//simple date format : ��������̶� Ÿ���� ������ ���� ���.
		
	}
}
