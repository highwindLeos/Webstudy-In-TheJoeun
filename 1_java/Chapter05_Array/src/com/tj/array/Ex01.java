package com.tj.array;

public class Ex01 {
	public static void main(String[] args) {
		// 1. �迭 ����� �ʱ�ȭ�� ����
		int i = 10;
		int[] arr = { 5, 6, 7 };
		// int[] iArr = new int[] {5,5,5};

		for (int idx = 0; idx < 3; idx++) {
			System.out.print(arr[idx] + " ");
		}
		System.out.println();
		
		for (int idx = 0; idx < arr.length; idx++) {
			System.out.print(arr[idx] + " ");
		}
		System.out.println();
		
		for (int temp : arr) { // Ȯ�� for �� 
			System.out.print(temp + " ");
		}
		System.out.println();
		
		System.out.println("arr �迭�� ������ �����ϱ�");
		
		for (int idx = 0; idx<arr.length; idx++) {
			arr[idx] = 100;
		}
		
//		for (int a : arr) { // �迭 �����ô� �Ϲ� for ���� ����ؾ��Ѵ�. (���� ������ ����)
//			a = 100;
//		}
		
		for (int a : arr) {
			System.out.print(a +"\t");
		}

	}
}
