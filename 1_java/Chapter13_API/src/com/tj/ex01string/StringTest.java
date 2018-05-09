package com.tj.ex01string;

public class StringTest {
	public static void main(String[] args) {
//		System.out.println(System.currentTimeMillis()); // 1970.1.1 부터 현제까지의 Millisecond 초를 계산해서 반환.
		String str = "A";
		long startTime = System.currentTimeMillis();
		
			for (int i = 0; i < 50000; i++) {
				str = str.concat("a");
			} // 50000번 수행
		
		long endTime = System.currentTimeMillis();
		System.out.println("String 작업하는데 걸린 시간 : " + (endTime - startTime));
		System.out.println("=========================================================");
		StringBuffer strBuffer = new StringBuffer("A");
		startTime = System.currentTimeMillis();
			
			for (int i = 0; i < 2500000; i++) {
				strBuffer.append("a");
			}// 2500000번 수행
		
		endTime = System.currentTimeMillis();
		System.out.println("StringBuffer 작업하는데 걸린 시간 : " + (endTime - startTime));
		System.out.println("=========================================================");
		StringBuilder strBuilder = new StringBuilder("A");
		startTime = System.currentTimeMillis();
		
			for (int i = 0; i < 2500000; i++) {
				strBuilder.append("a");
			}// 2500000번 수행
		
		endTime = System.currentTimeMillis();
		System.out.println("StringBuilder 작업하는데 걸린 시간 : " + (endTime - startTime));

	}
}
