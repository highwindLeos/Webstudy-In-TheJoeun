package com.tj.ex02date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex07SimpleDateFormat {
	public static void main(String[] args) { 
		//GregorianCalendar �� ������ ��� :GregorianCalendar �� Calender �� ������ �ٸ��� ������ �Ȱ���.
		Date today = new Date();  
		SimpleDateFormat sdf1, sdf2, sdf3, sdf4;
		sdf1 = new SimpleDateFormat("yyyy�� MM�� dd�� ��a�� - hh:mm");
		sdf2 = new SimpleDateFormat("a hh:mm:ss");
		sdf3 = new SimpleDateFormat("S");
		sdf4 = new SimpleDateFormat("������ ������ D��° ���Դϴ�.");
		
		System.out.println(sdf4.format(today));
		System.out.println(sdf3.format(today));
		System.out.println(sdf2.format(today));
		System.out.println(sdf1.format(today));

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
		
	}
}
