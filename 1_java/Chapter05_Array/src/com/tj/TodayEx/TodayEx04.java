package com.tj.TodayEx;

// 배열안의 원소값 정렬.
public class TodayEx04 {

	public static void main(String[] args) {
		int[] arr = { 76, 45, 34, 89, 100, 50, 90, 92 };
		int[] sortArr = new int[arr.length];

		System.arraycopy(arr, 0, sortArr, 0, arr.length); // 배열 복사 (변수 주소는 다르다)

		for (int i = 0; i < sortArr.length; i++) {
			for (int j = i + 1; j < sortArr.length; j++) {
				if (sortArr[i] > sortArr[j]) { // 첫번째 값과 두번째 값을 비교해서 첫번째 값이 크다면.
					// 부호만 바꾸면 오름 차순 정렬이 된다.

					int temp = sortArr[i]; // 임시 변수를 만들어 첫번째 값을 저장.
					sortArr[i] = sortArr[j]; // 두번째 값을 첫번째 값에 옴김.
					sortArr[j] = temp; // 임시 값을 두번째 변수에 저장.

				}
			} // for-j
		} // for-i
		for (int a : arr) {
			System.out.print(a + "\t");
		}
		System.out.println("\n 정렬 후");
		for (int a : sortArr) {
			System.out.print(a + "\t");
		}

	}

}
