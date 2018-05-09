package com.tj.ex04math;

import java.util.Random;

public class Ex3Random {

	public static void main(String[] args) {
		// 0.0 <= Math.random(); < 1.0 ���� �Ǽ��� ��ȯ

		System.out.println("���� : " + Math.random());

		Random ran = new Random(); // ���� �߻� Ŭ������ ��ü�� ����.
		
		System.out.println("0 ~ 100 ������ ���� : " + ran.nextInt(101)); // 101 ���� ���� �������� �߻�.
		System.out.println("0 ~ 50 ������ ���� : " + ran.nextInt(51)); // 51 ���� ���� �������� �߻�.
		System.out.println("1 ~ 45 ������ ���� : " + (ran.nextInt(45) + 1)); // 45+1 ���� ���� �������� �߻�.
		System.out.println("int�� ��ü���� ���� : " + ran.nextInt()); // 45+1 ���� ���� �������� �߻�.

		System.out.println("0,1,2 ���� ���� : " + ran.nextInt(3)); // 0~2 ���� �߻�
		System.out.println("Double ���� ���� : " + ran.nextDouble()); // ū�Ǽ��� ���� �߻�
		System.out.println("Float ���� ���� : " + ran.nextFloat()); // �Ǽ��� ���� �߻�
		System.out.println("long ���� ���� : " + ran.nextLong()); // ū������ ���� �߻�
		System.out.println("boolean ���� ���� : " + ran.nextBoolean()); // ���� ���� �߻�

		// �ζ� ��ȣ (1 ~ 45) 6���� lo1 , lo2 ... X / �迭 [6]
		byte[] lotto = new byte[6]; // lotto[0] ~ lotto[5]
		ran.nextBytes(lotto); // lotto �迭�� ������ ������ �ε����� ��ȯ��.

		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = (byte) (Math.abs(lotto[i] % 45) + 1); // 1 ~ 45 abs �� ������ ��ȯ�ϱ� ������ byte �迭�� �������� ����ȯ
			for (int j = 0; j < j; j++) {
				if (lotto[i] == lotto[j]) {
					i--;
					break;
				} // �ߺ� �� ����1
			}
		}
		
		byte temp; // ������ ���� �ӽ� ����
		for (int i = 0; i < lotto.length; i++) {
			for (int j = i + 1; j < lotto.length; j++) {
				if (lotto[i] > lotto[j]) {
					temp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = temp;
				}
			}
		} // ���� ����
		
		System.out.println("Lotto ��ȣ�� ");
		for (byte ltemp : lotto) {
			System.out.print(ltemp + "\t");
		}
	}
}
