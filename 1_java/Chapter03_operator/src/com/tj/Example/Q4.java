package com.tj.Example;

import java.util.Scanner;

public class Q4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int age;
		String resulte;
		
		System.out.println("우대 연령인지를 확인합니다. 나이를 입력하세요.");
		age = sc.nextInt();
		
		resulte =  (age >= 65) ? "65 세 이상입니다. 우대": "65세 이하입니다. 일반";
		System.out.println(resulte);
		
		sc.close();

	}

}
