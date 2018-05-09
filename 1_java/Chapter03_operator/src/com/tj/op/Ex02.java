package com.tj.op;

public class Ex02 {

	public static void main(String[] args) {
		System.out.println("= == 증감 연산자 (++ --) == =");
		
		int n1 = 10;
		// int n2 = n1++; //n1 을 1 증가 시킨다. 문장 나중에 실행하기에 10.
		// System.out.println("n1 = " + n1 + "\t n2=" + n2);
		int n2 = ++n1; //먼저 값을 증가 시킨다.
		System.out.print("n1 = " + n1 + "\t n2 = " + n2);
		System.out.println("n1 = " + n1 + "\t n2 = " + n2);
		
		int n3 = 10;
		// printf() 함수. format을 줘서 print - "포맷", "변수들"
		// %d (10진수 정수), %c (문자), %f (실수), %s (문자열), %x (16진수 정수) %b(논리값)출력
		System.out.printf("n3 = %d \n", n3++); //종료시점에서 연산.
		System.out.printf("n3 = %d \n", ++n3); 
		
	
		int n4 = 10;
		System.out.printf("n4 = %d \n", n4--); //종료시점에서 연산.
		System.out.printf("n4 = %d \n", --n4);
		
		int temp = 10;
		System.out.printf("%d %d %d %d", temp++, ++temp, temp--, --temp);
	
	}

}
