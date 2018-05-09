package com.tj.Example;

// 주사위를 던져서 두수의 합이 6이 되는 경우를 출력
// 1 + 5 = 6 2+4 = 6 3+3=6 4+2=6 5+1+6
public class Ex03 {

	public static void main(String[] args) {

		int resulte = 0;

		for (int i = 1; i < 6; i++) {
			for (int j = 1; j <= 6; j++) {
				resulte = i + j;
				if (i + j == 6) {
					System.out.println("두수의 합이 6이 되는 경우의 수");
					System.out.println(i + " + " + j + " = " + resulte);
				}
			}
		}
	}

}
