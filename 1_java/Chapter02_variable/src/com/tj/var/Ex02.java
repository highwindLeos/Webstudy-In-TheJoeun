package com.tj.var;

public class Ex02 {
	public static void main(String[] agrs) {
		// 변수 선언 법
		
		//1. 변수 선언과 할당을 분리
		int num1; //4byte
		num1 = 10;
		System.out.println("num1 = " + num1);
		
		//2. 변수선언과 할당을 동시에 작업
		int num2 = 20;
		System.out.print("num2 = " + num2 + "\n"); // \n는 줄바꿈 (print 함수)
		
		//3. 동일형 자료형을 다수 동시 선언.
		
		int num3, num4, num5;
		
		num3 = 30; 
		num4 = 40; 
		num5 = 50;
		// format을 주어져서 print - "포맷", "변수들"
		// %d 10진수 정수, %c 문자, %f 실수, %s 문자열, %x 16진수 출력
		System.out.printf("num3 = %d num4 = %d num4 = %d\n", num3, num4, num5);
		
		
		//4. 동일형 자료형을 동시에 선언과 할당.
		int num6 = 60, num7 = 70, num8 = 80/*, num9 = 90*/;
		System.out.printf("num6 = %d \t num7 = %d \t num8 = %d\n", num6, num7, num8); // \t 들여쓰기 출력
	}
}
