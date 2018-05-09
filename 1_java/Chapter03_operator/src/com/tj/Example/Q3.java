package com.tj.Example;

import java.util.Scanner;

public class Q3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num1,num2; // 입력받을 변수 선언
		String resulte; // 결과를 받을 문자열 선언
		
		System.out.println(" 같은 수인지를 알아봅니다. 두개의 정수를 순서대로 입력해주세요.");
		
		System.out.println(" 첫번째 수 입력");
		num1 = sc.nextInt();
		System.out.println(" 두번째 수 입력");
		num2 = sc.nextInt();
		
		resulte = (num1 == num2) ? "O : 같은 수입니다." : "X : 다른 수 입니다.";
		System.out.println(resulte);
		
		sc.close(); // 스캐너 객체를 닫는다.

	}

}
