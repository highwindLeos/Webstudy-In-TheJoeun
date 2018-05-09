package com.tj.method;
// 사용자로 부터 1-9  사이의 값을 입력 받아 구구단을 출력.

import java.util.Scanner;

public class Method02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int gugu;

		do {
			System.out.println("1 ~ 9 사이의 숫자를 입력해주세요 : (구구단을 출력)");
			gugu = sc.nextInt();
		} while (gugu < 1 || gugu > 9); // 1과 9사이의 값이 아니라면. 반복.

		Method02 m2 = new Method02();
		m2.gugudan_out(gugu);
		sc.close();
	}

	private void gugudan_out(int gugu) {
		int resulte;
		System.out.println(gugu + "단 구구단 :");

		for (int i = 1; i <= 9; i++) {
			resulte = gugu * i;
			System.out.printf("%d * %d = %d \n", gugu, i, resulte);
		}
	}

}
