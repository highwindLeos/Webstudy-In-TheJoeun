package com.tj.condition;

import java.util.Scanner;
// 수를 입력받아 절대 값 출력.

public class Ex04 {

	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		
		System.out.println("수를 입력하세요.");
		int num = sc.nextInt();
		
		if (num >= 0) {
			System.out.println("입력한 값("+ num +")의 절대값 : "+ num);
		} else {
			System.out.println("입력한 값("+ num +")의 절대값 : "+ (-num));
		}
		sc.close();
	}

}
