package com.tj.ex05;

public class FinalEx {

	public static void main(String[] args) {
		// final 지정하면 pi 변수는 상수가 된다. = 값이 변경 불가.
		final double pi = 3.1451492653589793;

		System.out.println("pi = " + pi);
		System.out.println("반지름이 2인 원의 넓이는 " + 2 * pi * pi);

		// pi = 3.14; // 위에서 변수를 final 으로 지정했는데 값을 변경하려고 하면 오류를 낸다.

		System.out.println("pi = " + pi);
		System.out.println("반지름이 2인 원의 넓이는 " + 2 * pi * pi);
	}

}
