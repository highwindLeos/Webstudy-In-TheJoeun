package com.tj.TodayEx;

// 2680 ���� �Ž����� 500 �� � , 100�� � , 50�� � 10�� �.
public class TodayEx7 {

	public static void main(String[] args) {

		int money = 2680;
		int[] coinUnit = { 500, 100, 50, 10 };
		
		for(int i = 0; i < coinUnit.length; i++) {
			System.out.print(coinUnit[i]+"��¥�� "+ money/coinUnit[i]+"�� \n");
			
			money = money % coinUnit[i];
			
		}
		// i = 0 money 2680 coin = 500 ��¥��
		// i = 1 money 180 coin = 100 ��¥��
		// i = 2 money 80 coin = 50 ��¥��
		// i = 3 money 30 coin = 10 ��¥��

	}// main
}// class
