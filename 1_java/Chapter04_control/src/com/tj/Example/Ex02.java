package com.tj.Example;

//1+(1+2)+(1+2+3)+(1+2+3+4)... (1+2+3+4+5...10) = 220

public class Ex02 {

	public static void main(String[] args) {
		int n = 10;
		int total = 0; // �����Ҷ��� �ʱⰪ�� �־���Ѵ�.

		for (int i = 1; i <= n; i++) {
			System.out.print("("); //���� ���θ� ����Ѵ�.
			for (int j = 1; j <= i; j++) {
				if (j == i) { // J�� i ���� ���� ������ ���.
					System.out.print(j);
				} else {
					System.out.print(j + "+");
				}
				total += j; // ����
			}
			if (i != 10) {
				System.out.print(") + "); // 10��° ����� �ƴѰ�츸 ) + �� ���.
			} else {
				System.out.print(") = "); // 10��° ����̶�� ) = �� ���
			}
		}
		System.out.println(total);
	}

}
