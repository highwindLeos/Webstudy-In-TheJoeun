package com.tj.TodayEx;

//76,45,34,89,100,50,90,92 �迭 �հ� ��� max min �� ���ϴ� ���α׷��� �����Ѵ�.
public class TodayEx02 {

	public static void main(String[] args) {

		int[] arr = { 76, 45, 34, 89, 100, 50, 90, 96 };
		int sum = 0;
		int max = 0, min = 999; // �ּҰ� �ִ밪
		double avg = 0.0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i]; // �հ�
			// max
			if (arr[i] > max) {	max = arr[i]; }
			// min
			if (arr[i] < min) {	min = arr[i]; }
			avg = (sum / (arr.length));
		} // end for
		System.out.printf("�հ�� %d \n����� %.2f \n�ִ밪�� %d \n�ּҰ��� %d �Դϴ�.", sum, avg, max, min);
	}
}
