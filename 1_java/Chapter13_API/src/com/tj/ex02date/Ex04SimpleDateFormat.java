package com.tj.ex02date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex04SimpleDateFormat {
	public static void main(String[] args) {
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd��(E) a hh�� mm�� ss��");
		// yyyy�� MM�� dd��(E) a hh�� mm�� ss��
		
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
		String resulte = sdf.format(today); // ������ �������� ����ϴ� ������ ��ȯ.
		System.out.println(resulte); 
	}
}
