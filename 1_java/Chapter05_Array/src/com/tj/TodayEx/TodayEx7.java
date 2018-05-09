package com.tj.TodayEx;

// 2680 원의 거스름을 500 원 몇개 , 100원 몇개 , 50원 몇개 10원 몇개.
public class TodayEx7 {

	public static void main(String[] args) {

		int money = 2680;
		int[] coinUnit = { 500, 100, 50, 10 };
		
		for(int i = 0; i < coinUnit.length; i++) {
			System.out.print(coinUnit[i]+"원짜리 "+ money/coinUnit[i]+"개 \n");
			
			money = money % coinUnit[i];
			
		}
		// i = 0 money 2680 coin = 500 원짜리
		// i = 1 money 180 coin = 100 원짜리
		// i = 2 money 80 coin = 50 원짜리
		// i = 3 money 30 coin = 10 원짜리

	}// main
}// class
