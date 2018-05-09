package com.tj.ex0trycatch;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i= 0, j = 0;
		
		System.out.println("사칙연산을 할겁니다.");

		System.out.println("첫번째 수?");
		try {
			i = sc.nextInt();
		} catch (Exception e) {
			System.out.println("꼭 수를 입력하세요.");
		}
		sc.nextLine(); // 버퍼 삭제
		System.out.println("두번째 수?");
		try {
			j = sc.nextInt();
		} catch (Exception e) {
			System.out.println("꼭 수를 입력하세요.");
		}
		
		System.out.println("i * j = " + (i * j));
		try {
			System.out.println("i / j = " + (i / j));
			
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("계속 수행됨니다.");
		}
		System.out.println("i + j = " + (i + j));
		System.out.println("i - j = " + (i - j));

		System.out.println("이상입니다.");
		sc.close();
	}
}
