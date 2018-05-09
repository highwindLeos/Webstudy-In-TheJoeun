package com.tj.method;
// ����� ȣ�� : A �޼ҵ尡 �ڱ� �ȿ��� A �޼ҵ带 ȣ��.

// Example : 5! = 5*4*3*2*1

import java.util.Scanner;

public class Method03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int su;
		do {
			System.out.println("�� factorial�� ����մϴ�. : ");
			su = sc.nextInt();
			
			if (su < 0) {
				System.out.println("����� �Է����ּ��� : ");
			} else if (su == 0) {
				System.out.println("0�� ���丮���� ����Ҽ� �����ϴ� : ");
			}
		} while (su <= 0); // ����� �Է���. �ƴϸ� �ݺ�.

		System.out.println(su + "! = " + factorial_out(su));
		sc.close();
	}

	private static long factorial_out(int value) {
		// factorial_out(3) = 3 * factorial_out(2)
		// factorial_out(n) = n * factorial_out(n-1) �� n >= 2 
		if (value == 1) {
			return 1;
		} else {
			return value * factorial_out(value - 1);
		} // ��� �Լ�.
	}

	// private static long factorial_out(int value) {
	// // factorial_out(3) = 3*2*1
	// long resulte = 1;
	// System.out.println(value + "! :");
	//
	// for (int i = value; i >= 1; i--) {
	// resulte = resulte * i;
	// }
	//
	// return resulte;
	// }// factorial_out() : for ���� �̿��ߴ�.

}
