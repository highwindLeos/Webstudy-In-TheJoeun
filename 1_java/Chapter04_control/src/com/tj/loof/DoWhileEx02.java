package com.tj.loof;

import java.io.IOException;

// ¦���� �Է¹޾� ���.(��, Ȧ���� �Է½� �ٽ� �Է¹���)
public class DoWhileEx02 {

	public static void main(String[] args) throws IOException {

		int num;
		do {
			System.out.println("���ϴ� ¦���� �Է����ּ���.");
			// 0 �� ������ �ԷµǴ� �ƽ�Ű �ڵ�� '0'(48), Enter(13, 10)
			// 0 (48) 1(49) 2(50)
			num = System.in.read()-'0'; // Ű���� �Է�Ű�� �ƽ�Ű �ڵ� �ϳ��� �����´�.
			System.in.read();	// �ƽ�Ű�ڵ尪�� ������ ��.
		} while ((num % 2) == 1 || (num%2) == -1); // �Էµ� ���� Ȧ�� �̸� true?

		System.out.println("�Է��� ¦���� " + num + " �Դϴ�.");

	}// main
}
