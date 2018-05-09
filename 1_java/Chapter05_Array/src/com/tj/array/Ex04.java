package com.tj.array;

public class Ex04 {
	public static void main(String[] args) {
		int i = 10;
		int j = i;
		System.out.println("i=" + i + ", j=" + j);
		j = 99;
		System.out.println("i=" + i + ", j=" + j);
		// 위의 작업을 레퍼런스 변수로 해보자.
		System.out.println();

		int[] score = { 100, 10, 20, 30, 40, 50 };
		int[] s = score;
		// 두개의 반복문 출력은 같은 값을 출력한다. score 와 s 배열은 같은 주소이기 때문.
		for (int idx = 0; idx < s.length; idx++) {
			System.out.printf("s[%d] = %d\t score[%d] = %d\n", idx, s[idx], idx, score[idx]);
		}

		s[0] = 9;	s[2] = 9;	s[4] = 9;
		System.out.println("s배열만 수정후");
		for (int idx = 0; idx < s.length; idx++) {
			System.out.printf("s[%d] = %d\t score[%d] = %d\n", idx, s[idx], idx, score[idx]);
		}
	}

}
