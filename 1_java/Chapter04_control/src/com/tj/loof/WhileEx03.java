package com.tj.loof;

public class WhileEx03 {

	public static void main(String[] args) {
		int i = 1, total = 0;
		while (i <= 100) {

			total += i; // 누접합.
			System.out.printf("i가 %d, 누접합은 %d 이다 \n", i, total);
			i++;

		}
	}
}
