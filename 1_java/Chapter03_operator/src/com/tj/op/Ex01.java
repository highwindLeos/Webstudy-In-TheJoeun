package com.tj.op;

public class Ex01 {
	
	public static void main(String[] args) {
		System.out.println("== 산술 연산자 ==");
		int n1 = 33, n2 = 10;
		int resulte;
		double resulteDouble;
		
		resulte = n1 + n2; // 더하기 연산
		System.out.printf("%d %c %d = %d \n", n1, '+', n2, resulte);
		
		resulte = n1 - n2; // 빼기 연산
		System.out.printf("%d %c %d = %d \n", n1, '-', n2, resulte);
		
		resulte = n1 * n2; // 곱하기 연산
		System.out.printf("%d %c %d = %d \n", n1, '*', n2, resulte);
		
		resulte = n1 / n2; // 나누기 연산
		System.out.printf("%d %c %d = %d \n", n1, '/', n2, resulte);
		
		resulteDouble = (double)n1 / n2; // 나누기 연산 (실수로 계산 결과를 반환)
		System.out.printf("%d %c %d = %3.1f \n", n1, '/', n2, resulteDouble);
		
		resulte = n1 % n2; // 나누기 연산 나머지 값.
		System.out.printf("%d %c %d = %d \n", n1, '%', n2, resulte);
		
		resulteDouble = n1 / 0.0; //0 으로 나누면 예외가 발생. 
		System.out.println("Test");
		System.out.printf("%d %c %f = %f\n",n1, '/', 0.0, resulteDouble); // 해당결과는 무한에 가까운 수 Infinity 출력.
		
		resulteDouble = n1 % 0.0;
		System.out.println("Test");
		System.out.printf("%d %c %f = %f\n", n1, '%', 0.0, resulteDouble); // 해당결과는 '수가 아닌 값' NaN 출력.
		
		if ((n1 % 2) == 0) { 
			System.out.println("n1 은 짝수입니다.");
		} else {
			System.out.println("n1 은 홀수입니다.");
		}
		
		if ((n1 % 5) == 0) {
			System.out.println("n1 은 5의 배수 입니다.");
		} else {
			System.out.println("n1 은 5의 배수가 아닙니다.");
		}

	}
	
}
