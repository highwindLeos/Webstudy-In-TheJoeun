package com.tj.loof;

import java.util.Scanner;

// 사용자가 원하는 해당 구구단을 출력.

public class ForEx08gugu {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("구구단 을 구할 단을 을 입력하세요.");
		int dan = sc.nextInt();

		for (int i = 1; i <= 9; i++) {
			System.out.println(dan + " * " + i + " = " + (dan * i));
		} // for end
		sc.close();
	} // main end
}
