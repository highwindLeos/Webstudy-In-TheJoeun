package com.tj.loof;

import java.util.Scanner;

// 짝수를 입력받아 출력.(단, 홀수를 입력시 다시 입력받음)
public class DoWhileEx01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num;
		do {
			System.out.println("원하는 짝수를 입력해주세요.");
			num = sc.nextInt();
		} while ((num % 2) == 1 ||(num%2) == -1); // 입력된 값이 홀수 이면 true?

		System.out.println("입력한 짝수는 " + num + " 입니다.");
		sc.close();

	}// main
}
