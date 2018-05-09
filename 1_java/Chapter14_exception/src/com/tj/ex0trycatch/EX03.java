package com.tj.ex0trycatch;

public class EX03 {

	public static void main(String[] args) {
		int[] iArr = { 0, 1, 2 };
		System.out.println("===========================================");
		try {
			System.out.println(iArr[3]);
		} catch (ArrayIndexOutOfBoundsException e) {
			// e.printStackTrace(); // 예외 메세지를 자세하게 보여준다.
			System.out.println(e.getMessage() + "인덱스를 봐");
		} finally {
			System.out.println("finally 나는 예외가 나든 안나든 항상 실행하지.");
		}
		System.out.println("===========================================");
	}
}
