package com.tj.ex1;

public class ThrowEx {

	public ThrowEx() throws Exception {
		actionC();
	}

	private void actionC() throws ArrayIndexOutOfBoundsException {
		System.out.println("actionC 전반부");
		actionB();
		System.out.println("actionC 후반부");
	}

	private void actionB() throws ArrayIndexOutOfBoundsException {
		System.out.println("actionB 전반부");
		actionA();		
		System.out.println("actionB 전반부");

	}

	private void actionA() throws ArrayIndexOutOfBoundsException { // 예외를 이 메소드에서 처리한다.
		System.out.println("actionA 전반부");
		int[] iArr = { 0, 1, 2 };
		System.out.println("인덱스 4 값" + iArr[4]);
//		try {
//			System.out.println("인덱스 4 값" + iArr[4]);
//		} catch (ArrayIndexOutOfBoundsException e) {
//			System.out.println(e.getMessage());
//		}
		System.out.println("actionA 후반부");
	}

}
