package com.tj.loof;

import java.util.Scanner;

// ����ڰ� ���ϴ� �ش� �������� ���.

public class ForEx08gugu {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("������ �� ���� ���� �� �Է��ϼ���.");
		int dan = sc.nextInt();

		for (int i = 1; i <= 9; i++) {
			System.out.println(dan + " * " + i + " = " + (dan * i));
		} // for end
		sc.close();
	} // main end
}
