package com.tj.TodayEx;

//arr = {10,20,30,40,50} �迭�� ��� ���� ���ϴ� ���α׷��� �����Ѵ�.
public class TodayEx01 {

	public static void main(String[] args) {

		int[] arr = { 10, 20, 30, 40, 50 };
		int total = 0;

//		for (int a : arr) {
//			total += a;
//		}
		// �� �Ʒ� �� for ���� ���� ���̴�.
		for (int i = 0; i < arr.length; i++) {
			total += arr[i];
		}
		System.out.println("���� �հ�� " + total);
	}
}
