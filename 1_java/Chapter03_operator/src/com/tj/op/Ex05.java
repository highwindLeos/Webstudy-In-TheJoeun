package com.tj.op;

public class Ex05 {

	public static void main(String[] args) {
		System.out.println("== 비트 연산자 (& , |, <<, >>) ==");
		int n1 = 10; // 2진수 01010
		int n2 = 5;  // 2진수 00101
		
		int resulte = n1 & n2;
		System.out.println("n1 & n2 = " + resulte);
		
		resulte = n1 | n2; // 0 1 1 1 1 
		System.out.println("n1 | n2 = " + resulte);
		
		resulte = n1 << 1; // 0 1 0 1 0 0 : 곱하기 2한 결과
		System.out.println("n1 << n2 = " + resulte);
		
		resulte = n1 >> 1; // 0 0 1 0 1 : 나누기 2한 결과
		System.out.println("n1 >> n2 = " + resulte);
		
	}

}
