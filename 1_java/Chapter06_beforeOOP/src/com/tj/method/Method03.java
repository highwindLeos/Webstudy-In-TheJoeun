package com.tj.method;
// 재귀적 호출 : A 메소드가 자기 안에서 A 메소드를 호출.

// Example : 5! = 5*4*3*2*1

import java.util.Scanner;

public class Method03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int su;
		do {
			System.out.println("몇 factorial을 계산합니다. : ");
			su = sc.nextInt();
			
			if (su < 0) {
				System.out.println("양수를 입력해주세요 : ");
			} else if (su == 0) {
				System.out.println("0은 팩토리얼을 계산할수 없습니다 : ");
			}
		} while (su <= 0); // 양수를 입력함. 아니면 반복.

		System.out.println(su + "! = " + factorial_out(su));
		sc.close();
	}

	private static long factorial_out(int value) {
		// factorial_out(3) = 3 * factorial_out(2)
		// factorial_out(n) = n * factorial_out(n-1) 단 n >= 2 
		if (value == 1) {
			return 1;
		} else {
			return value * factorial_out(value - 1);
		} // 재귀 함수.
	}

	// private static long factorial_out(int value) {
	// // factorial_out(3) = 3*2*1
	// long resulte = 1;
	// System.out.println(value + "! :");
	//
	// for (int i = value; i >= 1; i--) {
	// resulte = resulte * i;
	// }
	//
	// return resulte;
	// }// factorial_out() : for 문을 이용했다.

}
