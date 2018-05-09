package com.tj.array;

public class Ex02 {
	public static void main(String[] args) {
		// 2. 배열 선언과 초기화를 별도로
		int i;
		i = 10;

		int[] arr = new int[3]; // 인덱스를 확보한다 index : 0 ~ 2
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
//		arr[3] = 4; // 할당에서 에러가 나지만 실행은 되지 않는다. (배열의 인덱스가 없다.)
		for(int idx =0; idx < arr.length; idx++) {
			System.out.printf("arr[%d]=%d \n",idx ,arr[idx]);
		}

	}
}
