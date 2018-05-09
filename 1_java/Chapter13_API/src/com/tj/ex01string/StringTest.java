package com.tj.ex01string;

public class StringTest {
	public static void main(String[] args) {
//		System.out.println(System.currentTimeMillis()); // 1970.1.1 ���� ���������� Millisecond �ʸ� ����ؼ� ��ȯ.
		String str = "A";
		long startTime = System.currentTimeMillis();
		
			for (int i = 0; i < 50000; i++) {
				str = str.concat("a");
			} // 50000�� ����
		
		long endTime = System.currentTimeMillis();
		System.out.println("String �۾��ϴµ� �ɸ� �ð� : " + (endTime - startTime));
		System.out.println("=========================================================");
		StringBuffer strBuffer = new StringBuffer("A");
		startTime = System.currentTimeMillis();
			
			for (int i = 0; i < 2500000; i++) {
				strBuffer.append("a");
			}// 2500000�� ����
		
		endTime = System.currentTimeMillis();
		System.out.println("StringBuffer �۾��ϴµ� �ɸ� �ð� : " + (endTime - startTime));
		System.out.println("=========================================================");
		StringBuilder strBuilder = new StringBuilder("A");
		startTime = System.currentTimeMillis();
		
			for (int i = 0; i < 2500000; i++) {
				strBuilder.append("a");
			}// 2500000�� ����
		
		endTime = System.currentTimeMillis();
		System.out.println("StringBuilder �۾��ϴµ� �ɸ� �ð� : " + (endTime - startTime));

	}
}
