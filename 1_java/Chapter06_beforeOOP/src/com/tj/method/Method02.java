package com.tj.method;
// ����ڷ� ���� 1-9  ������ ���� �Է� �޾� �������� ���.

import java.util.Scanner;

public class Method02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int gugu;

		do {
			System.out.println("1 ~ 9 ������ ���ڸ� �Է����ּ��� : (�������� ���)");
			gugu = sc.nextInt();
		} while (gugu < 1 || gugu > 9); // 1�� 9������ ���� �ƴ϶��. �ݺ�.

		Method02 m2 = new Method02();
		m2.gugudan_out(gugu);
		sc.close();
	}

	private void gugudan_out(int gugu) {
		int resulte;
		System.out.println(gugu + "�� ������ :");

		for (int i = 1; i <= 9; i++) {
			resulte = gugu * i;
			System.out.printf("%d * %d = %d \n", gugu, i, resulte);
		}
	}

}
