package com.tj.ex04math;

public class Ex1Math {
	public static void main(String[] args) {
		// Math static method
		System.out.println("2의 3승 : "+Math.pow(2, 3)); // 제곱을 구한다.
		System.out.println("-9의 절대값 : "+Math.abs(-9)); // 절대값을 반환.
		System.out.println("16의 제곱근 : "+Math.sqrt(16)); // 제곱근을 반환.
		System.out.println("4 하고 9중 작은수 : "+Math.min(4, 9)); //입력된 두수 중 작은 수를 반환
		System.out.println("4 하고 9중 큰수 : "+Math.max(4, 9)); // 입력된 두수 중 큰 수를 반환
		// Math의 상수
		System.out.println("sin(PI) : "+Math.sin(Math.PI)); // 삼각함수
		System.out.println("cos(PI) : "+Math.cos(Math.PI));
		System.out.println("tan(PI) : "+Math.tan(Math.PI));

	}
}
