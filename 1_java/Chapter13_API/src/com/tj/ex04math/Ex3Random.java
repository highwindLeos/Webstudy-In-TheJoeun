package com.tj.ex04math;

import java.util.Random;

public class Ex3Random {

	public static void main(String[] args) {
		// 0.0 <= Math.random(); < 1.0 사이 실수값 반환

		System.out.println("난수 : " + Math.random());

		Random ran = new Random(); // 난수 발생 클래스로 객체를 만듬.
		
		System.out.println("0 ~ 100 까지의 난수 : " + ran.nextInt(101)); // 101 보다 작은 정수난수 발생.
		System.out.println("0 ~ 50 까지의 난수 : " + ran.nextInt(51)); // 51 보다 작은 정수난수 발생.
		System.out.println("1 ~ 45 까지의 난수 : " + (ran.nextInt(45) + 1)); // 45+1 보다 작은 정수난수 발생.
		System.out.println("int형 전체범위 난수 : " + ran.nextInt()); // 45+1 보다 작은 정수난수 발생.

		System.out.println("0,1,2 중의 난수 : " + ran.nextInt(3)); // 0~2 정수 발생
		System.out.println("Double 형의 난수 : " + ran.nextDouble()); // 큰실수형 난수 발생
		System.out.println("Float 형의 난수 : " + ran.nextFloat()); // 실수형 난수 발생
		System.out.println("long 형의 난수 : " + ran.nextLong()); // 큰정수형 난수 발생
		System.out.println("boolean 형의 난수 : " + ran.nextBoolean()); // 논리형 난수 발생

		// 로또 번호 (1 ~ 45) 6개월 lo1 , lo2 ... X / 배열 [6]
		byte[] lotto = new byte[6]; // lotto[0] ~ lotto[5]
		ran.nextBytes(lotto); // lotto 배열에 난수가 각각의 인덱스에 반환됨.

		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = (byte) (Math.abs(lotto[i] % 45) + 1); // 1 ~ 45 abs 는 정수를 반환하기 때문에 byte 배열에 넣으려면 형변환
			for (int j = 0; j < j; j++) {
				if (lotto[i] == lotto[j]) {
					i--;
					break;
				} // 중복 값 제거1
			}
		}
		
		byte temp; // 정렬을 위한 임시 변수
		for (int i = 0; i < lotto.length; i++) {
			for (int j = i + 1; j < lotto.length; j++) {
				if (lotto[i] > lotto[j]) {
					temp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = temp;
				}
			}
		} // 순차 정렬
		
		System.out.println("Lotto 번호는 ");
		for (byte ltemp : lotto) {
			System.out.print(ltemp + "\t");
		}
	}
}
