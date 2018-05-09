package com.tj.TodayEx;

//arr = {10,20,30,40,50} 배열에 담긴 값을 더하는 프로그램을 생성한다.
public class TodayEx01 {

	public static void main(String[] args) {

		int[] arr = { 10, 20, 30, 40, 50 };
		int total = 0;

//		for (int a : arr) {
//			total += a;
//		}
		// 위 아래 두 for 문은 같은 식이다.
		for (int i = 0; i < arr.length; i++) {
			total += arr[i];
		}
		System.out.println("누적 합계는 " + total);
	}
}
