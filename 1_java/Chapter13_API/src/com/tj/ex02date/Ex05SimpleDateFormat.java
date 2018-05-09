package com.tj.ex02date;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Ex05SimpleDateFormat {
	public static void main(String[] args) {
		Calendar today = Calendar.getInstance(); //  singleton class 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd�� ��a�� - hh:mm");
		// yyyy�� MM�� dd�� ��a�� - hh:mm
		
		/* 
		 * y�� M�� d�� 
		 * D �����о�����(1~365) 
		 * E ���� 
		 * (E) -> ��
		 * a ����/���� 
		 * W ���� ���° �� 
		 * w ���� ���°��
		 * H ��(0~23)
		 * h ��(1~12)
		 * m �� 
		 * s ��
		 * S �и�������(1/1000)
		 */
		String resulte = sdf.format(today.getTime()); // getTime() : Calendar > Date ������ �ٲپ���.
		System.out.println(resulte); 
	}
}
