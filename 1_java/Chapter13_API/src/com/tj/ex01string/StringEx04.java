package com.tj.ex01string;

public class StringEx04 {

	public static void main(String[] args) {
		String str = "ABC DEF 2002";
		// ABC DEF 2002
		System.out.println(str);
		// 2002 FDE CBA
		int temp = str.length();
		// System.out.println(temp);
		for (int i = temp - 1; i >= 0; i--) {
			System.out.print(str.charAt(i));
		}

		System.out.println();

		// A C D F 2 0 (짝수 인덱스만 출력 홀수 index 대신)
		for (int i = 0; i < str.length(); i += 2) {
			System.out.print(str.charAt(i));
		}
		System.out.println();
		// str 을 꺼꾸로 해서 새로운 arr temp 에 넣음
		char[] arr = str.toCharArray();
		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.print(arr[i]);
		}
		System.out.println();
		// A*C*D*F*2*0 (짝수 인덱스만 출력 홀수 index 대신 '*')
		for (int i = 0; i < str.length(); i++) {
			/*
			 * if (i %2 == 0) { System.out.print(str.charAt(i)); } else {
			 * System.out.print('*'); }
			 */
			System.out.print(i % 2 == 0 ? str.charAt(i) : '*');
		}

	}

}
