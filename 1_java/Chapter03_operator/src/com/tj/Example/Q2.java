package com.tj.Example;

import java.util.Scanner;

// 연습 문제 2 : 입력한 수가 짝수인지 홀수 인지 출력.
public class Q2 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("수를 입력하세요 : ");
		
		int i = scanner.nextInt(); // 정수를 입력받는다.

		String resulte = ((i % 2) == 0) ? "입력하신 수는 짝수입니다." 
										: "입력하신 수는 홀수입니다.";
		scanner.close();

		System.out.println(resulte);
		
	}

}
