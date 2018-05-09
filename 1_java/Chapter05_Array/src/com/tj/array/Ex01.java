package com.tj.array;

public class Ex01 {
	public static void main(String[] args) {
		// 1. 배열 선언과 초기화를 같이
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
		
		for (int temp : arr) { // 확장 for 문 
			System.out.print(temp + " ");
		}
		System.out.println();
		
		System.out.println("arr 배열에 데이터 수정하기");
		
		for (int idx = 0; idx<arr.length; idx++) {
			arr[idx] = 100;
		}
		
//		for (int a : arr) { // 배열 수정시는 일반 for 문을 사용해야한다. (값이 변하지 않음)
//			a = 100;
//		}
		
		for (int a : arr) {
			System.out.print(a +"\t");
		}

	}
}
