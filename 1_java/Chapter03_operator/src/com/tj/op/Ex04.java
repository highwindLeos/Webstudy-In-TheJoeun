package com.tj.op;

public class Ex04 {

	public static void main(String[] args) {
		System.out.println("== 논리 연산자 (&& - AND, || - OR) ==");
		int i = 1, j=10, h=100;
		System.out.println("i = " + i + " j = " + j +" h = " + h);
		
		System.out.println("&& : (i > j) && (j > h) : " + ((i < j) && (++j > h)));
		
		System.out.println("i = " + i + " j = " + j +" h = " + h);
		System.out.println("|| : (i > j) || (j > h) : " + ((i < j) || (++j > h)));
		System.out.println("i = " + i + " j = " + j +" h = " + h);

	}

}
