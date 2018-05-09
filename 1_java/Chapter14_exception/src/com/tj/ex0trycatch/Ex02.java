package com.tj.ex0trycatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = 0;
		int j = 0;
		
		System.out.println("사칙연산을 할겁니다.");
		
		do {
			System.out.println("첫번째 수?");
			try {
				i = sc.nextInt(); //*
				break;
			} catch (InputMismatchException e) {
				System.out.println("수를 입력하세요 안그러면 0으로");
				sc.nextLine();
			}
		}while(true); // 수를 입력할때 까지 계속 반복
		
		System.out.println("두번째 수?");
		
		try {
			j = sc.nextInt(); //*
			System.out.println("i * j = " + (i * j));
			System.out.println("i / j = " + (i / j)); //*
		} catch (InputMismatchException e) {
			System.out.println("수를 입력하세요 안그러면 0으로");
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		}
			
		System.out.println("i + j = " + (i + j));
		System.out.println("i - j = " + (i - j));

		System.out.println("이상입니다.");
		sc.close();
	}
}
