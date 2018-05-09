package com.tj.array;

// 배열 복사 : 
public class Ex05 {
	public static void main(String[] args) {
		int[] num = { 100, 20, 30, 40, 50 };
		int[] newNum = new int[num.length];

		// for (int i = 0; i < num.length; i++) { // 배열을 복사하는 작업을 for 문으로 했다.
		// newNum[i] = num[i];
		// }
		// arraycopy() : 카피원본 배열, 배열 인덱스, 카피될 배열, 카피될 배열인덱스, 복사한 범위.
		System.arraycopy(num, 0, newNum, 0, num.length);

		for (int i = 0; i < num.length; i++) {
			System.out.printf("num[%d] = %d\t newNum[%d] = %d \n", i, num[i], i, newNum[i]);
		}

		System.out.println("newNum 배열만 수정.");

		newNum[0] = 9;
		newNum[2] = 9;
		newNum[4] = 9;
		for (int i = 0; i < num.length; i++) { // 배열을 수정해도 주소가 다르기때문에 num 과 다르다.
			System.out.printf("num[%d] = %d\t newNum[%d] = %d \n", i, num[i], i, newNum[i]);
		}
	}
}
