package com.tj.method;

public class Ex03 {

	public static void main(String[] args) {
		//
		ArtisMetic sansu = new ArtisMetic(); // 클래스를 인스턴스로 만듬. (인스턴스는 클래스 내부의 함수를 모두 가지고 있다.)

		int sum = sansu.sum(1, 10);
		
		System.out.println("누적합 결과는 " + sum);
		System.out.println("누적합 sum은 " + sansu.evenOdd(sum));
		System.out.println("-5의 절대값은 " + sansu.abs(-5));
	}

}
