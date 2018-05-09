package com.tj.ex04math;

public class Ex2Math {
	public static void main(String[] args) {
		
		//ceil : 실수 반환 - 올림
		//floor : 실수 반환 - 버림
		//round : 정수 반환 - 반올림
		
		System.out.println("소수점에서 반올림, 올림, 버림");
		System.out.println("9.12 올림 : " + Math.ceil(9.12)); // 10.0 실수 반환
		System.out.println("9.69 버림 : " + Math.floor(9.69)); // 9.0 실수 반환
		System.out.println("9.69 반올림 : " + Math.round(9.69)); // 10 정수 반환
		System.out.println("9.49 반올림 : " + Math.round(9.49)); // 9 정수 반환
		
		System.out.println("소수점 한자리에서 반올림, 올림, 버림"); // 10의 지수로 자리수를 맟춘다.
		System.out.println("9.12 올림 : " + Math.ceil(9.12*10)/10); // 9.2 실수 반환 : 10을 곱하고 10.0으로 나눈다.
		System.out.println("9.69 버림 : " + Math.floor(9.69*10)/10); // 9.6 실수 반환
		System.out.println("9.69 반올림 : " + Math.round(9.69*10)/10.0); // 9.7 정수 반환
		System.out.println("9.69 반올림 : " + Math.round(9.69*10)/10.0); // 9.7 정수 반환
		
		System.out.println("십의 자리에서 반올림, 올림, 버림");// 아래의 계산들은 정수값으로 원하면 형변환.
		System.out.println("11 올림 : " + (int)Math.ceil(11/10.0)*10); // 20.0 실수 반환 :  10.0으로 나누고 10으로 나눈다.
		System.out.println("19 버림 : " + (int)Math.floor(19/10.0)*10); // 20.0 실수 반환 :  10.0으로 나누고 10으로 나눈다.
		System.out.println("19 반올림 : " + Math.round(19/10.0)*10); // 20 정수 반환 :  10.0으로 나누고 10으로 나눈다.

	}
}
