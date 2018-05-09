package com.tj.TodayEx;

//76,45,34,89,100,50,90,92 배열 합계 평균 max min 을 구하는 프로그램을 생성한다.
public class TodayEx02 {

	public static void main(String[] args) {

		int[] arr = { 76, 45, 34, 89, 100, 50, 90, 96 };
		int sum = 0;
		int max = 0, min = 999; // 최소값 최대값
		double avg = 0.0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i]; // 합계
			// max
			if (arr[i] > max) {	max = arr[i]; }
			// min
			if (arr[i] < min) {	min = arr[i]; }
			avg = (sum / (arr.length));
		} // end for
		System.out.printf("합계는 %d \n평균은 %.2f \n최대값은 %d \n최소값은 %d 입니다.", sum, avg, max, min);
	}
}
