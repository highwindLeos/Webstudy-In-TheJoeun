package com.tj.condition;

import java.util.Scanner;

public class SwitchEx02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("수를 입력하세요");
		int num = sc.nextInt();
		
		//모두 같은 조건문이다.
		System.out.println(num % 2 == 0 ? "짝수네" : "홀수네"); // 삼항연산자로 바로 출력

		if (num % 2 == 0) { // if 문
			System.out.println("짝수네");
		} else {
			System.out.println("홀수네");
		}

		switch (num % 2) { // switch 문 
		case 0:
			System.out.println("짝수네");
			break;
		case 1: case -1:
			System.out.println("홀수네");
			break;
		}

		sc.close(); // 스캐너 닫음

	}

}
