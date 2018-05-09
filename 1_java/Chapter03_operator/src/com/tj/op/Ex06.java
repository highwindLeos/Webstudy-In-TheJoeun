package com.tj.op;

public class Ex06 {

	public static void main(String[] args) {
		System.out.println("== 조건(3항)연산자 ( 조건 ? true 결과 : false 결과) ==");
		int h = 100;
		
		String resulte = ((h % 2) == 0) ? "h는 짝수" : "h는 홀수";
		System.out.println(resulte);
		
		h = 101;
		System.out.println((h%2 == 0) ? "h는 짝수 ": "h는 홀수");
		
	}

}
