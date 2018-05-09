package com.tj.Example;

import java.util.Scanner;

//연습 문제 3 : 입력한 수가 3의 배수인지 확인하는 프로그램.
public class Q1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int i;
		String resulte; 
		System.out.println("정수를 입력해주세요.");
		i = sc.nextInt();
		
		resulte = ((i % 3) == 0) ? "입력한 수는 3의 배수입니다."
								 : "입력한 수는 3의 배수가 아닙니다.";
		sc.close();
		System.out.println(resulte);
		
	}

}
